package com.Colegio.colegio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping(path="/demo")

public class MainController {
	
///////////////////////////////////////////////
///////////// START REPOSITORIOS //////////////
///////////////////////////////////////////////
	
	@Autowired
	private AlumnoRespository AlumnoRespository;
	
	@Autowired
	private CicloRepository CicloRepository;
	
///////////////////////////////////////////////
///////////// END REPOSITORIOS ////////////////
///////////////////////////////////////////////
	
	
///////////////////////////////////////////////
////////// START ALUMNOS REQUEST //////////////
///////////////////////////////////////////////
	
	///// MUESTRA TODOS LOS ALUMNOS DE LA BD /////
	@GetMapping(path="/allAlumnos")
	public @ResponseBody Iterable<Alumnos> getAllUsers() {
		
		return AlumnoRespository.findAll();
	}
	
	///// MUESTRA UN ALUMNO BUSCADO POR NOMBRE /////
	@GetMapping(path="/byName")
	public @ResponseBody Alumnos busquedaNombre(String nombre){

		return AlumnoRespository.findByNombre(nombre);
	}
	
	///// AÑADE UN ALUMNO NUEVO A LA BD /////
	@RequestMapping(path="/addAlumno")
	public @ResponseBody Alumnos addNewUser (@RequestParam String nombre,@RequestParam String apellido,@RequestParam int id_ciclo) {

		Alumnos a = new Alumnos();

		a.setNombre(nombre);
		a.setApellido(apellido);
		a.setId_ciclo(id_ciclo);
		AlumnoRespository.save(a);

		return a;
	}
	
	///// MODIFICA UN ALUMNO DE LA BD /////
	@RequestMapping(path="/updateAlumno")
	public @ResponseBody Alumnos updateAlumno (@RequestParam int id_personas,String nombre, String apellido, Integer id_ciclo) {

		Alumnos a = AlumnoRespository.findById(id_personas);
		
		if(nombre == null) {
			nombre = a.getNombre();
		}
		if(apellido == null) {
			apellido = a.getApellido();
		}
		if(id_ciclo == null) {
			id_ciclo =a.getId_ciclo();
		}
		
		a.setId_ciclo(id_ciclo);
		a.setNombre(nombre);
		a.setApellido(apellido);
		AlumnoRespository.save(a);

		return a;
	}
	
	///// ELIMINA UN ALUMNO MEDIANTE ID DE LA BD /////
	@RequestMapping(path="/deleteAlumno") // Map ONLY POST Requests
	public String deleteAlumno(@RequestParam int id_alumno) {
		
		AlumnoRespository.deleteById(id_alumno);
		
		return "redirect:/demo/allAlumnos" ;	
	}
///////////////////////////////////////////////
//////////// END ALUMNOS REQUEST //////////////
///////////////////////////////////////////////

	
///////////////////////////////////////////////
//////////// START CICLOS REQUEST /////////////
///////////////////////////////////////////////
	
	///// MUESTRA TODOS LOS CICLOS DE LA BD /////
	@GetMapping(path="/allCiclos")
	public @ResponseBody Iterable<Ciclos> TodosCiclos() {

		return CicloRepository.findAll();
	}

	///// MUESTRA UN CICLO DE LA BD MEDIANTE ESPECIALIDAD /////
	@GetMapping(path="/byEspecialidad")
	public @ResponseBody Ciclos busquedaEspecialidad(String especialidad){

		return CicloRepository.findByEspecialidad(especialidad);
	}
	
	///// AÑADE UN CICLO NUEVO A LA BD /////
	@RequestMapping(path="/addCiclos") // Map ONLY POST Requests
	public @ResponseBody Ciclos addNewCiclo (@RequestParam String nombre,@RequestParam String especialidad) {

		Ciclos c = new Ciclos();

		c.setName(nombre);
		c.setEspecialidad(especialidad);
		CicloRepository.save(c);

		return c;
	}

	///// MODIFICA UN CICLO DE LA BD MEDIANTE ID /////
	@RequestMapping(path="/updateCiclo") // Map ONLY POST Requests
	public @ResponseBody Ciclos UpdateCiclo (@RequestParam int id_ciclo,String nombre,String especialidad) {

		Ciclos c = CicloRepository.findById(id_ciclo);

		if(nombre == null) {
			nombre = c.getNombre();
		}
		if(especialidad == null) {
			especialidad = c.getEspecialidad();
		}
		
		c.setName(nombre);
		c.setEspecialidad(especialidad);
		CicloRepository.save(c);

		return c;
	}
	
	///// ELIMINA UN CICLO MEDIANTE ID DE LA BD /////
	@RequestMapping(path="/deleteCiclo") // Map ONLY POST Requests
	public String deleteCiclo(@RequestParam int id_ciclo) {
		
		CicloRepository.deleteById(id_ciclo);
		
		return "redirect:/demo/allCiclos";
	}

	
///////////////////////////////////////////////
//////////// END CICLOS REQUEST ///////////////
///////////////////////////////////////////////
}