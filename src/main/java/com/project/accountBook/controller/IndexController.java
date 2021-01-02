package com.project.accountBook.controller;

import com.project.accountBook.dto.AccountBookListResponseDto;
import com.project.accountBook.service.MyAccountBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final MyAccountBookService accountBookService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/accountBook/save")
    public String accountBookSave(){
        return "accountBook-save";
    }

    @GetMapping("/accountBook/deposit")
    public String accountBookDeposit(){
        return "accountBook-deposit";
    }

    @GetMapping("/accountBook/withdraw")
    public String accountBookWithdraw(){
        return "accountBook-withdraw";
    }

    @GetMapping("/accountBook/lookup")
    public String lookUp(@RequestParam(value = "email",required = false)String email, Model model){
        List<AccountBookListResponseDto> responseDto = accountBookService.lookUp(email);
        model.addAttribute("accountBooks", responseDto);
        return "accountBook-lookup";
    }
}
