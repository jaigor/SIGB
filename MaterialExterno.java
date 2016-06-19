
/**
 * Write a description of class MaterialExterno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaterialExterno
{
    private String biblioOrigen;
    private String biblioDestino;
    private String matTitulo;
    private String matAutor;    
    
    /**
     * Constructor for objects of class MaterialExterno
     */
    public MaterialExterno(String biblioOrigen, String biblioDestino, String matTitulo, String matAutor)
    {
        this.biblioOrigen = biblioOrigen;
        this.biblioDestino = biblioDestino;
        this.matTitulo = matTitulo;
        this.matAutor = matAutor;
    }
    
    /**
     * Constructor for objects of class MaterialExterno
     */
    public String getBiblioOrigen()
    {
        return biblioOrigen;
    }
    
    /**
     * Constructor for objects of class MaterialExterno
     */
    public String getBiblioDestino()
    {
        return biblioDestino;
    }
    
    /**
     * Constructor for objects of class MaterialExterno
     */
    public String getMatTitulo()
    {
        return matTitulo;
    }
    
    /**
     * Constructor for objects of class MaterialExterno
     */
    public String getMatAutor()
    {
        return matAutor;
    }
    
}
