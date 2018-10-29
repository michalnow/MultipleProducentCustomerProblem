package pl.michal.app;

import pl.michal.consumer.Consumer;
import pl.michal.producer.BlueProducer;
import pl.michal.producer.RedProducer;
import pl.michal.warehouse.Warehouse;

public class AppStart {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		RedProducer redProducer = new RedProducer(warehouse);
		BlueProducer blueProducer = new BlueProducer(warehouse);
		Consumer consumer1 = new Consumer(warehouse,"1111");
		Consumer consumer2 = new Consumer(warehouse,"2222");
		Consumer consumer3 = new Consumer(warehouse,"3333");
		
		Thread producerRedThread = new Thread(redProducer);
		Thread producerBlueThread = new Thread(blueProducer);
		Thread consumerThread1 = new Thread(consumer1);
		Thread consumerThread2 = new Thread(consumer2);
		Thread consumerThread3 = new Thread(consumer3);
		
		producerRedThread.start();
		producerBlueThread.start();
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();
		
	}

}
