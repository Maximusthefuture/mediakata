package com.kata.social.mediakata.webapp.controller.user;

import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import com.kata.social.mediakata.model.dto.page.PageDto;
import com.kata.social.mediakata.service.abstracts.dto.pagination.PaginationService;
import com.kata.social.mediakata.service.abstracts.dto.userDto.UserDtoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Api(description = "CRUD-контроллер сущности User")
@RequestMapping("api/user")
public class UserRestController {

    public final UserDtoService userDtoService;
    public final PaginationService<Object> paginationService;

    @Autowired
    public UserRestController(UserDtoService userDtoService, PaginationService<Object> paginationService) {
        this.userDtoService = userDtoService;
        this.paginationService = paginationService;
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Метод getUserbyId",
            notes = "Метод getUserbyId возвращает юзера по id в виде UserDto обернутый в Response Entity")
    public ResponseEntity<UserDto> getUserById (@PathVariable Long userId) {
         Optional<UserDto> userDto = userDtoService.getById(userId);
        return userDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<PageDto> getUsersWithPagination(@RequestParam int currentPage, @RequestParam int itemsOnPage) {
        Map<String, Object> map = new HashMap<>();
        map.put("currentPage", currentPage);
        map.put("itemsOnPage", itemsOnPage);
        return new ResponseEntity<>(paginationService.getPageDto("PaginationGetAllUsersDaoImpl", map), HttpStatus.OK);

    }



}
