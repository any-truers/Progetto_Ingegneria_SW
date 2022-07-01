package dominio;

import java.time.LocalDateTime;

public abstract class StatoAbbonamento {
	
	private LocalDateTime localDateTimeUpdate;
	private Cliente cliente;
	
	public StatoAbbonamento(Cliente cliente) {
		super();
		this.cliente=cliente;
	}
	
	public abstract String getStato();

	public LocalDateTime getLocalDateTimeUpdate() {
		return localDateTimeUpdate;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
