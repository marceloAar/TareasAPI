package cl.mar.tareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.mar.tareas.models.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer>{

}
