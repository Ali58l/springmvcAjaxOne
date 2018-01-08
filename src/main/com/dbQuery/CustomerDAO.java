package dbQuery;

import java.util.List;

import model.User;

public interface CustomerDAO {
	public List<User> findCustomerIds( );
	public User findByCustomerId(int id);
}
