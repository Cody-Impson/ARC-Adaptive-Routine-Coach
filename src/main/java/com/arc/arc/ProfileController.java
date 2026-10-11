package com.arc.arc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final UserProfileRepository repository;
    public ProfileController(UserProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/profile")
    public String saveProfile(@RequestBody UserProfile profile) {

        repository.save(profile);

        System.out.println("Saved profile:");
        System.out.println("Name: " + profile.name);
        System.out.println("Email: " + profile.email);
        System.out.println("Age: " + profile.age);
        System.out.println("Gender: " + profile.gender);
        System.out.println("Height: " + profile.feet + " ft " + profile.inches + " in ");
        System.out.println("Weight: " + profile.weight);
        System.out.println("Goal: " + profile.goal);

        return "Success";
    }
}
