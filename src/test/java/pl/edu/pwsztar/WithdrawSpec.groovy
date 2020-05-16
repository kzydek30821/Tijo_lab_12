package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class WithdrawSpec extends Specification{
    @Unroll
    def "should withdraw specific amount of money"(){
        given: "initial data"
        def bank = new Bank();
        when: "withdraw money"
        def withdrawBoolean = bank.withdraw(id,amount);
        then: "check status code"
        withdrawBoolean == isTrue;

        where:
        id  | amount | isTrue
        1   | 100    | false
        2   | 300    | true
        3   | 200    | true
        4   | -50    | false
        5   | 30     | false
        2   | 245    | true
    }
}