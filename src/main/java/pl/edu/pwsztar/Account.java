package pl.edu.pwsztar;
public class Account {

    private int id;
    private int money;

    public Account(int id, int money) {
        this.id = id;
        this.money = money;
    }
    public int getId() {
        return id;
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void depositMoney(int money){
        this.money = money + this.money;
    }
    public void withdrawMoney(int money){
        this.money -= money;
    }
}