package ToDo.Taches.service;

import java.util.List;
import java.util.Optional;

import ToDo.Taches.model.Tache;

public interface TaskService {
    
    Tache create(Tache tache);

    List<Tache> Read();

    Optional<Tache> singleTache(int id);

    Optional<Tache> update(int id, Tache tache);

    String delete(int id);
}
