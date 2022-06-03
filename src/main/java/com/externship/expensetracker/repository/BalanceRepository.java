package com.externship.expensetracker.repository;

import com.externship.expensetracker.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, String> {

    @Query(value = "select sum(amount) from balance where user = :user", nativeQuery = true)
    int getNetBalanceOf(@Param("user") Long user);
}

