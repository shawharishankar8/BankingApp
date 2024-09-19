package com.QuizApp.Start.Service;

import com.QuizApp.Start.Entity.AccountEntity;
import com.QuizApp.Start.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    // Add the dependecies

    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }


    //creates a new user id

    @Override
    public AccountEntity Add(AccountEntity accountEntity) {
        return accountRepo.save(accountEntity);
    }

    // searches through database for the id
    @Override
    public AccountEntity getAccountById(Long id) {
        return accountRepo.findById(id).orElseThrow(()->new RuntimeException("This id does not exist"));
    }

    @Override
    public AccountEntity deposite(Long id, Double balance) {
        //check if the account is present or not
        AccountEntity  accountEntity=  accountRepo.findById(id).orElseThrow(()-> new RuntimeException("wrong id"));

        double v = accountEntity.getBalance() + balance;
        accountEntity.setBalance(v);

        return  accountRepo.save(accountEntity);


    }

    @Override
    public AccountEntity WithDraw(Long id, Double amount) {

        //check if the account is present or not

        AccountEntity accountEntity = accountRepo.findById(id).orElseThrow(()->new RuntimeException("Wrong id"));

        //check for insufficient balance

        if(accountEntity.getBalance()< amount)
        {
            throw  new RuntimeException("Not sufficient balance");
        }

        double newAmount = accountEntity.getBalance() - amount;
        accountEntity.setBalance(newAmount);

        return accountRepo.save(accountEntity);
    }

    @Override
    public List<AccountEntity> getAllAccounts() {


        return   accountRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        AccountEntity accountEntity = accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Wrong id"));

        accountRepo.deleteById(id);
    }
}
