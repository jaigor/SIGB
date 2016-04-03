
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class test
     */
    public test()
    {
        // initialise instance variables
        x = 0;
    }
      
    public void test()
    {
        //test
        //Biblioteca b1 = new Biblioteca("bN", "bD", 944118888, "bH");
        // Perfiles
        ListaBiblioteca lb1 = new ListaBiblioteca();
        
        Perfil user1 = new Usuario("789254640J", "Igor", "Q", "Calle Haro");
        Perfil user2 = new Usuario("455646122F", "David", "V", "Calle Bilbao");
        lb1.añadirPerfil(user1);
        lb1.añadirPerfil(user2);
        for (Perfil perfil : lb1.getPerfiles()) {
            perfil.listar();
        }
        
        // Materiales
        Biblioteca b1 = new Biblioteca("UNED", "Portugalete", 944448888, "10:00-20:00");
        
        Material mat1 = new Libro("Los Mundos de Koda", "Perico", 10, 50, "HFGG12312", "02/01/2015", 140);
        Material mat2 = new Libro("Apocalipse", "Juanico", 2, 60, "GGG11311", "02/01/1980", 150);
        b1.añadirMaterial(mat1);
        b1.añadirMaterial(mat2);        
        for (Material material : b1.getMateriales(ETipoMaterial.LIBRO)) {
             material.listar();
        }
        for (Material material : b1.getMateriales(ETipoMaterial.AUDIO)) {
             material.listar();
        }
        for (Material material : b1.getMateriales(ETipoMaterial.VIDEO)) {
             material.listar();
        }
        for (Material material : b1.getMateriales(ETipoMaterial.PERIODICO)) {
             material.listar();
        }
        for (Material material : b1.getMateriales(ETipoMaterial.REVISTA)) {
             material.listar();
        }
    
    }
}
