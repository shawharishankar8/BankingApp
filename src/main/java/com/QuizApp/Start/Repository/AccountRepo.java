package com.QuizApp.Start.Repository;

import com.QuizApp.Start.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountEntity,Long> {
}
