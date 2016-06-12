import java.util.HashMap;
import java.util.ArrayList;

/**
 * Clase donde se gestionan y almacenan los
 * distintos tipos de materiales.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class GestorMateriales
{
    // Array de la coleccion almacenada
    private HashMap<ETipoMaterial, ArrayList> materiales;

    /**
     * Inicialización de la colección asociando el
     * valor especifico (key) para cada item usando los ENUM
     */
    public GestorMateriales()
    {
        // Inicialización de la coleccion
        materiales = new HashMap<ETipoMaterial, ArrayList>();
        // y asociación
        materiales.put(ETipoMaterial.LIBRO, new ArrayList<Libro>());
        materiales.put(ETipoMaterial.AUDIO, new ArrayList<Audio>());
        materiales.put(ETipoMaterial.VIDEO, new ArrayList<Video>());
        materiales.put(ETipoMaterial.PERIODICO, new ArrayList<Periodico>());
        materiales.put(ETipoMaterial.REVISTA, new ArrayList<Revista>());
    }

    /**
     * Añade un nuevo Material (Alta) a la base de datos, 
     * identificando por el tipo
     * 
     * @param  nuevoMaterial   el nuevo material a añadir
     */
    public void añadirMaterial(Material nuevoMaterial)
    {
        if (nuevoMaterial instanceof Libro){
            materiales.get(ETipoMaterial.LIBRO).add(nuevoMaterial);
        } else if (nuevoMaterial instanceof Audio) {
            materiales.get(ETipoMaterial.AUDIO).add(nuevoMaterial);
        } else if (nuevoMaterial instanceof Video){
            materiales.get(ETipoMaterial.VIDEO).add(nuevoMaterial);
        } else if (nuevoMaterial instanceof Periodico){
            materiales.get(ETipoMaterial.PERIODICO).add(nuevoMaterial);
        } else if(nuevoMaterial instanceof Revista){
            materiales.get(ETipoMaterial.REVISTA).add(nuevoMaterial);
        }
    }
    
    /**
     * Borra un Material de la base de datos (Dar de Baja)
     * 
     * @param  bajaMaterial   el material a eliminar
     */
    public void eliminarMaterial(Material bajaMaterial)
    {
        if (bajaMaterial instanceof Libro){
            materiales.get(ETipoMaterial.LIBRO).remove(bajaMaterial);
        } else if (bajaMaterial instanceof Audio) {
            materiales.get(ETipoMaterial.AUDIO).remove(bajaMaterial);
        } else if (bajaMaterial instanceof Video){
            materiales.get(ETipoMaterial.VIDEO).remove(bajaMaterial);
        } else if (bajaMaterial instanceof Periodico){
            materiales.get(ETipoMaterial.PERIODICO).remove(bajaMaterial);
        } else if(bajaMaterial instanceof Revista){
            materiales.get(ETipoMaterial.REVISTA).remove(bajaMaterial);
        }
    }
    
    /**
     * Devuelve la colección de los materiales
     * 
     * @return  la colección (HashMap) total de materiales
     */
    public HashMap<ETipoMaterial, ArrayList> getMateriales()
    {
       return materiales;
    }
    
    /**
    * Devuelve la colección de los materiales por el tipo indicado
    * 
    * @param  tipoMaterial   el tipo de material de la colección
    * @return  la colección (ArrayList) almacenada (cada uno de los items)
    */
    public ArrayList<Material> getMateriales(ETipoMaterial tipoMaterial)
    {
       return materiales.get(tipoMaterial);
    }
    
    /**
    * Buscador complejo usando el Titulo de la obra o el Nombre
    * del autor y devolviendo el material buscado
    * 
    * @param  matTitulo   título del item (String)
    * @param  matAutor   autor del item (String)
    * @return  el material en concreto buscado por el usuario
    */
    public Material buscarMaterial(String matTitulo, String matAutor)
    {
       // Crea un Array usado como lista de búsqueda por cada tipo de Material
       ArrayList <Material> listaMatLibro = materiales.get(ETipoMaterial.LIBRO);
       ArrayList <Material> listaMatAudio = materiales.get(ETipoMaterial.AUDIO);
       ArrayList <Material> listaMatVideo = materiales.get(ETipoMaterial.VIDEO);
       ArrayList <Material> listaMatPeriodico = materiales.get(ETipoMaterial.PERIODICO);
       ArrayList <Material> listaMatRevista = materiales.get(ETipoMaterial.REVISTA);
            
       // Recorre por cada lista comparando si se encuentra el Titulo o Autor de la obra
       for (Material material : listaMatLibro){
            if (material.getMatTitulo().equals(matTitulo)){
                return material;
            } else if (material.getMatAutor().equals(matAutor)) {
                return material;
            }
       }
       for (Material material : listaMatAudio){
            if (material.getMatTitulo().equals(matTitulo)){
                return material;
            } else if (material.getMatAutor().equals(matAutor)) {
                return material;
            }
       }
       for (Material material : listaMatVideo){
            if (material.getMatTitulo().equals(matTitulo)){
                return material;
            } else if (material.getMatAutor().equals(matAutor)) {
                return material;
            }
       }
       for (Material material : listaMatPeriodico){
            if (material.getMatTitulo().equals(matTitulo)){
                return material;
            } else if (material.getMatAutor().equals(matAutor)) {
                return material;
            }
       }
       for (Material material : listaMatRevista){
            if (material.getMatTitulo().equals(matTitulo)){
                return material;
            } else if (material.getMatAutor().equals(matAutor)) {
                return material;
            }
       }
       
       // Si no se encuentra en la base de datos o los 
       // datos introducidos no son correctos
       return null;
    }
    
    /**
     * Imprime en pantalla los datos correspondientes al material indicado
     * 
     * @param  material   material a imprimir
     */
    public void print(Material material)
    {
        System.out.println("-------------------------------------------");
        System.out.println("IDMaterial: " + material.getIDMaterial() +
        ", Título: " + material.getMatTitulo() + ", Autor: " + material.getMatAutor());
        System.out.println("Inventario: " + material.getStockActual() +
        ", Precio: " + material.getMatPrecio() + " €");
    }
}
