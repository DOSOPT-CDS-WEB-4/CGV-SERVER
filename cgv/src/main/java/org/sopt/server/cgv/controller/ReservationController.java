package org.sopt.server.cgv.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Movie;
import org.sopt.server.cgv.domain.Region;
import org.sopt.server.cgv.dto.response.MovieInfoResponseDto;
import org.sopt.server.cgv.dto.response.MovieScreenScheduleResponseDto;
import org.sopt.server.cgv.dto.response.QuickReservationResponseDto;
import org.sopt.server.cgv.global.response.ApiResponse;
import org.sopt.server.cgv.global.response.SuccessType;
import org.sopt.server.cgv.service.MovieService;
import org.sopt.server.cgv.service.RegionService;
import org.sopt.server.cgv.service.ScheduleService;
import org.sopt.server.cgv.service.ScreenService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final MovieService movieService;
    private final RegionService regionService;
    private final ScreenService screenService;
    private final ScheduleService scheduleService;

    @GetMapping("/{movieId}")
    public ApiResponse<QuickReservationResponseDto> registerReservation(@PathVariable Long movieId,
                                                                        @RequestParam(value = "region") String regionName,
                                                                        @RequestParam(value = "date", required = false) LocalDate date,
                                                                        @RequestParam(value = "type", required = false) List<String> screenTypes) {
        Movie movie = movieService.getMovieInfo(movieId);
        MovieInfoResponseDto movieInfo = MovieInfoResponseDto.of(movie);
        Region region = regionService.getRegionInfo(regionName);
        List<Long> screenIdList = screenService.getScreenIdList(movieId, region.getId(), screenTypes);
        if (date == null) {
            date = LocalDate.now();
        }
        List<MovieScreenScheduleResponseDto> movieScreenSchedules = scheduleService.getMovieScreenScheduleInfo(screenIdList, movie.getRunningTime(), date);
        return ApiResponse.success(SuccessType.GET_MOVIE_AND_SCREEN_TYPE_AND_SCHEDULE_LIST_SUCCESS, QuickReservationResponseDto.of(
                movieInfo, region, movieScreenSchedules));
    }
}
