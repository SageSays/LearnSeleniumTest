import app.Driver;
import app.pages.yandex.YandexMainPage;
import app.pages.yandex.YandexSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


/**
 * Тесты поисковика Яндекс.
 * @author Ivan_Parshin-Borodin
 */
public class YandexTests {
  private static String DEFAULT_PAGE = "https://yandex.ru/";
  static WebDriver driver = new Driver(DEFAULT_PAGE).getChromeDriver();

  /**
   * Проверка наличия ссылки "Карты".
   */
  @Test
  public void checkMapLink() {
    YandexMainPage yandex = new YandexMainPage(driver, DEFAULT_PAGE);
    Assert.assertFalse(yandex.checkMapLink());

  }

  /**
   * Проверка кнопки "Найти".
   */
  @Test
  public void testClick() {
    YandexMainPage yandex = new YandexMainPage(driver, DEFAULT_PAGE);
    yandex.inputSearchString("Selenium WebDriver");
    yandex.clickSearchButton();
    YandexSearchPage yandexSearchPage = new YandexSearchPage(driver);
    Assert.assertFalse(yandexSearchPage.checkFirstLink());
  }

  /**
   *
   */
  @Test
  public void searchAndFindResault() {
    YandexMainPage yandex = new YandexMainPage(driver, DEFAULT_PAGE);
    yandex.inputSearchString("Selenium WebDriver");
    yandex.clickSearchButton();
    YandexSearchPage yandexSearchPage = new YandexSearchPage(driver);
    yandexSearchPage.clickByFirstLink();
  }


  @AfterClass
  public static void finalise(){
    driver.quit();
  }

}
