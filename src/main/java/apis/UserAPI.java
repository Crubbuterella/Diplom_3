package apis;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.User;
import models.BaseURL;

import static io.restassured.RestAssured.given;

public class UserAPI extends BaseURL {


    @Step("Удаление пользователя (DELETE /api/auth/user)")
    public static Response deleteUser(String accessToken) {
        setUp();
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(EndpointsAPI.BURGER_API_USER_DELETE);
    }

    @Step("Авторизация пользователя (POST /api/auth/login)")
    public static  Response loginUser(User user) {
        setUp();
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(EndpointsAPI.BURGER_API_USER_AUTH);
    }

    @Step("Создание пользователя POST /api/auth/register")
    public  static Response createUser(User user) {
        setUp();
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(EndpointsAPI.BURGER_API_USER_CREATE);
    }
}
