package SIS_414.ExamenFinal.Controller;

import SIS_414.ExamenFinal.Entity.InstitucionEntity;
import SIS_414.ExamenFinal.Service.InstitucionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/institucion")
@Tag(name = "Institucion API", description = "CRUD de la tabla Institucion")
public class InstitucionController {

    private final InstitucionService service;

    public InstitucionController(InstitucionService service) {
        this.service = service;
    }

    @Operation(summary = "Listar instituciones")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de instituciones",
            content = @Content(
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo",
                                    value = """
                                    [
                                      {
                                        "id": 1,
                                        "institucion": "Caja Nacional de Salud",
                                        "referencias": "Sucursal Central"
                                      },
                                      {
                                        "id": 2,
                                        "institucion": "Hospital Obrero",
                                        "referencias": "Zona Sur"
                                      }
                                    ]
                                    """
                            )
                    }
            )
    )
    @GetMapping
    public List<InstitucionEntity> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar institución por ID")
    @GetMapping("/{id}")
    public Optional<InstitucionEntity> buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(summary = "Insertar institución")
    @PostMapping
    public InstitucionEntity guardar(@RequestBody InstitucionEntity institucion) {
        return service.guardar(institucion);
    }

    @Operation(summary = "Actualizar institución")
    @PutMapping("/{id}")
    public InstitucionEntity actualizar(@PathVariable Integer id,
                                        @RequestBody InstitucionEntity nuevo) {

        InstitucionEntity institucion = service.buscar(id).orElse(null);

        if (institucion != null) {
            institucion.setInstitucion(nuevo.getInstitucion());
            institucion.setReferencias(nuevo.getReferencias());

            return service.guardar(institucion);
        }

        return null;
    }

    @Operation(summary = "Eliminar institución")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "Institución eliminada";
    }
}