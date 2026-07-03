package SIS_414.ExamenFinal.Controller;

import SIS_414.ExamenFinal.Entity.Doctor;
import SIS_414.ExamenFinal.Service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
@CrossOrigin(origins = "*")
@Tag(name = "Doctores API", description = "CRUD de la tabla Doctores")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    @Operation(
            summary = "Listar doctores",
            description = "Muestra todos los doctores registrados en el sistema"
    )
    public List<Doctor> listarDoctores() {
        return doctorService.listarDoctores();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar doctor por ID",
            description = "Busca un doctor específico usando su ID"
    )
    public Doctor buscarDoctorPorId(
            @Parameter(description = "ID del doctor que se desea buscar", example = "1")
            @PathVariable Long id
    ) {
        return doctorService.buscarDoctorPorId(id);
    }

    @PostMapping
    @Operation(
            summary = "Registrar doctor",
            description = "Guarda un nuevo doctor en la base de datos"
    )
    public Doctor guardarDoctor(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del doctor que se desea registrar",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Ejemplo 1 - Doctor general",
                                            value = """
                                                    {
                                                      "nombre": "Carlos Mamani",
                                                      "fechaIngreso": "2026-07-03",
                                                      "area": "Consulta externa",
                                                      "celular": "76543210",
                                                      "especialidad": "Medicina general"
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Ejemplo 2 - Doctor especialista",
                                            value = """
                                                    {
                                                      "nombre": "Ana Quispe",
                                                      "fechaIngreso": "2026-07-03",
                                                      "area": "Emergencias",
                                                      "celular": "71234567",
                                                      "especialidad": "Pediatria"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
            @RequestBody Doctor doctor
    ) {
        return doctorService.guardarDoctor(doctor);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar doctor",
            description = "Actualiza los datos de un doctor existente mediante su ID"
    )
    public Doctor actualizarDoctor(
            @Parameter(description = "ID del doctor que se desea actualizar", example = "1")
            @PathVariable Long id,

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Nuevos datos del doctor",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Ejemplo 1 - Cambiar area",
                                            value = """
                                                    {
                                                      "nombre": "Carlos Mamani",
                                                      "fechaIngreso": "2026-07-03",
                                                      "area": "Hospitalizacion",
                                                      "celular": "76543210",
                                                      "especialidad": "Medicina general"
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Ejemplo 2 - Cambiar especialidad",
                                            value = """
                                                    {
                                                      "nombre": "Ana Quispe",
                                                      "fechaIngreso": "2026-07-03",
                                                      "area": "Emergencias",
                                                      "celular": "71234567",
                                                      "especialidad": "Cardiologia"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
            @RequestBody Doctor doctor
    ) {
        return doctorService.actualizarDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar doctor",
            description = "Elimina un doctor registrado usando su ID"
    )
    public void eliminarDoctor(
            @Parameter(description = "ID del doctor que se desea eliminar", example = "1")
            @PathVariable Long id
    ) {
        doctorService.eliminarDoctor(id);
    }
}