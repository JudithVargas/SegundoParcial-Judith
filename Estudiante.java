
/**
 * Write a description of class Estudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiante
{    
    private String nombre;
    private int carnet;
    ListaNotas listaNotas;
    private float promedio;
    private Estudiante siguiente;

    public void Estudiante() {
        this.nombre = "";        
        this.carnet = 0; 
        this.listaNotas = null;
        this.promedio = 0;
        this.siguiente = null;
    }

    /**
     * Constructor for objects of class Estudiante
     */

    public String getNombret()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getCarnet()
    {
        return carnet;
    }

    public void setCarnet(int carnet)
    {
        this.carnet = carnet;
    }

    public ListaNotas getListaNotas()
    {
        return listaNotas;
    }

    public void setListaNotas(ListaNotas listaNotas)
    {
        this.listaNotas = listaNotas;
    }

    public Estudiante getSiguiente()
    {
        return siguiente;
    }

    public void setSiguiente(Estudiante siguiente)
    {
        this.siguiente = siguiente;
    }
  
}
