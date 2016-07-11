
/**
 * Esta clase representa al objeto Director.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/04/2016
 */
public class Director extends Perfil
{
    private int permisoID = 3; //id equivalente a clase director, dentro de perfiles

    /**
     * Inicializa el usuario (Director)
     * asociando los campos 
     * 
     * @param perDNI        Número y letra del DNI del usuario.
     * @param perNombre     Nombre del usuario.
     * @param perApellidos  Apellidos del usuario.
     * @param perDireccion  Direccion local del usuario.
     * @param perUser       Nombre/nick del usuario.
     * @param perPassword   Password del usuario.
     */
    public Director(String perDNI, String perNombre, String perApellidos, String perDireccion, 
    String perUser, String perPassword)
    {
        super(perDNI, perNombre, perApellidos, perDireccion, perUser, perPassword);
        setPermisoID(permisoID);
    }
    
}
