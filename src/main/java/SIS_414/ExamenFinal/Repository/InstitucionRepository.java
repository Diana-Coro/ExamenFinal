package SIS_414.ExamenFinal.Repository;

import SIS_414.ExamenFinal.Entity.InstitucionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionRepository extends JpaRepository<InstitucionEntity, Integer> {

}