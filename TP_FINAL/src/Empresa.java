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

    private void inicializarDatos() {
        int num;
        System.out.println("\n========================================");
        System.out.println("          CONFIGURACIÓN INICIAL         ");
        System.out.println("========================================");
        do {
            System.out.print("Ingrese la antigüedad mínima para Puesto Jerárquico: ");
            num = input.nextInt();
            if (num <= 0) {
                System.out.println(">> Error: El valor debe ser mayor a 0.");
            } else {
                PuestoJerarquico.setAntiguedadMinimaRequerida(num);
            }
        } while (num <= 0);
        System.out.println(">> ¡Datos cargados correctamente!");
        input.nextLine();
    }

    private void test() {
        // Pre-carga de conocimientos
        Conocimiento gcp = new Conocimiento("GCP");
        Conocimiento terraform = new Conocimiento("TERRAFORM");
        Conocimiento devops = new Conocimiento("DEVOPS");
        Conocimiento html = new Conocimiento("HTML");
        Conocimiento javascript = new Conocimiento("JAVASCRIPT");
        Conocimiento css = new Conocimiento("CSS");
        Conocimiento linux = new Conocimiento("LINUX");
        this.conocimientos.add(gcp);
        this.conocimientos.add(terraform);
        this.conocimientos.add(devops);
        this.conocimientos.add(html);
        this.conocimientos.add(javascript);
        this.conocimientos.add(css);
        this.conocimientos.add(linux);

        // Pre-carga de HT
        Hashtable<Conocimiento, Integer> reqCloudEngineer = new Hashtable<>();
        reqCloudEngineer.put(gcp, 2);
        reqCloudEngineer.put(terraform, 3);
        reqCloudEngineer.put(devops, 1);
        reqCloudEngineer.put(linux, 1);

        Hashtable<Conocimiento, Integer> reqFrontEndDeveloper = new Hashtable<>();
        reqFrontEndDeveloper.put(html, 1);
        reqFrontEndDeveloper.put(javascript, 3);
        reqFrontEndDeveloper.put(css, 1);

        Hashtable<Conocimiento, Integer> reqJefeFrontEndDeveloper = new Hashtable<>();
        reqJefeFrontEndDeveloper.put(html, 5);
        reqJefeFrontEndDeveloper.put(javascript, 5);
        reqJefeFrontEndDeveloper.put(css, 5);

        // Pre-carga de Puestos no Jerarquicos
        Puesto cloudEngineer = new PuestoNoJerarquico("Cloud Engineer", reqCloudEngineer);
        Puesto frontEndDeveloper = new PuestoNoJerarquico("FrontEnd Developer", reqFrontEndDeveloper);

        this.puestos.add(frontEndDeveloper);
        this.puestos.add(cloudEngineer);

        // Pre-carga de Puestos Jerarquicos
        Puesto jefeFrontEndDeveloper = new PuestoJerarquico("Jefe FrontEnd Developer", reqJefeFrontEndDeveloper);
        this.puestos.add(jefeFrontEndDeveloper);

        // Pre-carga de Empleados no Jerarquicos
        Empleado dan = new EmpleadoNoJerarquico(42, "Dan", "Zabala", 3, reqCloudEngineer);
        cloudEngineer.tomarEmpleado(dan);
        this.empleados.add(dan);
        Empleado aye = new EmpleadoNoJerarquico(43, "Ayelen", "Victorino", 1, reqFrontEndDeveloper);
        frontEndDeveloper.tomarEmpleado(aye);
        this.empleados.add(aye);

        // Pre-carga de Empleados Jerarquicos
        Empleado tizi = new EmpleadoJerarquico(44, "Tiziano", "UM", reqJefeFrontEndDeveloper, 10);
        this.empleados.add(tizi);
        jefeFrontEndDeveloper.tomarEmpleado(tizi);

        // Pre-carga de Convocatorias
        Convocatoria convocatoria1 = new Convocatoria(1, LocalDate.now(), cloudEngineer);
        this.convocatorias.add(convocatoria1);
        Convocatoria convocatoria2 = new Convocatoria(2, LocalDate.now(), frontEndDeveloper);
        this.convocatorias.add(convocatoria2);

        // Prueba empleado con un cargo
        Empleado pepe = new EmpleadoNoJerarquico(50, "Pepe", "Perez", 3, reqCloudEngineer);
        this.empleados.add(pepe);
        cloudEngineer.tomarEmpleado(pepe);

    }

    public Empresa() {
        this.puestos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.convocatorias = new ArrayList<>();
        this.conocimientos = new ArrayList<>();
        this.input = new Scanner(System.in);
        this.inicializarDatos();
        this.test();
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
            Conocimiento key = this.getConocimiento(des.toUpperCase());

            if (key == null) {
                System.out.println("La habilidad ingresada no existe en el sistema.");
            } else if (!skills.containsKey(key)) {
                do {
                    System.out.println("Ingrese los años de experiencia en: " + des.toUpperCase());
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

        System.out.println(">> Alta de empleado finalizada!");
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
        System.out.println(">> Alta de conocimiento finalizada!");
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
            aux = this.getConocimiento(descripcion.toUpperCase());
            if (aux == null) {
                System.out.println("El conocimiento ingresado no existe en el sistema.");
            }
        } while (aux == null);
        System.out.println("Ingrese los años de experiencia en: " + descripcion);
        experiencia = input.nextInt();
        input.nextLine();
        e.getSkills().put(aux, experiencia);
        System.out.println(">> Conocimiento agregado/actualizado correctamente!");
    }

    // Caso de uso 6: Agregar requerimiento puesto
    public void agregarRequerimientoPuesto() {
        String descripcionConocimiento;
        Integer experiencia;
        Conocimiento aux;
        String descripcionPuesto;
        Puesto p;
        do {
            System.out.println("Ingrese la descripcion del conocimiento");
            descripcionConocimiento = input.nextLine();
            aux = this.getConocimiento(descripcionConocimiento);
            if (aux == null) {
                System.out.println("El conocimiento ingresado no existe en el sistema.");
            }
        } while (aux == null);
        System.out.println("Ingrese los años de experiencia en: " + descripcionConocimiento);
        experiencia = input.nextInt();
        input.nextLine();
        do {
            System.out.println("Ingrese la descripcion del puesto");
            descripcionPuesto = input.nextLine();
            p = this.getPuesto(descripcionPuesto);
            if (p == null) {
                System.out.println("El puesto ingresado no existe en el sistema.");
            }
        } while (p == null);
        p.getRequerimientos().put(aux, experiencia);
        System.out.println(">> Requerimiento agregado/actualizado correctamente!");
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
        c.agregarAspirante(e);
        System.out.println(">> Aspirante agregado correctamente!");
    }

    // Caso de uso 12: Seleccionar aspirante de una convocatoria
    public void seleccionarAspirante() {
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
        c.seleccionarAspirante(e);
        System.out.println(">> Aspirante seleccionado correctamente!");
    }

    // Caso de uso 13: Mostrar aspirantes de una convocatoria
    public void mostrarAspirantes() {
        int idConvocatoria;
        Convocatoria c;
        do {
            System.out.println("Ingrese el ID de la convocatoria");
            idConvocatoria = input.nextInt();
            c = this.getConvocatoria(idConvocatoria);
            if (c == null) {
                System.out.println("El ID de la convocatoria ingresado no existe.");
            }
        } while (c == null);
        c.mostrarAspirantes();
    }

    public void mostrarEmpleado() {
        int dni;
        Empleado e;
        do {
            System.out.println("Ingrese el DNI del empleado");
            dni = input.nextInt();
            e = this.getEmpleado(dni);
            if (e == null) {
                System.out.println("El DNI ingresado no existe.");
            }
        } while (e == null);
        e.imprimirDatos();
    }

    public void mostrarPuesto() {
        String descripcion;
        Puesto p;
        do {
            System.out.println("Ingrese la descripcion del puesto");
            descripcion = input.nextLine();
            p = this.getPuesto(descripcion);
            if (p == null) {
                System.out.println("El puesto ingresado no existe en el sistema.");
            }
        } while (p == null);
        p.imprimirDatos();
    }

    public void cerrarConvocatoria() {
        int idConvocatoria;
        Convocatoria c;
        do {
            System.out.println("Ingrese el ID de la convocatoria");
            idConvocatoria = input.nextInt();
            c = this.getConvocatoria(idConvocatoria);
            if (c == null) {
                System.out.println("El ID de la convocatoria ingresado no existe.");
            }
        } while (c == null);
        c.cerrarConvocatoria();
        System.out.println(">> Convocatoria cerrada correctamente!");
    }

    public void mostrarConvocatoria() {
        int idConvocatoria;
        Convocatoria c;
        do {
            System.out.println("Ingrese el ID de la convocatoria");
            idConvocatoria = input.nextInt();
            c = this.getConvocatoria(idConvocatoria);
            if (c == null) {
                System.out.println("El ID de la convocatoria ingresado no existe.");
            }
        } while (c == null);
        c.imprimirDatos();
    }

    // =======================
    // CASOS DE USO PENDIENTES
    // =======================

    // Caso de uso 2: Dar de alta un puesto
    /*
     * public void altaPuesto() {
     * String descripcion;
     * Puesto aux;
     * int respuesta;
     * 
     * if(conocimientos.isEmpty()){
     * return;
     * }
     * 
     * do{
     * System.out.println("Ingrese la descripcion del puesto: ");
     * descripcion = input.nextLine();
     * aux = this.getPuesto(descripcion);
     * 
     * if(aux!=null){
     * System.out.println("El puesto ya existe");
     * }
     * 
     * }while(aux!=null);
     * do{
     * System.out.println("Ingrese el tipo de puesto: ");
     * System.out.println("Puesto nro 1: Jerarquico");
     * System.out.println("Puesto nro 2: No Jerarquico");
     * 
     * respuesta = input.nextInt();
     * input.nextLine();
     * 
     * if(respuesta!=1 && respuesta!=2){
     * System.out.
     * println("La respuesta es incorrecta. Ingrese una opcion correcta(1 o 2)");
     * }while(respuesta!=1 && respuesta!=2);
     * 
     * Hashtable<Conocimiento, Integer> requerimientos = new Hashtable<>();
     * Integer experienciaNecesaria;
     * String conocimientos;
     * 
     * do{
     * System.out.println("Describa el conocimiento:");
     * 
     * conocimientos = input.nextLine();
     * Conocimiento key = this.getConocimiento(conocimientos);
     * 
     * if(key==null){
     * 
     * System.out.println("El conocimiento ingresado no existe");
     * 
     * }else if(!requerimientos.containsKey(key)){
     * 
     * do{
     * System.out.println("Ingrese los año de experiencia:");
     * 
     * if(input.hasNextInt()){
     * 
     * experienciaNecesaria = input.nextInt();
     * input.nextLine();
     * }else{
     * 
     * input.nextLine();
     * experienciaNecesaria = 0;
     * }
     * input.nextLine();
     * if(experienciaNecesaria<0){
     * 
     * System.out.println("Debe ser un nuemro positivo");
     * }
     * }while(experienciaNecesaria<0);
     * 
     * requerimientos.put(key,experienciaNecesaria);
     * System.out.println("Requisito agregado correctamente");
     * 
     * }else{
     * 
     * System.out.println("El requesio ya se agrego anteriormente");
     * 
     * }
     * while (this.salir()) {
     * 
     * Puesto nuevoPuesto = null;
     * 
     * switch (respuesta) {
     * case 1:
     * nuevoPuesto = new PuestoJerarquico(descripcion,requerimientos);
     * break;
     * case 2:
     * nuevoPuesto = new PuestoNoJerarquico(descripcion,requerimientos);
     * break;
     * default:
     * break;
     * }
     * if(nuevoPuesto!=null){
     * this.puestos.add(nuevoPuesto);
     * System.out.println(descripcion);
     * }else{
     * System.out.println("Error al agrega el puesto");
     * }
     * }
     * }while(this.salir());
     * }
     * }
     */

    // Caso de uso 3: Crear convocatoria
    /*
     * public void altaConvocatoria() {
     * int vacantes;
     * LocalDate inicio;
     * LocalDate fin;
     * //Puesto puesto;
     * String descripcion;
     * 
     * 
     * System.out.println("Ingrse los datos de la convocatoria: ");
     * System.out.println("Ingrese la cantidad de vancantes; ");
     * vacantes=input.nextInt();
     * System.out.println("Ingrese la fecha de inicio;");
     * inicio=input.next();
     * System.out.println("Ingrese la fecha de finalicación: ");
     * fin = input.next();
     * 
     * Hashtable<Conocimiento, Integer> requerimientos = new Hashtable<>();
     * 
     * System.out.println("Ingrese la descripción del puesto: ");
     * descripcion=input.next();
     * 
     * System.out.print("¿Desea agregar conocimientos requeridos? (s/n): ");
     * String respuesta = input.nextLine();
     * 
     * while (respuesta.equalsIgnoreCase("s")) {
     * 
     * System.out.print("Ingrese el nombre del conocimiento: ");
     * String nombreCon = input.nextLine();
     * 
     * System.out.print("Ingrese el nivel requerido (años de experiencia): ");
     * int nivel = input.nextInt();
     * 
     * Conocimiento c = new Conocimiento(nombreCon);
     * 
     * requerimientos.put(c, nivel);
     * 
     * System.out.print("¿Desea agregar otro conocimiento? (s/n): ");
     * respuesta = input.nextLine();
     * }
     * 
     * Puesto nuevoPuesto = new PuestoNoJerarquico(descripcionPuesto,
     * requerimientos);
     * Convocatoria nueva = new Convocatoria(vacantes, inicio, nuevoPuesto);
     * 
     * convocatorias.add(nueva);
     * System.out.println("Convocatoria creada exitosamente.");
     * 
     * }
     */

    public void bajaPuesto() {
        // Completar. -aye la mas linda
    }

    public void bajaConvocatoria() {
        // Completar. - vale
    }

    public void bajaEmpleado() {
        int dni;
        do {
            do {
                System.out.println("Ingrese el DNI del empleado");
                dni = input.nextInt();
                input.nextLine();
                if (dni <= 0) {
                    System.out.println("Error: Debe ser un número positivo.");
                }
            } while (dni <= 0);
            Empleado e = this.getEmpleado(dni);
            if (e == null) {
                System.out.println("El empleado no existe");
            } else {
                for (Puesto p : this.puestos) {
                    p.eliminarEmpleado(dni);
                }

                for (Convocatoria c : this.convocatorias) {
                    c.eliminarAspirante(dni);
                }

                this.empleados.remove(e);
                System.out.println(">>Empleado eliminado del sistema correctamente");
            }
        } while (this.salir());
    }

    public void bajaConocimiento() {
        String conocimiento;
        do {
            System.out.println("Ingrese el nombre del conocimiento");
            conocimiento = input.nextLine();
            Conocimiento c = this.getConocimiento(conocimiento.toUpperCase());
            if (c == null) {
                System.out.println("El conocimiento no existe");
            } else {

                for (Puesto p : this.puestos) {
                    p.eliminarConocimiento(c);
                }

                for (Empleado e : this.empleados) {
                    e.eliminarConocimiento(c);
                }

                this.conocimientos.remove(c);
                System.out.println(">>Conocimiento eliminado del sistema correctamente");
            }
        } while (this.salir());
    }
}