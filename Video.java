
/**
 * Write a description of class Video here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Video extends Material
{
    private int duracion;
    
    /**
     * Constructor for objects of class Video
     */
    public Video(String matNombre, String matAutor, int matStock, int durac)
    {
        super(matNombre, matAutor, matStock);
        duracion = durac;
    }

}
