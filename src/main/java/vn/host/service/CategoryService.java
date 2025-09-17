package vn.host.service;

import org.springframework.data.domain.*;
import vn.host.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    Page<Category> search(String keyword, Pageable pageable);
    List<Category> search(String keyword);
    Category findById(Integer id);
    Category save(Category c);
    void deleteById(Integer id);
}