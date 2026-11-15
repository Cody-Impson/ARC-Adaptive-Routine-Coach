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

    public Integer sleep;
    public Integer energy;
    public Integer soreness;
    public Integer stress;
    public Integer motivation;
    public String pain;
    public String painDetails;
    public String orinNotes;
}
