package com.darkblue97.animeapp.utils;

import java.util.UUID;
import java.util.regex.Pattern;

public class GenerationUUID {

    private GenerationUUID() {
    }

    private static final String REGEX_UUID = "([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})";
    private static final Pattern UUID_REGEX_PATTERN = Pattern.compile(REGEX_UUID);

    public static UUID generate() {
        return UUID.randomUUID();
    }

    public static boolean isUUIDValid(String uuid) {
        if (uuid == null) {
            return false;
        }
        return UUID_REGEX_PATTERN.matcher(uuid).matches();
    }

    public static UUID returnUUIDFrmString(String id) {
        return UUID.fromString(id);
    }
}
