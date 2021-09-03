package ru.stqa.pft.addressbook_homework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook_homework.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    app.end();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
