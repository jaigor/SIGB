
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
public abstract class Material
{
    // definición de los campos genéricos
    private int idMaterial;
    private String matTitulo;
    private String matAutor;
    private boolean matPrestado = false;
    private int stockActual = 0; // se inicializa a 0 el contador de inventario
    private double matPrecio;

    private static int contadorMateriales; 
    
    /**
     * Da de alta los campos genéricos de un material
     * 
     * @param matTitulo Nombre de la obra/item.
     * @param matAutor  Nombre del autor de la obra.
     * @param stockActual  Número de elementos que hay en base de datos.
     * @param matPrecio Cantidad de euros que cuesta el elemento.
     */
    public Material(String matTitulo, String matAutor, int stockActual, double matPrecio)
    {
        idMaterial = addIDMaterial();
        this.matTitulo = matTitulo;
        this.matAutor = matAutor;
        this.stockActual = stockActual;
        this.matPrecio = matPrecio;
    }
    
     /**
     * Método usado para agregar un campo id númerico a cada material
     * 
     * @return  El número de ID exacto buscado
     */
    public static int addIDMaterial()
    {
        contadorMateriales++;
        return contadorMateriales;
    }
    
    /**
     * Devuelve el título de la obra
     * 
     * @return  El Título del material buscado
     */
    public int getIDMaterial()
    {
        return idMaterial;
    }
    
    /**
     * Devuelve el título de la obra
     * 
     * @return  El Título del material buscado
     */
    public String getMatTitulo()
    {
        return matTitulo;
    }
    
    /**
     * Devuelve el nombre del autor de la obra
     * 
     * @return  El Nombre del Autor del material buscado
     */
    public String getMatAutor()
    {
        return matAutor;
    }
    
    /**
     * Devuelve el total de materiales disponibles 
     * 
     * @return  número entero de materiales por prestar
    */
    public int getStockActual()
    {
        return stockActual;
    }
    
    /**
     * Devuelve el precio del material 
     * 
     * @return  Precio (decimal) del material
    */
    public double getMatPrecio()
    {
        return matPrecio;
    }
    
    /**
     * Añade o elimina un registro del stock del material 
     * 
     * @param  dato   número que se utiliza 
    */
    public void actualizarStock(int dato)
    {
        // al menos un material en stock
        if (stockActual <= 0){
            System.out.println("El material que intenta añadir/eliminar no se encuentra en la base de datos");
        } else {
            stockActual = stockActual + dato;
            System.out.println("Stock modificado correctamente");
        }
    }
    
}
