
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
    ListaNotas listaNotas  = new ListaNotas();
    Nodo nodoInicio = new Nodo();

    String nombre = "";
    int carnet = 0;   
    int nota =0;
    float promedio = 0;
    String menores = "";
    String mayores = "";
    String iguales = "";
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
                listaNotas  = new ListaNotas();
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
                imprimir = imprimirMayores(promedioIngresado,arbolEstudiante.getRaiz());
                JOptionPane.showMessageDialog(null,"Valores mayores: \n" + imprimir);
                break;

                case "b":

                imprimir = imprimirMenores(promedioIngresado,arbolEstudiante.getRaiz());
                JOptionPane.showMessageDialog(null,"Valores menores: \n" + imprimir);
                break;

                case "c":
                imprimir = imprimirIguales(promedioIngresado,arbolEstudiante.getRaiz());
                JOptionPane.showMessageDialog(null,"Valores iguales: \n" + imprimir);
                break;

                case "d":
                String promedioEstudiantes = listaEstudiante.toString();
                JOptionPane.showMessageDialog(null,"Promedio de todos los estudiantes: \n" + promedioEstudiantes);
                break;

                case "e":
                       System.out.println("Valores del arbol\n");
                arbolEstudiante.recorrerEnOrden(arbolEstudiante.getRaiz());
                //JOptionPane.showMessageDialog(null,"Muchas gracias por usar el programa");
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
    public String imprimirMenores(float promedio, NodoArbol nodoActual){

        if( nodoActual != null)
        {
            imprimirMenores(promedio,nodoActual.getHijoIzquierdo());
            float promedioComparar = nodoActual.estudiante.getPromedio();
            if(promedioComparar < promedio){
                menores +=" " + promedioComparar;
            }            
            imprimirMenores(promedio,nodoActual.getHijoDerecho());
        }
        return menores;
    }

    /**
     * Metodo que imprime los datos de los Estudiantes
     * que tienen un promedio igual al indicado.
     * 
     * @param  promedio
     * @return    
     */
    public String imprimirIguales(float promedio,NodoArbol nodoActual){
        if( nodoActual != null)
        {
            imprimirMenores(promedio,nodoActual.getHijoIzquierdo());
            float promedioComparar = nodoActual.estudiante.getPromedio();
            if(promedioComparar == promedio){
                menores +=" " + promedioComparar;
            }            
            imprimirMenores(promedio,nodoActual.getHijoDerecho());
        }
        return iguales;
    }

    /**
     * Metodo que imprime los datos de los Estudiantes
     * que tienen un promedio mayor al indicado.
     * 
     * @param  promedio
     * @return    
     */
    public String imprimirMayores(float promedio,NodoArbol nodoActual){
                if( nodoActual != null)
        {
            imprimirMenores(promedio,nodoActual.getHijoIzquierdo());
            float promedioComparar = nodoActual.estudiante.getPromedio();
            if(promedioComparar > promedio){
                menores +=" " + promedioComparar;
            }            
            imprimirMenores(promedio,nodoActual.getHijoDerecho());
        }
        return iguales;
    }
}
