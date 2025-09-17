package vn.host.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.host.entity.Video;
import vn.host.repository.VideoRepository;
import vn.host.service.VideoService;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository repo;
    @Override public Page<Video> search(String kw, Pageable p){ return (kw==null||kw.isBlank())?repo.findAll(p):repo.findByTitleContainingIgnoreCase(kw,p); }
    @Override public Page<Video> findAll(Pageable p){ return repo.findAll(p); }
    @Override public Video findById(Long id){ return repo.findById(id).orElse(null); }
    @Override public Video save(Video v){ return repo.save(v); }
    @Override public void deleteById(Long id){ repo.deleteById(id); }
}