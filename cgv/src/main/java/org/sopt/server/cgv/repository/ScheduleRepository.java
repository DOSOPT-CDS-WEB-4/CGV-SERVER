package org.sopt.server.cgv.repository;

import org.sopt.server.cgv.domain.Schedule;
import org.sopt.server.cgv.global.exception.CommonException;
import org.sopt.server.cgv.global.response.ErrorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new CommonException(ErrorType.NOT_FOUND_SCHEDULE_ERROR));
    }
    
}
