
/**
 * Write a description of class NodoArbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoArbol
{
     Estudiante estudiante;
    NodoArbol hijoIzquierdo;
    NodoArbol hijoDerecho;

    public NodoArbol(Estudiante estudiante)
    {
        this.estudiante = estudiante;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
    
    public Estudiante getEstudiante()
    {
        return estudiante;
    }
    
    public NodoArbol getHijoIzquierdo()
    {
        return hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho()
    {
        return hijoDerecho;
    }
    
    public void setEstudiante(Estudiante estudiante)
    {
        this.estudiante = estudiante;
    }
    
    public void setHijoIzquierdo(NodoArbol nuevoNodo)
    {
        hijoIzquierdo = nuevoNodo;
    }

    public void setHijoDerecho(NodoArbol nuevoNodo)
    {
        hijoDerecho = nuevoNodo;
    }
}
