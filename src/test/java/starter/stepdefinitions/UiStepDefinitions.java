package starter.stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import starter.runner.TestRunner;

public class UiStepDefinitions extends TestRunner {

	public UiStepDefinitions() {
	}

	private static EnvironmentVariables env;

	public String uiBaseUri() {
		return EnvironmentSpecificConfiguration.from(env).getProperty("ui.base.url");
	}

	private static String uiWebDriver() {
		return EnvironmentSpecificConfiguration.from(env).getProperty("ui.driver.name");
	}

	private WebDriver getDriver() {
		if (uiWebDriver().charAt(0) == 'c') {
			WebDriverManager.chromedriver().browserVersion(uiWebDriver().replaceAll("\\D+", "")).setup();
			ChromeOptions opt = new ChromeOptions();
			//opt.addArguments("--headless");
			return new ChromeDriver(opt);
		} else if (uiWebDriver().charAt(0) == 'f') {
			WebDriverManager.firefoxdriver().browserVersion(uiWebDriver().replaceAll("\\D+", "")).setup();
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--headless");
			return new FirefoxDriver(opt);
		}
		return null;
	}

	@Step
	public void openEdjHomePageValidateWelcomeMessage() {
		WebDriver driver = getDriver();
		driver.get(uiBaseUri());
		driver.manage().window().maximize();
		try {
			Assertions.assertThat(driver.findElement(By.xpath("//h1")).isDisplayed());
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//h1")));
			Thread.sleep(3000);
		}catch(Exception e) {
			
		}
		driver.quit();
	}
}
