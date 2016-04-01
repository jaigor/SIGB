import java.util.ArrayList;

/**
 * Clase en la que se crean las distintas 
 * bibliotecas que pueden encontrarse en el
 * sistema de gestión.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class ListaBiblioteca
{
   private static int contadorPerfiles = 0; // id de usuarios inicializado a 0
   
    // Array de la coleccion biblioteca 
   private ArrayList<Biblioteca> bibliotecas;
   private ArrayList<Perfil> perfiles;
        
   /**
    * Constructor for objects of class ListaBiblioteca
    */
   public ListaBiblioteca()
   {
       bibliotecas = new ArrayList<Biblioteca>();
       perfiles = new ArrayList<Perfil>();
   }
  
 
   /***************PERFILES
   * Añadir un nuevo Perfil a la base de datos (Dar de Alta)
    * @param  nuevoPerfil   el nuevo perfil a añadir
    */
   public void añadirPerfil(Perfil nuevoPerfil)
   {
       if (buscarPerfil(nuevoPerfil) == 1){
           perfiles.add(nuevoPerfil);
       } else {
           System.out.println("El perfil que intenta añadir ya se encuentra en la base de datos");
       }       
   }
    
   /**
    * Borrar un Perfil de la base de datos (Dar de Baja)
    * @param  bajaPerfil   el perfil a eliminar
    */
   public void eliminarPerfil(Perfil bajaPerfil)
   {
       perfiles.remove(bajaPerfil);
   }
    
   /**
    * @return  la colección almacenada en perfiles (todos los usuarios)
    */
   public ArrayList<Perfil> getPerfiles()
   {
       return perfiles;
   }

   /**
     * Método usado para agregar un campo id númerico a cada usuario
     * Es un método estático porque no nos interesa el conocer de
     * que biblioteca es el perfil
     * 
     * @return  contadorPerfiles    devuelve el número actual de usuario
     */
    public static int getIDPerfil()
    {
        contadorPerfiles++;
        return contadorPerfiles;
    }
        
   /**
     * Método de modificación de los permisos y el tipo de usuario que se crea
     * 
     * @param  permisoInput   entrada que establece el tipo de usuario
     */ 
   public int buscarPerfil(Perfil perfilBuscado)
   {
       for (Perfil perfil : perfiles){
           if (perfil.getDNI() == perfilBuscado.getDNI()){
               return 0;
           }
       }
       return 1;  
   }
    
}
