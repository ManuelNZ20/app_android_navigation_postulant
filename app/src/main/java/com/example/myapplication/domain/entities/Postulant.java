package com.example.myapplication.domain.entities;

public class Postulant extends Person{
    private GradeInstructor gradeInstructor;
    private boolean experience;

    public Postulant(String name,String lastName,int age,GradeInstructor gradeInstructor,boolean experience) {
        super(name,lastName,age);
        this.gradeInstructor = gradeInstructor;
        this.experience = experience;
    }

    public Postulant()
    {
        this(null,null,0,null,false);
    }

    public GradeInstructor getGradeInstructor() {
        return gradeInstructor;
    }

    public void setGradeInstructor(GradeInstructor gradeInstructor) {
        this.gradeInstructor = gradeInstructor;
    }

    public boolean isExperience() {
        return experience;
    }

    public void setExperience(boolean experience) {
        this.experience = experience;
    }
}
