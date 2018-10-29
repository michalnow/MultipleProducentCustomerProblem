package pl.michal.producer;

import pl.michal.warehouse.Warehouse;

public class RedProducer implements Runnable{
	private Warehouse warehouse;

	public RedProducer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		for(int i=1;i<11;i++) {
			try {
				Thread.sleep((int) (10* Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			warehouse.setRedNumber(i);
		}
		
	}
	
	
}
