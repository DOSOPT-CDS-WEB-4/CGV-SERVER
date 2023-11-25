package org.sopt.server.cgv.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.dto.response.MovieListResponseDto;
import org.sopt.server.cgv.global.response.ApiResponse;
import org.sopt.server.cgv.global.response.SuccessType;
import org.sopt.server.cgv.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ApiResponse<List<MovieListResponseDto>> getMovieList() {
        return ApiResponse.success(SuccessType.GET_MOVIE_LIST_SUCCESS, movieService.getMovieList());
    }

    @GetMapping("/like/{movieId}")
    public ApiResponse<?> applyLike(@PathVariable Long movieId) {
        return movieService.applyLike(movieId) ? ApiResponse.success(SuccessType.MOVIE_DISLIKE_SUCCESS) : ApiResponse.success(SuccessType.MOVIE_LIKE_SUCCESS);
    }

}
