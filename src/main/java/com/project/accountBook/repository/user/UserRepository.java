package com.project.accountBook.repository.user;

import com.project.accountBook.domain.AccountBook;
import com.project.accountBook.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User save(User user);

    public Optional<User> findById(Long id);

    public List<User> findAll();

    public Optional<User> findByEmail(String email);
}
