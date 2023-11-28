package org.sopt.server.cgv.dto.response;

import org.sopt.server.cgv.domain.Schedule;
import org.sopt.server.cgv.domain.ScreenType;

import java.time.LocalDateTime;

public record MovieScreenScheduleResponseDto(
        Long scheduleId,
        ScreenType screenType,
        String place,
        LocalDateTime startTime,
        LocalDateTime endTime,
        int totalSeats,
        int emptySeats,
        boolean reservationAvailability
) {
    public static MovieScreenScheduleResponseDto of(Schedule schedule, LocalDateTime endTime, boolean reservationAvailability) {
        return new MovieScreenScheduleResponseDto(
                schedule.getId(),
                schedule.getScreen().getScreenType(),
                schedule.getScreen().getPlace(),
                schedule.getStartTime(),
                endTime,
                schedule.getTotalSeats(),
                schedule.getEmptySeats(),
                reservationAvailability
        );
    }
}
