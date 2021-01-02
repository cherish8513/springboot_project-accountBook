package com.project.accountBook.service;

import com.project.accountBook.domain.User;
import com.project.accountBook.dto.*;
import com.project.accountBook.repository.accountBook.AccountBookRepository;
import com.project.accountBook.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
@Log4j2
public class MyAccountBookServiceImpl implements MyAccountBookService {

    private final AccountBookRepository accountBookRepository;
    private final UserRepository userRepository;

    @Override
    public Long save(SaveRequestDto requestDto) {
        validateDuplicate(requestDto);
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public Long deposit(DepositRequestDto requestDto) {
        User user = getUser(userRepository.findByEmail(requestDto.getEmail()));
        Long currentBalance = user.deposit(requestDto.getMoney());
        DepositAccountBookRequestDto accountBookRequestDto = DepositAccountBookRequestDto.builder()
                .email(requestDto.getEmail())
                .money(requestDto.getMoney())
                .balance(currentBalance)
                .build();
        accountBookRepository.save(accountBookRequestDto.toEntity());
        return user.getId();
    }

    @Override
    public Long withdraw(WithdrawRequestDto requestDto) {
        User user = getUser(userRepository.findByEmail(requestDto.getEmail()));
        Long currentBalance = user.withdraw(requestDto.getMoney());
        WithdrawAccountBookRequestDto accountBookRequestDto = WithdrawAccountBookRequestDto.builder()
                .email(requestDto.getEmail())
                .money(requestDto.getMoney())
                .balance(currentBalance)
                .build();
        accountBookRepository.save(accountBookRequestDto.toEntity());
        return user.getId();
    }

    @Override
    public List<AccountBookListResponseDto> lookUp(String email) {
        return accountBookRepository.findAllDescByEmail(email).stream()
                .map(AccountBookListResponseDto::new)
                .collect(Collectors.toList());
    }

    private User getUser(Optional<User> byEmail) {
        return byEmail.orElseThrow(() -> new IllegalArgumentException("없는 유저 입니다"));
    }

    private void validateDuplicate(SaveRequestDto requestDto) {
        userRepository.findByEmail(requestDto.getEmail())
                .ifPresent(accountBook -> {
                    throw new IllegalStateException("이미 존재하는 이메일 입니다.");
                });
    }
}
