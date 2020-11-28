package com.Colegio.colegio;

import org.springframework.data.repository.CrudRepository;

public interface DeleteAlumnoRespository extends CrudRepository<Alumnos, Integer> {
	
	
	public Alumnos deleteById(int id);

}
