package org.sopt.server.cgv.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.sopt.server.cgv.domain.Schedule;
import org.sopt.server.cgv.domain.ScreenType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MovieScreenScheduleResponseDto(
        Long scheduleId,
        String screenType,
        String place,
        String date,
        String startTime,
        String endTime,
        int totalSeats,
        int emptySeats,
        boolean reservationAvailability
) {
    public static MovieScreenScheduleResponseDto of(Schedule schedule, LocalDateTime endTime, boolean reservationAvailability) {
        return new MovieScreenScheduleResponseDto(
                schedule.getId(),
                schedule.getScreen().getScreenType().getName(),
                schedule.getScreen().getPlace(),
                schedule.getStartTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                schedule.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                endTime.format(DateTimeFormatter.ofPattern("HH:mm")),
                schedule.getTotalSeats(),
                schedule.getEmptySeats(),
                reservationAvailability
        );
    }
}
