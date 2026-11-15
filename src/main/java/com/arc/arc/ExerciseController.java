package com.arc.arc;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Exercise> getExerciseById(@PathVariable String id) {
        return exerciseRepository.findById(id);
    }

    @GetMapping("/body-region/{bodyRegion}")
    public List<Exercise> getByBodyRegion(@PathVariable String bodyRegion) {
        return exerciseRepository.findByBodyRegionIgnoreCase(bodyRegion);
    }

    @GetMapping("/equipment/{equipment}")
    public List<Exercise> getByEquipment(@PathVariable String equipment) {
        return exerciseRepository.findByPrimaryEquipmentIgnoreCase(equipment);
    }

    @GetMapping("/modality/{modality}")
    public List<Exercise> getByModality(@PathVariable String modality) {
        return exerciseRepository.findByModalityIgnoreCase(modality);
    }

    @GetMapping("/search")
    public List<Exercise> searchByName(@RequestParam String name) {
        return exerciseRepository.findByNameContainingIgnoreCase(name);
    }
}
