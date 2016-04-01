
/**
 * Write a description of class Material here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Material
{
    private int idMaterial;
    private String mNombre;
    private String mAutor;
    private boolean mPrestado = false;
    private int mStock; // se inicializa a 0 el contador de inventario

    private int contadorMateriales; 
    
    /**
     * Constructor for objects of class Material
     */
    public Material(String matNombre, String matAutor, int matStock)
    {
        idMaterial = getIDMaterial();
        String mNombre = matNombre;
        String mAutor = matAutor;
        int mStock = matStock;       
    }
    
     /**
     * Método usado para agregar un campo id númerico a cada usuario
     * Es un método estático porque no nos interesa el conocer de
     * que biblioteca es el perfil
     * 
     * @return  contadorPerfiles    devuelve el número actual de usuario
     */
    public int getIDMaterial()
    {
        contadorMateriales++;
        return contadorMateriales;
    }

    
}
