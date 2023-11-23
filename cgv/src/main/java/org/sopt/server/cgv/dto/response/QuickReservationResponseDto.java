package org.sopt.server.cgv.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.sopt.server.cgv.domain.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record QuickReservationResponseDto(
        String title,
        String summary,
        LocalDate openingDate,
        Genre genre,
        int runningTime,
        Country country,
        String poster,
        String background,
        List<RegionName> regionNames,
        RegionName currentRegion,
        List<ScreenType> screenTypes,
        List<MovieScreenScheduleResponseDto> movieScreenSchedules
) {
    public static QuickReservationResponseDto of(Movie movie, Region region, List<MovieScreenScheduleResponseDto> movieScreenSchedules) {
        return new QuickReservationResponseDto(
                movie.getTitle(),
                movie.getSummary(),
                movie.getOpeningDate(),
                movie.getGenre(),
                movie.getRunningTime(),
                movie.getCountry(),
                movie.getPosterURL(),
                movie.getBackgroundURL(),
                Arrays.stream(RegionName.values()).toList(),
                region.getRegionName(),
                Arrays.stream(ScreenType.values()).toList(),
                movieScreenSchedules
        );
    }
}
