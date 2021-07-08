package entity;

public class BackSystem {
    int balanceBank;

    public BackSystem(int balanceBank) {
        this.balanceBank = balanceBank;
    }

    public int getBalanceBank() {
        return balanceBank;
    }

    private void increaseBalance(int money) {
        balanceBank += money;
    }

    private void reduceBalance(int money) {
        balanceBank -= money;
    }

    public synchronized void handlerRequest(Request request) {
        if (balanceBank > 0) {
            if (request.getTypeRequest() == TypeRequest.CREDIT) {
                reduceBalance(request.getMoney());
                System.out.println("Заявка на кредит" + request + " обработана банком, баланс банка: "+getBalanceBank());
            } else {
                increaseBalance(request.getMoney());
                System.out.println("Заявка на погашение кредита" + request + " обработана банком, баланс банка: "+ getBalanceBank());
            }
        }else{
            System.out.println("В банке денег нет");
        }
    }
}
