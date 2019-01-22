package servlet;

import dao.UserDao;
import net.sf.json.JSONArray;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class wxloginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		 response.setContentType("text/html;charset=utf-8");

	        response.setHeader("Access-Control-Allow-Origin", "*");

	        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

	        User user = new User();
	        user.setSno(Integer.parseInt(request.getParameter("username")));
	        user.setPassword(request.getParameter("password"));
	        System.out.println(user.toString());
	        user = UserDao.instance().findUser(user);
	        if(user.getSno()!= null) {
				JSONArray json = JSONArray.fromObject(user);
				Writer out = response.getWriter();
				String jsonstring = json.toString();
				out.write(jsonstring);
				System.out.println(json);
				out.flush();
			}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
