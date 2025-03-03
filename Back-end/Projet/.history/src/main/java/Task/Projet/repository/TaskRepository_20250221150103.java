package Task.Projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Task.Projet.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {
    
}
