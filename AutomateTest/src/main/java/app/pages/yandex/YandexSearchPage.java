package app.pages.yandex;

import app.web_pages.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

/**
 * Search page in yandex.
 * @author Ivan_Parshin-Borodin
 */
public class YandexSearchPage extends WebPage {

  WebDriver driver;


  public YandexSearchPage(WebDriver driver) {
    this.driver = driver;
  }


  //------Elements-----///
  private By firstSearchLink() {
    return findByXPath("//li[1]//div[1]//h2[1]//a[1]");
  }

  private By linkListBySearch() {
    return findByXPath("//li//div[1]//h2[1]//a[1]//div[2]");
  }


  //------Actions-----///
  /**
   * Клик по первой ссылке в выдаче.
   */
  public void clickByFirstLink() {
    driver.findElement(firstSearchLink()).click();
  }

  /**
   * Проверка наличия ссылки в результатах поиска.
   * @return
   */
  public boolean checkFirstLink() {
    try {
      driver.findElement(firstSearchLink());
      return true;
    } catch (ElementNotVisibleException e) {
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Проверка список ссылок на странице не пуст.
   * @return
   */
  public boolean checkNotEmptyLinkList() {
    try {
      driver.findElement(linkListBySearch());
      return true;
    } catch (ElementNotVisibleException e) {
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
