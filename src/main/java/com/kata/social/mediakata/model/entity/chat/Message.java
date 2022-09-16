package com.kata.social.mediakata.model.entity.chat;


import com.kata.social.mediakata.model.entity.media.Media;
import com.kata.social.mediakata.model.entity.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(generator = "messages_seq")
    private Long id;

    @Column
    private String message;

    @Column(name = "is_unread", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean is_unread = true;


    @Column(name = "persist_date")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @UpdateTimestamp
    private LocalDateTime lastRedactionDate;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Media.class)
    @JoinTable(name = "media_message", joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id"))
    private Set<Media> media;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User userSender;
}
