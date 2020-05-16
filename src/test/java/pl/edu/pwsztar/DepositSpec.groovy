package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DepositSpec extends Specification{
    @Unroll
    def "should deposit specific amount of money"(){
        given: "initial data"
        def bank = new Bank();
        when: "deposit money"
        def depositBoolean = bank.deposit(id,amount);
        then: "check status code"
        depositBoolean == isTrue;

        where:
        id  | amount | isTrue
        1   | 100    | true
        2   | 200    | true
        3   | 300    | true
        4   | 400    | false
    }
}