package com.QuizApp.Start.Controller;

import com.QuizApp.Start.Entity.AccountEntity;
import com.QuizApp.Start.Service.AccountService;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountEntity> addAccount (@RequestBody  AccountEntity accountEntity)
    {
        return  new ResponseEntity<>(accountService.Add(accountEntity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountEntity> getAccountById(@PathVariable  Long id)
    {
        AccountEntity accountEntity = accountService.getAccountById(id);
        return ResponseEntity.ok(accountEntity);
    }

    @PutMapping("/{id}/deposit")
    public  ResponseEntity<AccountEntity> depositeBalance(@PathVariable Long id, @RequestBody Map<String,Double> request)
    {
        Double amount = request.get("amount");
        AccountEntity accountEntity = accountService.deposite(id,amount);
        return  ResponseEntity.ok(accountEntity);
    }
    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<AccountEntity>  withdrawBalance(@PathVariable Long id , @RequestBody Map<String,Double> request)
    {
        Double amount = request.get("amount");
        AccountEntity accountEntity = accountService.WithDraw(id,amount);
        return ResponseEntity.ok(accountEntity);
    }
    @GetMapping("/all")
    public  List<AccountEntity> getAllAccounts()
    {
        return accountService.getAllAccounts();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable Long id)
    {
        accountService.deleteById(id);

        return ResponseEntity.ok("This account is deleted");
    }
    }

