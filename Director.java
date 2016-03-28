
/**
 * Esta clase representa al objeto Director.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Director extends Perfil
{
    private int permisoID = 2; //id equivalente a clase director, dentro de perfiles

    /**
     * Inicializa el usuario
     * 
     * @param dniPersona Número y letra del DNI del usuario.
     * @param perNombre Nombre del usuario.
     * @param perApellidos Apellidos del usuario.
     * @param perDireccion Direccion local del usuario.
     */
    public Director(String dniPersona, String perNombre, String perApellidos, String perDireccion)
    {
        super(dniPersona, perNombre, perApellidos, perDireccion);
        setPermisoID(permisoID);
    }

    
}
