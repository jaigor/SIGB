// se importa para tener la posibilidad de escribir
// y leer el objeto en un archivo externo (Serializar)
import java.io.Serializable;

/**
 * Clase en la que se almacenan los 
 * datos y métodos necesarios 
 * para gestionar un Material Externo,
 * o solicitud exterior.
 * 
 * @author Igor Quintela 
 * @version 01/06/2016
 */
public class MaterialExterno implements Serializable
{
    private String biblioOrigen;
    private String biblioDestino;
    private String matTitulo;
    private String matAutor;    
    
    /**
     * Da de alta los campos genéricos de un material externo
     * 
     * @param biblioOrigen     Nombre de la biblioteca Origen de la peticion.
     * @param biblioDestino    Nombre de la biblioteca Destino.
     * @param matTitulo        Titulo del material solicitado.
     * @param matAutor         Autor del material solicitado.
     */
    public MaterialExterno(String biblioOrigen, String biblioDestino, String matTitulo, String matAutor)
    {
        this.biblioOrigen = biblioOrigen;
        this.biblioDestino = biblioDestino;
        this.matTitulo = matTitulo;
        this.matAutor = matAutor;
    }
    
    /**
     * Devuelve el Nombre de la biblioteca Origen de la peticion
     * 
     * @return  nombre de la biblioteca origen
     */
    public String getBiblioOrigen()
    {
        return biblioOrigen;
    }
    
    /**
     * Devuelve el Nombre de la biblioteca Destino
     * 
     * @return  nombre de la biblioteca destino
     */
    public String getBiblioDestino()
    {
        return biblioDestino;
    }
    
    /**
     * Devuelve el titulo del material solicitado
     * 
     * @return  titulo del material
     */
    public String getMatTitulo()
    {
        return matTitulo;
    }
    
    /**
     * Devuelve el autor del material solicitado
     * 
     * @return  autor del material
     */
    public String getMatAutor()
    {
        return matAutor;
    }
    
}
