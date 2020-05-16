package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class AccountBalanceSpec extends Specification{
    @Unroll
    def "should get amount of money on account"(){
        given: "initial data"
        def bank = new Bank();
        when: "get amount money"
        def amountMoney = bank.accountBalance(id);
        then: "check status code"
        amountMoney == amount;

        where:
        id   | amount
        1    | 100
        2    | 200
        3    | 300
        4    | 400
    }
}