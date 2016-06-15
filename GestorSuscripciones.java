import java.util.ArrayList;

/**
 * Write a description of class GestorSuscripciones here.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class GestorSuscripciones
{
    private ArrayList<Suscripcion> suscripciones;
    
    /**
     * Constructor for objects of class GestorSuscripciones
     */
    public GestorSuscripciones()
    {
        suscripciones = new ArrayList<Suscripcion>();
    }
    
    /**
     * 
     * Añadir una nueva Suscripcion a la base de datos
     * 
     * @param  nuevaSuscripcion   la nueva suscripcion a añadir
     */
    public void añadirSuscripcion(Suscripcion nuevaSuscripcion)
    {
        suscripciones.add(nuevaSuscripcion);
        Socio socioSuscrito = nuevaSuscripcion.getPerSuscrito();
        MaterialSuscripcion matSuscrito = nuevaSuscripcion.getMatSuscrito();
        socioSuscrito.añadirMatSusc(matSuscrito);
        System.out.println("Suscripción añadida");
    }
    
    /**
     * Borrar una Suscripcion de la base de datos (Dar de Baja)
     * 
     * @param  bajaSuscripcion   la suscripcion a eliminar
     */
    public void eliminarSuscripcion(Suscripcion bajaSuscripcion)
    {
        suscripciones.remove(bajaSuscripcion);
        Socio socioSuscrito = bajaSuscripcion.getPerSuscrito();
        MaterialSuscripcion matSuscrito = bajaSuscripcion.getMatSuscrito();
        socioSuscrito.añadirMatSusc(matSuscrito);
        System.out.println("Suscripción eliminada");
    }
    
    /**
     * Buscador simple usando el Titulo de la obra e imprimiendo el material buscado
     * 
     * @return  el material en concreto buscado por el usuario
     */
    public Suscripcion buscarSuscripcion(Socio perSuscrito, MaterialSuscripcion matSuscrito)
    {
        if (suscripciones.size() > 0) {
            for (Suscripcion suscripcion : suscripciones) {
                if (suscripcion.getPerSuscrito().equals(perSuscrito) && 
                suscripcion.getMatSuscrito().equals(matSuscrito)){
                    return suscripcion;
                }
            }
        }
        return null;
    }
    
    /**
     * Buscador simple usando el Titulo de la obra e imprimiendo el material buscado
     * 
     * @return  el material en concreto buscado por el usuario
     */
    public void printSuscripcion(Suscripcion suscripcion)
    {
        System.out.println("-------------------------");
        System.out.println("DNI (Socio): " + suscripcion.getPerSuscrito().getPerDNI());
        System.out.println("Nombre (Socio): " + suscripcion.getPerSuscrito().getPerNombre());
        System.out.println("Material suscrito (Título): " + suscripcion.getMatSuscrito().getMatTitulo());
        System.out.println("Fecha Suscripción: " + suscripcion.getFechaSuscripcion());
    }
    
    /**
     * Buscador simple usando el Titulo de la obra e imprimiendo el material buscado
     * 
     * @return  el material en concreto buscado por el usuario
     */
    public void listadoSuscripciones()
    {
        for (Suscripcion suscripcion : suscripciones){
            printSuscripcion(suscripcion);            
        }
    }
}
