import java.util.ArrayList;

/**
 * Esta clase representa al objeto Socio (usuario estándar).
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 20/04/2016
 */
public class Socio extends Perfil
{
    private int permisoID = 1; //id equivalente a clase usuario, dentro de perfiles
    private ArrayList<Prestamo> historialPrestamo;
    private ArrayList<Prestamo> prestamosEnActivo;
    private ArrayList<MaterialSuscripcion> listaMatSuscritos;
    /**
     * Inicializa el usuario (Socio)
     * asociando campos e iniciando las
     * colecciones que mantiene el objeto
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
     * Devuelve el listado de los materiales
     * a los que se encuentran suscritos
     * 
     * @return  Lista (Array) de los Materiales suscritos 
     */
    public ArrayList<MaterialSuscripcion> getListaMatSuscritos()
    {
        return listaMatSuscritos;
    }
    
    /**
     * Añade un nuevo Material al que
     * se ha suscrito el usuario
     * 
     * @param  nuevoMatSusc nuevo material suscribible
     */
    public void añadirMatSusc(MaterialSuscripcion nuevoMatSusc)
    {
        listaMatSuscritos.add(nuevoMatSusc);
    }
    
    /**
     * Elimina un Material al que
     * se encontraba suscrito el usuario
     * 
     * @param  bajaMatSusc material suscribible a eliminar
     */
    public void eliminarMatSusc(MaterialSuscripcion bajaMatSusc)
    {
        listaMatSuscritos.remove(bajaMatSusc);
    }
    
    /**
     * Devuelve el listado de todo su 
     * historial de prestámos que ha tenido
     * 
     * @return  Lista (Array) de los Materiales suscritos (total)
     */
    public ArrayList<Prestamo> getHistorialPrestamo()
    {
        return historialPrestamo;
    }
    
    /**
     * Devuelve el listado de todo sus
     * prestámos en activo
     * 
     * @return  Lista (Array) de los Materiales suscritos activos
     */
    public ArrayList<Prestamo> getPrestamosEnActivo()
    {
        return prestamosEnActivo;
    }
    
    /**
     * Añade un nuevo préstamo tanto
     * al historial activo como al histórico
     * 
     * @param   nuevoPrestamo   nuevo préstamo a añadir 
     */
    public void añadirPrestamos(Prestamo nuevoPrestamo)
    {
        historialPrestamo.add(nuevoPrestamo);
        prestamosEnActivo.add(nuevoPrestamo);
    }
    
    /**
     * Elimina un préstamo existente tanto
     * del historial activo
     * 
     * @param   bajaPrestamo   préstamo existente a eliminar  
     */
    public void eliminarPrestamo(Prestamo bajaPrestamo)
    {
        prestamosEnActivo.remove(bajaPrestamo);
    }
}
