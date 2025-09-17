package vn.host.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.host.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByCategoryNameContainingIgnoreCase(String name);
    Page<Category> findByCategoryNameContainingIgnoreCase(String name, Pageable pageable);
}