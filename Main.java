//authors: Wojciech Dołęga, Adam Ziętek;

package com.example.ball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ball ball1 = new Ball("Plastic", "Football", "Adidas", 6, 290, 100, 11);
        Ball ball2 = new Ball("Rubber", "Basketball", "Spalding", 7, 570, 150, 11.5);
        Ball ball3 = new Ball("Plastic", "Volleyball", "Mikasa", 5, 270, 90, 10);
        AmericanFootballBall ball4 = new AmericanFootballBall("Leather", "Nike", 9, 310, 200, 5, 7);
        AmericanFootballBall ball5 = new AmericanFootballBall("Exotic Leather", "Nike", 9, 310, 200, 6, 8);
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

        ball4.setMaterial("Rubber");
        if (ball4.isStandard()) { ball4.setMaterial("Exotic Leather");}
        ball4.setShortRadius(6);
        ball4.setLongRadius(8);
        ball4.checkStandard();
        ball4.getInfo();
        System.out.println("ball4 material is: " + ball4.getMaterial());
        // Scanner scanner = new Scanner(System.in);
        System.out.println("ball4 sport: ");
        // ball4.setSport(scanner.nextLine());
        System.out.println("ball4 sport is: " + ball4.getSport());
        if(ball5.equals(ball4)){
            System.out.println("ball5 is the same as ball4");
        }
        else{
            System.out.println("ball4 and ball5 differs");
        }
    }
}
