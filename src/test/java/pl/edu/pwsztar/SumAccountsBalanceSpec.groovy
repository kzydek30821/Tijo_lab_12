package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class SumAccountsBalanceSpec extends Specification{
    @Unroll
    def "should return amount of money from all accounts"(){
        given: "initial data"
        def bank = new Bank();
        when: "get all money"
        def sum = bank.sumAccountsBalance();
        then: "check balance"
        sum == amount;

        where:
        amount = 800

    }
}