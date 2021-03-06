

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class customers5
 */
@WebServlet("/customers5")
public class Customers5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Preprocess request: we actually don't need to do any business stuff, so just display JSP.
		request.getRequestDispatcher("/Hello.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Postprocess request: gather and validate submitted data and display the result in the same JSP.

		// Prepare messages.
		//     Map<String, String> messages = new HashMap<String, String>();
		//  	String messages = "";
		//     request.setAttribute("messages", messages);

		// Get and validate name.
	//	String custid = request.getParameter("custid");
	//	int customerID = Integer.parseInt(custid);
		
	

		ArrayList<String> customers = new ArrayList<String>();
		String customerName = "";
		CustomerDB  cdb = new CustomerDB();

		customers =cdb.getCustomers();
	String firstname ="";
	String lastname = "";
	String output = "";
		
     for(String customer : customers) {
    	    	 
    	 String[] parts = customer.split(",");
    	 firstname = parts[0];
    	 lastname = parts[1];
    	 output = output + "<tr><td>" + firstname + "</td>   <td>" + lastname + "</td></tr><br/>";
      	 
     }
    	 
		request.setAttribute("messages", output);

		//      messages.put("success", String.format("Hello, your name is %s and your age is %s and your "
		//      		+ "favorite color is %s!" , name, age, color));
		//        }

		request.getRequestDispatcher("/outputcustomers.jsp").forward(request, response);
	}
}
