
/**
 * Write a description of class Lista here.
 * 
 * @author Judith Vargas 
 * @version 1
 */
public class ListaNotas
{
    private Nodo inicio;
    private int tamanio;

    public void ListaNotas()
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
    
    public Nodo getInicio(){
        return inicio;
    }
    
    public void agregarNota(int valor)
    {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setNota(valor);
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            Nodo auxiliar = inicio;
            
            while(auxiliar.getSiguiente() != null)
            {
                auxiliar = auxiliar.getSiguiente();
            }
            
            auxiliar.setSiguiente(nuevoNodo);
        }
        
        tamanio++;
    }
       public void imprimirLista()
    {
        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            int posicion = 0;
            
            while(auxiliar.getSiguiente() != null)
            {
                System.out.println("Posicion: " + posicion + " Valor: " + auxiliar.getNota());
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }
            
            System.out.println("Posicion: " + posicion + " Valor: " + auxiliar.getNota());
        }
    }
    
}
