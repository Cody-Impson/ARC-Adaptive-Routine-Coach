package com.arc.arc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository
        extends JpaRepository<Exercise, String> {

    List<Exercise> findByBodyRegionIgnoreCase(String bodyRegion);

    List<Exercise> findByPrimaryEquipmentIgnoreCase(String primaryEquipment);

    List<Exercise> findByModalityIgnoreCase(String modality);

    List<Exercise> findByNameContainingIgnoreCase(String name);
}
