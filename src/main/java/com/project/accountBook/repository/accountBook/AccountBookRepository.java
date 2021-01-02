package com.project.accountBook.repository.accountBook;

import com.project.accountBook.domain.AccountBook;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountBookRepository {

    public AccountBook save(AccountBook accountBook);

    public Optional<AccountBook> findById(Long id);

    public List<AccountBook> findAll();

    public Optional<AccountBook> findByEmail(String email);

    public List<AccountBook> findAllDescByEmail(String email);
}


