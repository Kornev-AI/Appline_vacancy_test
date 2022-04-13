package ru.inbox.kornev_ai;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormElements {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public FormElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    /**
     * определение локатора поля ввода
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    private WebElement fieldRequest;


    /**
     * определение локатора "Мне повезет"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]")
    private WebElement feelingLucky;

    /**
     * определение локатора поля ввода имени
     */
    @FindBy(xpath = "/html/body/div[2]/header/div/div[2]/nav/ul/li[6]/a")
    private WebElement contactButton;

    /**
     * определение локатора поля ввода имени
     */
    @FindBy(xpath = "//*[@id='name']")
    private WebElement nameField;

    /**
     * определение локатора поля ввода почты
     */
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailField;

    /**
     * определение локатора поля ввода сообщения
     */
    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement messageField;
    /**
     * определение локатора кнопки "Оставить заявку"
     */
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[3]/form/button")
    private WebElement buttonSend;



    /**
     * Метод для заполнения строки поиска
     */
    public void fieldRequest (String request){
        fieldRequest.sendKeys(request);
    }

    /**
     * Метод для нажатия кнопки "Мне повезет"
     */
    public void clickLucky() {
        feelingLucky.click();
    }

    /**
     * Метод для нажатия кнопки "Контакты"
     */
    public void clickContact() {
        contactButton.click();
    }

    /**
     * Метод для ввода имени
     */
    public void inputName (String name){

        nameField.sendKeys(name);
    }
    /**
     * Метод для ввода почты
     */
    public void inputEmail (String email){
        emailField.sendKeys(email);
    }
    /**
     * Метод для ввода сообщения
     */
    public void inputMessage (String message){
        messageField.sendKeys(message);
    }
    /**
     * Метод для нажатия кнопки "Оставить заявку"
     */
    public void clickButton() {
        buttonSend.click();
    }

}
