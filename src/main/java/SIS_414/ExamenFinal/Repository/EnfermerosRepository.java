package SIS_414.ExamenFinal.Repository;

import SIS_414.ExamenFinal.Entity.EnfermerosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermerosRepository extends JpaRepository<EnfermerosEntity, Integer> {
}
