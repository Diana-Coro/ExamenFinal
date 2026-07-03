package SIS_414.ExamenFinal.Service;

import SIS_414.ExamenFinal.Entity.ReporteEntity;
import SIS_414.ExamenFinal.Repository.ReporteRepository;
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

    public ReporteEntity buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));
    }

    public ReporteEntity guardar(ReporteEntity r) {
        return repo.save(r);
    }

    public ReporteEntity actualizar(Long id, ReporteEntity r) {
        ReporteEntity reporteExistente = buscarPorId(id);

        reporteExistente.setMes(r.getMes());
        reporteExistente.setIngresos(r.getIngresos());
        reporteExistente.setGastos(r.getGastos());
        reporteExistente.setTipo(r.getTipo());

        return repo.save(reporteExistente);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}