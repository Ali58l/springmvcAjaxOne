package dbQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import model.User;

public class JdbcCustomerDAO implements CustomerDAO {
	private DataSource dataSource;

	@Autowired	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<User> findCustomerIds(){
		List<User> users = new ArrayList<>(); 
		String sql = "SELECT id FROM users";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(
					rs.getInt("id"),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getInt("accountCount")
				);
				users.add(user);
			}
			rs.close();
			ps.close();
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public User findByCustomerId(int id){
		String sql = "SELECT * FROM users WHERE id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			User customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new User(
					rs.getInt("id"),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getInt("accountCount")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
