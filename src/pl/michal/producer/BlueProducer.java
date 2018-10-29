package pl.michal.producer;

import pl.michal.warehouse.Warehouse;

public class BlueProducer implements Runnable{
	private Warehouse warehouse;

	public BlueProducer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		for(int i=12;i<22;i++) {
			try {
				Thread.sleep((int) (10* Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			warehouse.setBlueNumber(i);
		}
		
	}
	
	
}
