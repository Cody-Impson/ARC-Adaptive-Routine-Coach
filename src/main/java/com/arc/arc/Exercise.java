package com.arc.arc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Exercise {

    @Id
    public String id;

    public String name;
    public String bodyRegion;
    public String modality;
    public String primaryEquipment;
    public String trackingType;
    public String difficulty;
    public String movementPattern;
    public String mechanic;
    public String laterality;
    public boolean recommendedForRoutines;
}
