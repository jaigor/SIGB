
/**
 * Esta clase representa al objeto Usuario (básico).
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Usuario extends Perfil
{
    private int permisoID = 0; //id equivalente a clase usuario, dentro de perfiles

    /**
     * Inicializa el usuario
     * 
     * @param dniPersona Número y letra del DNI del usuario.
     * @param perNombre Nombre del usuario.
     * @param perApellidos Apellidos del usuario.
     * @param perDireccion Direccion local del usuario.
     */
    public Usuario(String dniPersona, String perNombre, String perApellidos, String perDireccion)
    {
        super(dniPersona, perNombre, perApellidos, perDireccion);
        setPermisoID(permisoID);
    }
    
    
}
