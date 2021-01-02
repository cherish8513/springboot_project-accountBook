package com.project.accountBook.repository;

import com.project.accountBook.domain.AccountBook;
import com.project.accountBook.repository.accountBook.AccountBookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Transactional
@SpringBootTest
@Commit
public class JpaRepositoryTest {

    @Autowired
    AccountBookRepository accountBookRepository;

    @Test
    @DisplayName("JPA를 사용하여 데이터저장")
    public void work(){
        Long balance = 10000L;
        //given
        AccountBook accountBook = AccountBook.builder()
                .email("cherish85132naver.com")
                .money(balance.toString())
                .build();
        //when
        accountBookRepository.save(accountBook);
        
        //then
        List<AccountBook> all = accountBookRepository.findAll();
        assertThat(all.get(0).getMoney()).isEqualTo(balance);
    }

    @Test
    @DisplayName("JPA Auditing 테스트")
    public void JPA_AUDITING_테스트(){
        Long money = 1000L;
        //given
        LocalDateTime now = LocalDateTime.of(2021,1,1,0,0,0);
        accountBookRepository.save(AccountBook.builder()
                .email("cherish8513@naver.com")
                .money(money.toString())
                .build());
        //when
        List<AccountBook> all = accountBookRepository.findAll();

        //then
        AccountBook accountBook = all.get(0);

        System.out.println("createdTime = " + accountBook.getCreatedDate() + " ModifiedDate = " + accountBook.getModifiedDate());

        assertThat(accountBook.getCreatedDate()).isAfter(now);
        assertThat(accountBook.getModifiedDate()).isAfter(now);
    }

}
