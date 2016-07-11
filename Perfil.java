/**
 * Esta es la clase abstracta en la que se definen los métodos generales 
 * que afectan a distintos tipos de usuario pertenecientes a la biblioteca. 
 * Los tipos de usuario o perfiles que heredan esta clase son: 
 *      socio de la biblioteca
 *      bibliotecario
 *      director
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public abstract class Perfil 
{
    // Campos genéricos de los perfiles
    private String perDNI;
    private String perNombre;
    private String perApellidos;
    private String perDireccion;
    private String perUser;
    private String perPassword;
    private int permisoID;  // campo usado para guardar el valor del tipo de usuario creado

    /**
     * Asocia los campos genericos
     * al Perfil de usuario
     * pasados al constructor
     * 
     * @param perDNI        Número y letra del DNI del usuario.
     * @param perNombre     Nombre del usuario.
     * @param perApellidos  Apellidos del usuario.
     * @param perDireccion  Direccion local del usuario.
     * @param perUser       Alias/nick del usuario.
     * @param perPassword   Password del usuario.
     */
    public Perfil(String perDNI,String perNombre, String perApellidos, String perDireccion, 
    String perUser, String perPassword)
    {
        this.perDNI = perDNI;
        this.perNombre = perNombre;
        this.perApellidos = perApellidos;
        this.perDireccion = perDireccion;
        this.perUser = perUser;
        this.perPassword = perPassword;
    }

    /**
     * Modificación de los permisos y 
     * el tipo de usuario que se crea
     * 
     * @param  permisoID   numero que establece el tipo de usuario
     * 1 = Socio, 
     * 2 = Bibliotecario, 
     * 3 = Director
     */
    public void setPermisoID(int permisoID)
    {
        this.permisoID = permisoID;
    }
    
    /**
     * Devuelve el número de ID del 
     * permiso del usuario en cuestión.
     * 
     * @return ID del tipo de permiso 
     */
    public int getPermisoID()
    {
         return permisoID;
    }
    
    /**
     * Devuelve el número de DNI 
     * del perfil en cuestión.
     * 
     * @return DNI con letra (String) 
     */
    public String getPerDNI()
    {
         return perDNI;
    }
    
    /**
     * Modifica el número de 
     * DNI del perfil en cuestión.
     * 
     * @param  perDNI    número de DNI a modificar
     */
    public void setPerDNI(String perDNI)
    {
        this.perDNI = perDNI;
    }
    
    /**
     * Devuelve el Nombre del perfil en cuestión.
     * 
     * @return  Nombre (String) del usuario 
     */
    public String getPerNombre()
    {
         return perNombre;
    }
    
    /**
     * Modifica el Nombre del perfil en cuestión.
     * 
     * @param  perNombre    Nombre del perfil a modificar
     */
    public void setPerNombre(String perNombre)
    {
        this.perNombre = perNombre;
    }
    
    /**
     * Devuelve los Apellidos 
     * del perfil en cuestión.
     * 
     * @return  Apellidos (String) del usuario 
     */
    public String getPerApellidos()
    {
         return perApellidos;
    }
    
    /**
     * Modifica los Apellidos 
     * del perfil en cuestión.
     * 
     * @param  perApellidos    Apellidos del usuario a modificar
     */
    public void setPerApellidos(String perApellidos)
    {
        this.perApellidos = perApellidos;
    }
    
    /**
     * Devuelve la Dirección 
     * del perfil en cuestión.
     * 
     * @return  Dirección (String) del usuario 
     */
    public String getPerDireccion()
    {
         return perDireccion;
    }
    
    /**
     * Modifica la Dirección 
     * del perfil en cuestión.
     * 
     * @param  perDireccion    la Dirección del perfil a modificar
     */
    public void setPerDireccion(String perDireccion)
    {
        this.perDireccion = perDireccion;
    }
    
    /**
     * Devuelve el alias del 
     * perfil en cuestión.
     * 
     * @return  Alias (String) del usuario 
     */
    public String getPerUser()
    {
         return perUser;
    }
    
    /**
     * Modifica el alias del 
     * perfil en cuestión.
     * 
     * @param  perUser    el alias del perfil a modificar
     */
    public void setPerUser(String perUser)
    {
        this.perUser = perUser;
    }
    
    /**
     * Devuelve el password del 
     * perfil en cuestión.
     * 
     * @return  Password (String) del usuario 
     */
    public String getPerPassword()
    {
         return perPassword;
    }
    
    /**
     * Modifica el password del 
     * perfil en cuestión.
     * 
     * @param  perPassword    el password del perfil a modificar
     */
    public void setPerPassword(String perPassword)
    {
        this.perPassword = perPassword;
    }

}
