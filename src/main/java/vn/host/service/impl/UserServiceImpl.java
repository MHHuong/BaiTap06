package vn.host.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.host.entity.User;
import vn.host.repository.UserRepository;
import vn.host.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    @Override public Page<User> search(String kw, Pageable p){ return (kw==null||kw.isBlank())?repo.findAll(p):repo.findByUsernameContainingIgnoreCase(kw,p); }
    @Override public Page<User> findAll(Pageable p){ return repo.findAll(p); }
    @Override public User findById(Long id){ return repo.findById(id).orElse(null); }
    @Override public User save(User u){ return repo.save(u); }
    @Override public void deleteById(Long id){ repo.deleteById(id); }
}