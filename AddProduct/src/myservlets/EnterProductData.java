package myservlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product_database.dao.productDao;

@WebServlet("/EnterProductData")
public class EnterProductData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_barcode=request.getParameter("pbarcode");
		String product_name=request.getParameter("pname");
		String product_color=request.getParameter("pcolor");
		String product_description=request.getParameter("pdescription");
		
		productDao dao = new productDao();
		boolean numeric_string=false;
		HttpSession session = request.getSession();
		boolean everything_submited=true;
		
		if (product_barcode.equals(""))
		{
			everything_submited=false;
		}
			
		if (product_barcode.matches("[0-9]+")) {numeric_string=true; }
		
		
		
		if (product_name.equals(""))
		{
			everything_submited=false;
		}
		
		if (product_color.equals(""))
		{
			everything_submited=false;
		}
		
		if (product_description.equals(""))
		{
			everything_submited=false;
		}
		

		
		if (everything_submited==true) {
			session.setAttribute("submited_everything", "yes");
			if (numeric_string==true) {
				session.setAttribute("numeric", "yes");
				boolean barcode_exists = false;
				try {
					barcode_exists=dao.check_barcode(product_barcode);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (barcode_exists==true) 
				{
					session.setAttribute("barcode_exists", "yes");
					response.sendRedirect("WrongBarcode.jsp");
				}
				else 
				{
					session.setAttribute("barcode_exists", "no");
					try {
						dao.add_product(product_barcode, product_name, product_color, product_description);
						session.setAttribute("barcode", product_barcode);
						session.setAttribute("pname", product_name);
						session.setAttribute("pcolor", product_color);
						session.setAttribute("pdesc", product_description);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					response.sendRedirect("Success.jsp");
				}
			}
			else 
			{
				session.setAttribute("barcode_exists", "no");
				session.setAttribute("numeric", "no");
				response.sendRedirect("WrongBarcode.jsp");
			}
		}
		else 
		{
			session.setAttribute("barcode_exists", "no");
			session.setAttribute("numeric", "yes");
			session.setAttribute("submited_everything", "no");
			response.sendRedirect("WrongBarcode.jsp");
		}
		
	}
}
