package org.supportpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class UtilClass {
	
	public static WebDriver driver;
	public static Actions a;
	public static Workbook book;
	public static FileInputStream fi;
	public static JavascriptExecutor js;
	
	public static void browserLaunch(String browserName) {
		
		if (browserName.equals("chrome")) 
		{
		     driver = new ChromeDriver();	
		}
		else if (browserName.equals("edge")) 
		{
			 driver = new EdgeDriver();
		}
		else if (browserName.equals("firefox")) 
		{
		     driver = new FirefoxDriver();	
		}
	}
	
	public static void fetchParentWindow() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}
	
    public static void fetchAllWindow() {
    	
    	Set<String> windowHandles = driver.getWindowHandles();
    	System.out.println(windowHandles);
		
	}
	public static void launchURL(String url) {
		     driver.get(url);
    }
	public static void maxwindow() {
             driver.manage().window().maximize();
	}
	public static void pageRefresh() {
		driver.navigate().refresh();
	}
	public static void fetchTittle() {
		     String tittle = driver.getTitle();
		     System.out.println("page tittle = "+tittle);
	}
	public static void fetchURL() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("page url = "+currentUrl);
    }
	public static void closeBrowser() {
		driver.quit();
	}
	public static void btnClick(WebElement btn) {
		btn.click();
	}
	public static void valuePass(WebElement element,String value) {
		element.sendKeys(value);
	}	
    public static void takeSnap(String imgname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			  File source = ts.getScreenshotAs(OutputType.FILE);
			
			  File destination = new File("C:\\Users\\91877\\eclipse-workspace\\CucumberTraining\\ScreenShot"+imgname+".png");
		///	  C:\\Users\\91877\\eclipse-workspace\\CucumberTraining\\\\Images\\\\\"+imgname+\".png
			  FileUtils.copyFile(source, destination);
	}
    public static void moveTheCursor(WebElement object) {
        a = new Actions(driver);
		a.moveToElement(object).perform();
	}
    public static void dragDrop(WebElement sour,WebElement target) {
		a.dragAndDrop(sour, target).perform();
	}
    public static void switchFrame(int frameindex) {
		driver.switchTo().frame(frameindex);
	}
    public static void findElement(String value) {
		driver.findElement(By.xpath(value));
	}
    public static void findAndClick(String  value) {	
    	driver.findElement(By.xpath(value)).click();
	}
	public static void findAndSend(String value,String svalue) {
		WebElement txtfield = driver.findElement(By.xpath(value));
		txtfield.sendKeys(svalue);
	}
	public static void waitsApplytoElements() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void timeAndDate() {
		Date d = new Date();
		System.out.println(d);
	}
	public static void javascriptclick(WebElement btnhome) {
        js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",btnhome );
	     
	}
    public static String Datafromsheet(String sheetname,int rownum,int cellnum) {
		
		File f = new File("C:\\Users\\91877\\eclipse-workspace\\Maven6pmBatche\\ExternalFile\\LoginDetails.xlsx");
		try {
			 fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {}
		
		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {}
		
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		
		String value = null;
		
	    int cellType = cell.getCellType();
	    
	    if (cellType==1) {
	    	 value = cell.getStringCellValue();
		}
	    else if (DateUtil.isCellDateFormatted(cell)) {
	    	Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat();
			 value = s.format(d);
		}
	    else {
			double d = cell.getNumericCellValue();
			long l = (long)d;
			 value = String.valueOf(l);
	    }
	    return value;
	
	}



}
