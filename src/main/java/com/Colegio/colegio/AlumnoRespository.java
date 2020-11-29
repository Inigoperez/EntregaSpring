package com.Colegio.colegio;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Colegio.colegio.Alumnos;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AlumnoRespository extends CrudRepository<Alumnos, Integer> {

	////BUSQUEDA DE ALUMNOS MEDIANTE ID ////
	public Alumnos findById(int id);
	
	////BUSQUEDA DE ALUMNOS MEDIANTE NOMBRE ////
	public Alumnos findByNombre(String Nombre);


}