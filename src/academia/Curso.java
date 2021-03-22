package academia;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public abstract class Curso {

	protected String titulo;
	protected LocalDate fechaInicio, fechaFin;
	protected Double precio;
	protected Set<Alumno> alumnos;
	protected Integer diasClase;

	public Curso(String titulo, LocalDate fechaInicio, LocalDate fechaFin, Double precio, Integer diasClase) {

		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precio = precio;
		this.diasClase = diasClase;
		alumnos = new TreeSet<>();

	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public Double getPrecio() {
		return precio;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public Integer getDiasClase() {
		return diasClase;
	}

	public Integer getNumAlumnos() {
		return alumnos.size();
	}

	public void matricularAlumno(Alumno al) {
		if (al.getSaldo() >= precio && !alumnos.contains(al)) {
			al.decSaldo(precio);
			alumnos.add(al);
			System.out
					.println(String.join(" ", "Alumno", al.getNombre(), "matriculado con exito en", this.getTitulo()));
		} else {
			System.err.println("El alumno no ha podido ser matriculado");
		}
	}

	public abstract String expedirTitulo(Alumno al);

	@Override
	public String toString() {
		return "Curso: " + titulo + ", fecha Inicio: " + fechaInicio.toString() + ", fecha Fin: " + fechaFin.toString()
				+ "dias de Clase: " + diasClase;
	}

}
