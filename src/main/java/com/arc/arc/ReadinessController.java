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
        if ("Yes".equalsIgnoreCase(readiness.pain) || readiness.soreness >=8) {
            recommendation = "Recover focused workout recommended with reduced intensity.";
        } else if (readiness.sleep <= 4 || readiness.energy <= 4 || readiness.stress >= 8) {
            recommendation = "Light workout recommended with reduced intensity.";
        } else {
            recommendation = "Normal workout recommended with normal intensity.";
        }

        System.out.println("Orin Recommendation: " + recommendation);

        return recommendation;
    }
}
