package academia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CursoPresencial extends Curso {

	private Integer cupo, horasDiarias, numAsistencias;
	private Map<Integer, List<Alumno>> asistencias;

	public CursoPresencial(String titulo, LocalDate fechaInicio, LocalDate fechaFin, Double precio, Integer diasClase,
			Integer cupo, Integer horasDiarias, Integer numAsistencias) {
		super(titulo, fechaInicio, fechaFin, precio, diasClase);
		this.cupo = cupo;
		this.horasDiarias = horasDiarias;
		this.numAsistencias = numAsistencias;
		asistencias = new HashMap<>();

	}

	public void matricularAlumno(Alumno al) {
		if (this.alumnos.size() < cupo) {
			super.matricularAlumno(al);
		} else {
			System.out.println("No quedan plazas para este curso");
		}
	}

	@Override
	public String expedirTitulo(Alumno al) {
		if (asistencias.values().stream().filter(list -> list.contains(al)).count() >= numAsistencias
				&& getFechaFin().compareTo(LocalDate.now()) < 0 && alumnos.contains(al) && !al.hasCurso(this)) {

			al.getCursosActuales().remove(this);
			al.getCursosCompletos().add(this);
			return String.join("", "D/Da ", al.getNombre(), " ha realizado con aprovechamiento el curso: ", this.titulo,
					", en la modalidad Presencial, con una duración de ", Integer.toString(horasDiarias * diasClase),
					" horas");

		}

		return null;
	}

	public void registrarAsistencia(Integer dia, Alumno al) {
		if (dia <= diasClase && alumnos.contains(al)) {

			if (!asistencias.containsKey(dia)) {
				asistencias.put(dia, new ArrayList<>());
			}
			asistencias.get(dia).add(al);

		}

	}
}
