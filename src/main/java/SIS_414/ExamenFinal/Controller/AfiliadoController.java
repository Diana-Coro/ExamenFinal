package SIS_414.ExamenFinal.Controller;

import SIS_414.ExamenFinal.Entity.AfiliadoEntity;
import SIS_414.ExamenFinal.Service.AfiliadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/afiliado")
@Tag(name = "Afiliado API", description = "CRUD de la tabla Afiliado")
public class AfiliadoController {

    private final AfiliadoService service;

    public AfiliadoController(AfiliadoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar afiliados")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de afiliados",
            content = @Content(
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo",
                                    value = """
                                    [
                                      {
                                        "id": 1,
                                        "tipoAfiliado": "Regular",
                                        "nombre": "Juan Perez",
                                        "fechaHora": "2026-07-03T12:00:00"
                                      },
                                      {
                                        "id": 2,
                                        "tipoAfiliado": "Premium",
                                        "nombre": "Maria Gomez",
                                        "fechaHora": "2026-07-03T12:30:00"
                                      }
                                    ]
                                    """
                            )
                    }
            )
    )
    @GetMapping
    public List<AfiliadoEntity> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar afiliado por ID")
    @GetMapping("/{id}")
    public Optional<AfiliadoEntity> buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(summary = "Insertar afiliado")
    @PostMapping
    public AfiliadoEntity guardar(@RequestBody AfiliadoEntity afiliado) {
        // Si quieres que la fecha y hora se asigne automáticamente al crear, descomenta la siguiente línea:
        // afiliado.setFechaHora(LocalDateTime.now());
        return service.guardar(afiliado);
    }

    @Operation(summary = "Actualizar afiliado")
    @PutMapping("/{id}")
    public AfiliadoEntity actualizar(@PathVariable Integer id,
                                     @RequestBody AfiliadoEntity nuevo) {

        AfiliadoEntity afiliado = service.buscar(id).orElse(null);

        if (afiliado != null) {
            afiliado.setTipoAfiliado(nuevo.getTipoAfiliado());
            afiliado.setNombre(nuevo.getNombre());
            afiliado.setFechaHora(nuevo.getFechaHora());

            return service.guardar(afiliado);
        }

        return null;
    }

    @Operation(summary = "Eliminar afiliado")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "Afiliado eliminado";
    }
}