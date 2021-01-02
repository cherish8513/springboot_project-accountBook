package com.project.accountBook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WithdrawRequestDto {
    private Long money;
    private String email;

    @Builder
    public WithdrawRequestDto(Long money, String email) {
        this.money = money;
        this.email = email;
    }

    @Builder
    public WithdrawRequestDto(Long money) {
        this.money = money;
    }
}
