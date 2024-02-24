package Aroua.Authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FirstServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String name=request.getParameter("username");  
	    String password=request.getParameter("userpass");  
	          
	    if(LoginDao.validate(name, password)){ 
	    	
	    	request.setAttribute("message", "welcome to interservlet communication"+name);
	        RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }  
	    out.close();
	}

}
