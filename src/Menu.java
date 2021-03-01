import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu(){

        OperacionesEmpleado.inicializarLista();
        int opcion;
        do {
            mostrarOpciones();
            opcion = validarOpcion();
            switch (opcion) {
                case 1:
                    OperacionesEmpleado.agregarEmpleado();
                    break;
                case 2:
                    OperacionesEmpleado.eliminarEmpleado();
                    break;
                case 3:
                    OperacionesEmpleado.actualizarEmpleado();
                    break;
                case 4:
                    OperacionesEmpleado.mostrarEmpleado();
                    break;
                case 5:
                    OperacionesEmpleado.empleadoConMayorSueldo();
                    break;
                case 6:
                    OperacionesEmpleado.empleadoConMenorSueldo();
                    break;
                case 7:
                    OperacionesEmpleado.empleadosOrdenadosPorNombre();
                    break;
                case 8:
                    OperacionesEmpleado.sumaSalarioEmpleados();
                    break;
                case 9:
                    OperacionesEmpleado.empleadosConApellidoQueEmpiezaConA();
                    break;
                case 10:
                    OperacionesEmpleado.cincoEmpleadosConMayorSueldo();
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }while(opcion != 11);

        System.out.println("Gracias....");
    }

    private static void mostrarOpciones() {
        System.out.println("Bienvenido al menu estas son las opciones\n"
                + "1 - Agregar\n"
                +"2 - Eliminar\n"
                +"3 - Actualizar\n"
                +"4 - Listar\n"
                +"5 - Mostrar empleado con Mayor Salario\n"
                +"6 - Mostrar empleado con Menor Salario\n"
                +"7 - Ordenar los empleados por Nombre\n"
                +"8 - Suma de los salarios de todos los empleados cuyo salario es mayor a 700000\n"
                +"9 - Número total de empleados cuyo apellido comienza por la letra A\n"
                +"10 - Cinco primeros empleados con mayor Salario. \n"
                +"11 - Salir del sistema....\n");
    }
    private static int validarOpcion(){
        try{
            return scanner.nextInt();
        }catch(InputMismatchException exception){
            scanner.nextLine();
            return 0;
        }
    }
}
