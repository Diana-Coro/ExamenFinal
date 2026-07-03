package SIS_414.ExamenFinal;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository repo;

    public ReporteService(ReporteRepository repo) {
        this.repo = repo;
    }

    public List<ReporteEntity> listar() {
        return repo.findAll();
    }

    public ReporteEntity guardar(ReporteEntity r) {
        return repo.save(r);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}