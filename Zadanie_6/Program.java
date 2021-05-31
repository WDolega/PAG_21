package com.lineCalculator;

public class Program {
    public static void main(String[] args) {
        String[] s = new String[3];
        s[0] = ".txt";
        s[1] = ".py";
        s[2] = ".m";
        LineCalculator ln = new LineCalculator(s);
        ln.setExtentions(".txt");
        for (String e : ln.getExtentions())
            System.out.println(e);
    }
}
