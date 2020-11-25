
/**
 * Write a description of class Grupo here.
 * 
 * @author Judith Vargas 
 * @version 1
 */
import javax.swing.JOptionPane;
public class Grupo
{
    ListaEstudiante listaEstudiante = new ListaEstudiante();
    ArbolEstudiante arbolEstudiante = new ArbolEstudiante();
    
    Nodo nodoInicio = new Nodo();

    String nombre = "";
    int carnet = 0;   
    int nota =0;
    float promedio = 0;

    public void ingresarEstudiantes(){
        String entrada = "";
        while (! "c".equals (entrada)){
            
            entrada= JOptionPane.showInputDialog ( "Menu\n\n"
                +"Escoja una opcion:\n"               
                + "a. Agregar nuevo estudiante.\n"
                + "b. Finalizar.\n"
            );

            //Dependiendo del caso
            switch (entrada.toLowerCase()){
                case "a":
                ListaNotas listaNotas  = new ListaNotas();
                //Pregunta el nombre
                nombre = JOptionPane.showInputDialog("Ingrese el nombre");
                //Pregunta el carnet
                carnet = Integer. parseInt(JOptionPane.showInputDialog("Ingrese el carnet"));
                String entrada2 = "";
                //Pregunta las notas hasta que el usuario ya no desee agregar más, y las agrega a la lista
                while (! "b".equals (entrada2)){

                    entrada2= JOptionPane.showInputDialog ( "Desea agregar una nota\n"
                        +"a.Sí.\n"
                        +"b.No.\n"
                    );
                    switch (entrada2.toLowerCase()){
                        case "a": 
                        nota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota"));
                        listaNotas.agregarNota(nota);
                        break;
                    }                    
                }
                nodoInicio = listaNotas.getInicio();  
                //Calcular el promedio
                promedio = listaEstudiante.calcularPromedio(nodoInicio);
                //Agregar estudiante a la lista
                listaEstudiante.agregarEstudiante(nombre,carnet,listaNotas,promedio);
                
                break;

                case "b":
                mostrarMenu();                
                break;             
            }
        }      
    }

    public void mostrarMenu() {  
        float promedioIngresado = Float.parseFloat(JOptionPane.showInputDialog ("Digite el promedio"));
        String entrada= ""; 
        while (! "e".equals (entrada)){
            entrada= JOptionPane.showInputDialog ( "Menu\n\n"
                +"Escoja una opcion:\n"               
                + "a. Estudiantes que tengan un promedio mayor al ingresado.\n"
                + "b. Estudiantes que tengan un promedio menor al ingresado.\n"
                + "c. Estudiantes que tengan un promedio igual.\n"
                + "d. Promedio de todos los estudiantes.\n"
                + "e. Salir.\n"
            );

            //Dependiendo del caso
            switch (entrada.toLowerCase()){
                case "a":
                imprimirMayores(promedioIngresado);
                break;

                case "b":
                imprimirMenores(promedioIngresado);
                break;

                case "c":
                imprimirIguales(promedioIngresado);
                break;

                case "d":
                String promedioEstudiantes = listaEstudiante.toString();
                JOptionPane.showMessageDialog(null,"Promedio de todos los estudiantes: \n" + promedioEstudiantes);
                break;

                case "e":
                JOptionPane.showMessageDialog(null,"Muchas gracias por usar el programa");
                break;
            }
        }      
    }

    /**
     * Metodo que imprime los datos de los Estudiantes
     * que tienen un promedio menor al indicado.
     * 
     * @param  promedio
     * @return    
     */
    public void imprimirMenores(float promedio){

    }

    /**
     * Metodo que imprime los datos de los Estudiantes
     * que tienen un promedio igual al indicado.
     * 
     * @param  promedio
     * @return    
     */
    public void imprimirIguales(float promedio){

    }

    /**
     * Metodo que imprime los datos de los Estudiantes
     * que tienen un promedio mayor al indicado.
     * 
     * @param  promedio
     * @return    
     */
    public void imprimirMayores(float promedio){

    }
}
