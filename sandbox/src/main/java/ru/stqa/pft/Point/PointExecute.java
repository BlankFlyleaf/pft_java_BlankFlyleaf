package ru.stqa.pft.Point;

public class PointExecute {
  public static void main(String[] args) {

    Point p1 = new Point();
    p1.x = 2;
    p1.y = 3;
    Point p2 = new Point();
    p2.x = 4;
    p2.y = 5;
    System.out.println("Дистанция между точкой Х с координатами Х1=" + p1.x + ", Y1=" + p1.y + " и точкой Y с координатами Х2=" + p2.x + ", Y2=" + p2.y + " равна " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }
}