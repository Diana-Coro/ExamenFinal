package SIS_414.ExamenFinal.Repository;

import SIS_414.ExamenFinal.Entity.AfiliadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoRepository extends JpaRepository<AfiliadoEntity, Integer> {

}