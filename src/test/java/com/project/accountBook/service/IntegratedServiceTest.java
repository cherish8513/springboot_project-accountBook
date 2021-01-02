package com.project.accountBook.service;

import com.project.accountBook.dto.DepositRequestDto;
import com.project.accountBook.dto.SaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Transactional
@SpringBootTest
public class IntegratedServiceTest {

    @Autowired MyAccountBookService service;


    @Test
    @DisplayName("외부에서 서비스의 save 테스트")
    public void 서비스_save(){
        Long money = 20000L;
        //given
        SaveRequestDto requestDto = SaveRequestDto.builder()
                .email("cherish8513@naver.com")
                .balance(money)
                .build();
        //when
        service.save(requestDto);

        //then
    }

    @Test
    @DisplayName("외부에서 서비스의 deposit 테스트")
    public void 서비스_deposit(){

        Long money = 20000L;
        //given
        DepositRequestDto requestDto = DepositRequestDto.builder()
                .email("hyacinth8513@naver.com")
                .money(money)
                .build();

        //when
        service.deposit(requestDto);

        //then
        System.out.println("balance = " + service.lookUp("cherish8513@naver.com"));
    }
}
