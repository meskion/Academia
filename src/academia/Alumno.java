package academia;

import java.util.ArrayList;
import java.util.List;

public class Alumno implements Comparable<Alumno> {

	private String nombre, dni;
	private Double saldo;
	private List<Curso> cursosCompletos;
	private List<Curso> cursosActuales;

	public Alumno(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.saldo = 100.;
		cursosCompletos = new ArrayList<>();
		cursosActuales = new ArrayList<>();
	}

	public Alumno(String nombre, String dni, Double saldo) {
		this(nombre, dni);
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void addSaldo(double inc) {
		saldo += inc;
	}

	public void decSaldo(double dec) {
		saldo -= dec;
	}

	public List<Curso> getCursosCompletos() {
		return cursosCompletos;
	}

	public List<Curso> getCursosActuales() {
		return cursosActuales;
	}

	public boolean hasCurso(Curso curso) {
		return cursosCompletos.contains(curso);
	}

	@Override
	public String toString() {
		return nombre + ", " + dni + ", saldo:" + saldo;
	}

	@Override
	public int compareTo(Alumno o) {
		return this.dni.compareTo(o.dni);

	}

}
