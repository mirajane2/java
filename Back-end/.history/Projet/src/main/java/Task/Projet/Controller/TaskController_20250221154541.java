package Task.Projet.Controller;

import org.springframework.web.bind.annotation.RestController;

import Task.Projet.Service.TaskService;
import Task.Projet.model.Task;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class TaskController {

    @Autowired
    private  TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/api/tasks")
    public Task create(@RequestBody Task tache) {
        return taskService.create(tache);
    }

    @GetMapping("/api/tasks")
    public List<Task> read() {
        return taskService.Read();
    }

    @GetMapping("/api/tasks/{id}")
    public Optional<Task> singleTache(int id) {
        return taskService.singleTache(id);
    }

    @PutMapping("/api/tasks/{id}")
    public Optional<Task> update(@PathVariable int id, @RequestBody Task tache ) {
        return taskService.update(id, tache);
    }

    @DeleteMapping("/api/tasks/{id}")
    public String delete(@PathVariable int id) {
        return taskService.delete(id);
    }
}

