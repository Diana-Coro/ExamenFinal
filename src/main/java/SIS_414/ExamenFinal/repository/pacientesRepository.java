package SIS_414.ExamenFinal.repository;
import SIS_414.ExamenFinal.entity.pacientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface pacientesRepository extends JpaRepository<pacientesEntity ,Integer> {
}
