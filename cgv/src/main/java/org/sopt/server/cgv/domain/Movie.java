package org.sopt.server.cgv.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String summary;

    @Column(name = "opening_date", nullable = false)
    private LocalDate openingDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Column(name = "running_time", nullable = false)
    private int runningTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Country country;

    @Column(nullable = false)
    private String ranking;

    @Column(name = "total_audience", nullable = false)
    private String totalAudience;

    @Column(name = "like_count", nullable = false)
    private int like;

    @Column(name = "like_able")
    @ColumnDefault(value = "false")
    private boolean likeAble;

    @Column(name = "poster", nullable = false)
    private String posterURL;

    @Column(name = "background")
    private String backgroundURL;

    @OneToMany(mappedBy = "movie")
    List<Screen> screenList = new ArrayList<>();

    public boolean applyLike() {
        like += likeAble ? 1 : -1;
        likeAble = !likeAble;
        return likeAble;
    }

}
