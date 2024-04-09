package com.felipebrum;

public class App 
{
    public static void main( String[] args )
    {
        ChocolateFactory chocolateFactory = ChocolateFactory.getInstance();
        System.out.println("Instance reference: " + chocolateFactory);
        System.out.println("Static method reference: " + ChocolateFactory.getInstance());
    }
}
