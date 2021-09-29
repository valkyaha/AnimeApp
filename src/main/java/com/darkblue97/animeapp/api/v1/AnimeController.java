package com.darkblue97.animeapp.api.v1;

import com.darkblue97.animeapp.api.ApiVersion;
import com.darkblue97.animeapp.service.AnimeService;
import com.darkblue97.animeapp.utils.response.ResponseEntityBuilderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping(ApiVersion.VERSION_1 + "/anime/{uuid}")
    public String getAnime(@PathVariable(name = "uuid") String uuid) {
        return "API_VERSION.API_V1.toString()";
    }

    @PostMapping(ApiVersion.VERSION_1 + "/anime")
    public ResponseEntity<Object> publishAnime() {
        return new ResponseEntityBuilderResponse<>()
                .setObjectResponse("")
                .setStatus(HttpStatus.OK)
                .build();
    }

    @GetMapping(ApiVersion.VERSION_1 + "/anime")
    public ResponseEntity<Object> getAllAnime(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {

        animeService.getAllAnime(pageNo, pageSize, sortBy);

        return new ResponseEntityBuilderResponse<>()
                .setObjectResponse("")
                .setStatus(HttpStatus.OK)
                .build();
    }

    @PutMapping(ApiVersion.VERSION_1 + "/anime/{uuid}")
    public ResponseEntity<Object> updateAnime(@PathVariable String uuid) {
        return new ResponseEntityBuilderResponse<>()
                .setObjectResponse("")
                .setStatus(HttpStatus.OK)
                .build();
    }
}
