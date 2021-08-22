package ru.stqa.pft.Points;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTest {

  @Test
  public void testDistance() {
    Points p = new Points(2.0, 3.0, 4.0, 5.0);
    Assert.assertEquals(p.distance(), 2.8284271247461903);
  }
}
