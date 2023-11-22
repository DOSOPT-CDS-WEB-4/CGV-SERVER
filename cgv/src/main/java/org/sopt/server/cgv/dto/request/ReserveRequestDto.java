package org.sopt.server.cgv.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReserveRequestDto (
        @JsonProperty("schedule_id")
        Long id
) {}
