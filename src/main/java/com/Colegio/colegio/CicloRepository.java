package com.Colegio.colegio;

import org.springframework.data.repository.CrudRepository;

import com.Colegio.colegio.Ciclos;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface CicloRepository extends CrudRepository<Ciclos, String> {


	public Ciclos findByEspecialidad(String ciclo);

}