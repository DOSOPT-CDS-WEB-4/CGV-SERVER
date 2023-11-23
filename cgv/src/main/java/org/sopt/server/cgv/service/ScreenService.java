package org.sopt.server.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Screen;
import org.sopt.server.cgv.domain.ScreenType;
import org.sopt.server.cgv.global.exception.CommonException;
import org.sopt.server.cgv.global.response.ErrorType;
import org.sopt.server.cgv.repository.ScreenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScreenService {

    private final ScreenRepository screenRepository;

    public List<Long> getScreenIdList(Long movieId, Long regionId, String screenType) {
        if (screenType == null) {
            return filterWhenScreenTypeNotExist(movieId, regionId);
        }
        try {
            return filterWhenScreenTypeExist(movieId, regionId, screenType);
        } catch (IllegalArgumentException e) {
            throw new CommonException(ErrorType.NOT_FOUND_SCREEN_TYPE_ERROR);
        }
    }

    private List<Long> filterWhenScreenTypeExist(Long movieId, Long regionId, String screenType) {
        return screenRepository.findByMovieIdAndRegionIdAndScreenType(movieId, regionId, ScreenType.valueOf(screenType))
                .stream()
                .map(Screen::getId)
                .toList();
    }

    private List<Long> filterWhenScreenTypeNotExist(Long movieId, Long regionId) {
        return screenRepository.findByMovieIdAndRegionId(movieId, regionId)
                .stream()
                .map(Screen::getId)
                .toList();
    }
}
