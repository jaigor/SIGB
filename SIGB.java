
/**
 * Clase inicial de la herramienta de gestión.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class SIGB
{

    /**
     * Constructor de la clase principal vacío
     */
    public SIGB()
    {
        //
    }
    
    /**
     * Método principal que inicia la aplicación
     * 
     */
    public static void main(String[] args)
    {
        //inicia la clase principal de biblioteca
        Biblioteca.getInstacia().inicializarBiblioteca("UNED", "Portugalete", 944448888, "10:00-20:00"); // datos ejemplo
        SIGBInterfaz sigbInterfaz = new  SIGBInterfaz();
        sigbInterfaz.inicio();
    }
  
}
