package app.web_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebPage {

  public By findByXPath(String xpath){
    return By.xpath(xpath);
  }

  public By findByName(String name){
    return By.name(name);
  }

  public By findById(String id){
    return By.id(id);
  }

  public By findByText(String text) {return By.xpath(
      String.format("//*[text() = '%s']", text)
  );
  }

}
