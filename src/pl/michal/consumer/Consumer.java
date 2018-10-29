package pl.michal.consumer;

import java.util.ArrayList;
import java.util.List;

import pl.michal.warehouse.Warehouse;

public class Consumer implements Runnable {

	private Warehouse warehouse;
	private List<Integer> list;

	public Consumer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
		
	
	public List<Integer> getList() {
		return list;
	}



	public void setList(List<Integer> list) {
		this.list = list;
	}



	@Override
	public void run() {
		list = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep((int) (1000 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int number : warehouse.getBoth()) {
				list.add(number);
			}
		}

	}

}
