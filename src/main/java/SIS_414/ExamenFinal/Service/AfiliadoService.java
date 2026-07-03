package SIS_414.ExamenFinal.Service;

import SIS_414.ExamenFinal.Entity.AfiliadoEntity;
import SIS_414.ExamenFinal.Repository.AfiliadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoService {

    private final AfiliadoRepository repository;

    public AfiliadoService(AfiliadoRepository repository) {
        this.repository = repository;
    }

    public List<AfiliadoEntity> listar() {
        return repository.findAll();
    }

    public Optional<AfiliadoEntity> buscar(Integer id) {
        return repository.findById(id);
    }

    public AfiliadoEntity guardar(AfiliadoEntity afiliado) {
        return repository.save(afiliado);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}