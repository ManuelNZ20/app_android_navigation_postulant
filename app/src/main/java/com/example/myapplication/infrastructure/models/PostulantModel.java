package com.example.myapplication.infrastructure.models;

import com.example.myapplication.domain.entities.Postulant;

public class PostulantModel {
    private Postulant postulant;
    private int totalScore;

    public PostulantModel(Postulant postulant) {
        this(postulant, 0);
    }

    public PostulantModel(Postulant postulant, int totalScore) {
        this.postulant = postulant;
        this.totalScore = totalScore;
    }

    public String dataViewResults() {
        return String.valueOf("Nombre completo: " + postulant.getName()
                + "\nEdad: " + postulant.getAge()
                + "\nGrado de instrucción: " + postulant.getGradeInstructor()
                + "\nExperiencia: " + this.valueExperience());
    }

    public String dataViewTotalScore() {
        return String.valueOf("TOTAL: " + totalScorePostulant());
    }

    private String valueExperience() {
        return postulant.isExperience() ? "Con Experiencia" : "Sin Experiencia";
    }

    public int totalScorePostulant() {
        switch (postulant.getGradeInstructor()) {
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
        totalScore += (postulant.isExperience()) ? 1 : 0;
        return totalScore;

    }
}
