package com.project.accountBook.controller;

import com.project.accountBook.dto.*;
import com.project.accountBook.service.MyAccountBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class AccountBookController {

    private final MyAccountBookService accountBookService;
    private final HttpSession httpSession;

    @PostMapping("/api/accountBook")
    public Long save(@RequestBody SaveRequestDto requestDto) {
        return accountBookService.save(requestDto);
    }

    @PutMapping("/api/deposit")
    public Long deposit(@RequestBody DepositRequestDto requestDto) {
        return accountBookService.deposit(requestDto);
    }

    @PutMapping("/api/withdraw")
    public Long withdraw(@RequestBody WithdrawRequestDto requestDto) {
        return accountBookService.withdraw(requestDto);
    }

    @PutMapping("/api/login/deposit")
    public Long login_deposit(@RequestBody DepositRequestDto requestDto) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        requestDto.setEmail(user.getEmail());
        return accountBookService.deposit(requestDto);
    }

    @PutMapping("/api/login/withdraw")
    public Long login_withdraw(@RequestBody WithdrawRequestDto requestDto) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        requestDto.setEmail(user.getEmail());
        return accountBookService.withdraw(requestDto);
    }

}
