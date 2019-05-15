package npgeek.model;

import java.util.List;


public interface ParkDAO {
	
	public List<Park> getAllParks();
	public Park getParkByCode(String productCode);
	List<String> getParkNames();
	List<String> getParkCodes();

}
