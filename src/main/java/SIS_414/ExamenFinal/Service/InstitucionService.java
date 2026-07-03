package SIS_414.ExamenFinal.Service;

import SIS_414.ExamenFinal.Entity.InstitucionEntity;
import SIS_414.ExamenFinal.Repository.InstitucionRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionService {

    private final InstitucionRepository repository;

    public InstitucionService(InstitucionRepository repository) {
        this.repository = repository;
    }

    public List<InstitucionEntity> listar() {
        return repository.findAll();
    }

    public Optional<InstitucionEntity> buscar(Integer id) {
        return repository.findById(id);
    }

    public InstitucionEntity guardar(InstitucionEntity institucion) {
        return repository.save(institucion);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}