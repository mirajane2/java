package Task.Projet.Service;


import java.util.List;
import java.util.Optional;

import Task.Projet.model.Task;



public interface TaskService {
    
    Task create(Task tache);

    List<Task> Read();

    Optional<Task> singleTache(long id);

    Optional<Task> update(long id, Task tache);

    String delete(long id);
}