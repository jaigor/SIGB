
/**
 * Esta clase representa al objeto Bibliotecario.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Bibliotecario extends Perfil
{
    private int permisoID = 2; //id equivalente a clase bibliotecario, dentro de perfiles

    /**
     * Inicializa el usuario Bibliotecario
     * 
     * @param perDNI        Número y letra del DNI del usuario.
     * @param perNombre     Nombre del usuario.
     * @param perApellidos  Apellidos del usuario.
     * @param perDireccion  Direccion local del usuario.
     * @param perUser       Nombre/nick del usuario.
     * @param perPassword   Password del usuario.
     */
    public Bibliotecario(String perDNI, String perNombre, String perApellidos, String perDireccion, 
    String perUser, String perPassword)
    {
        super(perDNI, perNombre, perApellidos, perDireccion, perUser, perPassword);
        setPermisoID(permisoID);
    }
}
