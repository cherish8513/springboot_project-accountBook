package com.project.accountBook.repository;

import com.project.accountBook.domain.User_Redis;
import com.project.accountBook.repository.accountBook.AccountBookRepository;
import com.project.accountBook.repository.user.RedisUserRepository;
import com.project.accountBook.repository.user.SpringDataJpaUserRepository;
import com.project.accountBook.repository.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Transactional
@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    RedisUserRepository repository;


    @Test
    @DisplayName("Redis를 이용하여 데이터를 저장")
    public void 저장() {
        // given
        User_Redis user = User_Redis.builder()
                .email("good@morning")
                .balance(0L)
                .build();

        // when
        User_Redis savedUser = repository.save(user);

        // then
        Optional<User_Redis> findUser = repository.findById(savedUser.getId());

        assertThat(findUser.isPresent()).isEqualTo(Boolean.TRUE);
        assertThat(findUser.get().getEmail()).isEqualTo(user.getEmail());
    }
}
