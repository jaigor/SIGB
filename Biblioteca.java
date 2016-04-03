import java.util.ArrayList;
import java.util.HashMap;

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
    private HashMap<ETipoMaterial, ArrayList> materiales;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Suscripcion> suscripciones;
        
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
        materiales = new HashMap<ETipoMaterial, ArrayList>();
        materiales.put(ETipoMaterial.LIBRO, new ArrayList<Libro>());
        materiales.put(ETipoMaterial.AUDIO, new ArrayList<Audio>());
        materiales.put(ETipoMaterial.VIDEO, new ArrayList<Video>());
        materiales.put(ETipoMaterial.PERIODICO, new ArrayList<Periodico>());
        materiales.put(ETipoMaterial.REVISTA, new ArrayList<Revista>());
        
        prestamos = new ArrayList<Prestamo>();
        suscripciones = new ArrayList<Suscripcion>();
        // Asignacion de los campos correspondientes a la biblioteca
        this.bNombre = bNombre;
        this.bDireccion = bDireccion;
        this.bTelefono = bTelefono;
        this.bHorario = bHorario;
    }
    
    /***************MATERIALES
     * Añadir un nuevo Material a la base de datos
     * @param  materiales   el nuevo material a añadir
     */
    public void añadirMaterial(Material nuevoMaterial)
    {
        if (nuevoMaterial instanceof Libro){
            materiales.get(ETipoMaterial.LIBRO).add(nuevoMaterial);
        } else if (nuevoMaterial instanceof Audio) {
            materiales.get(ETipoMaterial.AUDIO).add(nuevoMaterial);
        } else if (nuevoMaterial instanceof Video){
            materiales.get(ETipoMaterial.VIDEO).add(nuevoMaterial);
        } else if (nuevoMaterial instanceof Periodico){
            materiales.get(ETipoMaterial.PERIODICO).add(nuevoMaterial);
        } else if(nuevoMaterial instanceof Revista){
            materiales.get(ETipoMaterial.REVISTA).add(nuevoMaterial);
        }
    }
    
    /**
     * Borrar un Material de la base de datos (Dar de Baja)
     * @param  bajaMaterial   el material a eliminar
     */
    public void eliminarMaterial(Material bajaMaterial)
    {
        if (bajaMaterial instanceof Libro){
            materiales.get(ETipoMaterial.LIBRO).remove(bajaMaterial);
        } else if (bajaMaterial instanceof Audio) {
            materiales.get(ETipoMaterial.AUDIO).remove(bajaMaterial);
        } else if (bajaMaterial instanceof Video){
            materiales.get(ETipoMaterial.VIDEO).remove(bajaMaterial);
        } else if (bajaMaterial instanceof Periodico){
            materiales.get(ETipoMaterial.PERIODICO).remove(bajaMaterial);
        } else if(bajaMaterial instanceof Revista){
            materiales.get(ETipoMaterial.REVISTA).remove(bajaMaterial);
        }
    }
    
   /**
    * @return  la colección almacenada en material (cada uno de los items)
    */
   public ArrayList<Material> getMateriales(ETipoMaterial tipoMaterial)
   {
       return materiales.get(tipoMaterial);
   }
    
   /**
    * Buscador simple usando el Titulo de la obra e imprimiendo el material buscado
    * 
    * @return  el material en concreto buscado por el usuario
    */
   public Material buscarMaterial(String matTitulo)
   {
       ArrayList <Material> listaMatLibro = materiales.get(ETipoMaterial.LIBRO);
       ArrayList <Material> listaMatAudio = materiales.get(ETipoMaterial.AUDIO);
       ArrayList <Material> listaMatVideo = materiales.get(ETipoMaterial.VIDEO);
       ArrayList <Material> listaMatPeriodico = materiales.get(ETipoMaterial.PERIODICO);
       ArrayList <Material> listaMatRevista = materiales.get(ETipoMaterial.REVISTA);
       
       for (Material titulo : listaMatLibro){
            if (titulo.getMTitulo() == matTitulo){
                return titulo;
            }
       }
       for (Material titulo : listaMatAudio){
            if (titulo.getMTitulo() == matTitulo){
                return titulo;
            }
       }
       for (Material titulo : listaMatVideo){
            if (titulo.getMTitulo() == matTitulo){
                return titulo;
            }
       }
       for (Material titulo : listaMatPeriodico){
            if (titulo.getMTitulo() == matTitulo){
                return titulo;
            }
       }
       for (Material titulo : listaMatRevista){
            if (titulo.getMTitulo() == matTitulo){
                return titulo;
            }
       }
       return null;
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
