package org.sopt.server.cgv.repository;

import org.sopt.server.cgv.domain.Region;
import org.sopt.server.cgv.domain.RegionName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByRegionName(RegionName regionName);

    default Region findByRegionNameOrThrow(RegionName regionName) {
        return findByRegionName(regionName).orElseThrow(
                () -> new IllegalStateException());
    }
}
