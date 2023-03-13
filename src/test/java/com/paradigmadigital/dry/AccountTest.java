package com.paradigmadigital.dry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void testPositiveBalance() {
        account.debit(50);
        account.credit(20);

        assertThat(account.getBalance()).isEqualTo(30);
    }

    @Test
    void testTransactionsTotal() {
        account.debit(5);
        account.debit(20);
        account.credit(10);

        assertThat(account.getTransactionsTotal()).isEqualTo(15);
    }

    @Test
    void getLastTransactionDate() {
        account.debit(50);

        assertThat(account.getLastTransactionDate()).isNotNull();
    }

}