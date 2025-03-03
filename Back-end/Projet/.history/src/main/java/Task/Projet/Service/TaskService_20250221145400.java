package Task.Projet.Service;


import java.util.List;
import java.util.Optional;

// import ToDo.Taches.model.Tache;

public interface TaskService {
    
    Tache create(Tache tache);

    List<Tache> Read();

    Optional<Tache> singleTache(long id);

    Optional<Tache> update(long id, Tache tache);

    String delete(long id);
}