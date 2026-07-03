package SIS_414.ExamenFinal.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reportes")
@Data
public class ReporteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mes;
    private Double ingresos;
    private Double gastos;
    private String tipo;
}