package ru.stqa.pft.Point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistance() {
    Point p1 = new Point(2, 5);
    Point p2 = new Point(4, 5);
    Assert.assertEquals(p1.distance(p2), 2.0);
  }

  @Test
  public void testIsY_Same() {
    Point p1 = new Point(2, 5);
    Point p2 = new Point(4, 5);
    Assert.assertSame(p1.y, p2.y);
  }

  @Test
  public void testIsX_Same() {
    Point p1 = new Point(2, 5);
    Point p2 = new Point(4, 5);
    Assert.assertSame(p1.x, p2.x);
  }
}
