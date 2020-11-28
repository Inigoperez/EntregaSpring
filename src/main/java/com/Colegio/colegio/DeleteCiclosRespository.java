package com.Colegio.colegio;

import org.springframework.data.repository.CrudRepository;

public interface  DeleteCiclosRespository extends CrudRepository<Ciclos, Integer> {
		
		
		public Ciclos deleteById(int id);
		
}
