import entity.*;

public class Main {
    public static void main(String[] args) {
        FrontSystem frontSystem = new FrontSystem();
        BackSystem backSystem = new BackSystem(100000);

        Client client1 = new Client("Client1",new Request(100,TypeRequest.CREDIT,"1"),frontSystem);
        Client client2 = new Client("client1",new Request(1000, TypeRequest.REPAYMENT,"2"),frontSystem);
        Client client3 = new Client("client1",new Request(1500, TypeRequest.CREDIT,"3"),frontSystem);
        Client client4 = new Client("client1",new Request(15, TypeRequest.REPAYMENT,"4"),frontSystem);
        Client client5 = new Client("client1",new Request(10, TypeRequest.CREDIT,"5"),frontSystem);

        HandlerRequest handlerRequest1 = new HandlerRequest(frontSystem,backSystem);
        HandlerRequest handlerRequest2 = new HandlerRequest(frontSystem,backSystem);

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();

        handlerRequest1.start();
        handlerRequest2.start();
    }
}
