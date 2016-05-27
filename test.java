import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test extends Biblioteca
{
    private Perfil user1;
    private Perfil user2;
    
    private GestorMateriales gM;
    private Material mat1;
    private Material mat2;
    private Material mat3;
    private Material mat4;
    private Material mat5;
    
    private GestorPerfiles gP;
    
    private Calendar cal = Calendar.getInstance();
    private Date fechaActual = cal.getTime();
    
    /**
     * Constructor for objects of class test
     */
    public test()
    {
        // Creacion de Biblioteca
        
        // Perfiles        
        user1 = new Socio("789254640J", "Igor", "Q", "Calle Haro", "iqs", "pass");
        user2 = new Socio("455646122F", "Ello", "S", "Calle Bilbao", "ello", "pass");
        
        // intento meter mismos perfiles con el dni igual
        gP = Biblioteca.getInstacia().getGestPerf();
        gP.añadirPerfil(user1);
        gP.añadirPerfil(user2);
        for (Perfil perfil : gP.getPerfiles()) {
            gP.generarTarjeta(perfil);
        }
        
        // Creacion de Materiales asociados
        mat1 = new Libro("Los Mundos de Koda", "Perico", 10, 50, "HFGG12312", "02/01/2015", 140);
        mat2 = new Audio("Apocalipse", "Juanico", 2, 60, 12);
        mat3 = new Video("Paradyse", "Manolito", 5, 100, 130);
        mat4 = new Periodico("ElMundoToday", "Sol", 3, 4, "Politica");
        mat5 = new Revista("Holas", "Luna", 1, 2, "Rosa");
        
        gM = Biblioteca.getInstacia().getGestMat();
        gM.añadirMaterial(mat1);
        gM.añadirMaterial(mat2);
        gM.añadirMaterial(mat3);
        gM.añadirMaterial(mat4);
        gM.añadirMaterial(mat5);
        
        for (Material material : gM.getMateriales(ETipoMaterial.LIBRO)) {
             gM.print(material);
        }
        for (Material material : gM.getMateriales(ETipoMaterial.AUDIO)) {
             gM.print(material);
        }
        for (Material material : gM.getMateriales(ETipoMaterial.VIDEO)) {
             gM.print(material);
        }
        for (Material material : gM.getMateriales(ETipoMaterial.PERIODICO)) {
             gM.print(material);
        }
        for (Material material : gM.getMateriales(ETipoMaterial.REVISTA)) {
             gM.print(material);
        }
    }    
    
    public void buscaMaterial(){
        //prueba de buscar un material en la biblioteca
        Material matBuscado = gM.buscarMaterial("Apocalipse",null);
        gM.print(matBuscado);
    }
    
    public void tiempo(){
        //Prestamo prest1 =  new Prestamo(1462989126, mat1, user1, 7);
    }
    
    public void fechaActual()
    {
       // se define el formato de la fecha a mostrar
       DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       
       //consigue la fecha actual
       Calendar fechaActual = Calendar.getInstance();
       System.out.println(formatoFecha.format(fechaActual.getTime()));
       
    }
    
    public void calcFecha()
    {
       //consigue la fecha actual
       //Calendar fechaActual = Calendar.getInstance();
       //System.out.println(fechaActual);
       
       long diff = Math.abs(fechaActual.getTime() - fechaActual.getTime());
       long diffDays = diff / (24 * 60 * 60 * 1000);
    }
}
