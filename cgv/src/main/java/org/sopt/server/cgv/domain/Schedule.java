package org.sopt.server.cgv.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.server.cgv.global.exception.CommonException;
import org.sopt.server.cgv.global.response.ErrorType;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "total_seats", nullable = false)
    private int totalSeats;

    @Column(name = "empty_seats", nullable = false)
    private int emptySeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    public void updateSeats(int seats) {
        if(this.emptySeats < 2) {
            throw new CommonException(ErrorType.NO_SEAT_SCHEDULE_ERROR);
        } else {
            this.emptySeats -= seats;
        }
    }
}
