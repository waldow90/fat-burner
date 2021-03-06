package edu.stts.fatburner.data.model;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String name;
    private String password;
    private int goal;
    private boolean gender;
    private double weight;
    private double height;
    private double bloodsugar;
    private double cholesterol;
    private double calorie;
    private String tipe;

    public User(){

    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBloodsugar() {
        return bloodsugar;
    }

    public void setBloodsugar(double bloodsugar) {
        this.bloodsugar = bloodsugar;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getCalorie() { return calorie; }

    public void setCalorie(double calorie) { this.calorie = calorie; }
}
