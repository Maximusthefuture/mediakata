package com.kata.social.mediakata.webapp.converter.user;

import com.kata.social.mediakata.model.dto.UserRegisterDto;
import com.kata.social.mediakata.model.entity.user.Active;
import com.kata.social.mediakata.model.entity.user.Role;
import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.model.user.ActiveService;
import com.kata.social.mediakata.service.abstracts.model.user.RoleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Optional;


@Mapper(componentModel = "spring")
public abstract class UserMapper {
    protected PasswordEncoder passwordEncoder;
    protected RoleService roleService;
    protected ActiveService activeService;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setActiveService(ActiveService activeService) {
        this.activeService = activeService;
    }
    //Если закомментить эти два маппинга то все работает, но падает при взаимодействии с апишкой
    @Mapping(target = "role", qualifiedByName = "findRoleByName")
    @Mapping(target = "active", qualifiedByName = "findByActiveByName")

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(userRegisterDto.getPassword()))")
    public abstract User toUser(UserRegisterDto userRegisterDto);

    @Named("findRoleByName")
    protected Role findRoleByName(String name) {
        Optional<Role> role = roleService.findByName(name);
        return role.isEmpty() ? null : role.get();
    }

    @Named("findActiveByName")
    protected Active findActiveByName(String name) {
        Optional<Active> active = activeService.findByName(name);
        return active.isEmpty() ? null : active.get();

    }

}
