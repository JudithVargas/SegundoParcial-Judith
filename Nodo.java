
/**
 * Write a description of class Nodo here.
 * 
 * @author Judith Vargas 
 * @version 1
 */
public class Nodo
{
    private int nota;
    private Nodo siguiente;

    /**
     * Constructor for objects of class Nodo
     */
    public void Nota()
    {
        this.nota = 0;
        this.siguiente = null;
    }
    
    public int getNota()
    {
        return nota;
    }
    
    public void setNota(int nota)
    {
        this.nota = nota;
    }

    public Nodo getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }
}
