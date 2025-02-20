package ToDo.Taches.service;

import ToDo.Taches.model.Tache;
import ToDo.Taches.repository.TacheRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImplements implements TaskService {
    
    @Autowired
    private TacheRepository tacheRepository;

    public TaskServiceImplements(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public Tache create(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> Read() {
        return tacheRepository.findAll();
    }

    @Override
    public Optional<Tache> singleTache(long id) {
        return tacheRepository.findById(id);
    }

    @Override
    public Optional<Tache> update(long id, Tache tache) {
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