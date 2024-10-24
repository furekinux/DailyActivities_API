package com.example.DailyActivities.repository;

import com.example.DailyActivities.model.Activdades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivdadesRepository extends JpaRepository<Activdades,Long> {
    @Query(value = "CALL findActivitiesByUser(:id_usuario)", nativeQuery = true)
    List<Activdades> findByUsuario(@Param("id_usuario") Long usuario_fk);
}
