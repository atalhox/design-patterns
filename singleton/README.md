# Singleton

This project serves as a practical demonstration of the Singleton design pattern. 

The Singleton pattern is a design approach that restricts the instantiation of a class to one single instance. 

Sometimes, in your software, you really need to make sure there's only one instance of a class. 

This could be because having more than one instance could cause problems (like conflicting configurations) or just be unnecessary (like a central database manager).

[Refactor Guru Reference](https://refactoring.guru/pt-br/design-patterns/singleton)

## Table of Contents
- Introduction
- Table of Contents
- Analogy
- Pros
- Cons
- How to implement

The Singleton pattern ensures that a class has only one instance and provides a global point of access to it. This repository contains a simple example of how to implement and use a Singleton class in Java.

## The Chocolate Factory Analogy

### The Factory

Think of your Singleton class as the chocolate factory. You want only one factory producing chocolate to ensure quality and consistency.

### No Public Construction 

The factory's constructor is private. This means no one outside can just decide to build another chocolate factory. 

In programming, making the constructor private prevents other parts of the code from creating a new instance of the class.

### The Only Factory

Inside the chocolate factory, there's a sign that says, "The One and Only Chocolate Factory". 

The factory has a special room (a static method in your class) where if someone wants to get chocolate, they have to go there. 

This room checks if the factory exists:
- If it does not exist, it builds the factory right there and then gives you the chocolate.
- If it already exists, it simply gives you the chocolate from the existing factory.

### Global Access

Anyone in the world can get chocolate from this factory by visiting the special room (calling the static method). 

They can't get chocolate from anywhere else because there's only one factory.

### No Duplication

What if someone tries to clone the factory? The real factory has special measures to prevent cloning, ensuring it remains the only factory.

## Pros

- Controlled access to the sole instance.
- Lazily initialized, created only when needed.
- Can be subclassed, and allows a finite number of instances.

## Cons

- Often considered an anti-pattern for overuse.
- Can lead to a more tightly coupled system.
- Violates the single responsibility principle. The pattern solves two problems at once: 
    - Grant only one instance of class.
    - Grants unique global access point to that instance. 
- The standard Singleton can mask bad design, for example when program components know too much about each other.
- The pattern requires special handling in a multithreaded environment so that multiple threads cannot create a singleton object multiple times.
- It can be difficult to unit test Singleton client code because many testing frameworks rely on inheritance when produced objects are mocked.
- Since the constructor of the singleton class is private and overriding static methods is impossible in most languages, you will have to think of a creative way to simulate the singleton. Or just don't send the tests. Or don't use the default Singleton.

## How to implement

Add a static private field in the class for storing the singleton instance.

```java
    private static Singleton instance;
```

Declare a public static creation method to obtain a singleton instance.

```java
    public static synchronized Singleton getInstance() {
        // Check if instance already exists
        if (instance == null) {
            // If not, create a new instance
            instance = new Singleton();
        }
        return instance;
    }
```

Implement a “lazy initialization” inside the static method. It should create a new object on its first call and place it in the static field `instance`. 

The method must always return that instance on all subsequent calls.

There are other initializations, like: 
- Eager.
- Lazy. 
- Double checked. 