/**
 * Clase abstracta (e intermedia) que diferencia a 
 * las clases suscribibles
 * de material que son Periodico y Revista.
 * 
 * @author Igor Quintela 
 * @version 30/04/2016
 */
public abstract class MaterialSuscripcion extends Material
{
    // Definición de campos genéricos del Material Suscribible
    private String tematica;
    private int periodicidad; // Número de días que tarda en lanzarse un nuevo ejemplar
    
    /**
     * Instaciación de campos genéricos del Material Suscribible
     * 
     * @param matTitulo     Nombre de la obra/item.
     * @param matAutor      Nombre del autor de la obra.
     * @param stockActual   Número de elementos que hay en base de datos.
     * @param matPrecio     Cantidad de euros que cuesta el elemento.
     * @param tematica      Tematica del material suscribible.
     */
    public MaterialSuscripcion (String matTitulo, String matAutor, int stockActual, 
    double matPrecio, String tematica)
    {
        super(matTitulo, matAutor, stockActual, matPrecio);
        this.tematica = tematica;
    }
    
    /**
     * Devuelve la tematica del material que le corresponde
     * 
     * @return  La tematica correspondiente al Periodico/Revista
     */
    public String getTematica()
    {
        return tematica;
    }
    
    /**
     * Devuelve la periodicidad que tiene asignada el material
     * 
     * @return  periodicidad (número) correspondiente al Periodico/Revista
     */
    public int getPeriodicidad()
    {
        return periodicidad;
    }
    
    /**
     * Modifica la periodicidad que tiene asignada el material,
     * y se la asigna
     * 
     * @param periodicidad  periodicidad (número) a cambiar
     */
    public void setPeriodicidad(int periodicidad)
    {
        this.periodicidad = periodicidad;
    }
    
}
