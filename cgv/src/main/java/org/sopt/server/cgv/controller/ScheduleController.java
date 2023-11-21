package org.sopt.server.cgv.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.dto.request.ReserveRequestDto;
import org.sopt.server.cgv.dto.response.ReserveResponseDto;
import org.sopt.server.cgv.global.response.ApiResponse;
import org.sopt.server.cgv.global.response.SuccessType;
import org.sopt.server.cgv.service.RegionService;
import org.sopt.server.cgv.service.ScheduleService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PatchMapping("/reserve")
    public ApiResponse<ReserveResponseDto> reserveSchedule(@RequestBody ReserveRequestDto requestDto) {
        return ApiResponse.success(SuccessType.PATCH_RESERVE_SUCCESS, scheduleService.reserveSchedule(requestDto));
    }

}
