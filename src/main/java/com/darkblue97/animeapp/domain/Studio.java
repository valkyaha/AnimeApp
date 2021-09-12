package com.darkblue97.animeapp.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "studio")
public class Studio {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Anime> animes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Studio studio = (Studio) o;
        return Objects.equals(id, studio.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
