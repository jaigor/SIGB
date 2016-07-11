
/**
 * Clase única, diseñada mediante el patrón
 * Singleton, para instanciar únicamente una 
 * biblioteca en el sistema.
 * En ella, se instancian los distintos
 * gestores a utilizar:
 *      Gestor de Perfiles
 *      Gestor de Materiales
 *      Gestor de Prestamos
 *      Gestor de SolicitudesExternas
 *      Gestor de Suscripciones
 * 
 * @author Igor Quintela 
 * @version 20/06/2016
 */
class Biblioteca
{
    // Singleton para acceder a la biblioteca
    private static Biblioteca instancia = new Biblioteca();
    public static Biblioteca getInstacia()
    {
        return instancia;
    }
    
    //Define los diferentes Gestores de elementos
    private GestorPerfiles gestPerf;
    private GestorMateriales gestorMat;
    private GestorPrestamos gestorPrest;
    private GestorSolicitudesExternas gestorSolicExt;
    private GestorSuscripciones gestorSusc;
    
    // Campos especificos pertenecientes a la biblioteca
    private String bibNombre;
    private String bibDireccion;
    private int bibTelefono;
    private String bibHorario;

    /**
     * Método que instancia los diferentes gestores
     * y asigna los valores registrados a los campos
     * de la nueva biblioteca
     * 
     * @param bibNombre         Nombre completo de la biblioteca.
     * @param bibDireccion      Direccion local de la biblioteca.
     * @param bibTelefono       Número de teléfono de la biblioteca.
     * @param bibHorario        Horario de apertura de la biblioteca.
     */
    public void inicializarBiblioteca(String bibNombre, String bibDireccion,
    int bibTelefono, String bibHorario)
    {
        // Inicialización de los gestores
        gestPerf = new GestorPerfiles();
        gestorMat = new GestorMateriales();
        gestorPrest = new GestorPrestamos();
        gestorSolicExt = new GestorSolicitudesExternas();
        gestorSusc = new GestorSuscripciones();
                
        // Asignacion de los campos correspondientes a la biblioteca
        this.bibNombre = bibNombre;
        this.bibDireccion = bibDireccion;
        this.bibTelefono = bibTelefono;
        this.bibHorario = bibHorario;
    }
    
    /**
     * Devuelve el nombre de la biblioteca instanciada.
     * 
     *  @return   Nombre (String) de la biblioteca 
     */
    public String getBibNombre()
    {
         return bibNombre;
    }
    
    /**
     * Modifica el nombre de la biblioteca instanciada.
     * 
     * @param  bibNombre    nombre de la biblioteca a modificar
     */
    public void setBibNombre(String bibNombre)
    {
        this.bibNombre = bibNombre;
    }
    
    /**
     * Devuelve la dirección de la biblioteca.
     * 
     *  @return   Dirección (String) de la biblioteca 
     */
    public String getBibDireccion()
    {
         return bibDireccion;
    }
    
    /**
     * Modifica la dirección de la biblioteca.
     * 
     * @param  bibDireccion    dirección de la biblioteca a modificar
     */
    public void setBibDireccion(String bibDireccion)
    {
        this.bibDireccion = bibDireccion;
    }
    
    /**
     * Devuelve el teléfono de la biblioteca.
     * 
     *  @return   Teléfono (int) de la biblioteca  
     */
    public int getBibTelefono()
    {
         return bibTelefono;
    }
    
    /**
     * Modifica el teléfono de la biblioteca.
     * 
     * @param  bibTelefono    el teléfono de la biblioteca a modificar
     */
    public void setBibTelefono(int bibTelefono)
    {
        this.bibTelefono = bibTelefono;
    }
    
    /**
     * Devuelve el horario de la biblioteca.
     * 
     *  @return   Horario (String) de la biblioteca  
     */
    public String getBibHorario()
    {
         return bibHorario;
    }
    
    /**
     * Modifica el horario de la biblioteca.
     * 
     * @param  bibHorario    el horario de la biblioteca a modificar
     */
    public void setBibHorario(String bibHorario)
    {
        this.bibHorario = bibHorario;
    }
    
    /**
     * Devuelve el aceeso a la clase gestor de
     * perfiles
     * 
     * @return   El gestor de perfiles indicado
     */
    public GestorPerfiles getGestPerf()
    {
        return gestPerf;
    }
    
    /**
     * Devuelve el aceeso a la clase gestor de 
     * Materiales asociado.
     * 
     *  @return   Gestor de Materiales 
     */
    public GestorMateriales getGestMat()
    {
         return gestorMat;
    }
    
    /**
     * Devuelve el aceeso a la clase gestor de
     * Préstamos asociado.
     * 
     *  @return   Gestor de Préstamos 
     */
    public GestorPrestamos getGestPrest()
    {
         return gestorPrest;
    }
    
    /**
     * Devuelve el aceeso a la clase gestor de
     * Solicitudes Externas asociado.
     * 
     *  @return   Gestor de Solicitudes Externos 
     */
    public GestorSolicitudesExternas getGestSolicExt()
    {
         return gestorSolicExt;
    } 
    
     /**
     * Devuelve el aceeso a la clase gestor de
     * Suscripciones asociado.
     * 
     *  @return   Gestor de Suscripciones 
     */
    public GestorSuscripciones getGestSusc()
    {
         return gestorSusc;
    } 
}
