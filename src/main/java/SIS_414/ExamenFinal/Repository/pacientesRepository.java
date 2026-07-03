package SIS_414.ExamenFinal.Repository;
import SIS_414.ExamenFinal.Entity.pacientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface pacientesRepository extends JpaRepository<pacientesEntity ,Integer> {
}
