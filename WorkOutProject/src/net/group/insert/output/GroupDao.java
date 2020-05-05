package net.group.insert.output;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.group.insert.output.Group;



public class GroupDao {
	private String url = "jdbc:mysql://localhost:3306/workout?useSSL=false";
	private String user = "root";
	private String pwd = "WYing2402";

	private static final String INSERT_GROUP_SQL = "INSERT INTO `group` (`name`, `groupnum`, `setsnum`, `sport`, `distance`, `split`) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_GROUP_BY_NUM = "SELECT name, groupnum, setsnum, sport, distance, split FROM `group` where num =?;";
	private static final String SELECT_ALL_GROUP = "select * from `group`";
	private static final String SELECT_GROUP_BY_GNUM = "select * from `group` where groupnum = ?";
	private static final String DELETE_GROUP_SQL = "delete from `group` where num = ?;";
	private static final String UPDATE_GROUP_SQL = "update `group` set name = ?,groupnum= ?, setsnum =?, distance =?, split=? where num = ?;";

	public GroupDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	public void insertGroup(Group group) throws SQLException {
		System.out.println(INSERT_GROUP_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GROUP_SQL)) {
			preparedStatement.setString(1, group.getName());
			preparedStatement.setInt(2, group.getGroupnum());
			preparedStatement.setString(3, group.getSetsnum());
			preparedStatement.setString(4, group.getSport());
			preparedStatement.setInt(5, group.getDistance());
			preparedStatement.setInt(6, group.getSplit());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<Group> printGroup() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Group> group = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_GROUP);) {
	
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int num = rs.getInt("num");
				int groupnum = rs.getInt("groupnum");
				String name = rs.getString("name");
				String setsnum = rs.getString("setsnum");
				String sport = rs.getString("sport");
				int distance = rs.getInt("distance");
				int split = rs.getInt("split");
				group.add(new Group(num, name, groupnum, setsnum, sport, distance, split));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return group;
	}
	

	

	public List<Group> selectAllGroup() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Group> groups = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_GROUP);) {
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int groupnum = rs.getInt("groupnum");
				String setsnum = rs.getString("setsnum");
				String sport = rs.getString("sport");
				int distance = rs.getInt("distance");
				int split = rs.getInt("split");
				groups.add(new Group(num, name, groupnum, setsnum, sport, distance, split));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return groups;
	}

	public Group selectGroup(int num) {
		Group group = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GROUP_BY_NUM);) {
			preparedStatement.setInt(1, num);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				int groupnum = rs.getInt("groupnum");
				String setsnum = rs.getString("setsnum");
				String sport = rs.getString("sport");
				int distance = rs.getInt("distance");
				int split = rs.getInt("split");
				
				group = new Group(num, name, groupnum, setsnum, sport, distance, split);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return group;
	}
	public boolean deleteGroup(int num) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement st = connection.prepareStatement(DELETE_GROUP_SQL);) {
			st.setInt(1, num);
			rowDeleted = st.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateGroup(Group group) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement st = connection.prepareStatement(UPDATE_GROUP_SQL);) {
			st.setString(1, group.getName());
			st.setInt(2, group.getGroupnum());
			st.setString(3, group.getSetsnum());
			st.setString(4, group.getSport());
			st.setInt(5, group.getDistance());
			st.setInt(6, group.getSplit());
			st.setInt(7, group.getNum());

			rowUpdated = st.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}

