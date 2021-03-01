import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacionesEmpleado {
    private static final List<Empleado> listaEmpleados = new ArrayList<>();
    public static void inicializarLista(){

        listaEmpleados.add(new Empleado(1,"Karen Dayanna","Nossa",1000.000));
        listaEmpleados.add(new Empleado(2,"Leticia","Nossa",310.000));
        listaEmpleados.add(new Empleado(3,"Brayan","Nossa",720.000));
        listaEmpleados.add(new Empleado(4,"Michael","Nossa",850.000));
        listaEmpleados.add(new Empleado(5,"Andres","Salamanca",910.000));
        listaEmpleados.add(new Empleado(6,"Luz","Alvarez",970.000));
        listaEmpleados.add(new Empleado(7,"Monica","Alvarado",1100.000));
        listaEmpleados.add(new Empleado(8,"Luisa","Acevedo",1300.000));
    }
    public static void agregarEmpleado(){
        Scanner leer = new Scanner(System.in);


        boolean correcto = true;
        int ids;

        do{
            System.out.print("\nIngrese el ID: ");
            ids=leer.nextInt();
            for(int i = 0; i < listaEmpleados.size(); i++){
                Empleado empleado=listaEmpleados.get(i);
                if(empleado.getId()==ids){
                    System.out.print("El usuario ya existe");
                    correcto=true;
                    break;
                }else{
                    correcto=false;
                    break;
                }
            }
        } while(correcto==true);

        System.out.print("Ingrese el Nombre: ");
        leer.nextLine();
        String name=leer.nextLine();
        System.out.print("Ingrese el Apellido: ");
        String lastname=leer.nextLine();
        System.out.print("Ingrese el Salario:  ");
        double money=leer.nextInt();
        Empleado emple=new Empleado(ids ,name,lastname,money);
        listaEmpleados.add(emple);
        System.out.println("_______________________________/");
        System.out.println("Empleado creado");
        System.out.println("Nombre: " + emple.getNombre());
        System.out.println("apellido: " + emple.getApellido());
        System.out.println("salario: " + emple.getSalario());
        System.out.println("ID: " + emple.getId());
        System.out.println("_______________________________/");

    }
    public static void eliminarEmpleado(){
        Scanner leer = new Scanner(System.in);

        System.out.println("Estos son los datos");
        for(int i = 0; i < listaEmpleados.size(); i++){
            Empleado empleado=listaEmpleados.get(i);
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("apellido: " + empleado.getApellido());
            System.out.println("salario: " + empleado.getSalario());
            System.out.println("ID: " + empleado.getId());

        }

        System.out.println("Ingrese el ID que desea eliminar");
        int id=leer.nextInt();

        for(int i = 0; i < listaEmpleados.size(); i++){
            Empleado empleado=listaEmpleados.get(i);
            if(empleado.getId()==id){
                listaEmpleados.remove(i);
            }

        }


    }
    public static void mostrarEmpleado(){

        System.out.println("Estos son los datos:");
        for(int i = 0; i < listaEmpleados.size(); i++)
        {
            Empleado empleado=listaEmpleados.get(i);

            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellido: " + empleado.getApellido());
            System.out.println("Salario: " + empleado.getSalario());
            System.out.println("ID:" + empleado.getId());

        }

    }
    public static void actualizarEmpleado(){
        Scanner leer = new Scanner(System.in);
        int id,ids;

        System.out.println("Estos son los datos");
        for(int i = 0; i < listaEmpleados.size(); i++){
            Empleado empleado=listaEmpleados.get(i);

            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellido: " + empleado.getApellido());
            System.out.println("Salario: " + empleado.getSalario());
            System.out.println("ID:" + empleado.getId());

        }

        System.out.print("Ingrese el ID que desea actualizar: ");
        id=leer.nextInt();
        for(int i = 0; i < listaEmpleados.size(); i++){
            Empleado empleado=listaEmpleados.get(i);
            if(empleado.getId()==id){
                System.out.print("Ingrese el ID: ");
                ids=leer.nextInt();
                System.out.print("Ingrese el Nombre: ");
                leer.nextLine();
                String name=leer.nextLine();
                System.out.print("Ingrese el Apellido: ");
                String lastname=leer.nextLine();
                System.out.print("Ingrese el Salario: ");
                double money=leer.nextInt();
                System.out.println("El registro se actualizo corectamente.");
                empleado.setId(ids);
                empleado.setNombre(name);
                empleado.setApellido(lastname);
                empleado.setSalario(money);
            }
        }


    }

    public static void empleadoConMayorSueldo() {
        System.out.println(listaEmpleados.stream().max(Comparator.comparing(Empleado::getSalario))
                .map(Empleado::toString)
                .orElse("No hay empleados"));
    }

    public static void empleadoConMenorSueldo() {//Encontrar empleado con menor sueldo
        System.out.println("\nEmpleado con mayor Salario");
        System.out.println(listaEmpleados.stream().min(Comparator.comparing(Empleado::getSalario))
                .map(Empleado::toString)
                .orElse("No hay empleados..."));

    }

    public static void empleadosOrdenadosPorNombre() {
        System.out.println("\nEmpleados Organizados por Nombre:");
        listaEmpleados.stream()
                .sorted(Comparator.comparing(Empleado::getNombre))
                .forEach(System.out::println);
    }

    public static void sumaSalarioEmpleados(){
        System.out.println("\nSuma del salario de los  empleados: "+

                listaEmpleados.stream()
                        .filter(empleado -> empleado.getSalario() >= 700.000)
                        .mapToDouble(Empleado::getSalario)
                        .reduce(0,(acc,salario)->acc+salario));

    }

    public static void empleadosConApellidoQueEmpiezaConA(){
        System.out.println("Empleados que su apellido empieza por la letra A: "+
                listaEmpleados.stream().filter(empleado -> empleado.getApellido().toUpperCase().startsWith("A")).count());
    }

    public static void cincoEmpleadosConMayorSueldo(){
        System.out.println("\nCinco primeros con mejor salario: ");
        listaEmpleados.stream().filter(empleado -> empleado.getSalario() >= 600.000)
                .sorted(Comparator.comparing(Empleado::getSalario)).limit(5)
                .forEach(System.out::println);

    }

}
