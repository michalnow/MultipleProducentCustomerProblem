package pl.michal.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	private int redNumber;
	private int blueNumber;
	private boolean redInStock;
	private boolean blueInStock;
	private List<Integer> redList;
	private List<Integer> blueList;

	public Warehouse() {
		redList = new ArrayList<Integer>();
		blueList = new ArrayList<Integer>();
	}
	
	/*synchronized public int getRedNumber() {

		if (!redInStock)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		redInStock = false;

		return redNumber;
	}*/
	
	synchronized public void setRedNumber(int redNumber) {
		if (redInStock) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Produced red number: " + redNumber);
		redInStock = true;
		this.redNumber = redNumber;
		redList.add(redNumber);
		
	}

	/*synchronized public int getBlueNumber() {
		if (!blueInStock)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		blueInStock = false;

		return blueNumber;
	}*/

	synchronized public void setBlueNumber(int blueNumber) {

		if (blueInStock) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Produced blue number: " + blueNumber);
		blueInStock = true;
		this.blueNumber = blueNumber;
		blueList.add(blueNumber);
		
	}
	
	synchronized public List<Integer> getBoth(){
		int redRan = 0 ; 
		int blueRan = 0 ; 
		List<Integer> list = new ArrayList<Integer>();
		
		if(blueList.size() != 0 && redList.size() != 0) {
			redRan = redList.get( redList.size() * (int) Math.random()); 
			blueRan = blueList.get( blueList.size() * (int) Math.random()); 
			list.add(redRan);
			list.add(blueRan);
			System.out.println("taking from the warehouse bothNumber number: " + blueNumber + " --- " + redNumber);
			
			for(int i = 0; i<redList.size(); i++) {
				if(redList.get(i) == redRan) {
					redList.remove(i);
					break;
				}
			}
			
			for(int i = 0; i<blueList.size(); i++) {
				if(blueList.get(i) == blueRan) {
					blueList.remove(i);
					break;
				}
			}
			
			notifyAll();
			
		}

		
		return list;
		
	}
}
