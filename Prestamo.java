import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;

/**
 * Clase en la que se almacenan los datos necesarios
 * para gestionar el Préstamo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Prestamo implements Serializable
{
    // Definicion de los campos necesarios para la clase Prestámo
    private Date fechaPrestamo;
    private Material matPrestado;
    private Socio socioPrestamo;
    private Date fechaDevolucion;
    private ETipoMaterial tipoMaterial;
    
    /**
     * Da de alta los campos genéricos de un material
     * 
     * @param fechaPrestamo     Fecha en la que se ha iniciado el prestamo.
     * @param matPrestado       Material que se prestado.
     * @param socioPrestamo     Socio al que se le hace el préstamo.
     * @param duracionPrestamo  Duración en días del Préstamo.
     */
    public Prestamo(Date fechaPrestamo, Material matPrestado, Socio socioPrestamo, int duracionPrestamo)
    {
        this.fechaPrestamo = fechaPrestamo;
        this.matPrestado = matPrestado;
        this.socioPrestamo = socioPrestamo;
        
        if (matPrestado instanceof Libro){
            tipoMaterial = ETipoMaterial.LIBRO;
        } else if (matPrestado instanceof Audio) {
            tipoMaterial = ETipoMaterial.AUDIO;
        } else if (matPrestado instanceof Video){
            tipoMaterial = ETipoMaterial.VIDEO;
        } else if (matPrestado instanceof Periodico){
            tipoMaterial = ETipoMaterial.PERIODICO;
        } else if(matPrestado instanceof Revista){
            tipoMaterial = ETipoMaterial.REVISTA;
        } 
        
        // se llama a la Clase Calendar para establecer una periodicidad en el prestamo
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaPrestamo);               // se fija la fecha a comparar
        cal.add(Calendar.DATE, duracionPrestamo); // periodicidad calculada de introducido en el constructor
        this.fechaDevolucion = cal.getTime();     // fechaDevolucion se obtiene tras el cálculo 
    }
    
    /**
     * Devuelve la fecha en la que se hizo el prestamo
     * 
     * @return  Fecha (Date) del prestamo 
     */
    public Date getFechaPrestamo()
    {
        return fechaPrestamo;
    }
    
    /**
     * Modifica la fecha en la que se hizo el prestamo
     * 
     * @param  fechaPrestamo    la fecha de realización del préstamo
     */
    public void setFechaPrestamo(Date fechaPrestamo)
    {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    /**
     * Devuelve el material que se ha prestado
     * 
     * @return  Material (clase) prestado 
     */
    public Material getMatPrestado()
    {
        return matPrestado;
    }
    
    /**
     * Modifica el material que se ha prestado
     * 
     * @param  matPrestado    el material prestado
     */
    public void setMatPrestado(Material matPrestado)
    {
        this.matPrestado = matPrestado;
    }
    
     /**
     * Devuelve el tipo del material prestado
     * 
     * @return  Material (clase) prestado 
     */
    public ETipoMaterial getTipoMat()
    {
        return tipoMaterial;
    }
    
    /**
     * Devuelve el socio al que se le ha prestado el material
     * 
     * @return  Socio (clase) que tiene el material 
     */
    public Socio getSocioPrestamo()
    {
        return socioPrestamo;
    }
    
    /**
     * Modifica el socio al que se le ha prestado el material
     * 
     * @param  socioPrestamo    el socio al que se le ha prestado
     */
    public void setSocioPrestamo(Socio socioPrestamo)
    {
        this.socioPrestamo = socioPrestamo;
    }
    
    /**
     * Devuelve la fecha exacta de devolución del material
     * 
     * @return  Fecha (Date) con la que se tiene que devolver el material 
     */
    public Date getFechaDevolucion()
    {
        return fechaDevolucion;
    }
    
    /**
     * Modifica la fecha exacta de devolución del material
     * 
     * @param  fechaDevolucion    Fecha devolución del material
     */
    public void setFechaDevolucion(Date fechaDevolucion)
    {
        this.fechaDevolucion = fechaDevolucion;
    }
}
