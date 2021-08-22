package ru.stqa.pft.sandbox;

public class MyFirstHello1 {
  public static void main(String[] args) {
    hello("Dio");
    hello("Alexey");
    hello("Aleksandr");

    double l = 5;
    System.out.println ("Площадь квадрата со стороной " + l + " = " + area(l));

    double a = 5;
    double b = 6;
    System.out.println ("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
  }

  public static void hello(String name) {
    System.out.println("You think it will be Hello, world, but no! It's me! " + name + " da!");
  }

  public static double area (double l){
    return l * l;
  }

  public static double area (double a, double b){
    return a * b;
  }

}
