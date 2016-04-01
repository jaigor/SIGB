
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
        ListaBiblioteca b1 = new ListaBiblioteca();
        Perfil user1 = new Usuario("789254640J", "Igor", "Q", "Calle Haro");
        Perfil user2 = new Usuario("455646122F", "David", "V", "Calle Bilbao");
        b1.añadirPerfil(user1);
        b1.añadirPerfil(user2);
        for (Perfil perfil : b1.getPerfiles()) {
            perfil.list();
        }
    
    }
}
