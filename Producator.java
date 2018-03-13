package thread;

import java.util.Random;

public class Producator extends Thread {
	
	public int randomElement;
	public int item;
	@Override 
	public void run() {
		try {
			while(true) {
				item = produce();
				Main.semFree.acquire();
				Main.s.acquire();
				
				if(Main.list.size() == Main.listSize) {
					System.out.println("Lista este plina");
				}
				else {
					Main.list.add(item);
					
					System.out.println("A fost produs elememntul" + item);
					System.out.println(" ");
				}
				Main.s.release();
				Main.semFull.release();
				Thread.sleep(2500);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int produce() {
		randomElement = new Random().nextInt(10);
		return randomElement;
	}
}
