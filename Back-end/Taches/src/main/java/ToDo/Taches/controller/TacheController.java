package ToDo.Taches.controller;

import org.springframework.web.bind.annotation.RestController;

import ToDo.Taches.model.Tache;
import ToDo.Taches.service.TaskService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class TacheController {

    private TaskService taskService;

    @PostMapping("/api/tasks")
    public Tache create(@RequestBody Tache tache) {
        return taskService.create(tache);
    }

    @GetMapping("/api/tasks")
    public List<Tache> read() {
        return taskService.Read();
    }

//     @GetMapping("/api/tasks/{id}")
//     public Optional<Tache> singleTache(int id) {
//         return taskService.singleTache(id);
//     }
}
    
