package org.sopt.server.cgv.repository;

import org.sopt.server.cgv.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    default Movie findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new IllegalStateException());
    }
}
