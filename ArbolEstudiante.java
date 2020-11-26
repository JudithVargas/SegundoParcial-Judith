
/**
 * Write a description of class Arbol here.
 * 
 * @author Judith Vargas  
 * @version 1
 */
public class ArbolEstudiante
{
   NodoArbol raiz;

    public ArbolEstudiante()
    {
        raiz = null;
    }
    
    public NodoArbol getRaiz()
    {
        return raiz;
    }
    
    private NodoArbol agregarRecursivo(NodoArbol actual, Estudiante estudiante)
    {
        if(actual == null)
        {
            return new NodoArbol(estudiante);
        }
        else if( estudiante.getPromedio() < actual.estudiante.getPromedio() )
        {
            actual.setHijoIzquierdo(agregarRecursivo(actual.getHijoIzquierdo(), estudiante));
        }
        else if( estudiante.getPromedio() > actual.estudiante.getPromedio() )
        {
            actual.setHijoDerecho(agregarRecursivo(actual.getHijoDerecho(), estudiante));
        }
        else
        {
            return actual;
        }
        
        return actual;
    }
    
    public void agregarHijo(Estudiante estudiante)
    {
        raiz = agregarRecursivo(raiz, estudiante);
    }
    
    public void recorrerEnOrden(NodoArbol nodoActual)
    {
        if( nodoActual != null)
        {
            recorrerEnOrden(nodoActual.getHijoIzquierdo());
            System.out.print(" " + nodoActual.estudiante.getPromedio());
            recorrerEnOrden(nodoActual.getHijoDerecho());
        }
    }
    

}
