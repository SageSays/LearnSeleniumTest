package app.pages.yandex;

import app.web_pages.WebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import java.util.List;

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
  @Step("Проверить наличие первной ссылке")
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
  @Step("Проверить, что список ссылок не пуст")
  public boolean checkNotEmptyLinkList() {
    try {
      List linkListBySearch = driver.findElements(linkListBySearch());
      if(linkListBySearch.size()>0){
        return true;
      } else {
        return false;
      }
    } catch (ElementNotVisibleException e) {
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
