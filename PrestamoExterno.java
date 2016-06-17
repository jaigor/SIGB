import java.util.Date;

/**
 * Write a description of class PrestamoExterno here.
 * 
 * @author Igor Quintela 
 * @version 17/06/2016
 */
public class PrestamoExterno extends Prestamo
{

    /**
     * Constructor for objects of class PrestamoExterno
     */
    public PrestamoExterno(Date fechaPrestamo, Material matPrestado, Socio socioPrestamo, int duracionPrestamo) 
    {
        super(fechaPrestamo, matPrestado, socioPrestamo, duracionPrestamo);
    }
    
    
}
