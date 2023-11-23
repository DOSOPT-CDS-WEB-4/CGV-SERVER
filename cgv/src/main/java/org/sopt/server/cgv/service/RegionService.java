package org.sopt.server.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.cgv.domain.Region;
import org.sopt.server.cgv.domain.RegionName;
import org.sopt.server.cgv.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionService {

    private final RegionRepository regionRepository;

    public Region getRegionInfo(String region) {
        return regionRepository.findByRegionNameOrThrow(RegionName.valueOf(region));
    }
}
