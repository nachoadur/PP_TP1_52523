import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    protected int id;
    protected String titulo;
    protected int cupoMaximo;
    public final int CUPO_MINIMO = 5;

    protected List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (inscripciones.size() < cupoMaximo) {
            Inscripcion nuevaInscripcion = new Inscripcion(estudiante);
            inscripciones.add(nuevaInscripcion);
            return nuevaInscripcion;
        } else {
            System.out.println("No hay cupo en: " + this.titulo);
            return null;
        }
    }

    public void mostrarInscripciones() {
        if(inscripciones.isEmpty()) {
            System.out.println("  -> Sin inscriptos.");
        }
        for (Inscripcion i : inscripciones) {
            i.mostrarDetalle();
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println("Actividad [" + getTipo() + "] - " + this.titulo);
    }

    public abstract double calcularCostoMateriales();
    public abstract String getTipo();
}