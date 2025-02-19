package ToDo.Taches.service;

import java.util.List;
import ToDo.Taches.model.Tache;

public interface TaskService {
    
    Tache create(Tache tache);

    List<Tache> Read();

    Tache singlTache(int id);

    Tache update(int id, Tache tache);

    String delete(int id);
}
