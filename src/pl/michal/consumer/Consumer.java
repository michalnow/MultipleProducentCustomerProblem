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
		list = new ArrayList<Integer>();
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
		while(list.size() != 4) {
			
			try {
				Thread.sleep(2500 + (int) (1000 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("Consumer " + getName() + " ");
			for (int number : warehouse.getBoth()) {
				list.add(number);
			}
			
			System.out.println();
		}
		System.out.println("Products of " + getName() +" = " + getList());	
		System.out.println();
	}

}
