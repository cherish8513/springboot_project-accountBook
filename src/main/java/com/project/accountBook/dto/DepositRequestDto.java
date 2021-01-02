package com.project.accountBook.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DepositRequestDto {
    private Long money;
    private String email;

    @Builder
    public DepositRequestDto(Long money, String email) {
        this.money = money;
        this.email = email;
    }
}
