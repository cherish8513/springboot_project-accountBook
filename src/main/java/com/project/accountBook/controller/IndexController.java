package com.project.accountBook.controller;

import com.project.accountBook.dto.AccountBookListResponseDto;
import com.project.accountBook.dto.SessionUser;
import com.project.accountBook.service.MyAccountBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final MyAccountBookService accountBookService;
    private final HttpSession httpSession;


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

    @GetMapping("/accountBook/login/deposit")
    public String loginAccountBookDeposit(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "accountBook-login-deposit";
    }

    @GetMapping("/accountBook/login/withdraw")
    public String loginAccountBookWithdraw(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "accountBook-login-withdraw";
    }

    @GetMapping("/accountBook/login/lookup")
    public String loginLookUp(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        List<AccountBookListResponseDto> responseDto = accountBookService.lookUp(user.getEmail());
        model.addAttribute("accountBooks", responseDto);
        return "accountBook-login-lookup";
    }

    @GetMapping("/")
    public String index(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userEmail", user.getEmail());
        }
        return "index";
    }
}
