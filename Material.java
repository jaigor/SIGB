
/**
 * Esta es la clase abstracta en la que se definen los métodos generales 
 * que afectan a distintos tipos de usuario pertenecientes a la biblioteca. 
 * Los tipos de usuario o perfiles que heredan esta clase son: 
 *      Libro
 *      Audio
 *      Video
 *      Periodico
 *      Revista
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Material
{
    private int idMaterial;
    private String mTitulo;
    private String mAutor;
    private boolean mPrestado = false;
    private int mStock = 0; // se inicializa a 0 el contador de inventario
    private float mPrecio;

    private static int contadorMateriales; 
    
    /**
     * Da de alta los campos genéricos de un material
     * 
     * @param matTitulo Nombre de la obra/item.
     * @param matAutor  Nombre del autor de la obra.
     * @param matStock  Número de elementos que hay en base de datos.
     * @param matPrecio Cantidad de euros que cuesta el elemento.
     */
    public Material(String matTitulo, String matAutor, int matStock, float matPrecio)
    {
        idMaterial = getIDMaterial();
        mTitulo = matTitulo;
        mAutor = matAutor;
        mStock = matStock;
        mPrecio = matPrecio;
    }
    
     /**
     * Método usado para agregar un campo id númerico a cada material
     * Es un método estático porque no nos interesa el conocer de
     * que biblioteca es el perfil
     * 
     * @return  El número de ID exacto buscado
     */
    public static int getIDMaterial()
    {
        contadorMateriales++;
        return contadorMateriales;
    }
    
    /**
     * Retorna el título de la obra
     * 
     * @return  El Título del material buscado
     */
    public String getMTitulo()
    {
        return mTitulo;
    }
    
    /**
     * Imprime en pantalla los datos correspondientes al material indicado
     */
    public void listar()
    {
        System.out.println("***************************************");
        System.out.println("ID: " + idMaterial + ", Título: " + mTitulo + ", Autor: " + mAutor);
        System.out.println("Inventario: " + mStock + ", Precio: " + mPrecio + " €");
    }
    
}
