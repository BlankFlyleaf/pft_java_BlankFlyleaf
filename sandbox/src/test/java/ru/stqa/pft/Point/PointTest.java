package ru.stqa.pft.Point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistance() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(4, 5);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
  }
}
