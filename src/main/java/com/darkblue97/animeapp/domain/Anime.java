package com.darkblue97.animeapp.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animes")
public class Anime {
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String japaneseName;
    private Byte qualification;

    @Column(nullable = false)
    private boolean seen;

    @Column(nullable = false)
    private boolean pending;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime dateAdded;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime dateUpdated;
    private LocalDateTime dateStarted;
    private LocalDateTime dateFinished;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(name = "animes_genres",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id"))
    @ToString.Exclude
    private List<Genre> genres;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    @ToString.Exclude
    private Studio studio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Anime anime = (Anime) o;
        return Objects.equals(id, anime.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
