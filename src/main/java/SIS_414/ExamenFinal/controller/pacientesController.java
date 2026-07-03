package SIS_414.ExamenFinal.controller;

import SIS_414.ExamenFinal.services.pacientesService;
import SIS_414.ExamenFinal.entity.pacientesEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/pacientes")
@Tag(name = "Pacientes API", description = "CRUD de la tabla Pacientes")
public class pacientesController {
    private final pacientesService service;

    public pacientesController(pacientesService service) {
        this.service = service;
    }

    @Operation(summary = "Listar pacientes")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de pacientes",
            content = @Content(
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo 1",
                                    value = """
                                [
                                   {
                                      "ci": 1234567,
                                      "nombre": "Juan Pérez",
                                      "fechaNacimiento": "1990-05-15",
                                      "diagnostico": "Estable",
                                      "numeroReferencia": "REF-001"
                                   },
                                   {
                                      "ci": 7654321,
                                      "nombre": "María López",
                                      "fechaNacimiento": "1985-11-23",
                                      "diagnostico": "Observación",
                                      "numeroReferencia": "REF-002"
                                   }
                                ]
                                """
                            )
                    }
            )
    )
    @GetMapping
    public List<pacientesEntity> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar paciente por ID")
    @GetMapping("/{id}")
    public Optional<pacientesEntity> buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(summary = "Insertar paciente")
    @PostMapping
    public pacientesEntity guardar(@RequestBody pacientesEntity paciente) {
        return service.guardar(paciente);
    }

    @Operation(summary = "Actualizar paciente")
    @PutMapping("/{id}")
    public pacientesEntity actualizar(@PathVariable Integer id, @RequestBody pacientesEntity nuevo) {

        pacientesEntity paciente = service.buscar(id).orElse(null);

        if (paciente != null) {
            paciente.setNombre(nuevo.getNombre());
            paciente.setFechaNacimiento(nuevo.getFechaNacimiento());
            paciente.setDiagnostico(nuevo.getDiagnostico());
            paciente.setNumeroReferencia(nuevo.getNumeroReferencia());

            return service.guardar(paciente);
        }

        return null;
    }

    @Operation(summary = "Eliminar paciente")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return "Paciente eliminado";
    }
}
