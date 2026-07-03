package SIS_414.ExamenFinal.Controller;

import SIS_414.ExamenFinal.Entity.ReporteEntity;
import SIS_414.ExamenFinal.Service.ReporteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin("*")
public class ReporteController {

    private final ReporteService service;

    public ReporteController(ReporteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReporteEntity> listar() {
        return service.listar();
    }

    @PostMapping
    public ReporteEntity guardar(@RequestBody ReporteEntity r) {
        return service.guardar(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}