package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class TransferSpec extends Specification{
    @Unroll
    def "should transfer money from A to B account"(){
        given: "initial data"
        def bank = new Bank();
        when: "transfer money"
        def transferBoolean = bank.transfer(idA,idB,amount);
        then: "check status code"
        transferBoolean == isTrue;

        where:
        idA | idB  | isTrue | amount
        1   | 1    | false  | 100
        2   | 1    | true   | 200
        1   | 2    | true   | 300
        1   | 2    | true   | 400
        2   | -1   | false  | 25
        2   | 1    | true   | 30
    }
}