package com.Colegio.colegio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Table;


@Entity // This tells Hibernate to make a table out of this class

@NamedQueries({
	@NamedQuery(name="Ciclos.deleteByID", query="SELECT c FROM Ciclos c where c.id_ciclo = :id"),
	
})


public class Ciclos {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_ciclo;


	private String especialidad;
	private String nombre;



	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String Especialidad) {
		this.especialidad = Especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setName(String Nombre) {
		this.nombre = Nombre;
	}

	public int getId_ciclo() {
		return id_ciclo;
	}

	public void setId_ciclo(int Id_ciclo) {
		this.id_ciclo = Id_ciclo;
	}



}
