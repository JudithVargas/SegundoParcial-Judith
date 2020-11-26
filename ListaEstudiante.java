
/**
 * Write a description of class ListaEstudiante here.
 * 
 * @author Judith Vargas  
 * @version 1
 */
public class ListaEstudiante
{
    Estudiante inicio;
    int tamanio;
    float promedio;
    int totalNotas;
    int sumaNotas;

    public ListaEstudiante()
    {
        inicio = null;
        tamanio = 0;
        promedio =0;
        totalNotas = 0;
        sumaNotas =0;
    }

    public boolean esVacia()
    {
        return inicio == null;
    }

    public int getTamanio()
    {
        return tamanio;
    }

    /**
     * Metodo que agrega cada estudiante de manera alfabetica
     * 
     * @param nombre,carnet,listaNotas,promedio
     * @return    
     */
    public Estudiante agregarEstudiante(String nombre, int carnet,ListaNotas listaNotas,float promedio )
    {
        Estudiante nuevoEstudiante = new Estudiante();       
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setCarnet(carnet);
        nuevoEstudiante.setListaNotas(listaNotas);
        nuevoEstudiante.setPromedio(promedio);

        Estudiante auxiliar = inicio;
        if(esVacia())
        {
            inicio = nuevoEstudiante;
        }
        else
        {
            if( nuevoEstudiante.getNombre().compareTo(auxiliar.getNombre())< 0){

                nuevoEstudiante.setSiguiente(inicio);
                inicio = nuevoEstudiante;
            }else{
                while(auxiliar.getSiguiente() != null)
                {
                    if(nuevoEstudiante.getNombre().compareTo(auxiliar.getNombre())< 0){
                        nuevoEstudiante.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevoEstudiante);
                        break;
                    }
                    auxiliar = auxiliar.getSiguiente();
                }
                nuevoEstudiante.setSiguiente(auxiliar.getSiguiente());
                auxiliar.setSiguiente(nuevoEstudiante);
            }
        }
        tamanio++;
        return nuevoEstudiante;
    }

    /**
     * Metodo que devuelve de manera ordenada los datos del estudiante 
     * 
     * @param 
     * @return String   
     */
    public String toString(){
        String datosEstudiante = "";
        if(!esVacia())
        {
            Estudiante auxiliar = inicio;
            while(auxiliar.getSiguiente() != null)
            {
                datosEstudiante = datosEstudiante + "Carnet: " + auxiliar.getCarnet() 
                + " Nombre: " + auxiliar.getNombre()
                + " Promedio: " + auxiliar.getPromedio()
                + "\n";
                auxiliar = auxiliar.getSiguiente();

            }            
            datosEstudiante =  datosEstudiante + "Carnet: " + auxiliar.getCarnet() 
            + " Nombre: " + auxiliar.getNombre()
            + " Promedio: " + auxiliar.getPromedio()
            + "\n";                 
        }
        return datosEstudiante;
    }

    /**
     * Metodo que calcula el promedio retorna el promedio de la lista.
     * 
     * @param 
     * @return float  
     */
    public float calcularPromedio(Nodo auxiliar){           
        if(auxiliar == null){
            return promedio;
        }else  {
            totalNotas=+ 1;
            sumaNotas =+ auxiliar.getNota();            
            promedio = sumaNotas/totalNotas;

            auxiliar = auxiliar.getSiguiente();            
            return calcularPromedio(auxiliar); 
        }
    }

}
