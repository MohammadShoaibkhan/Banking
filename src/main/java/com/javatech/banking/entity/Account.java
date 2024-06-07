package com.javatech.banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "account")
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @Column( name = "account_holder_name")
    private String accountHolderName;
    private double balance;
}
