package Task.Projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Task.Projet.model.Task;
import Task.Projet.repository.TaskRepository;

@Service
public class TaskServieImpl implements TaskService {
    
    
    @Autowired
    private TaskRepository taskRepository;

    public TaskServieImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task tache) {
        return taskRepository.save(tache);
    }

    @Override
    public List<Task> Read() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> singleTache(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Optional<Task> update(long id, Task tache) {
        return taskRepository.findById(id)
        .map(p-> {
            p.setTitle(update.getTitle());
            p.setDescription(update.getDescription());
            p.setStatus(update.getStatus());
            p.setDueDate(update.setDueDate());
            Task save = taskRepository.save(p);
            return Optional.ok(save);
        });
    }
    
    @Override
    public String delete(long id) {
        taskRepository.deleteById(id);
        return "tache supprime";
    }
    
}

