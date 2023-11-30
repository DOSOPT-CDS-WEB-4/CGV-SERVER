package org.sopt.server.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Schedule;
import org.sopt.server.cgv.dto.request.ReserveRequestDto;
import org.sopt.server.cgv.dto.response.MovieScreenScheduleResponseDto;
import org.sopt.server.cgv.dto.response.ReserveResponseDto;
import org.sopt.server.cgv.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private static final int HOUR = 60;

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ReserveResponseDto reserveSchedule(ReserveRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findByIdOrThrow(requestDto.id());
        schedule.updateSeats(2);
        return ReserveResponseDto.of(schedule);
    }

    public List<MovieScreenScheduleResponseDto> getMovieScreenScheduleInfo(List<Long> screenIdList, int runningTime) {
        return scheduleRepository.findByScreenIdIn(screenIdList)
                .stream()
                .filter(schedule -> isScheduleInWeek(schedule.getStartTime().toLocalDate()))
                .map(schedule -> createResponseDto(schedule, runningTime)).toList();
    }

    private boolean isScheduleInWeek(LocalDate date) {
        return !date.isBefore(LocalDate.now()) && !date.isAfter(LocalDate.now().plusDays(7));
    }

    private MovieScreenScheduleResponseDto createResponseDto(Schedule schedule, int runningTime) {
        LocalDateTime endTime = calculateEndTime(schedule.getStartTime(), runningTime);
        boolean isPast = schedule.getStartTime().isBefore(LocalDateTime.now());
        return MovieScreenScheduleResponseDto.of(schedule, endTime, isPast);
    }

    private LocalDateTime calculateEndTime(LocalDateTime startTime, int runningTime) {
        return startTime.plusHours(runningTime / HOUR).plusMinutes(runningTime % HOUR);
    }

}
