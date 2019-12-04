package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomeWorkPage {
    private WebDriverWait wait;

    public HomeWorkPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public static final String fileListLocator = "//tr/td[@class='content' and (not(@colspan ='3'))]";
    public static final String filesOnlyListLocator = "//*[name()=\"svg\" and @aria-label=\"file\"]";
    public static final String directoryOnlyListLocator = "//*[name()=\"svg\" and @aria-label=\"directory\"]";


    @FindBy(xpath = fileListLocator)
        private List<WebElement> fileList;

    @FindBy(xpath = filesOnlyListLocator)
        private List<WebElement> filesOnlyList;

    @FindBy(xpath = directoryOnlyListLocator)
    private List<WebElement> directoryOnlyList;


    public int getUserFilesCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fileListLocator)));
        return  fileList.size();
    }

    public int getUserFilesOnlyCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filesOnlyListLocator)));
        return  filesOnlyList.size();
    }

    public int getUserDirectoryOnlyCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(directoryOnlyListLocator)));
        return  directoryOnlyList.size();
    }
}
