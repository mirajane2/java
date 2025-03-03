package Task.Projet.Service;


public class TaskServieImpl {
    
    
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
}
