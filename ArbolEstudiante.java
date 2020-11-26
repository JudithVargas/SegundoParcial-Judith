
/**
 * Write a description of class Arbol here.
 * 
 * @author Judith Vargas  
 * @version 1
 */
public class ArbolEstudiante
{
    NodoArbol raiz;
    String menores = "";
    String mayores = "";
    String iguales = "";

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

     /**
     * Metodo que imprime los datos de los Estudiantes
     * que tienen un promedio menor al indicado.
     * 
     * @param  promedio
     * @return    
     */
    public void recorrerEnOrden(NodoArbol nodoActual)
    {
        if( nodoActual != null)
        {
            recorrerEnOrden(nodoActual.getHijoIzquierdo());
            System.out.print(" " + nodoActual.estudiante.getPromedio());
            recorrerEnOrden(nodoActual.getHijoDerecho());
        }
    }

    /**
     * Metodo que imprime los datos de los Estudiantes
     * que tienen un promedio menor al indicado.
     * 
     * @param  promedio
     * @return    
     */

    public String imprimirMenores(NodoArbol nodoActual,float promedio){
        if( nodoActual != null)
        {
            imprimirMenores(nodoActual.getHijoIzquierdo(),promedio);
            float promedioComparar = nodoActual.estudiante.getPromedio();
            if(promedioComparar < promedio){
                menores = menores + "Nombre: " + nodoActual.estudiante.getNombre()
                + " Carnet: " + nodoActual.estudiante.getCarnet()
                + " Promedio: " + nodoActual.estudiante.getPromedio()
                +"\n";
            }            
            imprimirMenores(nodoActual.getHijoDerecho(),promedio);
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
    public String imprimirIguales(NodoArbol nodoActual,float promedio){
        if( nodoActual != null)
        {
            imprimirIguales(nodoActual.getHijoIzquierdo(),promedio);
            float promedioComparar = nodoActual.estudiante.getPromedio();
            if(promedioComparar == promedio){
                iguales = iguales +"Nombre: " + nodoActual.estudiante.getNombre()
                + " Carnet: " + nodoActual.estudiante.getCarnet()
                + " Promedio: " + nodoActual.estudiante.getPromedio()
                +"\n";
            }             
            imprimirIguales(nodoActual.getHijoDerecho(),promedio);
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
    public String imprimirMayores(NodoArbol nodoActual,float promedio){
        if( nodoActual != null)
        {
            imprimirMayores(nodoActual.getHijoIzquierdo(),promedio);
            float promedioComparar = nodoActual.estudiante.getPromedio();
            if(promedioComparar > promedio){
                mayores = mayores + "Nombre: " + nodoActual.estudiante.getNombre()
                + " Carnet: " + nodoActual.estudiante.getCarnet()
                + " Promedio: " + nodoActual.estudiante.getPromedio()
                +"\n"; 
            }            
            imprimirMayores(nodoActual.getHijoDerecho(),promedio);
        }
        return mayores;
    }

}
