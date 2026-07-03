package SIS_414.ExamenFinal.Service;
import SIS_414.ExamenFinal.Entity.pacientesEntity;
import SIS_414.ExamenFinal.Repository.pacientesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class pacientesService {
    private final pacientesRepository repository;

    public pacientesService(pacientesRepository repository) {
        this.repository = repository;
    }

    public List<pacientesEntity> listar() {
        return repository.findAll();
    }

    public Optional<pacientesEntity> buscar(Integer id) {
        return repository.findById(id);
    }

    public pacientesEntity guardar(pacientesEntity paciente) {
        return repository.save(paciente);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

