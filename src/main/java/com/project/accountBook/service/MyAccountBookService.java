package com.project.accountBook.service;

import com.project.accountBook.dto.AccountBookListResponseDto;
import com.project.accountBook.dto.DepositRequestDto;
import com.project.accountBook.dto.SaveRequestDto;
import com.project.accountBook.dto.WithdrawRequestDto;

import java.util.List;

public interface MyAccountBookService {
    public Long save(SaveRequestDto requestDto);

    public Long deposit(DepositRequestDto requestDto);

    public Long withdraw(WithdrawRequestDto requestDto);

    public List<AccountBookListResponseDto> lookUp(String email);
}
