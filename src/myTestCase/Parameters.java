package myTestCase;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
WebDriver driver=new ChromeDriver();
String URL="https://global.almosafer.com/en";
String[] Websites={"https://global.almosafer.com/en","https://global.almosafer.com/ar"};
Random rand=new Random();

int RandomIndex=rand.nextInt(Websites.length);
}
