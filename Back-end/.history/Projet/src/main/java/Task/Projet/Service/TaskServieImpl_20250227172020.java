package Task.Projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        .map(existingTask -> {
            if (tache.getTitle() != null) existingTask.setTitle(tache.getTitle());
            if (tache.getDescription() != null) existingTask.setDescription(tache.getDescription());
            existingTask.setStatus(tache.getStatus()); 
            if (tache.getDueDate() != null) existingTask.setDueDate(tache.getDueDate());
            return taskRepository.save(existingTask);
        });
    }
    
    @Override
    public String delete(long id) {
        taskRepository.deleteById(id);
        return "tache supprimé";
    }
    
}

