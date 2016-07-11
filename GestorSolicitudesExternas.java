import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Clase gestora desde donde 
 * se instancian el listado de bibliotecas
 * externas, y las solicitudes externas, 
 * asi como los métodos que les afectan.
 * 
 * @author Igor Quintela 
 * @version 20/06/2016
 */
public class GestorSolicitudesExternas 
{
    private ArrayList<MaterialExterno> solicitudes;
    private ArrayList<Biblioteca> bibliotecas;
    
    /**
     * Instancia las colecciones de
     * solicitudes y bibliotecas
     */
    public GestorSolicitudesExternas()
    {
        solicitudes = new ArrayList<MaterialExterno>();
        bibliotecas = new ArrayList<Biblioteca>();
    }

    /**
     * Método para retornar la colección
     * de solicitudes externas
     * 
     * @return     colección de solicitudes externos 
     */
    public ArrayList<MaterialExterno> getSolicitudes()
    {
        return solicitudes;
    }
    
    /**
     * Método para retornar la colección
     * de bibliotecas
     * 
     * @return     colección de bibliotecas
     */
    public ArrayList<Biblioteca> getBibliotecas()
    {
        return bibliotecas;
    }
    
    /**
     * Método para añadir un Material 
     * Externo a la colección de solicitudes
     * 
     * @param   matExterno  Material externo a agregar 
     */
    public void añadirSolicitudes(MaterialExterno matExterno)
    {
        solicitudes.add(matExterno);      
    }
    
    /**
     * Método para buscar un Material
     * en el resto de bibliotecas buscando 
     * por Titulo y Autor
     * 
     * @param   matTitulo  Titulo del material
     * @param   matAutor   Autor del material 
     * @return    Material externo encontrado 
     */
    public MaterialExterno buscarMatExternos(String matTitulo, String matAutor)
    {
        for (Biblioteca b : bibliotecas){
            if (b.getGestMat().buscarMaterialMulti(matTitulo, matAutor) != null){
                MaterialExterno matEncontrado = 
                new MaterialExterno(Biblioteca.getInstacia().getBibNombre(),
                b.getBibNombre(),matTitulo, matAutor);
                return matEncontrado;
            }
        }
        return null;
    }
    
    /**
     * Método para imprimir en pantalla
     * un Material externo
     * 
     * @param   matExterno  material a imprimir
     */
    public void printMatExterno(MaterialExterno matExterno)
    {
        System.out.println("-------------------------------------------");
        System.out.println("Biblioteca Origen: " + matExterno.getBiblioOrigen() +
        " | Biblioteca Destino: " + matExterno.getBiblioDestino()+ " | Título: " + matExterno.getMatTitulo() +
        " | Autor: " + matExterno.getMatAutor());
    }
    
    /**
     * Método para exportar los materiales
     * externos solicitados mediante la
     * creación de un archivo en una ruta concreta.
     * 
     * @param   ruta  String con la ruta o path
    */ 
    public void exportarMateriales(String ruta)
    {
        // crea el fichero en la ruta en concreto
        File archivo = new File(ruta);
        try{
            // se usan las clases FileOutputStream y 
            // ObjectOutputStream para serializar el objeto en el fichero
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (MaterialExterno p : this.solicitudes){
                // escribe todas las solicitudes
                // recorriendo el array
                oos.writeObject(p);
            }
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    /**
     * Método para importar los materiales
     * que han sido solicitados mediante la
     * lectura de un archivo a través de una ruta concreta.
     * 
     * @param   ruta  String con la ruta o path
    */ 
    public void importarMateriales(String ruta)
    {
        File archivo = new File(ruta);
        boolean salir = false;
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            MaterialExterno me = leerArchivo(ois);
            while (me != null){
                // se crea un socio con el identificador
                // de la biblioteca de Origen
                Socio socioBusqueda = 
                new Socio(me.getBiblioOrigen(), "nombre", "apellidos", "direccion", 
                "perUser","perPassword");
                // se localiza el material solicitado en la 
                // biblioteca actual
                Material matBusqueda = 
                Biblioteca.getInstacia().getGestMat().buscarMaterialMulti(me.getMatTitulo(),
                me.getMatAutor());
                // se añade el préstamo a la base de datos actual
                Biblioteca.getInstacia().getGestPrest().añadirPrestamo(matBusqueda, socioBusqueda);
                me = leerArchivo(ois);
            } 
            ois.close();
        }
        catch (EOFException e) {
            System.out.println("El archivo está vacio");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método para leer del objeto
     * (cargado previamente), cada 
     * linea escrita.
     * 
     * @param   ois  objeto cargado para deserializar
     * @return  Material Externo como objeto
    */
    public MaterialExterno leerArchivo(ObjectInputStream ois)
    {
        MaterialExterno me;
        try {
            me = (MaterialExterno)ois.readObject();
        }
        catch (Exception e){
            me = null;
        }
        return me;    
    }
}
