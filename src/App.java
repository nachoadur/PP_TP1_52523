import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add(new Estudiante("L01", "Ana Gomez"));
        listaEstudiantes.add(new Estudiante("L02", "Juan Perez"));

        EventoUniversitario evento1 = new EventoUniversitario("E01", "Semana de la Tecnología", 10000, false);

        Sala salaPrincipal = new Sala(1, "Auditorio Central");
        evento1.asignarSala(salaPrincipal);

        evento1.crearActividad("Charla", 101, "Ciberseguridad", 50);
        evento1.crearActividad("Taller", 102, "Programación en Java", 30);

        Actividad charla = evento1.getActividades().get(0);
        Actividad taller = evento1.getActividades().get(1);

        charla.inscribir(listaEstudiantes.get(0));
        taller.inscribir(listaEstudiantes.get(1));

        System.out.println("--- Resumen de Eventos (Uso de Polimorfismo) ---");
        evento1.mostrarDatos();

        System.out.println("--- Totalizador ---");
        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}