
/**
 * Write a description of class ListaEstudiante here.
 * 
 * @author Judith Vargas  
 * @version 1
 */
public class ListaEstudiante
{
    private Estudiante inicio;
    private int tamanio;
    private float promedio;
    int totalNotas =0;
    int sumaNotas =0;

    public void Lista()
    {
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia()
    {
        return inicio == null;
    }

    public int getTamanio()
    {
        return tamanio;
    }

    public void agregarEstudiante(String nombre, int carnet,float promedio )
    {
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setCarnet(carnet);
        nuevoEstudiante.setPromedio(promedio);
        
        if(esVacia())
        {
            inicio = nuevoEstudiante;
        }
        else
        {
            Estudiante auxiliar = inicio;

            while(auxiliar.getSiguiente() != null)
            {
                auxiliar = auxiliar.getSiguiente();
            }

            auxiliar.setSiguiente(nuevoEstudiante);
        }
        tamanio++;
    }

    public String toString(){
        String datosEstudiante = "";
        if(!esVacia())
        {
            Estudiante auxiliar = inicio;
            int posicion = 0;
            while(auxiliar.getSiguiente() != null)
            {
                datosEstudiante = "Carnet: " + auxiliar.getCarnet() 
                + " Nombre: " + auxiliar.getNombre()
                + " Promedio: " + auxiliar.getPromedio()
                + "\n";
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }            
            datosEstudiante = "Carnet: " + auxiliar.getCarnet() 
            + " Nombre: " + auxiliar.getNombre()
            + " Promedio: " + auxiliar.getPromedio()
            + "\n";                 
        }
        return datosEstudiante;
    }

    public float calcularPromedio(Nodo auxiliar){
        if(!esVacia()){
            return 0;           
        }else if(auxiliar == null){
            return promedio;
        }else{
            totalNotas = totalNotas+1;
            sumaNotas += auxiliar.getNota();
            promedio = sumaNotas / totalNotas;
            auxiliar = auxiliar.getSiguiente();
            return calcularPromedio(auxiliar); 
        }
    }
}
