package org.sopt.server.cgv.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    @Column(name = "region_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private Double distance;

    @OneToMany(mappedBy = "region")
    List<Screen> screenList = new ArrayList<>();
}
