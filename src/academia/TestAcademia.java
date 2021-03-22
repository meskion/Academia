package academia;

import java.time.LocalDate;

public class TestAcademia {

	public static void main(String[] args) {
		
		Alumno pepe = new Alumno("Pepe", "34678904");
		Alumno andrea = new Alumno("Andrea", "17679456", 125.);
		CursoPresencial dBBDD = new CursoPresencial("Diseño de Bases de Datos", LocalDate.of(2018, 3, 12), LocalDate.of(2018, 3, 12), 50., 1, 20, 8, 1);
		CursoOnline aBBDD = new CursoOnline("Administracion de Bases de Datos", LocalDate.of(2018, 3, 19), LocalDate.of(2018, 3, 21), 50., 5, dBBDD.getTitulo());
		
		dBBDD.matricularAlumno(pepe);
		dBBDD.matricularAlumno(andrea);
		dBBDD.registrarAsistencia(1,pepe);
		
		System.out.println(dBBDD.expedirTitulo(pepe));
		System.out.println(dBBDD.expedirTitulo(andrea));
		
		aBBDD.matricularAlumno(pepe);
	}

}
