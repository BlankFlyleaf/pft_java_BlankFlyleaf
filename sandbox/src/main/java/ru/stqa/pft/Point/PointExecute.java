package ru.stqa.pft.Point;

public class PointExecute {
  public static void main(String[] args) {

    Point p1 = new Point(2, 3);
    Point p2 =new Point(4, 5);
    System.out.println("Функция: Дистанция между точкой Х с координатами Х1=" + p1.x + ", Y1=" + p1.y + " и точкой Y с координатами Х2=" + p2.x + ", Y2=" + p2.y + " равна " + distance(p1, p2));
    System.out.println("Метод: Дистанция между точкой Х с координатами Х1=" + p1.x + ", Y1=" + p1.y + " и точкой Y с координатами Х2=" + p2.x + ", Y2=" + p2.y + " равна " + p2.distance(p1));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }
}