package pl.michal.producer;

import java.util.Random;

import pl.michal.warehouse.Warehouse;

public class RedProducer implements Runnable{
	private Warehouse warehouse;
	private Random rand;

	public RedProducer(Warehouse warehouse) {
		this.warehouse = warehouse;
		rand = new Random();
	}

	@Override
	public void run() {
		for(int i=0;i<6;i++) {
			try {
				Thread.sleep((int) (2000* Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			warehouse.setRedNumber(1 + rand.nextInt(9));
		}
		
	}
	
	
}
