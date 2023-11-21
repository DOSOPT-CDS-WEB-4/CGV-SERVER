package org.sopt.server.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Schedule;
import org.sopt.server.cgv.dto.request.ReserveRequestDto;
import org.sopt.server.cgv.dto.response.ReserveResponseDto;
import org.sopt.server.cgv.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ReserveResponseDto reserveSchedule(ReserveRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findByIdOrThrow(requestDto.id());
        schedule.updateSeats();
        return ReserveResponseDto.of(schedule);
    }

}
