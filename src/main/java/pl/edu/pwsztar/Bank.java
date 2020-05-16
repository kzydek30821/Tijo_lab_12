package pl.edu.pwsztar;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Bank implements BankOperation {

    private static int accountNumber = 0;

    public int createAccount() {
        return ++accountNumber;
    }

    public int deleteAccount(int accountNumber) {
        Optional<Account> account = findUser(accountNumber);
        return account.isEmpty() ? BankOperation.ACCOUNT_NOT_EXISTS:account.get().getMoney();
    }

    public boolean deposit(int accountNumber, int amount) {
        if(amount < 0){
            return false;
        }

        Optional<Account> account = findUser(accountNumber);
        if(account.isEmpty()){
            return false;
        }
        account.get().depositMoney(amount);
        return true;
    }

    public boolean withdraw(int accountNumber, int amount) {
        Optional<Account> account = findUser(accountNumber);
        if(account.isEmpty()){
            return false;
        }
        if(amount < 0 || amount > account.get().getMoney()){
            return false;
        }
        account.get().withdrawMoney(amount);
        return true;
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        Optional<Account> accountA = findUser(fromAccount);
        Optional<Account> accountB = findUser(toAccount);
        if(accountA.isEmpty() || accountB.isEmpty() || fromAccount == toAccount){
            return false;
        }
        if(amount < 0 || amount > accountA.get().getMoney()){
            return false;
        }
        accountA.get().withdrawMoney(amount);
        accountB.get().depositMoney(amount);
        return true;
    }

    public int accountBalance(int accountNumber) {
        Optional<Account> account = findUser(accountNumber);
        return account.isEmpty() ? BankOperation.ACCOUNT_NOT_EXISTS : account.get().getMoney();
    }

    public int sumAccountsBalance() {
        int sum = 0;
        for(Account account : repo()){
            sum+=account.getMoney();
        }
        return sum;
    }

    private Optional<Account> findUser(int id){
        return  repo()
                .stream()
                .filter(userAccount -> id == userAccount.getId())
                .findAny();
    }
    private List<Account> repo(){
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account(1,100));
        accounts.add(new Account(2,200));
        accounts.add(new Account(3,300));
        accounts.add(new Account(4,400));
        return accounts;
    }
}
