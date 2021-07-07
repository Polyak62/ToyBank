package entity;

public class BackSystem {
    int balanceBank;

    public BackSystem(int balanceBank) {
        this.balanceBank = balanceBank;
    }

    private void increaseBalance(int money){
        balanceBank+=money;
    }
    private void reduceBalance(int money){
        balanceBank-=money;
    }

    public synchronized void handlerRequest( Request request){
        if(request.getTypeRequest() == TypeRequest.CREDIT){
            reduceBalance(request.getMoney());
            System.out.println("Заявка на кредит" + request + " обработана банком");

        }else{
            increaseBalance(request.getMoney());
            System.out.println("Заявка на погашение кредита" + request + " обработана банком");
        }
    }
}
