import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala salaAsignada;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id + "-COPIA";
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0.0;
        }

        double costoMaterialesTotal = 0;
        for (Actividad act : actividades) {
            costoMaterialesTotal += act.calcularCostoMateriales();
        }

        return (this.costoBase + costoMaterialesTotal) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.salaAsignada = sala;
    }

    public void crearActividad(String tipo, int id, String titulo, int cupo) {
        if (tipo.equalsIgnoreCase("Charla")) {
            Actividad charla = new Charla(id, titulo, cupo, "Por definir");
            this.actividades.add(charla);
        } else if (tipo.equalsIgnoreCase("Taller")) {
            Actividad taller = new Taller(id, titulo, cupo, true);
            this.actividades.add(taller);
        } else {
            System.out.println("Tipo de actividad no reconocido.");
        }
    }

    public List<Actividad> getActividades() {
        return this.actividades;
    }

    public void mostrarDatos() {
        System.out.println("==================================================");
        System.out.println("EVENTO: " + this.titulo + " (ID: " + this.id + ")");
        System.out.println("Costo Final (c/ impuestos): $" + calcularCostoEstimado() + " | Gratuito: " + this.gratuito);
        System.out.println("Sala asignada: " + (salaAsignada != null ? salaAsignada.getNombre() : "Ninguna"));

        System.out.println("--- Actividades del evento ---");
        for (Actividad act : actividades) {
            act.mostrarIdentificacion(); // Uso del método final polimórfico
            act.mostrarInscripciones();
        }
        System.out.println("==================================================\n");
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}