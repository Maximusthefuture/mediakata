package com.kata.social.mediakata.model.entity.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "active")
public class Active {

    @Id
    @GeneratedValue(generator = "active_seq")
    private Long id;


    @Column
    private String name;


    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "active")
    private Set<User> users;
}
