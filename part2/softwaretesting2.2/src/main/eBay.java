package main;

import java.util.Random;

public class eBay {
	//Setting the methods for when the appropriate events happen.
	public void badRequest(boolean request) {
		System.out.println("Bad Request at: " + System.currentTimeMillis());
	}
	
	public void goodRequest(boolean request) {
		System.out.println("Good Request at: " + System.currentTimeMillis());
	}
	
	public void getResponse(boolean response) {
		System.out.println("Get reponse ... " + System.currentTimeMillis());
	}
	
	public void returnTo(boolean returns) {
		System.out.println("Return to ... " + System.currentTimeMillis());
	}

	// Runner method
	public void run(final Requests requests) {
		final Random rand = new Random();
		while(true){
			final int randomNumber = rand.nextInt((2 - 1) + 1) + 1;
			// random number is equal to 1
			if (randomNumber == 1){
				this.badRequest(true);
				requests.setBadRequests(requests.getBadRequests() + 1);
				this.returnTo(true);
			// else if equal to 2
			} else {
				this.goodRequest(true);
				requests.setBadRequests(0);
				this.getResponse(true);
			}	
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final eBay m = new eBay();
		final Requests requests = m.new Requests(0);
		m.run(requests);
	}
	
	public class Requests{
		private Integer badRequest;
		
		public Requests(final Integer badRequests) {
			super();
			this.badRequest = badRequests;
		}

		public Integer getBadRequests() {
			return badRequest;
		}

		public void setBadRequests(Integer badRequests) {
			this.badRequest = badRequests;
		}
	}
}
