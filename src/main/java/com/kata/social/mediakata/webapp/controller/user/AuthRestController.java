package com.kata.social.mediakata.webapp.controller.user;

import com.kata.social.mediakata.exception.ApiRequestException;
import com.kata.social.mediakata.model.dto.UserRegisterDto;
import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.model.user.UserService;
import com.kata.social.mediakata.webapp.converter.user.UserMapper;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@Api(description ="REST контроллер для работы с пользователями (model-entity-User)")
public class AuthRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public AuthRestController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    @ApiOperation(value = "Метод addUser", notes = "Метод addUser принимает UserRegisterDto из тела request " +
            "проверяет есть ли юзер с такой почтой в БД, и если нет возвращает UserRegisterDto созданного пользователя" )
    public ResponseEntity<UserRegisterDto> addUser(@ApiParam("UserRegisterDto для добавления пользователя и проверки его почты")
                                                       @RequestBody UserRegisterDto userRegisterDto) {
        if (userService.existByMail(userRegisterDto.getEmail())) {
            throw new ApiRequestException("Пользователь с такой почтой уже существует");
        }

        User user = userMapper.toUser(userRegisterDto);
        userService.create(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
