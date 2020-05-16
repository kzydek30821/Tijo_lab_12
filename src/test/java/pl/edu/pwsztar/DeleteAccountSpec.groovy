package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DeleteAccountSpec extends Specification{
    @Unroll
    def "should delete account with specific ID"(){
        given: "initial data"
        def bank = new Bank();
        when: "the account is delete"
        def number = bank.deleteAccount();
        then: "check status code"
        number == respone;

        where:
        id  | respone
        1   | 100
        2   | 200
        3   | 300
        4   | 400
    }
}