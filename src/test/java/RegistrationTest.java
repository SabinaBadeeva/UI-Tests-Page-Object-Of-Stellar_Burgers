import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;


public class RegistrationTest extends Resources {


    @Test
    @Description("При успешной регистрации появляется форма авторизации с кнопкой Войти")
    @Step("Регистрация с минимальным паролем 6 символов - через кнопку Личный кабинет")
    public void registrationTest() {
        //Регистрация через кнопку "Войти в аккаунт"
        mainPage.clickPersonalAccountButton();
        //Нажать Зарегистрироваться
        registrationPage.clickRegistrationHref();
        // Заполнить инпуты
        registrationPage.registration(NAME, EMAIL, PASSWORD);
        // Ожидание загрузки данных
        authorisationPage.waitForLoadDataAccount();
        // Проверить, при успешной регистрации видна кнопка Войти
        authorisationPage.statusOfRegistration("Войти");}


    @Test
    @Description("При минимальном пароле выдает ошибку для некорректного пароля")
    @Step("Регистрация с минимальным паролем 6 символов через кнопку Личный кабинет")
    public void registrationIncorrectPasswordTest() {
        //Регистрация через кнопку "Личный кабинет"
        mainPage.clickEnterAccountButton();
        //Нажать Зарегистрироваться
        registrationPage.clickRegistrationHref();
        // Заполнить инпуты
        registrationPage.registration(NAME, EMAIL, PASSWORD_2);
        //Проверка ошибки пароля
        registrationPage.statusOfPasswordMessage("Некорректный пароль");}
}