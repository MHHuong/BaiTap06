package vn.host.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.host.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Page<Video> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}