
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDB {

	// private Book b = new Book();
	
	public CustomerDB() {
		connect();
	}

	private Connection con = null;

	private Connection connect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return con;
	}

	public String getCustomer(int value) {

	//	Book b = null;
		
		String customername = "";
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select lastname from bankcust where custid = \'" + value + "\'";

		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				customername = (rs.getString("lastname"));

				// System.out.println(rs.getString(1));
				// System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
				// System.out.println(rs.getString(4));
				// System.out.println(rs.getDouble(5) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			// } catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return customername;
	}

	public ArrayList<String> getCustomers() {

		//	Book b = null;
			
			String customername = "";
			ArrayList<String> customers = new ArrayList<String>();
			
			
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select firstname, lastname from bankcust where rownum <= 5";

			try {
				connect();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					customername = (rs.getString("lastname") + "," + rs.getString("firstname"));
                    customers.add(customername);
					// System.out.println(rs.getString(1));
					// System.out.println(rs.getString(2));
					// System.out.println(rs.getString(3));
					// System.out.println(rs.getString(4));
					// System.out.println(rs.getDouble(5) + "\n");

				}
			} catch (SQLException e) {
				e.printStackTrace();
				// } catch (ClassNotFoundException e) {
				// e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return customers;
		}

	
}
