package com.example.demo.app;

import com.example.demo.domain.model.dto.AccountRequest;
import com.example.demo.domain.model.entity.Account;
import com.example.demo.domain.model.entity.Store;
import com.example.demo.domain.service.AccountService;
import com.example.demo.domain.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public String getAccount(Model model) {
        model.addAttribute("accRequest", new AccountRequest());
        return "account.html";
    }

    @PostMapping("/account")
    public String postAccount(Model model, @ModelAttribute("accRequest") AccountRequest accRequest) {
        accountService.save(accRequest);
        return "redirect:/accountList";
    }

    @GetMapping("/accountList")
    public String getAccountList(Model model) {
        List<Account> accounts = accountService.findAll();
        AccountRequest accRequest = new AccountRequest();
        model.addAttribute("accountReq", accRequest);
        model.addAttribute("accounts", accounts);
        return "accountOutput.html";
    }

    @PostMapping("/accountList")
    public String postAccountList(Model model, @ModelAttribute("accountReq") AccountRequest accRequest) {
        System.out.println(accRequest.getIdx());
        accountService.deleteByIdx(accRequest.getIdx());
        return "redirect:/accountList";
    }

    @GetMapping("/accountUpdate")
    public String getAccountUpdate(Model model,
                                   @RequestParam Map<String, Object> params) {
        long idx = Long.parseLong(params.get("idx").toString());
        Account account = accountService.findByIdx(idx);
        model.addAttribute("accountRequest", new AccountRequest());
        model.addAttribute("account", account);
        return "accountUpdate.html";
    }

    @PostMapping("/accountUpdate")
    public String postAccountUpdate(Model model, @ModelAttribute("accountRequest") AccountRequest accRequest) {
        accountService.save(accRequest);
        return "redirect:/accountList";
    }
}
