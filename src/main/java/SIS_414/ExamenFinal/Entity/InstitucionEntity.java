package SIS_414.ExamenFinal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class InstitucionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String institucion;

    private String referencias;

    public InstitucionEntity() {
    }

    public InstitucionEntity(Integer id, String institucion, String referencias) {
        this.id = id;
        this.institucion = institucion;
        this.referencias = referencias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
}