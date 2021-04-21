//authors: Wojciech Dołęga, Adam Ziętek;

package com.example.ball;

public class Main {
    public static void main(String[] args) {
        Ball ball1 = new Ball("Plastic", "Football", "Adidas", 6, 290, 100, 11);
        Ball ball2 = new Ball("Rubber", "Basketball", "Spalding", 7, 570, 150, 11.5);
        Ball ball3 = new Ball("Plastic", "Volleyball", "Mikasa", 5, 270, 90, 10);
        System.out.println(ball1);
        ball1.getInfo();
        System.out.println(ball1.isStandard());
        ball1.checkStandard();
        ball1.setSize(5);
        System.out.println(ball1.isStandard());
        ball1.checkStandard();
        ball1.setSport("Volleyball");
        ball1.setBrand("Mikasa");
        ball1.setWeight(270);
        ball1.setDiscount(10); // value in percent
        ball1.setRadius(10);
        System.out.println(ball1);
        System.out.println(ball3);
        System.out.println(ball1.equals(ball2));
        System.out.println(ball1.equals(ball3));
        ball2.setMaterial("Leather");
        ball2.setSuggPrice(140);
        System.out.println(ball2);
    }
}
