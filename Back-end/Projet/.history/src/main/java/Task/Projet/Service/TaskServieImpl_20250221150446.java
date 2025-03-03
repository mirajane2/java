package Task.Projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Task.Projet.model.Task;
import Task.Projet.repository.TaskRepository;

public class TaskServieImpl {
    
    
    @Autowired
    private TaskRepository tacheRepository;

    public TaskServieImpl(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public Task create(Task tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public List<Task> Read() {
        return tacheRepository.findAll();
    }

    @Override
    public Optional<Task> singleTache(long id) {
        return tacheRepository.findById(id);
    }

    @Override
    public Optional<Task> update(long id, Task tache) {
        return tacheRepository.findById(id)
        .map(p-> {
            p.setTitle(p.getTitle());
            p.setDescription(p.getDescription());
            return tacheRepository.save(p);
        });
    }
    
    @Override
    public String delete(long id) {
        tacheRepository.deleteById(id);
        return "tache supprime";
    }
    
}

