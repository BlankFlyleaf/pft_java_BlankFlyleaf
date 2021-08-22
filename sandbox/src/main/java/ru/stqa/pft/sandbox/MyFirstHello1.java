package ru.stqa.pft.sandbox;

public class MyFirstHello1 {
  public static void main(String[] args) {
    hello("Dio");
    hello("Alexey");
    hello("Aleksandr");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String name) {
    System.out.println("You think it will be Hello, world, but no! It's me! " + name + " da!");
  }

}
