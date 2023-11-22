package org.sopt.server.cgv.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.sopt.server.cgv.domain.Schedule;
import org.sopt.server.cgv.dto.request.ReserveRequestDto;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ReserveResponseDto(
        Long schedule_id,
        String movieTitle,
        int emptySeats
) {
    public static ReserveResponseDto of(Schedule schedule) {
        return new ReserveResponseDto(
                schedule.getId(),
                schedule.getScreen().getMovie().getTitle(),
                schedule.getEmptySeats()
        );
    }
}
