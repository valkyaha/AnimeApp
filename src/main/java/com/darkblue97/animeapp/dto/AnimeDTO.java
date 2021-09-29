package com.darkblue97.animeapp.dto;

import com.darkblue97.animeapp.domain.Genre;
import com.darkblue97.animeapp.domain.Studio;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnimeDTO {
    private UUID id;
    @NotNull
    private String japaneseName;
    @NotNull
    private Byte qualification;
    @NotNull
    private boolean seen;
    @NotNull
    private boolean pending;
    @NotNull
    private LocalDateTime dateAdded;
    @NotNull
    private LocalDateTime dateUpdated;
    private LocalDateTime dateStarted;
    private LocalDateTime dateFinished;
    @NotNull
    private Studio studio;
    @NotNull
    private List<Genre> genres;
}
