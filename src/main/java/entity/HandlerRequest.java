package entity;


public class HandlerRequest extends Thread {
    private FrontSystem frontSystem;
    private BackSystem backSystem;
    private Request request;
    private String handlerName;

    public HandlerRequest(FrontSystem frontSystem, BackSystem backSystem,String handlerName) {
        this.frontSystem = frontSystem;
        this.backSystem = backSystem;
        this.handlerName = handlerName;
    }

    public String getHandlerName() {
        return handlerName;
    }

    // 2 потока Handler остаются весеть в состоянии wait.
    @Override
    public void run() {
        while (true) {
            request = frontSystem.getRequest();
            if (request != null){
                backSystem.handlerRequest(request);
                System.out.println(getHandlerName() + " обрабатывает заявку "+ request);
            }
        }
    }

}
