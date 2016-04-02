
/**
 * Esta clase representa al objeto Bibliotecario.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Bibliotecario extends Perfil
{
    private int permisoID = 1; //id equivalente a clase bibliotecario, dentro de perfiles

    /**
     * Inicializa el usuario Bibliotecario
     * 
     * @param dniPersona Número y letra del DNI del usuario.
     * @param perNombre Nombre del usuario.
     * @param perApellidos Apellidos del usuario.
     * @param perDireccion Direccion local del usuario.
     */
    public Bibliotecario(String dniPersona, String perNombre, String perApellidos, String perDireccion)
    {
        super(dniPersona, perNombre, perApellidos, perDireccion);
        setPermisoID(permisoID);
    }
}
