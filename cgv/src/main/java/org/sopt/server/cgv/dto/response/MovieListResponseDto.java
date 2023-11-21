package org.sopt.server.cgv.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.sopt.server.cgv.domain.Movie;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MovieListResponseDto(
        Long movieId,
        String title,
        String posterUrl,
        String ranking,
        String totalAudience,
        int likeCount
) {
    public static MovieListResponseDto of(Movie movie) {
        return new MovieListResponseDto(
                movie.getId(),
                movie.getTitle(),
                movie.getPosterURL(),
                movie.getRanking(),
                movie.getTotalAudience(),
                movie.getLike()
        );
    }
}
