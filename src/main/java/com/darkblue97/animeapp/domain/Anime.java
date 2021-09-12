package com.darkblue97.animeapp.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String japaneseName;
    private Byte qualification;

    @Column(nullable = false)
    private boolean seen;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime dateAdded;

    @Column(nullable = false, updatable = false)
    @LastModifiedDate
    private LocalDateTime dateUpdated;

    @Column(nullable = false)
    private LocalDateTime dateStarted;

    @Column(nullable = false)
    private LocalDateTime dateFinished;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    @ToString.Exclude
    private Studio studio;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "animeSet")
    @ToString.Exclude
    private Set<Genre> genres = new HashSet<>();


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
