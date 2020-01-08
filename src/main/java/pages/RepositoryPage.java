package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RepositoryPage extends Page {

    public RepositoryPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//summary[contains(@aria-label,'Create new')]")
    private WebElement createNewDropdown;

    @FindBy(xpath = "//a[@role='menuitem' and @href='/new']")
    private WebElement newRepositoryButton;

    @FindBy(xpath = " //input[@id='repository_name']")
    private WebElement repositoryNameInputField;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Create repository')]")
    private WebElement createRepositoryButton;

    @FindBy(xpath = "//h1/strong/a")
    private WebElement newRepositoryName;

    @FindBy(xpath = "//a[contains(.,'Settings') and not(@role)]")
    private WebElement settingsButton;

    @FindBy(xpath = "//summary[contains(.,'Delete this repository')]")
    private WebElement deleteRepositoryButton;

    @FindBy(xpath = "//input[contains(@aria-label,'delete')]")
    private WebElement inputDeleteRepositoryNameField;

    @FindBy(xpath = "//button[contains(.,'delete')]")
    private WebElement confirmDeleteRepositoryButton;

    @FindBy(xpath = "//button[@aria-label='Dismiss this message']/..")
    private WebElement successDeleteMessage;


    // Create new repository

    public void openCreateRepositoryForm() {
        wait.until(ExpectedConditions.visibilityOf(createNewDropdown));
        createNewDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(newRepositoryButton));
        newRepositoryButton.click();
    }

    public void enterRepositoryName(String repositoryName) {
        wait.until(ExpectedConditions.visibilityOf(repositoryNameInputField));
        repositoryNameInputField.clear();
        repositoryNameInputField.sendKeys(repositoryName);
    }

    public void submitCreateForm() {
        wait.until(ExpectedConditions.elementToBeClickable(createRepositoryButton));
        createRepositoryButton.click();
    }

    public String getRepositoryName() {
        wait.until(ExpectedConditions.visibilityOf(newRepositoryName));
        return newRepositoryName.getText();
    }


    // Delete repository

    public void openSettingsForm() {
        wait.until(ExpectedConditions.visibilityOf(settingsButton));
        settingsButton.click();
    }

    public void deleteRepository() {
        wait.until(ExpectedConditions.visibilityOf(deleteRepositoryButton));
        deleteRepositoryButton.click();
    }

    public void inputDeleteRepositoryName(String repositoryName) {
        wait.until(ExpectedConditions.visibilityOf(inputDeleteRepositoryNameField));
        inputDeleteRepositoryNameField.clear();
        inputDeleteRepositoryNameField.sendKeys("AlexSmetanin/"+repositoryName);
    }

    public void submitDeleteRepositoryForm() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteRepositoryButton));
        confirmDeleteRepositoryButton.click();
    }

    public String getDeleteMessage() {
        wait.until(ExpectedConditions.visibilityOf(successDeleteMessage));
        return successDeleteMessage.getText();
    }
}
