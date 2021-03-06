//authors: Wojciech Dołęga, Adam Ziętek;

package com.example.ball;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ball {
    private String material; // material of ball e.g. leather
    private String sport; // specify sport that uses this ball
    private String brand; // brand of the ball
    private int size; // e.g. 3,4,5 for football
    private int weight; // weight of the ball given in grams
    private double suggPrice; // suggested price of the ball in store given in PLN
    protected double radius; // radius of the ball given in centimetres - changed in inherited class
    private final Map<String, Integer> standardBall = new HashMap<>();

    /**
     *
     * @param material
     * @param sport
     * @param brand
     * @param size
     * @param weight
     * @param suggPrice
     * @param radius
     */
    public Ball(String material, String sport, String brand, int size, int weight, double suggPrice, double radius) { // builder
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

    /**
     *
     * @param material
     */
    public void setMaterial(String material) {
        this.material = material;
    } //shorter radius getter

    /**
     *
     * @param sport
     */
    public void setSport(String sport) {
        this.sport = sport;
    }  //shorter radius getter

    /**
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    } //shorter radius getter

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    } //shorter radius getter

    /**
     *
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    } //shorter radius getter
    /**
     *
     * @param suggPrice
     */
    public void setSuggPrice(double suggPrice) {
        this.suggPrice = suggPrice;
    } //shorter radius getter

    /**
     *
     * @param discount given in percent
     */
    public void setDiscount(double discount) { // value of discount is given in percent
        this.suggPrice *= (1 - discount/100);
    }

    /**
     *
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    } //shorter radius getter

    /**
     *
     * @return
     */
    public String getMaterial() {
        return material;
    } //shorter radius getter

    /**
     *
     * @return
     */
    public String getSport() {
        return sport;
    } //shorter radius getter

    /**
     *
     * @return
     */
    public String getBrand() {
        return brand;
    } //shorter radius getter

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    } //shorter radius getter

    /**
     *
     * @return
     */
    public int getWeight() {
        return weight;
    } //shorter radius getter

    /**
     *
     * @return
     */
    public double getSuggPrice() {
        return suggPrice;
    } //shorter radius getter

    /**
     *
     * @return
     */
    public double getRadius() {
        return radius;
    } //shorter radius getter

    /**
     *
     * @return
     */
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

    public void getInfo() {
        System.out.println(this.getSport() + " uses " + getClass().getSimpleName().toLowerCase() + "s made of a "
                + this.getMaterial().toLowerCase());
    } // function printing general information about ball

    /**
     *
     * @return
     */
    public boolean isStandard(){
        if (standardBall.containsKey(getSport())){
            return size == standardBall.get(getSport());
            }
        else
        return false;
    } // function comparing size of created ball to standard size * boolean version

    public void checkStandard(){
        if (standardBall.containsKey(getSport())){
            if (size == standardBall.get(getSport())){
                System.out.println("The ball is standard");
            }
            else { System.out.println("The ball is non-standard");
            }
        }
        else { System.out.println("No record of the sport"); }
    } // function comparing size of created ball to standard size * println version

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return getSize() == ball.getSize() && getWeight() == ball.getWeight() &&
                Double.compare(ball.getSuggPrice(), getSuggPrice()) == 0 &&
                Double.compare(ball.getRadius(), getRadius()) == 0 && Objects.equals(getMaterial(), ball.getMaterial())
                && Objects.equals(getSport(), ball.getSport()) && Objects.equals(getBrand(), ball.getBrand());
    } //objects comparison

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getSport(), getBrand(), getSize(), getWeight(), getSuggPrice(), getRadius());
    }
}
