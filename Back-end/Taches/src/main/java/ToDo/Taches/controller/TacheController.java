package ToDo.Taches.controller;

import org.springframework.web.bind.annotation.RestController;

import ToDo.Taches.model.Tache;
import ToDo.Taches.service.TaskService;

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
public class TacheController {

    @Autowired
    private  TaskService taskService;


    public TacheController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/api/tasks")
    public Tache create(@RequestBody Tache tache) {
        return taskService.create(tache);
    }

    @GetMapping("/api/tasks")
    public List<Tache> read() {
        return taskService.Read();
    }

    @GetMapping("/api/tasks/{id}")
    public Optional<Tache> singleTache(int id) {
        return taskService.singleTache(id);
    }

    @PutMapping("/api/tasks/{id}")
    public Optional<Tache> update(@PathVariable int id, @RequestBody Tache tache ) {
        return taskService.update(id, tache);
    }

    @DeleteMapping("/pai/tasks/{id}")
    public String delete(@PathVariable int id) {
        return taskService.delete(id);
    }
}
    
