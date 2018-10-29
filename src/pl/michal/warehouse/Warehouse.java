package pl.michal.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	private int redNumber;
	private int blueNumber;
	private boolean redInStock;
	private boolean blueInStock;

	synchronized public int getRedNumber() {

		if (!redInStock)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		redInStock = false;
		

		return redNumber;
	}

	synchronized public void setRedNumber(int redNumber) {

		if (redInStock) {
			//System.out.println("bbb");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Produced red number: " + redNumber);
		redInStock = true;
		this.redNumber = redNumber;
		
	}

	synchronized public int getBlueNumber() {
		if (!blueInStock)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		blueInStock = false;
		

		return blueNumber;
	}

	synchronized public void setBlueNumber(int blueNumber) {

		if (blueInStock) {
			//System.out.println("aaa");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Produced blue number: " + blueNumber);
		blueInStock = true;
		this.blueNumber = blueNumber;
		
	}
	
	synchronized public List<Integer> getBoth(){
		
		List list = list = new ArrayList<Integer>();
		
		//System.out.println(blueInStock +"   " + redInStock);
		if(blueInStock && redInStock) {
			
			//System.out.println("elo");
			list.add(getRedNumber());
			list.add(getBlueNumber());
			System.out.println("Taking from the warehouse bothNumber number: " + blueNumber + " --- " + redNumber);
			notifyAll();
		}
		
		return list;
		
	}
}
