package com.userfront.controller;

import com.userfront.domain.*;
import com.userfront.service.AccountService;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/incomeDetails", method = RequestMethod.GET)
    public String incomeDetails(Model model, Principal principal) {
        List<Income> incomeList = transactionService.findIncomeList(principal.getName());

        User user = userService.findByUsername(principal.getName());
        Account account = user.getAccount();

        model.addAttribute("account", account);
        model.addAttribute("incomeList", incomeList);

        return "incomeDetails";
    }

    @RequestMapping(value = "/costDetails", method = RequestMethod.GET)
    public String costDetails(Model model, Principal principal) {
        List<Cost> costList = transactionService.findCostList(principal.getName());

        User user = userService.findByUsername(principal.getName());
        Account account = user.getAccount();

        model.addAttribute("account", account);
        model.addAttribute("costList", costList);

        return "costDetails";
    }


    @RequestMapping(value = "/savingsAccount", method = RequestMethod.GET)
    public String savingsAccount(Model model, Principal principal) {
        List<Cost> costList = transactionService.findCostList(principal.getName());

        User user = userService.findByUsername(principal.getName());
        Account account = user.getAccount();

        model.addAttribute("account", account);
        model.addAttribute("costList", costList);

        return "account";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String deposit(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositPOST(@ModelAttribute("description") String description, @ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
        accountService.deposit(description, accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawPOST(@ModelAttribute("description") String description, @ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
        accountService.withdraw(accountType, accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }
}
