package org.sopt.server.cgv.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.sopt.server.cgv.domain.*;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MovieInfoResponseDto(
        String title,
        String summary,
        LocalDate openingDate,
        Genre genre,
        int runningTime,
        Country country,
        String poster,
        String background
) {
    public static MovieInfoResponseDto of(Movie movie) {
        return new MovieInfoResponseDto(
                movie.getTitle(),
                movie.getSummary(),
                movie.getOpeningDate(),
                movie.getGenre(),
                movie.getRunningTime(),
                movie.getCountry(),
                movie.getPosterURL(),
                movie.getBackgroundURL()
        );
    }
}
