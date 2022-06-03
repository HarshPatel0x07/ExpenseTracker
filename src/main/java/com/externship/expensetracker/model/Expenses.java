package com.externship.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "expense_id")
    int id;
    int amount;
    long user;
    @Column(columnDefinition = "date")
    Date date;
    String category;
}
