
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
    Estudiante estudiante = new Estudiante();

    Nodo nodoInicio = new Nodo();

    String nombre = "";
    int carnet = 0;   
    int nota = 0;
    float promedio =0;
   String imprimir = "";

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
                int totalNotas = 0;
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
                System.out.println("Lista Notass:\n" );
                listaNotas.imprimirLista();
                nodoInicio = listaNotas.getInicio(); 
                System.out.println("Nodo inicio: "+nodoInicio.getNota());
                //Calcular el promedio
                promedio = listaEstudiante.calcularPromedio(nodoInicio);
                System.out.println("Promedio: "+promedio);
                //Agregar estudiante a la lista
                estudiante = listaEstudiante.agregarEstudiante(nombre,carnet,listaNotas,promedio);
                //Le envia el estudiante creado al arbol para añadirlo
                crearArbol(estudiante);
                break;

                case "b":
                mostrarMenu();                
                break;             
            }
        }      
    }

    public void crearArbol(Estudiante estudiante){        
        arbolEstudiante.agregarHijo(estudiante);        
    }

    public void mostrarMenu() {  
        float promedioIngresado = Float.parseFloat(JOptionPane.showInputDialog ("Digite el promedio"));
        String entrada= ""; 
        while (! "f".equals (entrada)){
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
                imprimir = arbolEstudiante.imprimirMayores(arbolEstudiante.getRaiz(),promedioIngresado);
                JOptionPane.showMessageDialog(null,"Valores mayores: \n" + imprimir);
                break;

                case "b":

                imprimir = arbolEstudiante.imprimirMenores(arbolEstudiante.getRaiz(),promedioIngresado);
                JOptionPane.showMessageDialog(null,"Valores menores: \n" + imprimir);
                break;

                case "c":
                imprimir = arbolEstudiante.imprimirIguales(arbolEstudiante.getRaiz(),promedioIngresado);
                JOptionPane.showMessageDialog(null,"Valores iguales: \n" + imprimir);
                break;

                case "d":
                System.out.println("Todos los promedios\n");
                arbolEstudiante.recorrerEnOrden(arbolEstudiante.getRaiz());
                break;

                case "e":
                
                JOptionPane.showMessageDialog(null,"Muchas gracias por usar el programa");
                break;
            }
        }      
    }

  
}
