package app.web_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Описание веб-страницы.
 * @author Ivan_Parshin-Borodin
 */
public class WebPage {

  /**
   * Поис по xpath.
   * @param xpath xpath путь
   * @return
   */
  public By findByXPath(String xpath) {
    return By.xpath(xpath);
  }

  /**
   * Поиск по name элемента.
   * @param name элемента
   * @return
   */
  public By findByName(String name) {
    return By.name(name);
  }

  /**
   * Поиск по id элемента.
   * @param id элемента
   * @return
   */
  public By findById(String id) {
    return By.id(id);
  }

  /**
   * Находит элемент по тексту, который он содержит.
   * @param text текст, который содержит элемент
   * @return
   */
  public By findByText(String text) {
    return By.xpath(
      String.format("//*[text() = '%s']", text)
    );
  }

}
