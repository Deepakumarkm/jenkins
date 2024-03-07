
package com.base;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Deepak
 * @date 08-06-2023
 * @see Maintain reusable methods
 *
 */
public class BaseClass {
	public static WebDriver driver;
	/**
	 * @param browser
	 * @see To launch the browser
	 */
	public static void getdriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			 driver= new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
			break;
		default:
			break;
		}
			}
	/**
	 * 
	 * @param url
	 * @see To get the webpage url
	 */
	public static void geturl(String url) {
driver.get(url);
}
	
	
	/**
	 * 
	 * @param Sort list
	 * @see To print the list for sort option
	 */
	public static void Print(String[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}}
	/**
	 * @see  Used To maximize the webpage
	 */
public static void maximize() {
driver.manage().window().maximize();
}
/**
 * 
 * @param Key
 * @return String
 * @throws FileNotFoundException
 * @throws IOException
 * @see Used to get the property file value
 */
public static String getpropertyfilevalue(String Key) throws FileNotFoundException, IOException {
	Properties properties=new Properties();
	properties.load(new FileInputStream("E:\\New Project\\Jenkins\\Config\\Config.properties"));
	Object object=properties.get(Key);
	String value=(String) object;
	return value;
}
/**
 * 
 * @return String
 * @see Used to get the project path location
 */
public static String getprojectpath() {
	String path = System.getProperty("user.dir");
	return path;
}
/**
 * 
 * @throws AWTException
 * @see Used to funtionate the Tab key
 */
public void tabKey() throws AWTException {

	Robot r= new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
}
/**
 * 
 * @return String
 * @see Used to get the current webpage url
 */
public String getcurrenturl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
}
/**
 * 
 * @return byte[]
 * @see used to take screenshot
 */
public byte[] ScreenShot() {
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
	return bs;
}
/**
 * 
 * @return string
 * @see used to get the title
 */
public String gettitle() {
	String title = driver.getTitle();
	return title;
	}
/**
 * 
 * @param attributevalue
 * @return WebElement
 * @see To find element location by using id
 */
public static  WebElement findElementbyid(String attributevalue) {
	WebElement element = driver.findElement(By.id(attributevalue));
	return element;
}
/**
 * 
 * @param name
 * @return WebElement
 * @see To find element location by using name
 */
public WebElement findElementbyname(String name) {
	WebElement element = driver.findElement(By.name(name));
	return element;
}
/**
 * 
 * @param className
 * @return WebElement
 * @see To find element location by using class name
 */
public WebElement findElementbyclass(String className) {
	WebElement element = driver.findElement(By.className(className));
	return element;
}
/**
 * @param xpathExpression
 * @return WebElement
 * @see To find element location by using xpath
 *
 */
public WebElement findElementbyxpath(String xpathExpression) {
	WebElement element = driver.findElement(By.xpath(xpathExpression));
	return element;
}
/**
 * 
 * @param element
 * @param data
 * @see used to send the data to webpage
 */
public static void sendkeys(WebElement element,String data) {
	element.sendKeys(data);
}
/**
 * 
 * @param element
 * @param data
 * @see used to clear the data 
 */
public static void clear(WebElement element,String data) {
	element.clear();
}
/**
 * 
 * @param element
 * @see used to click the button,radio button and checkboxs  
 */
public static void click(WebElement element) {
	element.click();
}
/**
 * 
 * @param element
 * @return string
 * @see used to get the attribute value from webpage
 */
public  String getAttribute(WebElement element) {
	String attribute = element.getAttribute("value");
	System.out.println(attribute);
	return attribute;
}
/**
 * 
 * @param element
 * @return string
 * @see used to get the text from the web page
 */
public String gettext(WebElement element) {
	String text = element.getText();
	System.out.println(text);
	return text;
}
/**
 * @see used to close the current window
 */
public void closewindow() {
driver.close();
}
/**
 * @see usedd to close the all windows
 */
public  static void quitwindow() {
driver.quit();
}
/**
 * 
 * @param element
 * @param text
 * @see in drop down using select option by text
 */
public void selectoptionbytext(WebElement element,String text) {
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
/**
 * 
 * @param element
 * @param value
 *  @see in drop down using select option by attribute
 */
public void selectoptionbyattribute(WebElement element,String value) {
	Select s=new Select(element);
s.selectByValue(value);
}
/**
 * 
 * @param element
 * @param index
 *  @see in drop down using select option by index
 */
public void selectoptionbyindex(WebElement element,int index) {
	Select s=new Select(element);
	s.selectByIndex(index);
}
/**
 * 
 * @param element
 * @see used to de select the all parameters
 */
public void deselectall(WebElement element) {
	Select s=new Select(element);
	s.deselectAll();
}
/**
 * 
 * @param element
 * @param attributename
 * @return string
 * @see used to get the attribute using attribute name
 */
public String getattribute(WebElement element,String attributename) {
	String attribute = element.getAttribute(attributename);
	return attribute;
}
/**
 * 
 * @param element
 * @param data
 * @see used to send the data by using java script option
 */
public void elementsendkeysjs(WebElement element,String data) {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
}
/**
 * 
 * @param element
 * @param xpath
 * @see method for mouse over action
 */
public void movetoelement(WebElement element,String xpath) {
Actions a=new Actions(driver);
a.moveToElement(element).perform();
driver.findElement(By.xpath(xpath)).click();
}
/**
 * 
 * @param source
 * @param destination
 * @see used to drag and drop method in action class
 */
public void draganddrop(WebElement source,WebElement destination) {
	Actions a=new Actions(driver);
	a.dragAndDrop(source, destination).perform();
}
/**
 * 
 * @param path
 * @throws Exception
 * @see used to take screen shot 
 */
public void screenshot(String path) throws Exception {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
	File file=new File(path);
	FileUtils.copyFile(screenshotAs, file);
}
/**
 * 
 * @param shift
 * @param element
 * @param input
 * @see used key board action using automation without using keyboard
 */
public void keyboardactions(Keys shift,WebElement element,String input ) {
Actions actions=new Actions(driver);
actions.keyDown(shift).sendKeys(element,input).keyUp(shift).perform();
}
/**
 * 
 * @param element
 * @see double click action usion action class method
 */
public void doubleclick(WebElement element) {
	Actions a=new Actions(driver);
	a.doubleClick(element).perform();
}
/**
 * @see used to accept the alert
 */
public void acceptalert() {
	Alert alert=driver.switchTo().alert();
	alert.accept();
}
/**
 * @see used to cancel the alert
 */
public void dismissalert() {
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
}
/**
 * 
 * @param input
 * @return string
 * @see send input to the alert popup bok
 */
public  Alert alert(String input) {
	Alert alert=driver.switchTo().alert();
	return alert;
}
/**
 * 
 * @param element
 * @see used to attribute set using java script
 */
public void jssetattribute(WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].SetAttribute('value','suresh')",element);
}
/**
 * 
 * @param element
 * @return string
 * @see used to get attributte by using java script
 */
public String jsgetattribute(WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	Object executeScript = js.executeScript("arguments[0].getAttribute('value')",element);
	String string = executeScript.toString();
	return string;
}
/**
 * 
 * @param element
 * @see used to click option using java script
 */
public void jsclick(WebElement element) {
	JavascriptExecutor exector=(JavascriptExecutor)driver;
	exector.executeScript("arguments[0].click()",element);
}
/**
 * 
 * @param id
 */
public void frameid(String id){
	driver.switchTo().frame(id);
}
/**
 * 
 * @param element
 */
public void frameelement(WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * 
 * @param index
 */
public void frameindex(int index) {
	driver.switchTo().frame(index);
}
/**
 * 
 */
public void parentframe() {
	driver.switchTo().parentFrame();
}
/**
 * 
 */
public void childwindow() {
	String parent = driver.getWindowHandle();
Set<String> both = driver.getWindowHandles();
for(String x:both) {
	if(!parent.equals(x)) {
		driver.switchTo().window(x);
	}}}
/**
 * 
 */
public void backtoparentwindow() {
	String parent = driver.getWindowHandle();
Set<String> both = driver.getWindowHandles();
for(String x:both) {
	if(parent.equals(x)) {
		driver.switchTo().window(x);
	}}}
/**
 * 
 * @param index
 */
public void windowhandling(int index) {
	Set<String> windowHandles = driver.getWindowHandles();
List<String> li=new ArrayList<String>();
li.addAll(windowHandles);
String x = li.get(index);
driver.switchTo().window(x);
}
/**
 * 
 * @param url
 * @see using navigate method to url
 */
public void navigateto(String url) {
	driver.navigate().to(url);
}
/**
 * @see to navigate backward for webpage
 */
public void navigateback() {
driver.navigate().back();
}
/**
 * @see to navigate forward for webpage
 */
public void navigateforward() {
	driver.navigate().forward();
}
/**
 * @see navigate to refresh the webpage
 */
public void navigaterefresh() {
	driver.navigate().refresh();
}
/**
 * 
 * @param element
 * @param index
 */
public void deselectbyindex(WebElement element,int index) {
	Select s=new Select(element);
	s.deselectByIndex(index);
}
/**
 * 
 * @param element
 * @param value
 */
public void deselectbyvalue(WebElement element,String value) {
	Select s=new Select(element);
	s.deselectByValue(value);
}
/**
 * 
 * @param element
 * @param text
 */
public void deselectbyvisibletext(WebElement element,String text) {
	Select s=new Select(element);
	s.deselectByVisibleText(text);
}
/**
 * 
 * @param element
 * @return
 */
public boolean ismultiple(WebElement element) {
	Select s=new Select(element);
	boolean b = s.isMultiple();
return b;
}
/**
 * 
 * @param element
 */
public void getfirstselectedoptions(WebElement element) {
Select s=new Select(element);
WebElement firstSelectedOption = s.getFirstSelectedOption();
System.out.println(firstSelectedOption);
}
/**
 * 
 * @param element
 */
public void getoptions(WebElement element) {
Select s=new Select(element);
List<WebElement> options = s.getOptions();
for (int i = 0; i <options.size(); i++) {
	options.get(i);
}}
/**
 * 
 * @param element
 */
public void jsscrolldown(WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeAsyncScript("arguments[0].scrollingtoview(true)", element);
}
/**
 * 
 * @param element
 */
public void jsscrollup(WebElement element) {
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeAsyncScript("arguments[0].scrollingtoview(false)", element);
}
/**
 *@see to find the list of number of tables 
 */
public void nooftables() {
List<WebElement>findElement =driver.findElements(By.tagName("table"));
int Size=findElement.size();
System.out.println(Size);
}
/**
 * 
 * @param index
 */
public void gettexttext(int index) {
	List<WebElement> findElement = driver.findElements(By.tagName("table"));
WebElement a = findElement.get(index);
List<WebElement> findElement2 = a.findElements(By.tagName("tr"));
for(WebElement x:findElement2) {
String text = x.getText();
System.out.println(text);
}}
/**
 * 
 * @param index
 */
public void gettextweb(int index) {
	List<WebElement> elements = driver.findElements(By.tagName("table"));
WebElement ee = elements.get(index);
String text = ee.getText();
System.out.println(text);
}
/**
 * 
 * @param element
 */
public void getselectedoption(WebElement element) {
	Select s=new Select(element);
	List<WebElement> options = s.getAllSelectedOptions();
	for(WebElement x:options){
		String text = x.getText();
		System.out.println(text);
	}}
/**
 * 
 * @param sec
 * @param interval
 */
public void fluentwait(int sec,int interval) {
	FluentWait w = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(interval)).ignoring(NoSuchElementException.class);
}
/**
 * 
 * @param Sheetname
 * @param rownum
 * @param cellnum
 * @return
 * @throws IOException
 * @see to get the data from the excel sheet 
 */
public static String getdatafromcell(String Sheetname,int rownum,int cellnum) throws IOException {
	String res="";
	File file=new File("C:\\Users\\admin\\eclipse-workspace\\MevanProject\\Excel\\xcel\\Adactin.xlsx");
	FileInputStream fileinputstream=new FileInputStream(file);
	Workbook workbook=new XSSFWorkbook(fileinputstream);
	Sheet sheet = workbook.getSheet(Sheetname);
Row row = sheet.getRow(rownum);
Cell cell = row.getCell(cellnum);
CellType cellType = cell.getCellType();
switch (cellType) {
case STRING:
	res = cell.getStringCellValue();
	break;
case NUMERIC:
	if (DateUtil.isCellDateFormatted(cell)) {
		Date dateCellValue = cell.getDateCellValue();
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		  res= dateformat.format(dateCellValue);
	}else {
		double numericCellValue = cell.getNumericCellValue();
	long check = Math.round(numericCellValue);
	if (check==numericCellValue) {
		res=String.valueOf(check);
	}}
default:
	break;
}
return res;
}
/**
 * 
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @param olddata
 * @param newdata
 * @throws IOException
 * @see to enter the data in excel sheet from webpage
 */
public void updatedateincell(String sheetname,int rownum,int cellnum,String olddata,String newdata) throws IOException {
	File file=new File("C:\\Users\\admin\\eclipse-workspace\\MevanProject\\Excel\\xcel\\Adactin.xlsx");
FileInputStream fileInputStream=new FileInputStream(file);
Workbook workbook=new XSSFWorkbook(fileInputStream);
Sheet sheet = workbook.getSheet(sheetname);
Row row = sheet.getRow(rownum);
Cell cell = row.getCell(cellnum);
CellType type = cell.getCellType();
String value = cell.getStringCellValue();
if (value.equals(olddata)) {
	cell.setCellValue(newdata);
}
FileOutputStream out=new FileOutputStream(file);
workbook.write(out);
}
/**
 * 
 * @param sheetname
 * @param data
 * @param rownum
 * @param cellnum
 * @throws IOException
 * @see to insert the new data in new cell in excel sheet
 */
public void insertdataincell(String sheetname,String data,int rownum,int cellnum) throws IOException {
	File file=new File("C:\\Users\\admin\\eclipse-workspace\\MevanProject\\Excel\\xcel\\");
FileInputStream fileInputStream=new FileInputStream(file);
Workbook workbook =new XSSFWorkbook(fileInputStream);
Sheet sheet = workbook.getSheet(sheetname);
Row row = sheet.getRow(rownum);
Cell cell = row.createCell(cellnum);
cell.setCellValue(data);

FileOutputStream out=new FileOutputStream(file);
workbook.write(out);
}
/**
 * 
 * @param path
 * @param sheet
 * @param i
 * @param j
 * @return
 */
public String excelread(String path,String sheet,int i,int j) {
	String value=null;
	return value;
}
}