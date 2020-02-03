package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.lang.reflect.Field;

public class Driver {
  private WebDriver webDriver;
  private String startPage;

  public Driver(String url){
    startPage = url;
  }


  public WebDriver getChromeDriver() {
    initChromeDriver();
    webDriver.get(startPage);
    return  this.webDriver;
  }

  private void initChromeDriver(){
    ChromeDriverService service = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File("src\\main\\java\\app\\source\\chromedriver.exe"))
        .usingAnyFreePort()
        .build();
    webDriver = new ChromeDriver(service);
    webDriver.manage().window().maximize();
  }

}
