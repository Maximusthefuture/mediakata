package com.kata.social.mediakata.webapp.controller.swagger;


import com.kata.social.mediakata.model.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** C помощью аннотации @Api над классом контроллера можно добавить описание контроллера,
 *  для проверки результата введите в браузере http://${DB_HOST}:${DB_PORT}/swagger-ui/   */

@RestController
@Api(description = "Тестовый контроллер для проверки сваггера")
public class SwaggerTestController {

    /** C помощью аннотации @ApiOperation над методом контроллера можно добавить описание метода*/

    @ApiOperation(value = "Метод allUsers",
            notes = "Метод allUsers возвращает всех юзеров из БД")
    @GetMapping("/api/swagger/users")
    public ResponseEntity<User> allUsers() {
        return null;
    }
}
