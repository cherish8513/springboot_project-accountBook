package com.project.accountBook.repository.accountBook;

import com.project.accountBook.domain.AccountBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaAccountBookRepository extends JpaRepository<AccountBook, Long>, AccountBookRepository {

    @Override
    Optional<AccountBook> findByEmail(String email);

    @Override
    List<AccountBook> findAllDescByEmail(String email);
}
