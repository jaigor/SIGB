import java.util.ArrayList;

/**
 * Esta es la clase principal del sistema de gestión.
 * En ella, se inician las diferentes colecciones
 * de items que tiene el sistema:
 *      Perfiles
 *      Materiales
 *      Prestamos
 *      Suscripciones
 *      ...
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Biblioteca
{
    // Arrays de las diferentes colecciones 
    private ArrayList<Material> materiales;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Suscripcion> suscripciones;
    
    private static int contadorUsuarios = 0; // id de usuarios inicializado a 0
        
    // Campos exclusivos pertenecientes a la biblioteca
    private String bNombre;
    private String bDireccion;
    private int bTelefono;
    private String bHorario;

    /**
     * Crea bases de datos de las diferentes clases
     * y asigna los valores registrados a los campos
     * de la nueva biblioteca
     * 
     * @param bNombre Nombre completo de la biblioteca.
     * @param bDireccion Direccion local de la biblioteca.
     * @param bTelefono Número de teléfono de la biblioteca.
     * @param bHorario Horario de apertura de la biblioteca.
     */
    public Biblioteca(String bNombre, String bDireccion, int bTelefono, String bHorario)
    {
        // Inicialización de las colecciones
        materiales = new ArrayList<Material>();
        prestamos = new ArrayList<Prestamo>();
        suscripciones = new ArrayList<Suscripcion>();
        // Asignacion de los campos correspondientes a la biblioteca
        this.bNombre = bNombre;
        this.bDireccion = bDireccion;
        this.bTelefono = bTelefono;
        this.bHorario = bHorario;
    }
    
    /**
     * Método usado para agregar un campo id númerico a cada usuario
     * Es un método estático porque no nos interesa el conocer de
     * que biblioteca es el perfil
     * 
     * @return  contadorUsuarios    devuelve el número actual de usuario
     */
    public static int getIDPerfil()
    {
        contadorUsuarios++;
        return contadorUsuarios;
    }

    /***************PERFILES
     * Añadir un nuevo Perfil a la base de datos (Dar de Alta)
     * @param  nuevoPerfil   el nuevo perfil a añadir
     */
    public void añadirPerfil(Perfil nuevoPerfil)
    {
        //nuevoPerfil.comprobarPerfil(nuevoPerfil);
        perfiles.add(nuevoPerfil);
    }
    
    /**
     * Borrar un Perfil de la base de datos (Dar de Baja)
     * @param  bajaPerfil   el perfil a eliminar
     */
    public void eliminarPerfil(Perfil bajaPerfil)
    {
        perfiles.remove(bajaPerfil);
    }
    
    /**
     * @return  la colección almacenada en perfiles (todos los usuarios)
     */
    public ArrayList<Perfil> getPerfiles()
    {
        return perfiles;
    }

    
    /***************MATERIALES
     * Añadir un nuevo Material a la base de datos
     * @param  materiales   el nuevo material a añadir
     */
    public void añadirMaterial(Material nuevoMaterial)
    {
        materiales.add(nuevoMaterial);
    }
    
    /**
     * Borrar un Material de la base de datos (Dar de Baja)
     * @param  bajaMaterial   el material a eliminar
     */
    public void eliminarMaterial(Perfil bajaMaterial)
    {
        materiales.remove(bajaMaterial);
    }
    
    /***************PRESTAMOS
     * Añadir un nuevo Prestamo a la base de datos
     * @param  nuevoPrestamo   el nuevo prestamo a añadir
     */
    public void añadirPrestamo(Prestamo nuevoPrestamo)
    {
        prestamos.add(nuevoPrestamo);
    }
    
    /**
     * Borrar un Prestamo de la base de datos (Dar de Baja)
     * @param  bajaPrestamo   el prestamo a eliminar
     */
    public void eliminarPrestamo(Perfil bajaPrestamo)
    {
        prestamos.remove(bajaPrestamo);
    }
    
    /***************SUSCRIPCIONES
     * Añadir una nueva Suscripcion a la base de datos
     * @param  nuevaSuscripcion   la nueva suscripcion a añadir
     */
    public void añadirSuscripcion(Suscripcion nuevaSuscripcion)
    {
        suscripciones.add(nuevaSuscripcion);
    }
    
    /**
     * Borrar una Suscripcion de la base de datos (Dar de Baja)
     * @param  bajaSuscripcion   la suscripcion a eliminar
     */
    public void eliminarSuscripcion(Perfil bajaSuscripcion)
    {
        suscripciones.remove(bajaSuscripcion);
    }
        
}
