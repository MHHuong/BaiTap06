package vn.host.service;

import org.springframework.data.domain.*;
import vn.host.entity.User;

public interface UserService {
    Page<User> search(String keyword, Pageable pageable);
    Page<User> findAll(Pageable pageable);
    User findById(Long id);
    User save(User u);
    void deleteById(Long id);
}