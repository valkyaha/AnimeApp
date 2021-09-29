package com.darkblue97.animeapp.api.v1;

import com.darkblue97.animeapp.api.ApiVersion;
import com.darkblue97.animeapp.dto.AnimeDTO;
import com.darkblue97.animeapp.exceptions.NotFoundException;
import com.darkblue97.animeapp.service.AnimeService;
import com.darkblue97.animeapp.utils.GenerationUUID;
import com.darkblue97.animeapp.utils.response.ResponseEntityBuilderResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping(ApiVersion.VERSION_1 + "/anime/{uuid}")
    public ResponseEntity<Object> getAnime(@PathVariable(name = "uuid") String uuid) {

        UUID id = null;

        if (GenerationUUID.isUUIDValid(uuid)) {
            id = GenerationUUID.returnUUIDFrmString(uuid);
        }

        try {
            AnimeDTO animeDTO = animeService.getAnime(id);

            return new ResponseEntityBuilderResponse<>()
                    .setObjectResponse(animeDTO)
                    .setStatus(HttpStatus.OK)
                    .build();
        } catch (NotFoundException e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(e.getLocalizedMessage())
                    .setStatus(HttpStatus.NOT_FOUND)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(e.getLocalizedMessage())
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping(ApiVersion.VERSION_1 + "/anime")
    public ResponseEntity<Object> publishAnime(@RequestBody AnimeDTO dto) {

        try {
            animeService.saveAnime(dto);
            return new ResponseEntityBuilderResponse<>()
                    .setMessage("Saved successfully")
                    .setStatus(HttpStatus.OK)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(e.getLocalizedMessage())
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping(ApiVersion.VERSION_1 + "/anime")
    public ResponseEntity<Object> getAllAnime(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {

        try {
            Page<AnimeDTO> animeDTOPage = animeService.getAllAnime(pageNo, pageSize, sortBy);
            return new ResponseEntityBuilderResponse<>()
                    .setObjectResponse(animeDTOPage)
                    .setStatus(HttpStatus.OK)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(e.getLocalizedMessage())
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping(ApiVersion.VERSION_1 + "/anime/")
    public ResponseEntity<Object> updateAnime(@RequestBody AnimeDTO toUpdate) {

        try {
            AnimeDTO animeDTO = animeService.updateAnime(toUpdate);

            return new ResponseEntityBuilderResponse<>()
                    .setObjectResponse(animeDTO)
                    .setStatus(HttpStatus.OK)
                    .build();
        } catch (NotFoundException e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(e.getLocalizedMessage())
                    .setStatus(HttpStatus.NOT_FOUND)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(e.getLocalizedMessage())
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}