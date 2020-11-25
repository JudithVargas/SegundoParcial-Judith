
/**
 * Write a description of class ListaEstudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaEstudiante
{
    private Estudiante inicio;
    private int tamanio;
    private float promedio;
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

    public void agregarAlFinal(int valor)
    {
        Estudiante nuevoEstudiante = new Estudiante();
        //nuevoEstudiante.setValor(valor);

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

    public void tooString(){

    }

    public float calcularPromedio(){

        return promedio;
    }
}
