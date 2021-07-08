import entity.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FrontSystem frontSystem = new FrontSystem();
        BackSystem backSystem = new BackSystem(1000);

        Client client1 = new Client("Client1", new Request(1, TypeRequest.CREDIT, "Заявка№1"), frontSystem);
        Client client2 = new Client("client2", new Request(2, TypeRequest.REPAYMENT, "Заявка№2"), frontSystem);
        Client client3 = new Client("client3", new Request(3, TypeRequest.CREDIT, "Заявка№3"), frontSystem);
        Client client4 = new Client("client4", new Request(4, TypeRequest.REPAYMENT, "Заявка№4"), frontSystem);
        Client client5 = new Client("client5", new Request(5, TypeRequest.CREDIT, "Заявка№5"), frontSystem);


        HandlerRequest handlerRequest1 = new HandlerRequest(frontSystem, backSystem, "Обработчик 1");
        HandlerRequest handlerRequest2 = new HandlerRequest(frontSystem, backSystem, "Обработчик 2");

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();


        handlerRequest1.start();
        handlerRequest2.start();

    }
}
