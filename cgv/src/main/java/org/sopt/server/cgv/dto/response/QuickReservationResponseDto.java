package org.sopt.server.cgv.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.sopt.server.cgv.domain.*;

import java.util.Arrays;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record QuickReservationResponseDto(
        MovieInfoResponseDto movieInfo,
        List<RegionName> regionNames,
        RegionName currentRegion,
        List<ScreenType> screenTypes,
        List<MovieScreenScheduleResponseDto> movieScreenSchedules
) {
    public static QuickReservationResponseDto of(MovieInfoResponseDto movieInfo, Region region, List<MovieScreenScheduleResponseDto> movieScreenSchedules) {
        return new QuickReservationResponseDto(
                movieInfo,
                Arrays.stream(RegionName.values()).toList(),
                region.getRegionName(),
                Arrays.stream(ScreenType.values()).toList(),
                movieScreenSchedules
        );
    }
}
