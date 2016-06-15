import java.util.ArrayList;

/**
 * Clase donde se gestionan y almacenan los
 * distintos tipos de perfiles.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class GestorPerfiles
{
    // Array de la coleccion almacenada
    private ArrayList<Perfil> perfiles;
    
    private Perfil perfilBuscado;
    
    /**
     * Instaciación de la colección de perfiles
     */
    public GestorPerfiles()
    {
        perfiles = new ArrayList<Perfil>();
    }
    
    /**
     * Devuelve la colección almacenada en perfiles (todos los usuarios)
     * 
     * @return  la colección (ArrayList) almacenada
     */
    public ArrayList<Perfil> getPerfiles()
    {
        return perfiles;
    }
    
    /**
    * Añade un nuevo Perfil a la base de datos (Dar de Alta)
    * 
    * @param  nuevoPerfil   el nuevo perfil a añadir
    */
    public void añadirPerfil(Perfil nuevoPerfil)
    {
        // se comprueba que el perfil (DNI) no está en la base de datos
        if (buscarPerfil(nuevoPerfil.getPerDNI()) == null){
            perfiles.add(nuevoPerfil);
            System.out.println("Perfil "+ nuevoPerfil.getPerDNI() +" añadido correctamente");
        } else {
            System.out.println("El perfil que intenta añadir ya se encuentra en la base de datos");
        }
    }
    
    /**
     * Borra un Perfil de la base de datos (Dar de Baja)
     * 
     * @param  bajaPerfil   el perfil a eliminar
     */
    public void eliminarPerfil(Perfil bajaPerfil)
    {
        // se comprueba que el perfil(DNI) está en la base de datos
        if (buscarPerfil(bajaPerfil.getPerDNI()) != null){
            perfiles.remove(bajaPerfil);
            System.out.println("Perfil eliminado correctamente");
        } else {
            System.out.println("El perfil que intenta eliminar no se encuentra en la base de datos");
        }
    }
    
    /**
     * Búsqueda de usuario por DNI y/o alias comparándolo
     * con los de la colección
     * 
     * @param   stringBuscado   DNI/alias del usuario a buscar
     */ 
    public Perfil buscarPerfil(String stringBuscado)
    { 
        if (perfiles.size() > 0){
            for (Perfil p : perfiles) {
                if (p.getPerDNI().equals(stringBuscado)){
                    return p;
                }else if (p.getPerUser().equals(stringBuscado)){
                    return p;
                }
            }
        }
        // sentencia que se da cuando la base de datos está vacía
        return null;            
    }
   
    /**
     *  Imprime en pantalla los datos correspondientes al usuario indicado
     *  "Generador de tarjetas"
     *  
     * @param   user   usuario (Perfil) a imprimir  
     */
    public void generarTarjeta(Perfil user)
    {
        System.out.println();
        System.out.println("-----------------CARNET---------------------"); 
        System.out.println("---------------BIBLIOTECA-------------------"); 
        System.out.println("DNI: " + user.getPerDNI());
        System.out.println("Nombre: " + user.getPerNombre() + "|  Apellidos: " + user.getPerApellidos());
        System.out.println("Direccion: " + user.getPerDireccion() + "|    Perfil: " +
        traductorPermiso(user.getPermisoID()));
        System.out.println("--------------------------------------------"); 
        System.out.println("--------------------------------------------");
        System.out.println();
    }
    
    /**
     * Devuelve el Perfil correspondiente al ID del Usuario.
     * // posibilidad de hacer ENUMs y eliminar el id para el acceso
     * 
     *  @param   permisoID   número de ID del usuario  
     *  @return Texto (String) del tipo de usuario
     */
    public String traductorPermiso(int permisoID)
    {
        String permiso;
        switch (permisoID) {
            case 1:  permiso = "Socio";
                     break;
            case 2:  permiso = "Bibliotecario";
                     break;
            case 3:  permiso = "Director";
                     break;
            default: permiso = "Permiso no válido";
                     break;
        }
        return permiso;
    }
    
    /**
     * Devuelve el Perfil correspondiente al ID del Usuario.
     * 
     *  @param   permisoID   número de ID del usuario  
     *  @return Texto (String) del tipo de usuario
     */
    public boolean controlAcceso(String user, String password)
    {
        for (Perfil p : perfiles){
            if (p.getPerUser().equals(user) && p.getPerPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
