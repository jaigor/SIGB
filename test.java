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
public class test 
{
    private GestorPerfiles gP;
    private Perfil user1;
    private Perfil user2;
    private Perfil admin;
    private Perfil biblio;
    
    private GestorMateriales gM;
    private Material mat1;
    private Material mat2;
    private Material mat3;
    private Material mat4;
    private Material mat5;
    private Material mat6;
    
    private GestorPrestamos gPr;
    private Prestamo prest1;
    private Prestamo prest2;
    private Prestamo prest3;
    private Prestamo prest4;
    
    private Calendar cal = Calendar.getInstance();
    private Date fechaActual = cal.getTime();
    /**
     * Constructor for objects of class test
     */
    public test()
    {        
        // Perfiles        
        user1 = new Socio("789254640J", "Igor", "Quintela", "Calle Haro", "iqs", "pass");
        user2 = new Socio("455646122F", "Francisco", "Garcia", "Calle Bilbao", "fran", "pass");
        biblio = new Bibliotecario("999999999Z", "Indiana", "Jones", "Plaza Latorre", "biblio", "admin");
        admin = new Director("111111111Z", "Señor", "Director", "Calle Portugalete", "admin", "admin");
        
        // intento meter mismos perfiles con el dni igual
        gP = Biblioteca.getInstacia().getGestPerf();
        gP.añadirPerfil(user1);
        gP.añadirPerfil(user2);
        gP.añadirPerfil(admin);
        gP.añadirPerfil(biblio);
        
        // Creacion de Materiales asociados
        mat1 = new Libro("Los Mundos de Koda", "Perico", 10, 50, "HFGG12312", "02/01/2015", 140);
        mat2 = new Audio("Apocalipse", "Juanico", 2, 60, 12);
        mat3 = new Video("Paradyse", "Manolito", 5, 100, 130);
        mat4 = new Periodico("ElMundoToday", "Sol", 3, 4, "Politica");
        mat5 = new Revista("Holas", "Luna", 1, 2, "Rosa");
        mat6 = new Libro("Zombies", "Dark Seed", 1, 30, "HFGG22222", "02/01/2000", 240);
        
        gM = Biblioteca.getInstacia().getGestMat();
        gM.añadirMaterial(mat1);
        gM.añadirMaterial(mat2);
        gM.añadirMaterial(mat3);
        gM.añadirMaterial(mat4);
        gM.añadirMaterial(mat5);
        gM.añadirMaterial(mat6);
        
        // Creacion de Prestamos asociados
        prest1 = new Prestamo(new Date(),mat1,(Socio)user1, 1);
        prest2 = new Prestamo(new Date(),mat2,(Socio)user2, -1);
        prest3 = new Prestamo(new Date(),mat3,(Socio)user2, -5);
        prest4 = new Prestamo(new Date(),mat6,(Socio)user2, -2);
        
        gPr = Biblioteca.getInstacia().getGestPrest();
        gPr.getPrestamos().add(prest1);
        Socio socio1 = (Socio)user1;
        socio1.añadirPrestamos(prest1);
        gPr.getPrestamos().add(prest2);
        Socio socio2 = (Socio)user2;
        socio2.añadirPrestamos(prest2);
        gPr.getPrestamos().add(prest3);
        socio2.añadirPrestamos(prest3);
        gPr.getPrestamos().add(prest4);
        socio2.añadirPrestamos(prest4);
    }    
        
}
