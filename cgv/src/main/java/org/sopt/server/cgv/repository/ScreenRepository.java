package org.sopt.server.cgv.repository;

import org.sopt.server.cgv.domain.Screen;
import org.sopt.server.cgv.domain.ScreenType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

    List<Screen> findByMovieIdAndRegionIdAndScreenType(Long movieId, Long regionId, ScreenType screenType);

    List<Screen> findByMovieIdAndRegionId(Long movieId, Long regionId);
}
