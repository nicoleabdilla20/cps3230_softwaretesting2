package main;

import java.util.Random;

public class MarketAlertUM {
	//Setting the methods for when the appropriate events happen.
	public void badLogin() {
		System.out.println("Bad login at: " + System.currentTimeMillis());
	}
	
	public void goodLogin() {
		System.out.println("Good login at: " + System.currentTimeMillis());
	}
	
	public void view(boolean views) {
		System.out.println("Viewing alert: " + System.currentTimeMillis());
	}
	

	public void logout() {
		System.out.println("Logging out: " + System.currentTimeMillis());
	}

	// Runner methods
	public void run(final Login login) {
		final Random rand = new Random();
		// Getting random number between 1 and 2
		while(true){
			final int randomNumber = rand.nextInt((2 - 1) + 1) + 1;
			// random number is equal to 1
			if (randomNumber == 1){
				this.badLogin();
				login.setBadLogins(login.getBadLogins() + 1);
			// else if equal to 2
			} else {
				this.goodLogin();
				login.setBadLogins(0);
				this.view(true);
				this.logout();
			}	
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		final MarketAlertUM m = new MarketAlertUM();
		final Login login = m.new Login(0);
		//Running the runner method using the login object.
		m.run(login);
	}
	
	public class Login{
		private Integer badLogins;
		
		public Login(final Integer badLogins) {
			super();
			this.badLogins = badLogins;
		}

		public Integer getBadLogins() {
			return badLogins;
		}

		public void setBadLogins(Integer badLogins) {
			this.badLogins = badLogins;
		}
	}
}
