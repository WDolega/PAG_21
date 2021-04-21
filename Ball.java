//authors: Wojciech Dołęga, Adam Ziętek;

package com.example.ball;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ball {
    protected String material;
    private String sport;
    protected String brand;
    protected int size; // e.g. 3,4,5 for football
    private int weight;
    protected double suggPrice;
    protected double radius;
    private Map<String, Integer> standardBall = new HashMap<>();


    public Ball(String material, String sport, String brand, int size, int weight, double suggPrice, double radius) {
        this.material = material;
        this.sport = sport;
        this.brand = brand;
        this.size = size;
        this.weight = weight;
        this.suggPrice = suggPrice;
        this.radius = radius;
        standardBall.put("Football", 5);
        standardBall.put("Volleyball", 5);
        standardBall.put("Basketball", 7);
        standardBall.put("Handball", 3);
        standardBall.put("American Football", 9);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSuggPrice(double suggPrice) {
        this.suggPrice = suggPrice;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getMaterial() {
        return material;
    }

    public String getSport() {
        return sport;
    }

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public double getSuggPrice() {
        return suggPrice;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() +
                " material=" + getMaterial() +
                ", sport=" + getSport() +
                ", brand=" + getBrand() +
                ", size=" + getSize() +
                ", weight[g]=" + getWeight() +
                ", suggested price[zł]= " + getSuggPrice() +
                ", radius[cm]=" + getRadius() +
                ']';
    }

    public void getInfo(String sport, String material) {
        System.out.println(this.getSport() + " uses " + getClass().getSimpleName().toLowerCase() + "s made of a "
                + this.getMaterial().toLowerCase());
    }

    public boolean isStandard(){
        if (standardBall.containsKey(sport)){
            return size == standardBall.get(sport);
            }
        else
        return false;
    }

    public void checkStandard(){
        if (standardBall.containsKey(sport)){
            if (size == standardBall.get(sport)){
                System.out.println("The ball is standard");
            }
            else { System.out.println("The ball is non-standard");
            }
        }
        else { System.out.println("No record of the sport"); }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return getSize() == ball.getSize() && getWeight() == ball.getWeight() && Double.compare(ball.getSuggPrice(), getSuggPrice()) == 0 && Double.compare(ball.getRadius(), getRadius()) == 0 && Objects.equals(getMaterial(), ball.getMaterial()) && Objects.equals(getSport(), ball.getSport()) && Objects.equals(getBrand(), ball.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getSport(), getBrand(), getSize(), getWeight(), getSuggPrice(), getRadius());
    }
}
