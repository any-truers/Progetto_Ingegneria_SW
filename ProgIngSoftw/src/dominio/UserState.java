package dominio;

import java.time.LocalDateTime;

public abstract class UserState {
	
	private User user;
	private LocalDateTime localDateTime;
	
	public UserState(User user) {
		super();
		this.user=user;
	}
	
	public abstract String getStato();
	
	public User getUser() {
		return this.user;
	}
	
	public LocalDateTime getLocalDateTime() {
		return this.localDateTime;
	}

}
