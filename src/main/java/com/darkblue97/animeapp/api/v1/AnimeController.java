package com.darkblue97.animeapp.api.v1;

import com.darkblue97.animeapp.api.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimeController {


    @GetMapping(ApiVersion.VERSION_1 + "/anime/{uuid}")
    public String getAnime(@PathVariable(name = "uuid") String uuid) {
        return "API_VERSION.API_V1.toString()";
    }
}
