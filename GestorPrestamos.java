import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/**
 * Clase donde se gestionan y almacenan los
 * distintos tipos de préstamos.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class GestorPrestamos
{
    // Array de la coleccion almacenada
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Prestamo> reservas;
    
    //instancia la fecha actual en fechaActual
    private Calendar cal = Calendar.getInstance();
    private Date fechaActual = cal.getTime();
    
    // la duración del préstamo es de 7 días
    private int duracionPrestamo = 7;

    /**
     * Inicialización de la colección de préstamos
     */
    public GestorPrestamos()
    {
        prestamos = new ArrayList<Prestamo>();
        reservas = new ArrayList<Prestamo>();
    }
    
    /**
     * Constructor for objects of class GestorPrestamos
     */
    public ArrayList<Prestamo> getPrestamos()
    {
        return prestamos;
    }

    /** 
     * Añadir un nuevo Prestamo a la base de datos
     * 
     * @param  nuevoPrestamo   el nuevo prestamo a añadir
     */
    public void añadirPrestamo(Material matPrestado, Socio socioPrestamo)
    {
        // comprueba primero que no excede el limite de los prestamos
        boolean excedePrestamos = comprobarNPrestamos(socioPrestamo);
        if (excedePrestamos == false){
            // crea el nuevo préstamo asociando la fecha de creación actual
            Date fechaPrestamo = new Date();
            Prestamo nuevoPrestamo = new Prestamo(fechaPrestamo, matPrestado, socioPrestamo, duracionPrestamo);
            if (matPrestado.getStockActual() > 0){
                prestamos.add(nuevoPrestamo);
                matPrestado.actualizarStock(-1);    // -1 para eliminar del stock el material
                socioPrestamo.añadirPrestamos(nuevoPrestamo); // añade a prestamos en activo del socio
            } else {
                System.out.println("Actualmente, no hay stock disponible para este material");
                System.out.println();
                procesarReserva(nuevoPrestamo);
            }
        } else {
            System.out.println("Ha alcanzado el número máximo de préstamos (6)");
            System.out.println();
        }
    }
    
    /** 
     * Buscar un Préstamo en la base de datos
     * 
     * @param   matPrestado   el material al que pertenece el prestamo
     * @param   socioPrestamo   el socio al que pertenece el prestamo
     * @return  el préstamo buscado
     */
    public Prestamo buscarPrestamo(Material matPrestado, Socio socioPrestamo)
    {
        for (Prestamo p : prestamos){
            if (p.getMatPrestado().equals(matPrestado) && p.getSocioPrestamo().equals(socioPrestamo)){
                return p;
            }
        }
        // Si no se encuentra en la base de datos o los 
        // datos introducidos no son correctos
        return null;
    }
    
    /**
     * Borrar un Prestamo de la base de datos (Dar de Baja)
     * 
     * @param  bajaPrestamo   el prestamo a eliminar
     */
    public boolean comprobarNPrestamos(Socio socioPrestamo)
    {
        // Mide el número de préstamos que tiene el usuario
        int tamañoLPrestamos = socioPrestamo.getPrestamosEnActivo().size();
        if (tamañoLPrestamos > 5){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Borrar un Prestamo de la base de datos (Dar de Baja)
     * 
     * @param  bajaPrestamo   el prestamo a eliminar
     */
    public void procesarReserva(Prestamo nuevaReserva)
    {
        //añadimos la reserva a una colección
        reservas.add(nuevaReserva);
        // se hace una búsqueda por todos los usuarios que tienen
        // un prestamo con ese material y se les avisa.
        int matBuscado = nuevaReserva.getMatPrestado().getIDMaterial();
        for (Prestamo p : prestamos){
            int matPrestado = p.getMatPrestado().getIDMaterial();
            if (matPrestado == matBuscado){
                Socio userPrestamo = p.getSocioPrestamo();
                System.out.println("Enviar aviso para entregar material a " + userPrestamo.getPerNombre());
            }
        }
    }
      
    /**
     * Método para gestionar la devolución de un material prestado
     * y su eliminacion de base de datos
     * 
     * @param  bajaPrestamo   el prestamo a devolver
     */
    public void devolverPrestamo(Prestamo bajaPrestamo)
    {
       Date fechaDevolucion = bajaPrestamo.getFechaDevolucion();
       if (fechaActual.after(fechaDevolucion)){
           System.out.println("AVISO! Material de fuera de plazo!");
           procesarMulta(bajaPrestamo);
       } else {
           System.out.println("Prestamo entregado a tiempo");
       }
       // damos de baja el prestamo de la coleccion
       prestamos.remove(bajaPrestamo);
       
       // se elimina de los prestamos en activo del socio
       bajaPrestamo.getSocioPrestamo().eliminarPrestamo(bajaPrestamo);
       
       // procesamos si existe una reserva para avisar al usuario de que está disponible
       // pero antes se verifica que existan reservas
       if (reservas.size() > 0){
           int matDevuelto = bajaPrestamo.getMatPrestado().getIDMaterial();
           for (Prestamo r : reservas){
               int matReservado = r.getMatPrestado().getIDMaterial();
               if (matReservado == matDevuelto){
                   Socio userReserva = r.getSocioPrestamo();
                   System.out.println("Enviar aviso de material devuelto a " + userReserva);
               } else {
                   // 1 para devolverlo al stock del material y dejarlo como libre
                   bajaPrestamo.getMatPrestado().actualizarStock(1);
               }
           }
       } else {
           // 1 para devolverlo al stock del material y dejarlo como libre
           bajaPrestamo.getMatPrestado().actualizarStock(1);
       }
    }
    
    /**
     * Cálculo de los días que ha estado sin entregarse el material
     * y proceso de multa siguiente
     * 
     * @param  bajaPrestamo   el prestamo a devolver
     */
    public void procesarMulta(Prestamo bajaPrestamo)
    {
       // instanciamos y calculamos la diferencia en dias
       long diferencia = Math.abs(fechaActual.getTime() - bajaPrestamo.getFechaDevolucion().getTime());
       long diferenciaDias = diferencia / (24 * 60 * 60 * 1000);
       
       System.out.println("El retraso es de " + diferenciaDias + " días.");
       // el cálculo es igual a 2 € por día de retraso
       long multa = diferenciaDias * 2;
       System.out.println("Se debe abonar la cantidad de " + multa + " euros.");
    }
    
    /**
     * Cálculo de los días que ha estado sin entregarse el material
     * y proceso de multa siguiente
     * 
     * @param  socio   el prestamo a devolver
     */
    public void historialMultas(Socio socio)
    {
        long totalMultas = 0;
        boolean tieneMultas = false;
        for (Prestamo prestamo : socio.getPrestamosEnActivo()){
            // instanciamos y calculamos la diferencia en dias
            long diferencia = Math.abs(fechaActual.getTime() - prestamo.getFechaDevolucion().getTime());
            long diferenciaDias = diferencia / (24 * 60 * 60 * 1000);
            if (diferenciaDias > 0){
                long multa = diferenciaDias * 2;
                print(prestamo);
                System.out.println("Deuda: " + multa + " euros");
                tieneMultas = true;
                totalMultas += multa;
            }
        }
        
        if (tieneMultas){
            System.out.println("-------------------------");
            System.out.println("Total acumulado de multas: " + totalMultas + " euros");
        } else {
            System.out.println("El usuario no tiene multas");
        }
    }

    /**
     * Imprime en pantalla los datos correspondientes al prestamo indicado
     * 
     * @param  prestamo   prestamo a imprimir
     */
    public void print(Prestamo prestamo)
    {
        System.out.println("-------------------------");
        System.out.println("DNI (Socio): " + prestamo.getSocioPrestamo().getPerDNI());
        System.out.println("Nombre (Socio): " + prestamo.getSocioPrestamo().getPerNombre());
        System.out.println("Material prestado (Título): " + prestamo.getMatPrestado().getMatTitulo());
        System.out.println("Fecha Préstamo: " + prestamo.getFechaPrestamo());
        System.out.println("Fecha Devolución: " + prestamo.getFechaDevolucion());
    }
    
    /**
     * Imprime listado de préstamos por tipo de Material
     * 
     * @param  tipoMatBuscado   tipo de Material a imprimir
     */
    public void printPorTipo(ETipoMaterial tipoMatBuscado)
    {
        // recorre el array de prestamos e imprime los que coincidan con el tipo
        boolean encontrado = false;
        for (Prestamo p : prestamos){
            if (tipoMatBuscado == p.getTipoMat()){
                encontrado = true;
                print(p);
            }
        }
        
        if (!encontrado){
            System.out.println("No hay préstamos por ese tipo de material");
        }
    }
    
    /**
     * Imprime listado de préstamos por tipo de Material
     * 
     * @param  tipoMatBuscado   tipo de Material a imprimir
     */
    public void printHistorial(Socio socio)
    {
        // recorre el array de prestamos e imprime los que coincidan con el tipo
        if (socio.getHistorialPrestamo().size() == 0){
            System.out.println("No hay préstamos en el historial");
        } else {
            for (Prestamo p : socio.getHistorialPrestamo()){
                print(p);
            }
        }
    }
    
    /**
     * Imprime listado de préstamos por tipo de Material
     * 
     * @param  tipoMatBuscado   tipo de Material a imprimir
     */
    public void printPrestamosEnActivo(Socio socio)
    {
        // recorre el array de prestamos e imprime los que coincidan con el tipo
        if (socio.getPrestamosEnActivo().size() == 0){
            System.out.println("No hay préstamos en activo");
        } else {
            for (Prestamo p : socio.getPrestamosEnActivo()){
                print(p);
            }
        }
    }
}
