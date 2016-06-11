import java.util.Date;
import java.util.Calendar;

/**
 * Write a description of class Suscripcion here.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Suscripcion
{
    private Socio perSuscrito;
    private MaterialSuscripcion matSuscrito;
    private Date fechaSuscripcion;

    /**
     * Constructor for objects of class Suscripcion
     */
    public Suscripcion(Date fechaSuscripcion, Socio perSuscrito, MaterialSuscripcion matSuscrito)
    {
       this.perSuscrito = perSuscrito;
       this.matSuscrito = matSuscrito; 
       this.fechaSuscripcion = fechaSuscripcion;
       
       // se llama a la Clase Calendar para establecer una periodicidad en el prestamo
       Calendar cal = Calendar.getInstance();
       cal.setTime(fechaSuscripcion);          // se fija la fecha a comparar
       fechaSuscripcion = cal.getTime();       // fechaSuscripcion se obtiene tras el cálculo
    }

    /**
     * Retorna el Socio que se encuentra suscrito
     * 
     * @return  Socio (clase) suscrito 
     */
    public Socio getPerSuscrito()
    {
        return perSuscrito;
    }
    
    /**
     * Retorna el Material que se encuentra suscrito
     * 
     * @return  Material (clase) suscrito  
     */
    public MaterialSuscripcion getMatSuscrito()
    {
        return matSuscrito;
    }
}
