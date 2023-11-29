package org.sopt.server.cgv.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.sopt.server.cgv.domain.*;

import java.util.Arrays;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record QuickReservationResponseDto(
        MovieInfoResponseDto movieInfo,
        List<String> regionNames,
        String currentRegion,
        Double distance,
        List<String> screenTypes,
        List<MovieScreenScheduleResponseDto> movieScreenSchedules
) {
    public static QuickReservationResponseDto of(MovieInfoResponseDto movieInfo, Region region, List<MovieScreenScheduleResponseDto> movieScreenSchedules) {
        return new QuickReservationResponseDto(
                movieInfo,
                Arrays.stream(RegionName.values())
                        .map(RegionName::getName)
                        .toList(),
                region.getRegionName().getName(),
                region.getDistance(),
                Arrays.stream(ScreenType.values())
                        .map(ScreenType::getName)
                        .toList(),
                movieScreenSchedules
        );
    }
}
