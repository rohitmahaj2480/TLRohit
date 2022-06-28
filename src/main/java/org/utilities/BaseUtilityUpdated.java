package org.utilities;



import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtilityUpdated {

	WebDriver driver; //null
	public WebDriver startup(String bName,String url) {//Here we are returning the instancs of Webdriver therefore return type is WebDriver.

		if(bName.equalsIgnoreCase("CH")||bName.equalsIgnoreCase("Chrome")){

			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(bName.equalsIgnoreCase("FF")||bName.equalsIgnoreCase("FireFox")){

			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(bName.equalsIgnoreCase("ED")||bName.equalsIgnoreCase("Edge")){

			System.setProperty("webdriver.edge.driver","./driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		//driver.manage().window().minimize();//Available after selenium 4
		//driver.manage().window().setSize(new Dimension (200,200));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();

		return driver;
	}
	public void waitForVisibilityofElement(WebDriver driver,int time,By locator) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}
	public void waitForInvisibilityofElement(WebDriver driver,int time,By locator) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForElementToBeClickable(WebDriver driver,int time ,By locator) {
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.elementToBeClickable(locator));	
	}
	public void waitForElementToBeSelected(WebDriver driver,int time ,By locator) {
		WebDriverWait wt=new WebDriverWait (driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public void waitForPresenceOfElement(WebDriver driver,int time ,By locator) {
		WebDriverWait wt= new WebDriverWait (driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	//Wait for Alert to Be present on screen before accept/dismiss.
	public void WaitForAlertIsPresent(WebDriver driver,int time) {
		WebDriverWait wt =new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.alertIsPresent());
	}

	//To click on  Particular WebElement
	public void clickByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	//Scroll Down By Using Page Down
	public void pgDown(WebDriver driver, int no_ofTime) {
		for(int i=0;i<=no_ofTime;i++) {
			driver.findElement(By.tagName("Body")).sendKeys(Keys.PAGE_DOWN);
		}
	}
	//Scroll Down Till Required element by JS
	public void scrollByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	//Scroll Down Till End
	public void scrollByJsTillEnd(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	//To Highlight or flash the WebElement
	public void flash(WebDriver driver,WebElement element) throws InterruptedException {
		String bgcolor =element.getCssValue("backgroundColor");
		for(int i=0;i<500;i++) {
			changeColor("#000000",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}

	public void changeColor(String color,WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
		Thread.sleep(50);
	}
	//To Draw border around the WebElement
	public void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	//Refresh WebDriver by Js.
	//driver.navigate().refresh() webdriver method 
	public void refreshBrowserByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	//Generate User Define  Alert
	public void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}
	//It Will Return all text from ddl.
	public ArrayList<String> getAllTextfromDDL(WebElement ddelement) {
		ArrayList<String> ar = new ArrayList<String>();
		Select se = new Select(ddelement);
		//List<WebElement> allList=se.getOptions();
		//for(int i =0;i<allList.size();i++) {
		//ar.add(allList.get(i).getText());
		//shortcut
		for(int i =0;i<se.getOptions().size();i++) {
			ar.add(se.getOptions().get(i).getText());
		}
		return ar;
	}

	//It will return all options of DDL
	public List<WebElement> getAlloptionsFromDDL(WebElement ddelement) {

		Select se=new Select(ddelement);
		return se.getOptions();
	}

	//It will return count of option from DDl
	public int getNumberofOption(WebElement ddelement) {
		Select se=new Select(ddelement);
		return se.getOptions().size();
	}
	//Select all from MultiSelect DDMenu
	public void selectAll(WebElement element) {
		Select sel =new Select(element);
		for(int i=0;i<sel.getOptions().size();i++) {
			sel.selectByIndex(i);
		}
	}
	//It will Return all Selected options Text
	public ArrayList<String> getAllSelectedOptionsText(WebElement element) {
		ArrayList<String> selectedList = new ArrayList<String>();
		Select sel = new Select(element);
		for(int i=0;i<sel.getAllSelectedOptions().size();i++) {
			selectedList.add(sel.getAllSelectedOptions().get(i).getText());
		}
		return selectedList; 
	}
	//It will Return Selcted option WebElemnt
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select sel = new Select(element);
		return sel.getAllSelectedOptions();
	}
	//It will Return firstSelcted option Text /Default Selected 
	public String getFirstSelectedOptionText(WebElement element){
		Select sel = new Select (element);
		String str =sel.getFirstSelectedOption().getText();
		return str;
	}
	//It will Return first Selected option WebElemnt/Default Selected 
	public WebElement getFirstSelectedOption(WebElement element) {
		Select sel = new Select (element);
		WebElement firstSelectedoption =sel.getFirstSelectedOption();
		return firstSelectedoption;
	}
	//Window Handler
	public void windowSwitch(WebDriver driver,By locator,By WebElement) {

		String parentWindow =driver.getWindowHandle();//Parent Window Store 
		driver.findElement(locator).click();//Click on elements that opens new windows.
		Set<String> allWindow =driver.getWindowHandles();//Store  in set
		Iterator<String> itr=allWindow.iterator();//Iterator method call

		String str ="";WebElement wb;//
		while(itr.hasNext()){
			str=itr.next();
			if(str.equalsIgnoreCase(parentWindow)) {
				continue;
			}
			driver.switchTo().window(str);
			try {
				wb=driver.findElement(WebElement);
				break;
			}catch(NoSuchElementException e) {
				continue;
			}
		}
	}//To check isAlertPresent and handle NoAlertPresent Exception 

	public boolean isAlertPresent(WebDriver driver,int time) {
		try {
			WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(Exception e) {
			return false;	
		}
	}
	//to open Link in new tab or new Window
	public void toOpenLinkInNewTaborWindow(WebDriver driver,String linkToOpen,WindowType taborWindow) {

		driver.switchTo().newWindow(taborWindow);
		driver.get(linkToOpen);
	}
	//to upload file
	public static void fileUpload(String exePath, String file_name){
		try {
			Thread.sleep(2000);
			Runtime.getRuntime().exec(exePath+" "+file_name);
		} catch (InterruptedException | IOException e) {

			e.printStackTrace();
		}
	}
	//Click by Action Class
	public void clickByActionClass(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}
	//sendKeys by Action class.
	public void sendKeysByActionClass(WebDriver driver,WebElement element,String message) {
		Actions act = new Actions(driver);
		act.sendKeys(element,message).perform(); 
	}//Drag and Drop By Action Class
	public void dragNDropByActionClass(WebDriver driver,WebElement source,WebElement destination) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source,destination).perform();
	}
	//Drag and drop by click and hold
	public void clickNHoldByActionClass(WebDriver driver,WebElement source,WebElement destination) {
		Actions act = new Actions(driver);
		act.clickAndHold(source).release(destination).build().perform();
	}

	//To Avoid staleElement Exception
	public boolean retryingFind(By locator) {
		boolean result = false;
		int attempts = 0;
		while(attempts < 3) {
			try {
				driver.findElement(locator);
				result = true;
				break;
			} catch(StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}



	//get all cell type from Excel sheet if a
	public void getallCellType(String filePath,String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis =new FileInputStream(filePath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet s1 =wb.getSheet(sheetName);

		for(int i=0;i<=s1.getLastRowNum();i++){
			for(int j=0;j<s1.getRow(i).getLastCellNum();j++) {
				try {
					System.out.println(s1.getRow(i).getCell(j).getCellType());
				}catch(NullPointerException e) {
					System.out.println("Cell Is Blank");
				}
			}
			System.out.println();
		}
	}//get all cell data of each row
	public void getAllCellDataType(String filePath,String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream (filePath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetName);
		for(int i=0;i<=s1.getLastRowNum();i++) {//7
			for(int j=0;j<s1.getRow(i).getLastCellNum();j++) {//6
				//Storing cell type in object of CellType	

				try {
					CellType ct=s1.getRow(i).getCell(j).getCellType();

					switch(ct) {
					case STRING:System.out.println(s1.getRow(i).getCell(j).getStringCellValue());
					break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(s1.getRow(i).getCell(j))) {
							//System.out.println(s1.getRow(i).getCell(j).getDateCellValue());
							SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
							System.out.println(sdf.format(s1.getRow(i).getCell(j).getDateCellValue()));
						}else {
							System.out.println((long)s1.getRow(i).getCell(j).getNumericCellValue());
						}
						break;	
					case BOOLEAN:System.out.println(s1.getRow(i).getCell(j).getBooleanCellValue());
					break;
					case FORMULA:System.out.println(s1.getRow(i).getCell(j).getCellFormula());
					break;
					case BLANK:	System.out.println("Cell Is Blank");
					break;
					default :System.out.println("Invalid Cell Type");
					}
				}catch(NullPointerException e) {
					System.out.println("");
					continue;
				}
			}
			System.out.println();
		}

	}//Get data of particular cell data 
	public void getDataOfParticularCell(String filePath,String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream (filePath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetName);
		for(int i=0;i<=s1.getLastRowNum();i++) {//7
			for(int j=0;j<s1.getRow(i).getLastCellNum();j++) {//6
				//Storing cell type in object of CellType	
				if(i==row && j==cell) {
					try {	
						CellType ct=s1.getRow(i).getCell(j).getCellType();
						switch(ct) {
						case STRING:System.out.println(s1.getRow(i).getCell(j).getStringCellValue());
						break;
						case NUMERIC:
							if(DateUtil.isCellDateFormatted(s1.getRow(i).getCell(j))) {
								//System.out.println(s1.getRow(i).getCell(j).getDateCellValue());
								SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
								System.out.println(sdf.format(s1.getRow(i).getCell(j).getDateCellValue()));
							}else {
								System.out.println((long)s1.getRow(i).getCell(j).getNumericCellValue());
							}
							break;	
						case BOOLEAN:System.out.println(s1.getRow(i).getCell(j).getBooleanCellValue());
						break;
						case FORMULA:System.out.println(s1.getRow(i).getCell(j).getCellFormula());
						break;
						case BLANK:	System.out.println("Cell Is Blank");
						default :System.out.println("Invalid Cell Type");
						}
					}catch(NullPointerException e) {
						System.out.println("Cell Is Blank");
					}
				}

			}

		}

	}
	//return data of particular data
	public Object getObjectOfParticularCell(String filePath,String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream (filePath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetName);
		for(int i=0;i<=s1.getLastRowNum();i++) {//7
			for(int j=0;j<s1.getRow(i).getLastCellNum();j++) {//6
				//Storing cell type in object of CellType	
				if(i==row && j==cell) {
					try {	
						CellType ct=s1.getRow(i).getCell(j).getCellType();
						switch(ct) {
						case STRING://System.out.println(s1.getRow(i).getCell(j).getStringCellValue());
							return (s1.getRow(i).getCell(j).getStringCellValue());

						case NUMERIC:
							if(DateUtil.isCellDateFormatted(s1.getRow(i).getCell(j))) {
								//System.out.println(s1.getRow(i).getCell(j).getDateCellValue());
								SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
								//System.out.println(sdf.format(s1.getRow(i).getCell(j).getDateCellValue()));
								return (sdf.format(s1.getRow(i).getCell(j).getDateCellValue()));
							}else {
								//System.out.println((long)s1.getRow(i).getCell(j).getNumericCellValue());
								return ((long)s1.getRow(i).getCell(j).getNumericCellValue());
							}

						case BOOLEAN://System.out.println(s1.getRow(i).getCell(j).getBooleanCellValue());
							return (s1.getRow(i).getCell(j).getBooleanCellValue());

						case FORMULA://System.out.println(s1.getRow(i).getCell(j).getCellFormula());
							return (s1.getRow(i).getCell(j).getCellFormula());
						case BLANK:	//System.out.println("Cell Is Blank");
							return "Cell Is Blank";
						default ://System.out.println("Invalid Cell Type");
							return "Invalid Cell Type";
						}
					}catch(NullPointerException e) {
						System.out.println("");
					}
				}

			}

		}
		return null;
	}
	//to get Random Number 
	public  int randomNumberGenerator(String filePath,String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis =new FileInputStream(filePath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetName);
		int min=1;
		int max=s1.getLastRowNum();
		int randomNumber=(int)(Math.random()*(max-min+1)+min);
		return randomNumber;
	}
	//to Get Data Of Any Cell With Respect To Table Heading 
	public Object returnDataOfAnyCellWithRespectToTableHeading(String filePath,String sheetName,String requiredKey,int requiredRow) throws EncryptedDocumentException, IOException {
		//BaseUtilityUpdated bu = new BaseUtilityUpdated();
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetName);
		HashMap<String,Object> data=new HashMap<String,Object>();
		for(int i=0;i<s1.getRow(0).getLastCellNum();i++) {

			String key =s1.getRow(0).getCell(i).getStringCellValue();
			Object value = /* bu. */getObjectOfParticularCell(filePath, sheetName,requiredRow,i);
			data.put(key, value);
		}
		//System.out.println(data);
		//System.out.println(data.get(requiredKey));
		return data.get(requiredKey);
	}
	//It will return total no. of rows present in sheet
	public int getlastRowNumber(String filePath,String sheetName) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream(filePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s1=wb.getSheet(sheetName);
	return s1.getLastRowNum();
	}
	//It will Return No.of Columns/Cell Present in first row
	public int getlastCellNumber(String filePath,String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetName);
		
		Row r1 =s1.getRow(0);
		
		return s1.getRow(0).getLastCellNum();
	
}
	//Get data From Excel and provide data to the the test case 
	public  Object[][] getDataAndProvideData(String filePath,String sheetData) throws EncryptedDocumentException, IOException{
			
		int last_row=getlastRowNumber(filePath,sheetData);
		int last_cell=getlastCellNumber(filePath,sheetData);
		//System.out.println(last_row);
		//System.out.println(last_cell);
		Object ar[][]=new Object[last_row][last_cell];
		//int k = 0;
		//int l = 0;
		for (int i=1,k=0;i<=last_row;i++,k++) {//1//2
			for(int j = 0,l=0;j<last_cell;j++,l++) {//0

				ar[k][l]=getObjectOfParticularCell(filePath,sheetData,i,j);

				//System.out.println(ar[k][l]);
			}
		}
		return ar;
	}
}










