package cl.mar.tareas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mar.tareas.models.Tarea;
import cl.mar.tareas.repositories.TareaRepository;

@RestController
@RequestMapping("/tareas")
public class TareaRestController {
	
	@Autowired
	private TareaRepository repo;	
	
	
	// http://localhost:8080/tareas/mostrar
	@GetMapping("/mostrar")
	public List<Tarea> mostrarTareas(){
		
		return repo.findAll();
	}
	
	
	// http://localhost:8080/tareas/agregar
	@PostMapping("/agregar")
	public String agregarTarea(@RequestBody Tarea tarea) {
		
		repo.save(tarea);
		
		return "Tarea guardada exitosamente.";
	}
	
	
	// http://localhost:8080/tareas/editar/{id}
	@PutMapping("/editar/{id}")
	public String editarTarea(@PathVariable Integer id, @RequestBody Tarea tarea) {
		
		Tarea buscaTarea = repo.findById(id).get();
		
		buscaTarea.setTitulo(tarea.getTitulo());
		buscaTarea.setDescripcion(tarea.getDescripcion());
		buscaTarea.setEstado(tarea.getEstado());
		
		repo.save(buscaTarea);
		
		return "Tarea actualizada exitosamente.";
	}
	
	
	// http://localhost:8080/tareas/eliminar/{id}
	@DeleteMapping("/eliminar/{id}")
	public String eliminarTarea(@PathVariable Integer id) {
		
		Tarea buscaTarea = repo.findById(id).get();
		
		repo.delete(buscaTarea);
		
		return "Tarea id "+id+ " eliminada correctamente.";
	}	

}
