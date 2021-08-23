package com.theopentutorials.jdbc.main;

public class Students {
	private int numeroIdentificacion;
	private String nombre;
	private String apellido;
	private int edad;
	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Students [numeroIdentificacion=" + numeroIdentificacion + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + "]";
	}
	

}
