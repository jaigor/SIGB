import java.util.ArrayList;

/**
 * Esta clase representa al objeto Socio (usuario estándar).
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Socio extends Perfil
{
    private int permisoID = 1; //id equivalente a clase usuario, dentro de perfiles
    private ArrayList<Prestamo> historialPrestamo;
    private ArrayList<Prestamo> prestamosEnActivo;
    private ArrayList<MaterialSuscripcion> listaMatSuscritos;
    
    /**
     * Inicializa el usuario (Socio)
     * 
     * @param perDNI        Número y letra del DNI del usuario.
     * @param perNombre     Nombre del usuario.
     * @param perApellidos  Apellidos del usuario.
     * @param perDireccion  Direccion local del usuario.
     * @param perUser       Nombre/nick del usuario.
     * @param perPassword   Password del usuario.
     */
    public Socio(String perDNI, String perNombre, String perApellidos, String perDireccion, 
    String perUser, String perPassword)
    {
        super(perDNI, perNombre, perApellidos, perDireccion, perUser, perPassword);
        setPermisoID(permisoID);
        
        historialPrestamo = new ArrayList<Prestamo> (); // historial total prestamos del socio
        prestamosEnActivo = new ArrayList<Prestamo> (); // historial en activo de prestamos (no mayor que 6)
        
        listaMatSuscritos = new ArrayList<MaterialSuscripcion> (); // Materiales a los que se encuentra suscrito
    }
    
    /**
     * Devuelve el listado de los materiales a los que se encuentran suscritos
     * 
     * @return  Lista (Array) de los Materiales que se encuentran suscritos 
     */
    public ArrayList<MaterialSuscripcion> getListaMatSuscritos()
    {
        return listaMatSuscritos;
    }
    
    /**
     * Devuelve el listado de los materiales a los que se encuentran suscritos
     * 
     * @return  Lista (Array) de los Materiales que se encuentran suscritos 
     */
    public void añadirMatSusc(MaterialSuscripcion nuevoMatSusc)
    {
        listaMatSuscritos.add(nuevoMatSusc);
    }
    
        /**
     * Devuelve el listado de los materiales a los que se encuentran suscritos
     * 
     * @return  Lista (Array) de los Materiales que se encuentran suscritos 
     */
    public void eliminarMatSusc(MaterialSuscripcion bajaMatSusc)
    {
        listaMatSuscritos.remove(bajaMatSusc);
    }
    
    /**
     * Devuelve el listado de todo su historial de prestámos de materiales
     * 
     * @return  Lista (Array) de los Materiales que se encuentran suscritos 
     */
    public ArrayList<Prestamo> getHistorialPrestamo()
    {
        return historialPrestamo;
    }
    
    /**
     * Devuelve el listado de todo su historial de prestámos de materiales
     * 
     * @return  Lista (Array) de los Materiales que se encuentran suscritos 
     */
    public ArrayList<Prestamo> getPrestamosEnActivo()
    {
        return prestamosEnActivo;
    }
    
    /**
     * Devuelve el listado de los materiales a los que se encuentran suscritos
     * 
     * @return  Lista (Array) de los Materiales que se encuentran suscritos 
     */
    public void añadirPrestamos(Prestamo nuevoPrestamo)
    {
        historialPrestamo.add(nuevoPrestamo);
        prestamosEnActivo.add(nuevoPrestamo);
    }
    
    /**
     * Devuelve el listado de los materiales a los que se encuentran suscritos
     * 
     * @return  Lista (Array) de los Materiales que se encuentran suscritos 
     */
    public void eliminarPrestamo(Prestamo bajaPrestamo)
    {
        prestamosEnActivo.remove(bajaPrestamo);
    }
}
