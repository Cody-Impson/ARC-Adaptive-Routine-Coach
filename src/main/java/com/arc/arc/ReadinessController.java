package com.arc.arc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadinessController {

    private final ReadinessRepository repository;

    public ReadinessController(ReadinessRepository repository) {
        this.repository = repository; }

    @PostMapping("/readiness")
    public String saveReadiness(@RequestBody ReadinessCheck readiness) {

        if (readiness.sleep == null ||
                readiness.energy == null ||
                readiness.soreness == null ||
                readiness.stress == null ||
                readiness.motivation == null) {

            return "ERROR: All readiness fields are required.";
        }
        if (readiness.sleep < 1 || readiness.sleep > 10 ||
                readiness.energy < 1 || readiness.energy > 10 ||
                readiness.soreness < 1 || readiness.soreness > 10 ||
                readiness.stress < 1 || readiness.stress > 10 ||
                readiness.motivation < 1 || readiness.motivation > 10) {

            return "ERROR: Readiness values must be between 1 and 10.";
        }
        if ("Yes".equalsIgnoreCase(readiness.pain) &&
                (readiness.painDetails == null || readiness.painDetails.trim().isEmpty())) {

            return "ERROR: Please describe the pain or discomfort before continuing.";
        }
        if (readiness.orinNotes != null && readiness.orinNotes.length() > 1000) {
            return "ERROR: ORIN notes cannot exceed 1000 characters.";
        }
        repository.save(readiness);

        System.out.println("Saved Readiness");
        System.out.println("Sleep: " + readiness.sleep);
        System.out.println("Energy: " + readiness.energy);
        System.out.println("Soreness: " + readiness.soreness);
        System.out.println("Stress: " + readiness.stress);
        System.out.println("Motivation: " + readiness.motivation);
        System.out.println("Pain: " + readiness.pain);
        System.out.println("Pain Details: " + readiness.painDetails);
        System.out.println("ORIN Notes: " + readiness.orinNotes);

        String recommendation;

        if ("Yes".equalsIgnoreCase(readiness.pain) || readiness.soreness >= 8) {
            recommendation =
                    "Status: RECOVERY\n" +
                            "Intensity: 40%\n" +
                            "Recommendation: Recovery-focused workout recommended. " +
                            "Use lighter loads and avoid movements that increase discomfort.";
        }
        else if (readiness.sleep <= 4 || readiness.energy <= 4 || readiness.stress >= 8) {
            recommendation =
                    "Status: MODIFY\n" +
                            "Intensity: 70%\n" +
                            "Recommendation: Reduce workout intensity or volume and focus on recovery.";
        }
        else {
            recommendation =
                    "Status: READY\n" +
                            "Intensity: 100%\n" +
                            "Recommendation: Proceed with the planned workout at normal intensity.";
        }

        System.out.println("Orin Recommendation: " + recommendation);

        return recommendation;
    }
}
