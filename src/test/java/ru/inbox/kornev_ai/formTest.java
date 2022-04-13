package ru.inbox.kornev_ai;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class formTest {

    public static FormElements formElements;
    public static Success success;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        formElements = new FormElements(driver);
        success = new Success(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
    }
        /**
         * тестовый метод для осуществления отправки сообщения в форму обратной связи
         */
        @Test
        public void formTest() {
            String request = "appline.ru";
            String name = "Корнев Александр";
            String email = "kornev_ai@inbox.ru";
            String messageForm = "Тестируем форму обратной связи Junit Java";
            String successMessage = "Ваша заявка успешно отправлена.";

            //Заполняем строку поиска
            formElements.fieldRequest(request);

            //Кликаем на "Мне повезет"
            formElements.clickLucky();

            //Кликаем на контакты
            formElements.clickContact();

            //Вводим имя
            formElements.inputName(name);

            //Вводим почту
            formElements.inputEmail(email);

            //Вводим сообщение
            formElements.inputMessage(messageForm);

            //Нажимаем кнопку отправки
            formElements.clickButton();
            //Получаем сообщение
            String message = success.getMessage();
            //Сравниваем ожидаемый результат и фактический
            Assert.assertEquals(successMessage, message);
        }
    @AfterClass
    public static void tearDown() {
            driver.quit();
        }
}