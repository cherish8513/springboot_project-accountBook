package com.project.accountBook.repository.accountBook;

import com.project.accountBook.domain.AccountBook;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaAccountBookRepository implements AccountBookRepository{

    private final EntityManager em;

    @Override
    public AccountBook save(AccountBook accountBook) {
        em.persist(accountBook);
        return accountBook;
    }

    @Override
    public Optional<AccountBook> findById(Long id) {
        AccountBook accountBook = em.find(AccountBook.class, id);
        return Optional.ofNullable(accountBook);
    }

    @Override
    public List<AccountBook> findAll() {
        return em.createQuery("select a from AccountBook a", AccountBook.class)
                .getResultList();
    }

    @Override
    public Optional<AccountBook> findByEmail(String email) {
        AccountBook accountBook = em.find(AccountBook.class, email);
        return Optional.ofNullable(accountBook);
    }

    @Override
    public List<AccountBook> findAllDescByEmail(String email) {
        return em.createQuery("SELECT a FROM AccountBook a WHERE a.email = email ORDER BY a.createdDate DESC", AccountBook.class)
                .getResultList();
    }
}
