package org.sopt.server.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Region;
import org.sopt.server.cgv.domain.RegionName;
import org.sopt.server.cgv.global.exception.CommonException;
import org.sopt.server.cgv.global.response.ErrorType;
import org.sopt.server.cgv.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionService {

    private final RegionRepository regionRepository;

    public Region getRegionInfo(String region) {
        try {
            return regionRepository.findByRegionNameOrThrow(RegionName.valueOf(region));
        } catch (IllegalArgumentException e) {
            throw new CommonException(ErrorType.NOT_FOUND_REGION_ERROR);
        }
    }
}
