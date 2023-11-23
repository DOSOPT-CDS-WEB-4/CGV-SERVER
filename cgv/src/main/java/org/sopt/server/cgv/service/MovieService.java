package org.sopt.server.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Movie;
import org.sopt.server.cgv.dto.response.MovieListResponseDto;
import org.sopt.server.cgv.global.response.ApiResponse;
import org.sopt.server.cgv.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieListResponseDto> getMovieList() {
        return movieRepository.findAll().stream()
                .map(MovieListResponseDto::of)
                .collect(Collectors.toList());
    }

    public Movie getMovieInfo(Long movieId) {
        return movieRepository.findByIdOrThrow(movieId);
    }

}
