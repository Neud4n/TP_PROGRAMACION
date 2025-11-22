import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.time.LocalDate;

public class Empresa {

    private ArrayList<Puesto> puestos;
    private ArrayList<Empleado> empleados;
    private ArrayList<Convocatoria> convocatorias;
    private ArrayList<Conocimiento> conocimientos;
    private Scanner input;

    public Empresa() {

        this.puestos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.convocatorias = new ArrayList<>();
        this.conocimientos = new ArrayList<>();
        this.input = new Scanner(System.in);

        // Pre-carga de conocimientos
        Conocimiento gcp = new Conocimiento("GCP");
        Conocimiento terraform = new Conocimiento("Terraform");
        Conocimiento devops = new Conocimiento("DevOps");
        Conocimiento html = new Conocimiento("HTML");
        Conocimiento javascript = new Conocimiento("Javascript");
        Conocimiento css = new Conocimiento("CSS");
        Conocimiento linux = new Conocimiento("Linux");
        this.conocimientos.add(gcp);
        this.conocimientos.add(terraform);
        this.conocimientos.add(devops);
        this.conocimientos.add(html);
        this.conocimientos.add(javascript);
        this.conocimientos.add(css);
        this.conocimientos.add(linux);
        // Pre-carga de HT
        Hashtable<Conocimiento, Integer> requerimientosCloudEngineer = new Hashtable<>();
        requerimientosCloudEngineer.put(gcp, 2);
        requerimientosCloudEngineer.put(terraform, 3);
        requerimientosCloudEngineer.put(devops, 1);
        requerimientosCloudEngineer.put(linux, 1);
        Hashtable<Conocimiento, Integer> requerimientosFrontEndDeveloper = new Hashtable<>();
        requerimientosFrontEndDeveloper.put(html, 1);
        requerimientosFrontEndDeveloper.put(javascript, 3);
        requerimientosFrontEndDeveloper.put(css, 1);
        // Pre-carga de Puestos
        Puesto cloudEngineer = new PuestoNoJerarquico("Cloud Engineer", requerimientosCloudEngineer);
        Puesto frontEndDeveloper = new PuestoNoJerarquico("FrontEnd Developer", requerimientosFrontEndDeveloper);
        this.puestos.add(frontEndDeveloper);
        this.puestos.add(cloudEngineer);
        // Pre-carga de Empleados
        Empleado dan = new EmpleadoNoJerarquico(42, "Dan", "Zabala", 3, requerimientosCloudEngineer);
        cloudEngineer.tomarEmpleado(dan);
        this.empleados.add(dan);
        Empleado aye = new EmpleadoNoJerarquico(43, "Ayelen", "Victorino", 1, requerimientosFrontEndDeveloper);
        frontEndDeveloper.tomarEmpleado(aye);
        this.empleados.add(aye);
        // Pre-carga de Convocatorias
        Convocatoria convocatoria1 = new Convocatoria(1, LocalDate.now(), cloudEngineer);
        this.convocatorias.add(convocatoria1);
        Convocatoria convocatoria2 = new Convocatoria(2, LocalDate.now(), frontEndDeveloper);
        this.convocatorias.add(convocatoria2);
    }

    private Conocimiento getConocimiento(String descripcion) {
        for (Conocimiento c : conocimientos) {
            if (c.comparoDescripcion(descripcion)) {
                return c;
            }
        }
        return null;
    }

    private Empleado getEmpleado(int dni) {
        for (Empleado e : empleados) {
            if (e.comparoDni(dni)) {
                return e;
            }
        }
        return null;
    }

    private Puesto getPuesto(String descripcion) {
        for (Puesto p : puestos) {
            if (p.comparoDescripcion(descripcion)) {
                return p;
            }
        }
        return null;
    }

    private Convocatoria getConvocatoria(int id) {
        for (Convocatoria c : convocatorias) {
            if (c.comparoId(id)) {
                return c;
            }
        }
        return null;
    }

    private boolean salir() {
        int resp;
        do {
            System.out.println("Hay más datos? Si - 1 | No - 0");
            resp = input.nextInt();
            input.nextLine();
            if (resp != 0 && resp != 1) {
                System.out.println("Error: Ingrese un valor valido");
            }
        } while (resp != 0 && resp != 1);
        return resp == 1;
    }

    // Caso de uso 1: Dar de alta un empleado
    public void altaEmpleado() {

        if (this.conocimientos.isEmpty()) {
            System.out.println("No existen conocimientos en el sistema.");
            return;
        }

        if (this.puestos.isEmpty()) {
            System.out.println("No existen puestos en el sistema.");
            return;
        }

        Empleado e;
        int dni;
        do {
            System.out.println("Ingrese el DNI del empleado");
            dni = input.nextInt();
            e = this.getEmpleado(dni);
            if (e != null) {
                System.out.println("El DNI ingresado ya existe.");
            }
        } while (e != null);
        input.nextLine();
        System.out.println("Ingrese el nombre del empleado");
        String nombre = input.nextLine();
        System.out.println("Ingrese el apellido");
        String apellido = input.nextLine();
        int antiguedad;

        do {
            System.out.println("Cuántos años lleva en la empresa?");
            antiguedad = input.nextInt();
            input.nextLine();
            if (antiguedad <= 0) {
                System.out.println("Error: Debe ser un número positivo.");
            }
        } while (antiguedad <= 0);

        Hashtable<Conocimiento, Integer> skills = new Hashtable<>();
        String des = "";
        Integer experiencia = null;
        do {
            System.out.println("Ingrese una habilidad dura del empleado");
            des = input.nextLine();
            Conocimiento key = this.getConocimiento(des);

            if (key == null) {
                System.out.println("La habilidad ingresada no existe en el sistema.");
            } else if (!skills.containsKey(key)) {
                do {
                    System.out.println("Ingrese los años de experiencia en: " + des);
                    experiencia = input.nextInt();
                } while (experiencia <= 0);
                skills.put(key, experiencia);
            } else {
                System.out.println("El empleado ya tiene registrada esa habilidad.");
            }
        } while (this.salir());

        int resp;
        do {
            System.out.println("Tipo de empleado: ");
            System.out.println("1.- Jerarquico");
            System.out.println("2.- No Jerarquico");
            resp = input.nextInt();
            input.nextLine();
            if (resp != 1 && resp != 2) {
                System.out.println("Error: Ingreso un número incorrecto.");
            }
        } while (resp != 1 && resp != 2);

        switch (resp) {
            case 1:
                this.empleados.add(new EmpleadoJerarquico(dni, nombre, apellido, skills, antiguedad));
                break;
            case 2:
                this.empleados.add(new EmpleadoNoJerarquico(dni, nombre, apellido, antiguedad, skills));
                break;
        }

    }

    // Caso de uso 2: Dar de alta un puesto
    public void altaPuesto() {
        // Completar.
    }

    // Caso de uso 3: Crear convocatoria
    public void altaConvocatoria() {
        // Completar.
    }

    // Caso de uso 4: Alta de conocimientos
    public void altaConocimientos() {
        String descripcion;
        Conocimiento aux;
        do {
            System.out.println("Ingrese la descripcion del conocimiento");
            descripcion = input.nextLine();
            aux = this.getConocimiento(descripcion.toUpperCase());
            if (aux != null) {
                System.out.println("El conocimiento ya existe en el sistema.");
            }
        } while (aux != null);
        Conocimiento conocimiento = new Conocimiento(descripcion);
        this.conocimientos.add(conocimiento);
    }

    // Caso de uso 5: Agregar conocimiento empleado
    public void agregarSkillEmpleado() {
        int dni;
        String descripcion;
        Integer experiencia;
        Conocimiento aux;
        Empleado e;
        do {
            System.out.println("Ingrese el DNI del empleado");
            dni = input.nextInt();
            e = this.getEmpleado(dni);
            if (e == null) {
                System.out.println("El DNI ingresado no existe.");
            }
        } while (e == null);
        input.nextLine();
        System.out.println("Ingrese la descripcion del conocimiento");
        do {
            descripcion = input.nextLine();
            aux = this.getConocimiento(descripcion);
            if (aux == null) {
                System.out.println("El conocimiento ingresado no existe en el sistema.");
            }
        } while (aux == null);
        System.out.println("Ingrese los años de experiencia en: " + descripcion);
        experiencia = input.nextInt();
        input.nextLine();
        e.getSkills().put(aux, experiencia);
    }

    // Caso de uso 6: Agregar requerimiento puesto
    public void agregarRequerimientoPuesto() {
        String descripcion;
    }

    // Caso de uso 7: Mostrar puestos jerarquicos y no jerarquicos.
    public void mostrarPuestos() {
        int countJerarquicos = 0;
        int countNoJerarquicos = 0;
        System.out.println("=====================");
        System.out.println("Puestos Jerarquicos");
        System.out.println("=====================");
        for (Puesto p : puestos) {
            if (p.sosJerarquico()) {
                countJerarquicos++;
                p.imprimirDatos();
            }
        }

        if (countJerarquicos == 0) {
            System.out.println("No hay puestos jerarquicos.");
        }

        System.out.println("=====================");
        System.out.println("Puestos No Jerarquicos");
        System.out.println("=====================");
        for (Puesto p : puestos) {
            if (!p.sosJerarquico()) {
                countNoJerarquicos++;
                p.imprimirDatos();
            }
        }

        if (countNoJerarquicos == 0) {
            System.out.println("No hay empleados no jerarquicos.");
        }
    }

    // Caso de uso 8: Mostra convocatorias.
    public void mostrarConvocatorias() {
        int countAbiertas = 0;
        int countCerradas = 0;
        System.out.println("=====================");
        System.out.println("Convocatorias Abiertas");
        System.out.println("=====================");
        for (Convocatoria c : convocatorias) {
            if (c.getEstado()) {
                countAbiertas++;
                c.imprimirDatos();
            }
        }

        if (countAbiertas == 0) {
            System.out.println("No hay convocatorias abiertas.");
        }

        System.out.println("=====================");
        System.out.println("Convocatorias Cerradas");
        System.out.println("=====================");
        for (Convocatoria c : convocatorias) {
            if (!c.getEstado()) {
                countCerradas++;
                c.imprimirDatos();
            }
        }

        if (countCerradas == 0) {
            System.out.println("No hay convocatorias cerradas.");
        }
    }

    // Caso de uso 9: Mostrar empleados
    public void mostrarEmpleados() {
        int countJerarquicos = 0;
        int countNoJerarquicos = 0;
        System.out.println("=====================");
        System.out.println("Empleados Jerarquicos");
        System.out.println("=====================");
        for (Empleado e : empleados) {
            if (e.sosJerarquico()) {
                countJerarquicos++;
                e.imprimirDatos();
            }
        }

        if (countJerarquicos == 0) {
            System.out.println("No hay empleados jerarquicos.");
        }

        System.out.println("=====================");
        System.out.println("Empleados No Jerarquicos");
        System.out.println("=====================");
        for (Empleado e : empleados) {
            if (!e.sosJerarquico()) {
                countNoJerarquicos++;
                e.imprimirDatos();
            }
        }

        if (countNoJerarquicos == 0) {
            System.out.println("No hay empleados no jerarquicos.");
        }
    }

    // Caso de uso 10: Mostrar conocimientos
    public void mostrarConocimientos() {
        System.out.println("=====================");
        System.out.println("    HABILIDADES");
        System.out.println("=====================");
        for (Conocimiento c : conocimientos) {
            c.imprimirDatos();
        }

        if (conocimientos.isEmpty()) {
            System.out.println("No hay habilidades en el sistema.");
        }
    }

    // Caso de uso 11: Agregar aspirante a una convocatoria
    public void agregarAspirante() {

        if (convocatorias.isEmpty()) {
            System.out.println("No hay convocatorias en el sistema.");
            return;
        }

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en el sistema.");
            return;
        }

        int dni;
        int idConvocatoria;
        Empleado e;
        Convocatoria c;
        do {
            System.out.println("Ingrese el DNI del aspirante");
            dni = input.nextInt();
            e = this.getEmpleado(dni);
            if (e == null) {
                System.out.println("El DNI ingresado no existe.");
            }
        } while (e == null);
        do {
            System.out.println("Ingrese el ID de la convocatoria");
            idConvocatoria = input.nextInt();
            c = this.getConvocatoria(idConvocatoria);
            if (c == null) {
                System.out.println("El ID de la convocatoria ingresado no existe.");
            }
        } while (c == null);
        // En el método agregarAspirante debería:
        // Verificar que el empleado no esté en la lista de aspirantes.
        // Y también que el empleado cumpla con los requisitos del puesto.
        c.agregarAspirante(e);
    }

    // Caso de uso 12: Seleccionar aspirante de una convocatoria
    public void seleccionarAspirante() {
        // Completar
    }

    // Caso de uso 13: Mostrar aspirantes de una convocatoria
    public void mostrarAspirantes() {
        // Completar
    }
}