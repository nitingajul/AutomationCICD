package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;


public class BaseTest 
{
 public WebDriver driver;
 public LandingPage landingPage;
 
	public WebDriver initializeDriver() throws Exception
	{
			//properties file
	Properties prop = new Properties();
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
    		"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
    prop.load(fis);
    String browserName = prop.getProperty("browser");
    if(browserName.equalsIgnoreCase("chrome"))
    {
    	WebDriverManager.chromedriver().setup();
    driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
    }
    else if(browserName.equalsIgnoreCase("firefox"))
    {
    	
    }
    else if(browserName.equalsIgnoreCase("edge"))
    {
    	System.setProperty("webdriver.edge.driver","edge.exe");
    	WebDriver driver = new EdgeDriver();
    	
    }
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
 
	}
	

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//string to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });

		return data;
		//{map, map}

		
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws Exception
	{
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
}
