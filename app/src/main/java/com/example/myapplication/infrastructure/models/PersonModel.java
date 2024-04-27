package com.example.myapplication.infrastructure.models;

import com.example.myapplication.domain.entities.GradeInstructor;
import com.example.myapplication.domain.entities.Person;

public class PersonModel {
    private Person person;
    private int scoreGradeIsntructor;
    private int experience;
    private int totalScore;

    public PersonModel(Person person) {
        this(person, 0, 0, 0);
    }

    public PersonModel(Person person, int scoreGradeIsntructor, int experience, int totalScore) {
        this.person = person;
        this.scoreGradeIsntructor = scoreGradeIsntructor;
        this.experience = experience;
        this.totalScore = totalScore;
    }

    public String dataViewResults() {
        return String.valueOf("Nombre completo: " + person.getName()
                + "\nEdad: " + person.getAge()
                + "\nGrado de instrucción: " + person.getGradeInstructor()
                + "\nExperiencia: " + this.valueExperience());
    }

    public String dataViewTotalScore() {
        return String.valueOf("TOTAL: "+totalScorePostulant());
    }
    private String valueExperience() {
        return person.isExperience() ? "Con Experiencia" : "Sin Experiencia";
    }

    public int totalScorePostulant() {
        switch (person.getGradeInstructor()) {
            case INICIAL:
                totalScore += 0;
                break;
            case PRIMARIA:
                totalScore += 1;
                break;
            case SECUNDARIA:
                totalScore += 2;
                break;
            case SUPERIOR:
                totalScore += 3;
                break;
        }
        //  determinar la experiencia
        totalScore += (person.isExperience()) ? 1 : 0;
        return totalScore;

    }
}
