package thread;

public class Consumator extends Thread {
	int item;
	
	@Override
	public void run() {
		try {
			while(true) {
				Main.semFull.acquire();
				Main.s.acquire();
				item = Main.list.getLast();
				
				
				if(Main.list.isEmpty() == true) {
					System.out.println("Lista este goala");
				}
				else {
					System.out.println("A fost consumat elementul" + Main.list.getLast());
					System.out.println(" ");
					Main.list.remove(item);
				}
				Main.s.release();
				Main.semFree.release();
				consume(item);
				
				Thread.sleep(2000);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void consume(int item) {
		item = 0;
	}
}
