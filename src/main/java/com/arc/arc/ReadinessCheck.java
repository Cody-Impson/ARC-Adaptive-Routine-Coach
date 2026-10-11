package com.arc.arc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReadinessCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public int sleep;
    public int energy;
    public int soreness;
    public int stress;
    public int motivation;
    public String pain;
    public String painDetails;
    public String orinNotes;
}
