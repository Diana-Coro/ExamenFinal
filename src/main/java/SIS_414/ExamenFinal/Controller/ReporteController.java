package SIS_414.ExamenFinal.Controller;

import SIS_414.ExamenFinal.Entity.ReporteEntity;
import SIS_414.ExamenFinal.Service.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
@Tag(name = "Reporte API", description = "CRUD de la tabla Reporte")
public class ReporteController {

    private final ReporteService service;

    public ReporteController(ReporteService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar reportes", description = "Muestra todos los reportes registrados")
    public List<ReporteEntity> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar reporte por ID", description = "Busca un reporte usando su ID")
    public ReporteEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Guardar reporte", description = "Registra un nuevo reporte")
    public ReporteEntity guardar(@RequestBody ReporteEntity r) {
        return service.guardar(r);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar reporte", description = "Actualiza los datos de un reporte existente")
    public ReporteEntity actualizar(@PathVariable Long id, @RequestBody ReporteEntity r) {
        return service.actualizar(id, r);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar reporte", description = "Elimina un reporte usando su ID")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}