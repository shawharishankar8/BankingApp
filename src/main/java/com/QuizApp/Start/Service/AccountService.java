package com.QuizApp.Start.Service;

import com.QuizApp.Start.Entity.AccountEntity;

import java.util.List;

public interface AccountService {
    AccountEntity Add(AccountEntity accountEntity);

    AccountEntity getAccountById(Long id);

    AccountEntity deposite (Long id , Double balance);

    AccountEntity WithDraw(Long id , Double balance);

    List<AccountEntity> getAllAccounts();

    void deleteById(Long id );
}
