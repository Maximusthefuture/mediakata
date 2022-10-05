package com.kata.social.mediakata.service;

import com.kata.social.mediakata.model.entity.user.Active;
import com.kata.social.mediakata.model.entity.user.Role;
import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.model.user.ActiveService;

import com.kata.social.mediakata.service.abstracts.model.user.RoleService;
import com.kata.social.mediakata.service.abstracts.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class TestDataInitService implements ApplicationRunner {

    private static final int USERS_COUNT = 60;

    @Autowired
    private RoleService roleService;
    @Autowired
    private ActiveService activeService;
    @Autowired
    private UserService userService;

    private static final String[] actives = {"ACTIVE", "DISABLED"};
    private static final String[] roles = {"ROLE_ADMIN", "ROLE_USER"};

    private static final String[] avatars = {"http://someapi.com/avatar?id=1"};
    private static final String[] firstNames = {"Sergey", "Сергей", "NeSergey", "НеСергей", "Иван", "Петр", "Ivan", "Petr", "Jhon", "Джон", "Игорь", "Igor", "Neznaika"};
    private static final String[] lastNames = {"Sergeev", "NeSergeev", "Ivanov", "NeIvanov", "Dalnovidnui", "Сергеев", "НеСергеев", "Выборочной", "Рандомов", "Какойнибудной", "Фамилиев", "Такойтов"};
    private static final String[] about = {"Ем овощи", "Не ем овощи", "Пишу код", "Не пишу код", "Плохо пишу код", "Хорошо пишу код", "Учусь", "Не учусь", "Переезжаю", "Что то делаю", "Что-то не делаю"};
    private static final String[] status = {"Не надо быть правильным, надо быть настоящим…", "Самый дешевый товар в мире — это мнение других о тебе.", "Неважно, сколько ты знаком с человеком. Главное, кем он для тебя стал", "Счастье не надо искать – им надо быть."};
    private static final String[] education = {"Высшее", "Среднее", "Низшее"};
    private static final String[] city = {"Волгоград", "Москва", "Питер", "Хабаровск", "Тында", "Комсомольск-на-амуре", "Мытищи", "Абаза", "Абинск", "Калининград", "Гуково", "Гурьевск", "Гусев"};

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createActive();
        createRoles();
        generateUsers();
    }

    private void createActive() {
        for (int i = 0; i < actives.length; i++) {
            Active active = new Active();
            active.setName(actives[i]);
            activeService.create(active);
        }
    }

    private void createRoles() {
        for (int i = 0; i < roles.length; i++) {
            Role role = new Role();
            role.setName(roles[i]);
            roleService.create(role);
        }
    }

    private void createUser(String name, String lastName, String email, String about,
                            String education, String status, String city,
                            String password, Active active, Role role, String avatar) {
        User user = new User();
        user.setRole(role);
        user.setActive(active);
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setEducation(education);
        user.setStatus(status);
        user.setAbout(about);
        user.setCity(city);
        user.setAvatar(avatar);
        userService.create(user);
    }

    private void generateUsers() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < USERS_COUNT; i++) {
            int namesIndex = random(firstNames);
            Long index = (i % 2 == 0) ? 2L : 1L;
            Optional<Role> role = roleService.getById(index);
            Optional<Active> active = activeService.getById(index);

            String password = passwordEncoder.encode(firstNames[namesIndex]+ i);
            createUser(firstNames[namesIndex], lastNames[random(lastNames)], firstNames[namesIndex] + i + "@mail.ru", about[random(about)],
                    education[random(education)], status[random(status)], city[random(city)], password, active.get(), role.get(), avatars[random(avatars)]);
        }
    }

    private <T> int random(T[] array) {
        Random random = new Random();
        return random.nextInt(array.length);
    }

}
