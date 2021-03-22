package academia;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CursoOnline extends Curso {

	private List<String> cursosRequeridos;

	public CursoOnline(String titulo, LocalDate fechaInicio, LocalDate fechaFin, Double precio, Integer diasClase,
			String... cursos) {
		super(titulo, fechaInicio, fechaFin, precio, diasClase);
		cursosRequeridos = List.of(cursos);
	}

	@Override
	public void matricularAlumno(Alumno al) {
		if (al.getCursosCompletos().stream().map(c -> c.getTitulo()).collect(Collectors.toList())
				.containsAll(cursosRequeridos)) {
			super.matricularAlumno(al);
		} else {
			System.out.println("No cumple los prerequisitos de cursos.");
		}

	}

	public String expedirTitulo(Alumno al) {
		if (getFechaFin().compareTo(LocalDate.now()) < 0 && alumnos.contains(al) && !al.hasCurso(this)) {
			al.getCursosActuales().remove(this);
			al.getCursosCompletos().add(this);
			return String.join("", "D/Da ", al.getNombre(), " ha realizado con aprovechamiento el curso: ", this.titulo,
					", en la modalidad Online, con una duración de ",diasClase.toString(), " dias");
		}
		return null;
	}
}
