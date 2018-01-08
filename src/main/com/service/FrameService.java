package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import model.User;
import org.springframework.jdbc.core.RowMapper; 
import dbQuery.CustomerDAO;

public class FrameService {
	
	private String usersQuery;
	private String usersIdQuery;
	private JdbcTemplate jdbcTemplate;
	
	CustomerDAO customerDAO;

	@Autowired	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Autowired	
	public void setUsersIdQuery(String usersIdQuery) {
		this.usersIdQuery = usersIdQuery;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setUsersQuery(String usersQuery) {
		this.usersQuery = usersQuery;
	}
	
	public List<Integer> returnCustomerIds() {
			
			return jdbcTemplate.query(usersIdQuery, new RowMapper<Integer>(){
					
				@Override  
				public Integer mapRow(ResultSet rs, int rownumber) throws SQLException {  
					
					return rs.getInt(1);  
				}  
		    });  
	}

	public List<User> returnCustomers() {
		
		return jdbcTemplate.query(usersQuery, new RowMapper<User>(){
				
			@Override  
			public User mapRow(ResultSet rs, int rownumber) throws SQLException {  
				User u = new User(rs.getInt(1),
								  rs.getString(2),
								  rs.getString(3),
								  rs.getInt(4));  
				return u;  
			}  
	    });  
	}
}
