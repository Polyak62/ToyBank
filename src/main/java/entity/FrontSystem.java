package entity;

import java.util.LinkedList;
import java.util.Queue;

public class FrontSystem {
    Queue<Request> queueRequest = new LinkedList<Request>();


    public synchronized void addRequest(Request request) throws InterruptedException {
        while (queueRequest.size()==2){
            wait();
        }
        queueRequest.add(request);
        System.out.println("заявка "+ request + "обрабатывается банком");
        notifyAll();
//        queueRequest.add(request);
    }

    public synchronized Request getRequest() {
        while (queueRequest.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request req = queueRequest.poll();
        return req;
//        Request req = queueRequest.poll();
//        return req;
    }

}
