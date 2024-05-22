package com.example.waste_recycle.pak;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecyclingProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String programName;
    private String description;

    public RecyclingProgram() {
    }

    public RecyclingProgram(Long id, String programName, String description) {
        this.id = id;
        this.programName = programName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
