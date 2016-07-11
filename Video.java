
/**
 * Esta clase representa al objeto Video.
 * Almacena y devuelve información 
 * relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Video extends Material
{
    // Definición de campos propios del Material
    private int duracion;
    
    /**
     * Instaciación de campos propios y genéricos del Material
     * 
     * @param matTitulo     Nombre de la obra/item.
     * @param matAutor      Nombre del autor de la obra.
     * @param stockActual   Número de elementos que hay en base de datos.
     * @param matPrecio     Cantidad de euros que cuesta el elemento.
     * @param duracion      Minutos totales de duración del video.
     */
    public Video(String matTitulo, String matAutor, int stockActual, double matPrecio, int duracion)
    {
        super(matTitulo, matAutor, stockActual, matPrecio);
        this.duracion = duracion;
    }
    
    /**
     * Devuelve los minutos totales de duración del objeto de video
     * 
     * @return  número entero de los minutos de duracion 
     */
    public int getDuracion()
    {
        return duracion;
    }
    
    /**
     * Modifica los minutos totales de duración del objeto de video
     * 
     * @param  duracion    String a modificar en los minutos totales
     */
    public void setDuracion(int duracion)
    {
        this.duracion = duracion;
    }
}
