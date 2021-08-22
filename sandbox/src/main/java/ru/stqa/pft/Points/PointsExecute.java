package ru.stqa.pft.Points;

public class PointsExecute {

  public static void main(String[] args) {
    Points p = new Points(2.0, 3.0, 4.0, 5.0);
    System.out.println("Дистанция между точкой Х с координатами Х1 = " + p.x1 + ", Y1 = " + p.y1 + " и точкой Y с координатами Х2 = " + p.x2 + ", Y2 =  " + p.y2 + " = " + p.distance());
  }

}