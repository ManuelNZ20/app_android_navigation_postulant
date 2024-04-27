package com.example.myapplication.domain.entities;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String lastName;
    private int age;
    private GradeInstructor gradeInstructor;
    private boolean experience;

    public Person(String name, String lastName, int age, GradeInstructor gradeInstructor, boolean experience) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gradeInstructor = gradeInstructor;
        this.experience = experience;
    }

    public Person() {
        this(null, null, 0, null, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return this.getName() + "-" + this.getLastName() + "-" + this.getAge() + "-" + this.getGradeInstructor() + "-" + this.isExperience();
    }
}
