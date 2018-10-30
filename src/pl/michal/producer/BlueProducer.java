package pl.michal.producer;

import java.util.Random;

import pl.michal.warehouse.Warehouse;

public class BlueProducer implements Runnable{
	private Warehouse warehouse;
	private Random rand;

	public BlueProducer(Warehouse warehouse) {
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
			
			warehouse.setBlueNumber(100 + rand.nextInt(100));
		}
		
	}
	
	
}
