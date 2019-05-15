package npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcParkDAO implements ParkDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park ORDER BY parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}
	
	
	
	@Override
	public Park getParkByCode(String parkcode) {
		Park park = null;
		String sqlSelectParkByCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByCode, parkcode);
		if(results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}
	
	@Override
	public List<String>  getParkNames() {
		List<String> allNames = new ArrayList<>();
		
		String nameSearchSql = "SELECT parkname FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(nameSearchSql);
        while(results.next()) {
        	allNames.add(results.getString("parkname"));
        }
        return allNames;
    }
	@Override
	public List<String>  getParkCodes() {
		List<String> allCodes = new ArrayList<>();
		
		String codeSearchSql = "SELECT parkcode FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(codeSearchSql);
        while(results.next()) {
        	allCodes.add(results.getString("parkcode"));
        }
        return allCodes;
    }

	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkcode(row.getString("parkcode"));
		park.setParkimgcode(row.getString("parkcode").toLowerCase());
		park.setParkname(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevationinfeet(row.getInt("elevationinfeet"));
		park.setMilesoftrail(row.getFloat("milesoftrail"));
		park.setNumberofcampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearfounded(row.getInt("yearfounded"));
		park.setAnnualvisitorcount(row.getInt("annualvisitorcount"));
		park.setInspirationalquote(row.getString("inspirationalquote"));
		park.setInspirationalquotesource(row.getString("inspirationalquotesource"));
		park.setParkdescription(row.getString("parkdescription"));
		park.setEntryfee(row.getInt("entryfee"));
		park.setNumberofanimalspecies(row.getInt("numberofanimalspecies"));
		
		
		return park;
	}

	
	
}
