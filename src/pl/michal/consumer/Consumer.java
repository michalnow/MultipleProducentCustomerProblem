package pl.michal.consumer;

import java.util.ArrayList;
import java.util.List;

import pl.michal.warehouse.Warehouse;

public class Consumer implements Runnable {

	private Warehouse warehouse;
	private List<Integer> list;
	private String name;

	public Consumer(Warehouse warehouse,String name) {
		this.warehouse = warehouse;
		this.name = name;
	}
		
	
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void run() {
		list = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep((int) (10000 * Math.random())+1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("Consumer " + getName() + " ");
			for (int number : warehouse.getBoth()) {
				list.add(number);
			}
		}
		System.out.println(getName() + getList());	
	}

}
