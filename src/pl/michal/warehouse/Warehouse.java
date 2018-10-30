package pl.michal.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	/*
	 * synchronized public int getRedNumber() {
	 * 
	 * if (!redInStock) try { wait(); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * redInStock = false;
	 * 
	 * return redNumber; }
	 */

	synchronized public void setRedNumber(int redNumber) {
		/*
		 * if (redInStock) { try { wait(); } catch (InterruptedException e) {
		 * e.printStackTrace(); } }
		 */

		System.out.println("Produced red number: " + redNumber);
		redInStock = true;
		this.redNumber = redNumber;
		redList.add(redNumber);
		/*try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	/*
	 * synchronized public int getBlueNumber() { if (!blueInStock) try { wait(); }
	 * catch (InterruptedException e) { e.printStackTrace(); }
	 * 
	 * blueInStock = false;
	 * 
	 * return blueNumber; }
	 */

	synchronized public void setBlueNumber(int blueNumber) {

		/*
		 * if (blueInStock) { try { wait(); } catch (InterruptedException e) {
		 * e.printStackTrace(); } }
		 */
		System.out.println("Produced blue number: " + blueNumber);
		blueInStock = true;
		this.blueNumber = blueNumber;
		blueList.add(blueNumber);
		/*try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	synchronized public List<Integer> getBoth() {
		Random rand = new Random();
		int redRan = 0;
		int blueRan = 0;
		List<Integer> list = new ArrayList<Integer>();
		if(blueList.size() == 0 || redList.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		} 
			
			list.add(redList.get(0));
			list.add(blueList.get(0));
			System.out.println("taking from the warehouse bothNumber number: " + redList.get(0) + " --- " + blueList.get(0));

			redList.remove(redRan);
			blueList.remove(blueRan);
			notifyAll();
	
			return list;
		}
		

		

	}

