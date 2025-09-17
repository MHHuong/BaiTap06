package vn.host.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.host.entity.Category;
import vn.host.repository.CategoryRepository;
import vn.host.service.CategoryService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repo;

    @Override public List<Category> findAll() { return repo.findAll(); }

    @Override public Page<Category> findAll(Pageable pageable) { return repo.findAll(pageable); }

    @Override public Page<Category> search(String keyword, Pageable pageable) {
        if (keyword == null || keyword.isBlank()) return repo.findAll(pageable);
        return repo.findByCategoryNameContainingIgnoreCase(keyword, pageable);
    }

    @Override public List<Category> search(String keyword) {
        if (keyword == null || keyword.isBlank()) return repo.findAll();
        return repo.findByCategoryNameContainingIgnoreCase(keyword);
    }

    @Override public Category findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override public Category save(Category c) { return repo.save(c); }

    @Override public void deleteById(Integer id) { repo.deleteById(id);
    }
}