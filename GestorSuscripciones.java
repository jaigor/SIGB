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
    }
    
    /**
     * Borrar una Suscripcion de la base de datos (Dar de Baja)
     * 
     * @param  bajaSuscripcion   la suscripcion a eliminar
     */
    public void eliminarSuscripcion(Suscripcion bajaSuscripcion)
    {
        suscripciones.remove(bajaSuscripcion);
    }
    
    /**
     * Buscador simple usando el Titulo de la obra e imprimiendo el material buscado
     * 
     * @return  el material en concreto buscado por el usuario
     */
    public Suscripcion buscarSuscripcion(Socio perSuscrito)
    {
        if (suscripciones.size() > 0) {
            for (Suscripcion suscripcion : suscripciones) {
                if (suscripcion.getPerSuscrito().equals(perSuscrito)){
                    return suscripcion;
                }
            }
        }
        return null;
    }
}
