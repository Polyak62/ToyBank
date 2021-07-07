package entity;

public class Client extends Thread {

    private String clientName;
    private int money;
    private TypeRequest typeRequest;
    private FrontSystem frontSystem;
    private Request request;

    public Client(String clientName, Request request,FrontSystem frontSystem) {
        this.clientName = clientName;
        this.request = request;
        this.frontSystem = frontSystem;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMoney() {
        return money;
    }

    public TypeRequest getTypeRequest() {
        return typeRequest;
    }


    public void run() {
        System.out.println("Заявка " + request.toString() + " отправлена банку");
        try {
            frontSystem.addRequest(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
