package com.project.accountBook.repository.user;

import com.project.accountBook.domain.User_Redis;
import org.springframework.data.repository.CrudRepository;

public interface RedisUserRepository extends CrudRepository<User_Redis, Long> {
}
