package interfacceAllenatore;

import controller.PersistenceException;

public interface IVisualizzaStatisticheAllenatore {
	
	public String visualizzaStatistiche(String username) throws PersistenceException;
	
}
