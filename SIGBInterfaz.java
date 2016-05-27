import java.util.Scanner;
import java.lang.NullPointerException;

/**
 * Clase usada para presentar textualmente el
 * menú de la herramienta de gestión.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class SIGBInterfaz
{
    // Variable a llamar cada vez que se pide input al usuario
    Scanner in = new Scanner(System.in);
    /**
     * Constructor for objects of class SIGBInterfaz
     */
    public SIGBInterfaz()
    {
        // initialise instance variables
    }

    /**
     * Inicia el menú de acceso al sistema de gestión
     * 
     */
    public void inicio()
    {
        // iniciamos el menu principal de la interfaz
        new test();
        this.menuAcceso();
    }
    
    /**
     * Menú usado para comprobar si el usuario se
     * encuentra registrado en la base de datos
     * 
     */
    public void menuAcceso()
    {
        // iniciamos el menu de acceso de la interfaz
        System.out.println("***********************************************");
        System.out.println("    Control de acceso");
        System.out.println("***********************************************");
        System.out.println("Introduzca su usuario y contraseña para acceder");
        System.out.println("***********************************************");
        System.out.print("Usuario: ");
        String user = in.next();
        System.out.print("Contraseña: ");
        String password = in.next();
        System.out.println("***********************************************");
        if (Biblioteca.getInstacia().getGestPerf().controlAcceso(user, password)){
            menuFunciones(user);
        } else {
            System.out.println("Usuario/Contraseña no válido, Vuelva a intentarlo.");
            System.out.println();
            menuAcceso();
        }
    }
    
    /**
     * Método que muestra las funciones dependiendo
     * del tipo de usuario logueado
     * 
     * @param   user    El alias del usuario
     */
    public void menuFunciones(String user)
    {
        //segun el tipo de usuario cargamos un menú u otro
        if(Biblioteca.getInstacia().getGestPerf().buscarPerfil(user).getPermisoID() > 1){
            // menu de funciones correspondientes a Bibliotecario/Director
            System.out.println("***********************************************");
            System.out.println("Menú opciones");
            System.out.println("1. Perfiles");
            System.out.println("2. Materiales");
            System.out.println("3. Préstamos");
            System.out.println("4. Suscripciones");
            System.out.println("0. Salir");
            System.out.println("***********************************************");
            boolean salir = false;
            int opcion;
            do {
                System.out.print("Escoja una de las opciones siguientes: ");
                opcion = in.nextInt();
                switch(opcion) {
                    case 1:
                        menuPerfiles();
                    case 2: 
                         menuMateriales();
                    case 3:
                         menuPrestamos();
                    case 4:
                     // hacer tal;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Error, Vuelva a intentarlo");
                        System.out.println();
                }
            }
            while (!salir);

        } else {
            // iniciamos el menu de funciones correspondientes a Socio
            Scanner in = new Scanner(System.in);
            System.out.println("***********************************************");
            /* A REVISAR */   
        }
        
    }
    
    //Menús PERFILES
    /**
     * Método que continua con las opciones 
     * o submenus de del menú Perfiles
     * 
     */
    public void menuPerfiles()
    {
        // iniciamos el menu de Perfiles
        System.out.println("***********************************************");
        System.out.println("1. Añadir Perfil");
        System.out.println("2. Eliminar Perfil");
        System.out.println("3. Buscar Perfil (Generacion Tarjeta)");
        System.out.println("0. Salir");
        System.out.println("***********************************************");
        boolean salir = false;
        int opcion;
        do {
            System.out.print("Escoja una de las opciones siguientes: ");
            opcion = in.nextInt();
            switch(opcion) {
                case 1:
                    altaPerfil();
                case 2: 
                    bajaPerfil();
                case 3:
                    printPerfil();
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, Vuelva a intentarlo");
                    System.out.println();
            }
        }
        while (!salir);
    }
    
    /**
     * Formulario de alta de perfil 
     * leyendo las entradas del usuario 
     * 
     */
    public void altaPerfil()
    {
        System.out.println("***********************************************");
        System.out.println("Introduzca los datos del formulario: ");
        System.out.print("DNI: ");
        String perDNI = in.next(); 
        System.out.print("Nombre: ");
        String perNombre = in.next();  
        System.out.print("Apellidos: ");
        String perApellidos = in.next();  
        System.out.print("Direccion: ");
        String perDireccion = in.next(); 
        System.out.print("Usuario: ");
        String perUser = in.next(); 
        System.out.print("Contraseña: ");
        String perPassword = in.next(); 
        System.out.println("***********************************************");
        
        // se añade el perfil a la base de datos
        Perfil nuevoPerfil = new Perfil(perDNI, perNombre, perApellidos, perDireccion, perUser, perPassword);
        Biblioteca.getInstacia().getGestPerf().añadirPerfil(nuevoPerfil);
    }
    
    /**
     * Formulario de baja de perfil 
     * en el que se busca por DNI el
     * objeto a eliminar
     * 
     */
    public void bajaPerfil()
    {
        Perfil userBuscado = buscarPerfil();
        Biblioteca.getInstacia().getGestPerf().eliminarPerfil(userBuscado);
    }
        
    /**
     * Formulario para buscar el perfil por DNI o alias
     * @return  el Perfil Buscado
     */
    public Perfil buscarPerfil()
    {
        Perfil userBuscado = null;
        while(userBuscado == null){
            System.out.println("***********************************************");
            System.out.println("Indique el DNI o alias del usuario: ");
            System.out.print("DNI o usuario: ");
            String user = in.next(); 
            System.out.println("***********************************************");
            userBuscado = Biblioteca.getInstacia().getGestPerf().buscarPerfil(user);
            if(userBuscado == null){
                System.out.println("Perfil no encontrado en la biblioteca.");
                System.out.println();
            }
        }
        return userBuscado;
    }
    
    /**
     * Imprimir el perfil, buscándolo primero
     * 
     */
    public void printPerfil()
    {
        Perfil userBuscado = buscarPerfil();
        Biblioteca.getInstacia().getGestPerf().generarTarjeta(userBuscado);
    }
    
    // Menús MATERIALES
    /**
     * Las distintas opciones o submenús del menú Materiales
     * 
     */
    public void menuMateriales()
    {
        // iniciamos el menu de Materiales
        System.out.println("***********************************************");
        System.out.println("1. Añadir Material");
        System.out.println("2. Eliminar Material");
        System.out.println("3. Buscar Material");
        System.out.println("0. Salir");
        System.out.println("***********************************************");
        boolean salir = false;
        int opcion;
        do {
            System.out.print("Escoja una de las opciones siguientes: ");
            opcion = in.nextInt();
            switch(opcion) {
                case 1:
                    altaTipoMaterial();
                case 2: 
                    bajaMaterial();
                case 3:
                    printMaterial();
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, Vuelva a intentarlo");
                    System.out.println();
            }
        }
        while (!salir);
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void altaTipoMaterial()
    {
        System.out.println("***********************************************");
        System.out.println("Alta Material");
        System.out.println("1. Libro");
        System.out.println("2. Audio");
        System.out.println("3. Video");
        System.out.println("4. Periodico");
        System.out.println("5. Revista");
        System.out.println("0. Salir");
        int opcion;
        System.out.print("Escoja el Material a crear: ");
        opcion = in.nextInt();
        if (opcion != 0){
            altaMaterial(opcion);
        } else { 
            System.exit(0);
        }
    }
    
    /**
     * Formulario para buscar el perfil por DNI o alias
     * e imprimir la tarjeta
     * 
     * @param   tipoMaterial    el numero equivalente al material
     */
    public void altaMaterial(int tipoMaterial)
    {
        if (tipoMaterial < 0 || tipoMaterial > 5) {
            System.out.println("Error, Vuelva a intentarlo");
            System.out.println();
            altaTipoMaterial();
        }

        System.out.println("Introduzca los datos para añadir Material.");
        System.out.print("Titulo: ");
        String matTitulo = in.next(); 
        System.out.print("Autor: ");
        String matAutor = in.next();
        
        // se comprueba que los datos introducidos son números   
        System.out.print("Stock: ");
        int stockActual = getInteger(in);
        System.out.print("Precio: ");
        double matPrecio = getDouble(in);
   
        // Hasta aqui están los datos genericos de material
        // Ahora se solicitan los especificos por tipo y
        // se añaden a la base de datos
        if (tipoMaterial == 1) { // Libro
            System.out.print("ISBN: ");
            String isbn = in.next();
            System.out.print("Fecha Edición: ");
            String fechaEdicion = in.next();
            System.out.print("Número de páginas: ");
            int numPaginas = getInteger(in);    
            System.out.println("***********************************************");
            Material nuevoLibro = new Libro(matTitulo, matAutor, stockActual, matPrecio, isbn, fechaEdicion, numPaginas);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoLibro);
        } else if (tipoMaterial == 2) { // Audio
            System.out.print("Número de pistas: ");
            int numPistas = getInteger(in);      
            System.out.println("***********************************************");
            Material nuevoAudio = new Audio(matTitulo, matAutor, stockActual, matPrecio, numPistas);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoAudio);
        } else if (tipoMaterial == 3) { // Video
            System.out.print("Duración del video: ");
            int duracion = in.nextInt();         
            System.out.println("***********************************************");
            Material nuevoVideo = new Video(matTitulo, matAutor, stockActual, matPrecio, duracion);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoVideo);
        } else if (tipoMaterial == 4) { // Periodico
            System.out.print("Tematica: ");
            String tematica = in.next();         
            System.out.println("***********************************************");
            Material nuevoPeriodico = new Periodico(matTitulo, matAutor, stockActual, matPrecio, tematica);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoPeriodico);
        } else if (tipoMaterial == 5) { // Revista
            System.out.print("Tematica: ");
            String tematica = in.next();         
            System.out.println("***********************************************");
            Material nuevaRevista = new Revista(matTitulo, matAutor, stockActual, matPrecio, tematica);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevaRevista);
        }
    }
    
    /**
     * Método para comprobar que el dato introducido
     *  por el usuario es un número entero
     * 
     * @param   in      variable para solicitar el dato
     * @return  numero introducido por el usuario
     */
    public int getInteger(Scanner in)
    {
        boolean inputValido = true;
        int num = 0;
        do {
            if (in.hasNextInt()){
                num = in.nextInt();
            } else {
                System.out.print("Introduzca un número, por favor: ");
                in.next();
                continue;
            }
            inputValido = false;
        } while (inputValido);
        return num;
    }
    
    /**
     * Método para comprobar que el dato introducido
     *  por el usuario es un número decimal
     * 
     * @param   in      variable para solicitar el dato
     * @return  numero introducido por el usuario
     */
    public double getDouble(Scanner in)
    {
        boolean inputValido = true;
        double num = 0;
        do {
            if (in.hasNextDouble()){
                num = in.nextDouble();
            } else {
                System.out.print("Introduzca un número, por favor: ");
                in.next();
                continue;
            }
            inputValido = false;
        } while (inputValido);
        return num;
    }
    
     /**
     * Baja de perfil en el que se busca por
     * el objeto a eliminar
     * 
     */
    public void bajaMaterial()
    {
        Material matBaja = buscarMaterial();
        Biblioteca.getInstacia().getGestMat().eliminarMaterial(matBaja);
    }
      
    /**
     * Formulario de búsqueda de material, dependiendo 
     * del parametro, en el que se busca por Titulo o Autor
     * @return  el Material Buscado
     */
    public Material buscarMaterial()
    {
        Material matBuscado = null;
        while(matBuscado == null){
            System.out.println("***********************************************");
            System.out.println("Indique el Titulo del material: ");
            System.out.print("Titulo: ");
            String matTitulo = in.next();
            System.out.println("Indique, si lo conoce, el Autor también: ");
            System.out.print("Autor: ");
            String matAutor = in.next();
            System.out.println("***********************************************");
            matBuscado = Biblioteca.getInstacia().getGestMat().buscarMaterial(matTitulo, matAutor);
            if(matBuscado == null){
                System.out.println("Material no encontrado en la biblioteca.");
                System.out.println();
            }
        }
        return matBuscado;
    }
    
    /**
     * Imprimir el material, buscándolo primero
     * 
     */
    public void printMaterial()
    {
        Material matPrint = buscarMaterial();
        Biblioteca.getInstacia().getGestMat().print(matPrint);
    }
    
    // Menús PRESTAMOS
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void menuPrestamos()
    {
        // inicio del menú Prestamos
        System.out.println("***********************************************");
        System.out.println("1. Añadir Préstamo");
        System.out.println("2. Eliminar Préstamo");
        System.out.println("3. Buscar Préstamo");
        System.out.println("4. Avisos materiales fuera de plazo");
        System.out.println("5. Gestión de multas");
        System.out.println("6. Listados de materiales prestados");
        System.out.println("0. Salir");
        System.out.println("***********************************************");
        boolean salir = false;
        int opcion;
        do {
            System.out.print("Escoja una de las opciones siguientes: ");
            opcion = in.nextInt();
            switch(opcion) {
                case 1:
                    altaPrestamo();
                case 2: 
                    bajaPrestamo();
                case 3:
                    printPrestamo();
                case 4:
                    //avisosFueraPlazo();
                case 5:
                    //gestionMultas();
                case 6:
                    listadosPrestamos();
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, Vuelva a intentarlo");
                    System.out.println();
            }
        }
        while (!salir);
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void altaPrestamo()
    {
        Prestamo nuevoPrestamo = buscarPrestamo();
        Biblioteca.getInstacia().getGestPrest().añadirPrestamo(nuevoPrestamo.getMatPrestado(), nuevoPrestamo.getSocioPrestamo());
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void bajaPrestamo()
    {
        Prestamo bajaPrestamo = buscarPrestamo();
        Biblioteca.getInstacia().getGestPrest().devolverPrestamo(bajaPrestamo);
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public Prestamo buscarPrestamo()
    {
        Prestamo prestamoBuscado = null;
        while(prestamoBuscado == null){
            Material matPrestado = buscarMaterial();
            Socio socioPrestamo = (Socio)buscarPerfil();
            prestamoBuscado = Biblioteca.getInstacia().getGestPrest().buscarPrestamo(matPrestado, socioPrestamo);
            if(prestamoBuscado == null){
                System.out.println("Préstamo no encontrado en la biblioteca.");
                System.out.println();
            }
        }
        return prestamoBuscado;
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void printPrestamo()
    {
        Prestamo prestamoBuscado = buscarPrestamo();
        Biblioteca.getInstacia().getGestPrest().print(prestamoBuscado);
    }
    
     /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void listadosPrestamos()
    {
        System.out.println("***********************************************");
        System.out.print("Indique el tipo de Material que desea imprimir:");
        System.out.println("1. Libro");
        System.out.println("2. Audio");
        System.out.println("3. Video");
        System.out.println("4. Periodico");
        System.out.println("5. Revista");
        System.out.println("***********************************************");
        String tipoMatBuscado = in.next();
        if (tipoMatBuscado == 1){
            ETipoMaterial tipoMatBuscado = LIBRO;
        } else if (tipoMatBuscado == 2){
            ETipoMaterial tipoMatBuscado = AUDIO;
        } else if (tipoMatBuscado == 3){
            ETipoMaterial tipoMatBuscado = VIDEO;
        } else if (tipoMatBuscado == 3){
            ETipoMaterial tipoMatBuscado = VIDEO;
        Biblioteca.getInstacia().getGestPrest().printPorTipo((ETipoMaterial)tipoMatBuscado);
    }
}