package com.Colegio.colegio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.web.bind.annotation.Mapping;


@Entity // This tells Hibernate to make a table out of this class

@NamedQueries({
	@NamedQuery(name="Alumno.deleteByID", query="SELECT a FROM Alumnos a where a.id_personas = :id")
})

public class Alumnos {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)


	private int id_personas;
	private String apellido;
	private String nombre;
	private int id_ciclo;



	public int getId_personas() {
		return id_personas;
	}

	public void setId_personas(int id_personas) {
		this.id_personas = id_personas;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}

	public int getId_ciclo() {
		return id_ciclo;
	}

	public void setId_ciclo(int id_ciclo) {
		this.id_ciclo = id_ciclo;
	}


}
