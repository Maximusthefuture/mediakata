package com.kata.social.mediakata.model.entity.user;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "role_seq")
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
