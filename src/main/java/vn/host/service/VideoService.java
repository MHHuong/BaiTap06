package vn.host.service;

import org.springframework.data.domain.*;
import vn.host.entity.Video;

public interface VideoService {
    Page<Video> search(String keyword, Pageable pageable);
    Page<Video> findAll(Pageable pageable);
    Video findById(Long id);
    Video save(Video v);
    void deleteById(Long id);
}