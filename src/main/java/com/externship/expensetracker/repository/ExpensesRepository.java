package com.externship.expensetracker.repository;

import com.externship.expensetracker.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, String> {

    @Query(value = "select * from expenses where user = :user", nativeQuery = true)
    Iterable<Expenses> getAllEntries(@Param("user") long user);

    @Query(value = "select sum(amount) from expenses where user = :user group by category order by category", nativeQuery = true)
    int[] getCategoryWiseExpenses(@Param("user") long user);

    @Query(value = "select distinct category from expenses where user = :user order by category", nativeQuery = true)
    String[] getAllCategories(@Param("user") long user);

    @Query(value = "select sum(amount) from expenses where user = :user group by month(date)", nativeQuery = true)
    int[] getMonthWiseExpenses(@Param("user") long user);

    @Query(value = "select month(date) from expenses where user = :user group by month(date)", nativeQuery = true)
    String[] getMonths(@Param("user") long user);

    @Query(value = "select sum(amount) from expenses where user = :user group by year(date)", nativeQuery = true)
    int[] getYearWiseExpenses(@Param("user")long user);

    @Query(value = "select year(date) from expenses where user = :user group by year(date)", nativeQuery = true)
    String[] getYears(@Param("user") long user);

    @Query(value = "select sum(amount) from expenses where user = :user and date between curdate()-7 and curdate() group by date order by date", nativeQuery = true)
    int[] getLastWeekExpenses(@Param("user") long user);

    @Query(value = "select date from expenses where user = :user and date between curdate()-7 and curdate() group by date order by date", nativeQuery = true)
    String[] getLastWeekDates(@Param("user") long user);
}

