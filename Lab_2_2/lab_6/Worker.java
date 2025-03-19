package Lab_2_2.lab_6;

import java.util.concurrent.BlockingQueue;

public abstract class Worker extends Thread {
    protected final BlockingQueue<Detail> inputQueue;
    protected final BlockingQueue<Detail> outputQueue;

    public Worker(String name, BlockingQueue<Detail> inputQueue, BlockingQueue<Detail> outputQueue) {
        super(name);
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    public abstract void processDetail(Detail detail);
}



