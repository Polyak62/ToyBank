package entity;

import java.util.ArrayList;

//worker thread
public class HandlerRequest extends Thread {
    private FrontSystem frontSystem;
    private BackSystem backSystem;
    private Request request;

    public HandlerRequest(FrontSystem frontSystem, BackSystem backSystem) {
        this.frontSystem = frontSystem;
        this.backSystem = backSystem;
    }

    @Override
    public void run() {
        while (true) {
            request = frontSystem.getRequest();
            if (request != null){
                backSystem.handlerRequest(request);
            }
        }
    }
}
