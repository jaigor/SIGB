import java.util.Date;
import java.util.Calendar;

/**
 * Clase que representa la suscripción
 * de un usuario asociada a el mismo,
 * un Material Suscribible y a su periodicidad.
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
     * Asocia los campos de socio y material
     * a la Suscripción
     * pasados al constructor
     * 
     * @param perSuscrito   socio suscrito 
     * @param matSuscrito   material suscrito 
     */
    public Suscripcion(Socio perSuscrito, MaterialSuscripcion matSuscrito)
    {
       this.perSuscrito = perSuscrito;
       this.matSuscrito = matSuscrito; 
       fechaSuscripcion = new Date();
       
       // se llama a la Clase Calendar para establecer una periodicidad en el prestamo
       Calendar cal = Calendar.getInstance();
       cal.setTime(fechaSuscripcion);          // se fija la fecha a comparar
       fechaSuscripcion = cal.getTime();       // fechaSuscripcion se obtiene tras el cálculo
    }

    /**
     * Retorna el Socio al que se encuentra suscrito
     * 
     * @return  Socio (clase) suscrito 
     */
    public Socio getPerSuscrito()
    {
        return perSuscrito;
    }
    
    /**
     * Modifica el Socio al que se encuentra suscrito
     * 
     * @param  perSuscrito    nuevo Socio asociado a la suscripción
     */
    public void setPerSuscrito(Socio perSuscrito)
    {
        this.perSuscrito = perSuscrito;
    }
    
    /**
     * Retorna el Material al que se encuentra suscrito
     * 
     * @return  Material (clase) asociado a la suscripción  
     */
    public MaterialSuscripcion getMatSuscrito()
    {
        return matSuscrito;
    }
    
    /**
     * Modifica el Material al que se encuentra suscrito
     * 
     * @param  matSuscrito    nuevo Material(MaterialSuscripcion) de suscripción
     */
    public void setMatSuscrito(MaterialSuscripcion matSuscrito)
    {
        this.matSuscrito = matSuscrito;
    }
    
    /**
     * Retorna la fecha de cuando se hizo la suscripción
     * 
     * @return  Fecha de Suscripcion  
     */
    public Date getFechaSuscripcion()
    {
        return fechaSuscripcion;
    }
    
    /**
     * Modifica la fecha de cuando se hizo la suscripción
     * 
     * @param  fechaSuscripcion    nueva fecha (Date) de suscripción
     */
    public void setFechaSuscripcion(Date fechaSuscripcion)
    {
        this.fechaSuscripcion = fechaSuscripcion;
    }
    
}
