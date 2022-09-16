package com.kata.social.mediakata.model.entity.group;


import com.kata.social.mediakata.model.entity.post.Post;
import com.kata.social.mediakata.model.entity.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(generator = "groups_seq")
    private Long id;

    @Column
    String name;

    @Column(name = "last_redaction_date", nullable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @UpdateTimestamp
    private LocalDateTime lastRedactionDate;

    @Column(name = "persist_date", nullable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @CreationTimestamp
    private LocalDateTime persistDate;

    @Column
    private String linkSite;

    @Column
    private String description;

    @Column
    private String addressImageGroup;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinTable(name = "group_wall", joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> posts;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;
}
