package app.pages.yandex;

import app.web_pages.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Главная страница яндекса.
 * @author Ivan_Parshin-Borodin
 */
public class YandexMainPage extends WebPage {

  private WebDriver driver;

  public YandexMainPage(WebDriver driver) {
    this.driver = driver;
  }

  public YandexMainPage(WebDriver driver, String url) {
    this.driver = driver;
    this.driver.get(url);
  }



  //-------Elements-----------------//

  private By searchButton() {
    return findByXPath(
        "//button[@class='button suggest2-form__button button_theme_websearch "
        + "button_size_ws-head i-bem']"
    );
  }

  private By searchString() {
    return findByXPath("//input[@id='text']");
  }

  private By mapLink() {
    return findByText("Карты");
  }


  //---------------Actions----------------//
  public void clickSearchButton() {
    driver.findElement(searchButton()).click();
  }


  public void inputSearchString(String str) {
    driver.findElement(searchString()).sendKeys(str);
  }

  /**
   * Проверка наличия ссылки на карты.
   * @return
   */
  public boolean checkMapLink() {
    try {
      driver.findElement(mapLink());
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
