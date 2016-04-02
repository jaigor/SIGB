/**
 * Esta es la clase abstracta en la que se definen los métodos generales 
 * que afectan a distintos tipos de usuario pertenecientes a la biblioteca. 
 * Los tipos de usuario o perfiles que heredan esta clase son: 
 *      usuario (básico) de la biblioteca
 *      bibliotecario
 *      director
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Perfil
{
    private int idPerfil;
    private String dni;
    private String pNombre;
    private String pApellidos;
    private String pDireccion;
    private int permisoID;  // campo usado para guardar el valor del tipo de usuario creado

    /**
     * Da de alta los campos genéricos de un perfil de usuario
     * 
     * @param dniPersona Número y letra del DNI del usuario.
     * @param perNombre Nombre del usuario.
     * @param perApellidos Apellidos del usuario.
     * @param perDireccion Direccion local del usuario.
     */
    public Perfil(String dniPersona,String perNombre, String perApellidos, String perDireccion)
    {
        idPerfil = ListaBiblioteca.getIDPerfil();
        dni = dniPersona;
        pNombre = perNombre;
        pApellidos = perApellidos;
        pDireccion = perDireccion;
    }

    /**
     * Método de modificación de los permisos y el tipo de usuario que se crea
     * 
     * @param  permisoInput   entrada que establece el tipo de usuario
     * 0 = Usuario, 
     * 1 = Bibliotecario, 
     * 2 = Director
     */
    public void setPermisoID(int permisoInput)
    {
        permisoID = permisoInput;
    }
    
    /**
     * Print details about this item to the text terminal.
     */
    public String getDNI()
    {
         return dni;
    }
    
    /**
     * Print details about this item to the text terminal.
     */
    public void listar()
    {
        System.out.println("***************************************"); 
        System.out.println("ID: " + idPerfil + ", DNI: " + dni);
        System.out.println("Nombre: " + pNombre + ", Apellidos: " + pApellidos 
        + ", Direccion: " + pDireccion + ", Permiso: " + permisoID);
    }
}
