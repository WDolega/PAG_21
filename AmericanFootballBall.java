package com.example.ball;

import java.util.Objects;

public class AmericanFootballBall extends Ball {

    private static final String SPORT = "American Football";//sport is constant
    private double longRadius;                              //american f. ball is egg shaped, it's value of longer radius

    /**
     *
     * @param material
     * @param brand
     * @param size
     * @param weight
     * @param suggPrice
     * @param radius
     * @param longRadius
     */
    public AmericanFootballBall(String material, String brand, int size, int weight, double suggPrice, double radius, double longRadius) {
        super(material, SPORT, brand, size, weight, suggPrice, radius);
                                                            //variables inherited from Ball, where RADIUS is in fact SHORTER RADIUS
        this.longRadius = longRadius;
    }

    /**
     *
     * @return
     */
    public double getShortRadius() {
        return getRadius();                                 //shorter radius getter
    }

    /**
     *
     * @return
     */
    public double getLongRadius() {
        return longRadius;                                  //longer radius getter
    }

    /**
     *
     * @param shortRadius
     */
    public void setShortRadius(double shortRadius) {
        this.radius = shortRadius;                          //shorter radius setter
    }

    /**
     *
     * @param longRadius
     */
    public void setLongRadius(double longRadius) {
        this.longRadius = longRadius;                       //longer radius setter
    }

    /**
     *
     * @return
     */
    @Override
    public String getSport() {
        return SPORT;                                       //overriden sport getter
    }

    /**
     *
     * @param sport
     */
    @Override
    public void setSport(String sport) {
        if (!sport.equals(getSport())) { System.out.println("You cannot change sport attribute of this ball to " + sport + "!"); }
                                                            //sport is constant, user gets informed about that
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() +
                " material=" + getMaterial() +
                ", sport=" + getSport() +
                ", brand=" + getBrand() +
                ", size=" + getSize() +
                ", weight[g]=" + getWeight() +
                ", suggested price[zł]= " + getSuggPrice() +
                ", short radius[cm]=" + getShortRadius() +
                ", long radius[cm] =" + getLongRadius() +
                ']';                                        //print all of the objects attributes
    }

    @Override
    public void getInfo() {
        System.out.println(getSport() + " uses balls made of a " + this.getMaterial().toLowerCase());
                                                            //brief info about objects purpose
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmericanFootballBall)) return false;
        AmericanFootballBall ball = (AmericanFootballBall) o;
        return Double.compare(ball.getSuggPrice(), getSuggPrice()) == 0 && Double.compare(ball.getShortRadius(), getShortRadius()) == 0 && Double.compare(ball.getLongRadius(), getLongRadius()) == 0 && Objects.equals(getMaterial(), ball.getMaterial()) && Objects.equals(getSport(), ball.getSport()) && Objects.equals(getBrand(), ball.getBrand());
                                                            //objects comparison
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getSport(), getBrand(), getSuggPrice(), getShortRadius(), getLongRadius());

    }
}


