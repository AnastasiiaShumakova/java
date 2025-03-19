package Lab_2_2.lab_6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Detail> stamperToAssemblerQueue = new LinkedBlockingQueue<>(1); // Ограниченный размер
        BlockingQueue<Detail> assemblerToQualityQueue = new LinkedBlockingQueue<>(1); // Ограниченный размер

        Stamper stamper = new Stamper(stamperToAssemblerQueue);
        Assembler assembler = new Assembler(stamperToAssemblerQueue, assemblerToQualityQueue);
        QualityController qualityController = new QualityController(assemblerToQualityQueue);

        stamper.start();
        assembler.start();
        qualityController.start();

        // Даем поработать некоторое время
        Thread.sleep(20000);

        stamper.stopStamper();
        assembler.stopAssembler();
        qualityController.stopQualityController();

        stamper.join();
        assembler.join();
        qualityController.join();
    }
}



