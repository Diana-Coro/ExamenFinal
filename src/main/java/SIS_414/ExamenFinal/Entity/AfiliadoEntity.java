package SIS_414.ExamenFinal.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "afiliado")
public class AfiliadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_afiliado")
    private String tipoAfiliado;

    private String nombre;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    public AfiliadoEntity() {
    }

    public AfiliadoEntity(Integer id, String tipoAfiliado, String nombre, LocalDateTime fechaHora) {
        this.id = id;
        this.tipoAfiliado = tipoAfiliado;
        this.nombre = nombre;
        this.fechaHora = fechaHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}