//authors: Wojciech Dołęga, Adam Ziętek;

package com.example.ball;

public class Main {
    public static void main(String[] args) {
        Ball ball1 = new Ball("Plastic", "Football", "Adidas", 6, 290, 100, 23);
        Ball ball2 = new Ball("Rubber", "Basketball", "Spalding", 7, 570, 150, 11.5);
        System.out.println(ball1);
        ball1.getInfo(ball1.getSport(),ball1.getMaterial());
        System.out.println(ball1.isStandard());
        ball1.checkStandard();
        ball1.setSize(5);
        System.out.println(ball1.isStandard());
        ball1.checkStandard();
        System.out.println(ball1.equals(ball2));

    }
}
