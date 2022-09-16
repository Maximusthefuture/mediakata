package com.kata.social.mediakata.model.entity.album;


import com.kata.social.mediakata.exception.ApiRequestException;
import com.kata.social.mediakata.model.entity.media.Media;
import com.kata.social.mediakata.model.entity.media.MediaType;
import com.kata.social.mediakata.model.entity.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(generator = "albums_seq")
    private Long id;

    @NotNull
    private String name;

    private String icon;

    @ManyToOne
    @JoinColumn(name = "user_owner_id")
    private User userOwnerId;

    @Enumerated
    @NotNull
    private MediaType mediaType;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Set<Media> mediaSet = new HashSet<>();


    @Column(name = "persist_date", nullable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @UpdateTimestamp
    private LocalDateTime lastRedactionDate;


    public boolean addMedia(Media media) {
        if (media.getMediaType() != mediaType) {
            throw new ApiRequestException(String.format(
                    "У экземпляра Album, связанного с %s, " +
                            "после MediaType должно принимать значение %s",
                    mediaType.name(), mediaType.toString()));
        }
        return mediaSet.add(media);
    }

    public boolean removeMedia(Media media){
        return mediaSet.remove(media);
    }
}
