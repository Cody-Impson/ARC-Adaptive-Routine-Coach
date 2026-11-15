package com.arc.arc;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ExerciseDataLoader implements CommandLineRunner {

    private final ExerciseRepository exerciseRepository;

    public ExerciseDataLoader(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Prevent duplicate loading if data already exists
        if (exerciseRepository.count() > 0) {
            System.out.println("Exercise database already loaded.");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();

        ClassPathResource resource =
                new ClassPathResource("openexercisedb.json");

        try (InputStream inputStream = resource.getInputStream()) {

            JsonNode root = mapper.readTree(inputStream);
            JsonNode records = root.get("records");

            if (records == null || !records.isArray()) {
                System.out.println("No exercise records found.");
                return;
            }

            int loaded = 0;

            for (JsonNode record : records) {

                // Only import exercises recommended for new routines
                if (!record.path("recommended_for_routines").asBoolean(false)) {
                    continue;
                }

                Exercise exercise = new Exercise();

                exercise.id = record.path("id").asText();
                exercise.name = record.path("name").asText();

                exercise.bodyRegion =
                        getNullableText(record, "body_region");

                exercise.modality =
                        getNullableText(record, "modality");

                exercise.trackingType =
                        getNullableText(record, "tracking_type");

                exercise.difficulty =
                        getNullableText(record, "difficulty");

                exercise.movementPattern =
                        getNullableText(record, "movement_pattern");

                exercise.mechanic =
                        getNullableText(record, "mechanic");

                exercise.laterality =
                        getNullableText(record, "laterality");

                exercise.recommendedForRoutines =
                        record.path("recommended_for_routines")
                                .asBoolean(false);

                // Find primary equipment
                JsonNode equipment = record.get("equipment");

                if (equipment != null && equipment.isArray()) {
                    for (JsonNode item : equipment) {

                        if ("primary".equalsIgnoreCase(
                                item.path("kind").asText())) {

                            exercise.primaryEquipment =
                                    item.path("id").asText();

                            break;
                        }
                    }
                }

                exerciseRepository.save(exercise);
                loaded++;
            }

            System.out.println(
                    "OpenExerciseDB exercises loaded: " + loaded
            );
        }
    }

    private String getNullableText(JsonNode node, String field) {

        JsonNode value = node.get(field);

        if (value == null || value.isNull()) {
            return null;
        }

        return value.asText();
    }
}
