/**
 * @author Adalgiso Della Calce
 */
package Controller.GestioneInterazioni;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Manager.SeguiDAO;
import Model.SeguiBean;

@WebServlet("/AggiungiSegui")
public class AggiungiSegui extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		HttpSession session;
		String idFollower, idFollowing;
		
		session=request.getSession();
		idFollower=(String) request.getParameter("idFollower");
		idFollowing=request.getParameter("idFollowing");
		if (idFollower!=null) {
			SeguiBean seguiBean= new SeguiBean();
			seguiBean.setIdFollower(idFollower);
			seguiBean.setIdFollowing(idFollowing);
			SeguiDAO seguiDAO= new SeguiDAO();
			seguiDAO.doSave(seguiBean) ;
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
}
