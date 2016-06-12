import java.util.Scanner;
import java.lang.NullPointerException;

/**
 * Clase usada para presentar textualmente el
 * menú de la herramienta de gestión.
 * 
 * @author Igor Quintela 
 * @version 11/06/2016
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
        // 
    }

    /**
     * Inicia el menú de acceso al sistema de gestión
     * 
     */
    public void inicio()
    {
        // inicia el menu principal de la interfaz
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
        boolean inputValido = false;
        do{
            System.out.println("***********************************************");
            System.out.print("Usuario: ");
            String user = in.next();
            System.out.print("Contraseña: ");
            String password = in.next();
            System.out.println("***********************************************");
            if (Biblioteca.getInstacia().getGestPerf().controlAcceso(user, password)){
                inputValido = true;
                menuFunciones(user);
            } else {
                System.out.println("Usuario/Contraseña no válido, Vuelva a intentarlo.");
                System.out.println();
            }
        } while (inputValido == false);
    } 
    
    /**
     * Método que muestra las funciones dependiendo
     * del tipo de usuario logueado
     * 
     * @param   user    El alias del usuario
     */
    public void menuFunciones(String user)
    {
        // Segun el tipo de usuario carga un menú u otro
        if(Biblioteca.getInstacia().getGestPerf().buscarPerfil(user).getPermisoID() > 1){
            // Menú de funciones correspondientes a Bibliotecario/Director
            boolean salir = false;
            do {
                System.out.println("***********************************************");
                System.out.println("Menú opciones");
                System.out.println("1. Perfiles");
                System.out.println("2. Materiales");
                System.out.println("3. Préstamos");
                System.out.println("4. Suscripciones");
                System.out.println("0. Salir");
                int opcion;
                System.out.print("Escoja una de las opciones siguientes: ");
                opcion = getInteger(in);
                switch(opcion) {
                    case 1:
                        menuPerfiles();
                        break;
                    case 2:
                        menuMateriales();
                        break;
                    case 3:
                        menuPrestamos();
                        break;
                    case 4:
                        //menuSuscripciones(); ** a implementar **
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
            // Menu de funciones correspondientes a Socio
            boolean salir = false;
            do {
                System.out.println("***********************************************");
                System.out.println("Menú opciones");
                System.out.println("1. Préstamos");
                System.out.println("2. Suscripciones");
                System.out.println("3. Generar Carnet");
                System.out.println("0. Salir");
                int opcion;
                System.out.print("Escoja una de las opciones siguientes: ");
                opcion = getInteger(in);
                switch(opcion) {
                    case 1:
                        menuPrestamos(user);
                        break;
                    case 2: 
                         //menuSuscripciones(); ** a implementar **
                    case 3: 
                         Perfil userBuscado = Biblioteca.getInstacia().getGestPerf().buscarPerfil(user);
                         Biblioteca.getInstacia().getGestPerf().generarTarjeta(userBuscado);
                         break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Error, Vuelva a intentarlo");
                        System.out.println();
                }
            }
            while (!salir);
            menuAcceso();
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
        // inicia el menu de Perfiles
        boolean salir = false;
        do {
            System.out.println("***********************************************");
            System.out.println("1. Añadir Perfil");
            System.out.println("2. Eliminar Perfil");
            System.out.println("3. Buscar Perfil (Generacion Tarjeta)");
            System.out.println("0. Salir");
            int opcion;
            System.out.print("Escoja una de las opciones siguientes: ");
            opcion = getInteger(in);
            switch(opcion) {
                case 1:
                    altaPerfil();
                    break;
                case 2: 
                    bajaPerfil();
                    break;
                case 3:
                    printPerfil();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, Vuelva a intentarlo");
                    System.out.println();
            }
        }
        while (!salir);
        menuAcceso();
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
        
        // Añade el perfil a la base de datos
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
        // inicia el menu de Materiales
        boolean salir = false;
        do {
            System.out.println("***********************************************");
            System.out.println("1. Añadir Material");
            System.out.println("2. Eliminar Material");
            System.out.println("3. Buscar Material");
            System.out.println("0. Salir");
            int opcion;
            System.out.print("Escoja una de las opciones siguientes: ");
            opcion = getInteger(in);
            switch(opcion) {
                case 1:
                    altaTipoMaterial();
                    break;
                case 2: 
                    bajaMaterial();
                    break;
                case 3:
                    printMaterial();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, Vuelva a intentarlo");
                    System.out.println();
            }
        }
        while (!salir);
        menuAcceso();
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
        opcion = getInteger(in);
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
        
        // Comprueba que los datos introducidos son números   
        System.out.print("Stock: ");
        int stockActual = getInteger(in);
        System.out.print("Precio: ");
        double matPrecio = getDouble(in);
   
        // Hasta aqui están los datos genericos de material,
        // solicitan los especificos por tipo y se añaden a la base de datos
        if (tipoMaterial == 1) { // Libro
            System.out.print("ISBN: ");
            String isbn = in.next();
            System.out.print("Fecha Edición: ");
            String fechaEdicion = in.next();
            System.out.print("Número de páginas: ");
            int numPaginas = getInteger(in);    
            Material nuevoLibro = new Libro(matTitulo, matAutor, stockActual, matPrecio, isbn, fechaEdicion, numPaginas);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoLibro);
        } else if (tipoMaterial == 2) { // Audio
            System.out.print("Número de pistas: ");
            int numPistas = getInteger(in);      
            Material nuevoAudio = new Audio(matTitulo, matAutor, stockActual, matPrecio, numPistas);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoAudio);
        } else if (tipoMaterial == 3) { // Video
            System.out.print("Duración del video: ");
            int duracion = getInteger(in);         
            Material nuevoVideo = new Video(matTitulo, matAutor, stockActual, matPrecio, duracion);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoVideo);
        } else if (tipoMaterial == 4) { // Periodico
            System.out.print("Tematica: ");
            String tematica = in.next();         
            Material nuevoPeriodico = new Periodico(matTitulo, matAutor, stockActual, matPrecio, tematica);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevoPeriodico);
        } else if (tipoMaterial == 5) { // Revista
            System.out.print("Tematica: ");
            String tematica = in.next();         
            Material nuevaRevista = new Revista(matTitulo, matAutor, stockActual, matPrecio, tematica);
            Biblioteca.getInstacia().getGestMat().añadirMaterial(nuevaRevista);
        }
        
        System.out.print("El material se ha añadido correctamente.");
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
        System.out.print("El material se ha eliminado correctamente.");
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
            System.out.println("Indique el Titulo del material, si lo desconoce introduzca 0");
            System.out.print("Titulo: ");
            String matTitulo = in.next();
            System.out.println("Indique el Nombre del Autor, si lo desconoce introduzca 0");
            System.out.print("Autor: ");
            String matAutor = in.next();
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
    
    // Menús PRESTAMOS (admin y user)
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void menuPrestamos()
    {
        // inicio del menú Prestamos
        boolean salir = false;
        do {
            System.out.println("***********************************************");
            System.out.println("1. Añadir Préstamo");
            System.out.println("2. Eliminar Préstamo");
            System.out.println("3. Buscar Préstamo");
            System.out.println("4. Gestión de multas");
            System.out.println("5. Listados de materiales prestados");
            System.out.println("0. Salir");
            int opcion;
            System.out.print("Escoja una de las opciones siguientes: ");
            opcion = getInteger(in);
            switch(opcion) {
                case 1:
                    altaPrestamo();
                    break;
                case 2: 
                    bajaPrestamo();
                    break;
                case 3:
                    printPrestamo();
                    break;
                case 4:
                    gestionMultas();
                    break;
                case 5:
                    listadosPrestamos();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, Vuelva a intentarlo");
                    System.out.println();
            }
        }
        while (!salir);
        menuAcceso();
    }
    
    // submenu correspondiente al usuario
     /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void menuPrestamos(String user)
    {
        // inicio del menú Préstamos
        boolean salir = false;
        Perfil userUsado = Biblioteca.getInstacia().getGestPerf().buscarPerfil(user);
        do {
            System.out.println("***********************************************");
            System.out.println("1. Añadir Préstamo");
            System.out.println("2. Eliminar Préstamo");
            System.out.println("3. Historial de Préstamos");
            System.out.println("4. Préstamos en activo");
            System.out.println("5. Gestión de multas");
            System.out.println("0. Salir");
            int opcion;
            System.out.print("Escoja una de las opciones siguientes: ");
            opcion = getInteger(in);
            switch(opcion) {
                case 1:
                    altaPrestamo(userUsado);
                    break;
                case 2: 
                    bajaPrestamo();
                    break;
                case 3:
                    Biblioteca.getInstacia().getGestPrest().printHistorial((Socio)userUsado);
                    break;
                case 4:
                    Biblioteca.getInstacia().getGestPrest().printPrestamosEnActivo((Socio)userUsado);
                    break;
                case 5:
                    gestionMultas((Socio)userUsado);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, Vuelva a intentarlo");
                    System.out.println();
            }
        }
        while (!salir);
        menuAcceso();
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void altaPrestamo()
    {
        Material matPrestado = buscarMaterial();
        Socio socioPrestamo = (Socio)buscarPerfil();
        Biblioteca.getInstacia().getGestPrest().añadirPrestamo(matPrestado, socioPrestamo);
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void altaPrestamo(Perfil userUsado)
    {
        Material matPrestado = buscarMaterial();
        Biblioteca.getInstacia().getGestPrest().añadirPrestamo(matPrestado, (Socio)userUsado);  
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
        System.out.println("Indique el tipo de Material que desea imprimir:");
        System.out.println("1. Libro");
        System.out.println("2. Audio");
        System.out.println("3. Video");
        System.out.println("4. Periodico");
        System.out.println("5. Revista");
        System.out.print("Indique opción: ");
        int tipoEscogido = getInteger(in);
        if (tipoEscogido == 1){
            ETipoMaterial tipoMatBuscado = ETipoMaterial.LIBRO;
            Biblioteca.getInstacia().getGestPrest().printPorTipo(tipoMatBuscado);
        } else if (tipoEscogido == 2){
            ETipoMaterial tipoMatBuscado = ETipoMaterial.AUDIO;
            Biblioteca.getInstacia().getGestPrest().printPorTipo(tipoMatBuscado);
        } else if (tipoEscogido == 3){
            ETipoMaterial tipoMatBuscado = ETipoMaterial.VIDEO;
            Biblioteca.getInstacia().getGestPrest().printPorTipo(tipoMatBuscado);
        } else if (tipoEscogido == 4){
            ETipoMaterial tipoMatBuscado = ETipoMaterial.PERIODICO;
            Biblioteca.getInstacia().getGestPrest().printPorTipo(tipoMatBuscado);
        } else if (tipoEscogido == 5){
            ETipoMaterial tipoMatBuscado = ETipoMaterial.REVISTA;
            Biblioteca.getInstacia().getGestPrest().printPorTipo(tipoMatBuscado);
        }
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void gestionMultas()
    {
        Socio socioMultado = (Socio)buscarPerfil();
        Biblioteca.getInstacia().getGestPrest().historialMultas(socioMultado);
    }
    
    /**
     * Formulario de alta del tipo de Material 
     * leyendo las entradas del usuario 
     * 
     */
    public void gestionMultas(Socio socio)
    {
        Biblioteca.getInstacia().getGestPrest().historialMultas(socio);
    }
    
     // Menús SUSCRIPCIONES
    
}    