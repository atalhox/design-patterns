package com.felipebrum;

public class ChocolateFactory {
    private static ChocolateFactory instance; // The one and only factory

    private ChocolateFactory() {} // Private constructor, no one else can build a factory

    public static ChocolateFactory getInstance() { // The special room to get chocolate
        if (instance == null) { // If the factory doesn't exist yet,
            instance = new ChocolateFactory(); // build it.
        }
        return instance; // Return the one and only factory.
    }
}