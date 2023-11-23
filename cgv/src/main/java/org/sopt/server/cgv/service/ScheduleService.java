package org.sopt.server.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Schedule;
import org.sopt.server.cgv.dto.request.ReserveRequestDto;
import org.sopt.server.cgv.dto.response.MovieScreenScheduleResponseDto;
import org.sopt.server.cgv.dto.response.ReserveResponseDto;
import org.sopt.server.cgv.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        List<Schedule> schedules = scheduleRepository.findByScreenIdIn(screenIdList);
        return schedules.stream()
                .map(schedule -> MovieScreenScheduleResponseDto.of(
                        schedule,
                        schedule.getStartTime().plusHours(runningTime / HOUR).plusMinutes(runningTime % HOUR),
                        schedule.getStartTime().isBefore(LocalDateTime.now())
                )).toList();
    }

}
