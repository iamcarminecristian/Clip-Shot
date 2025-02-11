/**
 * @author Adalgiso Della Calce
 */
package Manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import Model.AcquistiBean;

public class AcquistiDAO {
	
	public AcquistiDAO() {	}
	
	public boolean doSave (AcquistiBean acquistiBean) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = (PreparedStatement) con.prepareStatement("insert into clipshot.acquisto values(?, ?, ?);");
			ps.setString(1, acquistiBean.getIdUtente());
			ps.setInt(2, acquistiBean.getIdFoto());
			ps.setString(3, acquistiBean.getStringData());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public AcquistiBean doRetrieveByKey (String idUtente, int idFoto) throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from clipshot.acquisto where idUtente=? and idFoto=?;");
		ps.setString(1, idUtente);
		ps.setInt(2, idFoto);
		ResultSet resultSet=ps.executeQuery();
		AcquistiBean acquistiBean= new AcquistiBean();
		if (resultSet.next()) {
			acquistiBean.setIdUtente(resultSet.getString("idUtente"));
			acquistiBean.setIdFoto(resultSet.getInt("idFoto"));
			Date dataFrom=resultSet.getDate("data");
			GregorianCalendar data = new GregorianCalendar();
			data.setTime(dataFrom);
			acquistiBean.setData(data);
		}
		ps.close();
		DriverManagerConnectionPool.releaseConnection(con);
		return acquistiBean;
	}
	public AcquistiBean doSaveOrUpdate (AcquistiBean acquistiBean) throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		PreparedStatement ps=(PreparedStatement)con.prepareStatement("select * from clipshot.acquisto where idUtente=? and idFoto=?;");
		ps.setString(1, acquistiBean.getIdUtente());
		ps.setInt(2, acquistiBean.getIdFoto());
		ResultSet resultSet=ps.executeQuery();
		if (resultSet.next()) {
			ps=(PreparedStatement) con.prepareStatement("update clipshot.acquisto set data=? where idUtente=? and idFoto=?");
			ps.setString(1, acquistiBean.getStringData());
			ps.setString(2, acquistiBean.getIdUtente());
			ps.setInt(3, acquistiBean.getIdFoto());
			ps.executeUpdate();
		}
		else {
			doSave(acquistiBean);
			return acquistiBean;
		}
		ps.close();
		DriverManagerConnectionPool.releaseConnection(con);		
		return acquistiBean;
	}
	
	public ArrayList<AcquistiBean> doRetrieveByAll() throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		ArrayList<AcquistiBean> listaAcquisti= new ArrayList<AcquistiBean>();
		Statement query=(Statement) con.createStatement();
		ResultSet resultSet=query.executeQuery("select * from clipshot.acquisto");
		while (resultSet.next()) {
			AcquistiBean acquistiBean= new AcquistiBean();
			acquistiBean.setIdUtente(resultSet.getString("idUtente"));
			acquistiBean.setIdFoto(resultSet.getInt("idFoto"));
			Date dataFrom=resultSet.getDate("data");
			GregorianCalendar data= new GregorianCalendar();
			data.setTime(dataFrom);
			acquistiBean.setData(data);
			listaAcquisti.add(acquistiBean);
		}
		query.close();
		DriverManagerConnectionPool.releaseConnection(con);
		return listaAcquisti;
	}
	
	public ArrayList<AcquistiBean> doRetrieveByCond(String idUtente) throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection();
		ArrayList<AcquistiBean> listaAcquisti= new ArrayList<AcquistiBean>();
		PreparedStatement query = (PreparedStatement)con.prepareStatement("SELECT * FROM clipshot.acquisto WHERE idUtente = ?");
		query.setString(1, idUtente);
		ResultSet resultSet = query.executeQuery();
		while (resultSet.next()) {
			AcquistiBean acquistiBean= new AcquistiBean();
			acquistiBean.setIdUtente(resultSet.getString("idUtente"));
			acquistiBean.setIdFoto(resultSet.getInt("idFoto"));
			Date dataFrom=resultSet.getDate("data");
			GregorianCalendar data= new GregorianCalendar();
			data.setTime(dataFrom);
			acquistiBean.setData(data);
			listaAcquisti.add(acquistiBean);
		}
		query.close();
		DriverManagerConnectionPool.releaseConnection(con);
		return listaAcquisti;
	}
	
	public boolean doDelete (AcquistiBean acquistiBean) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = (PreparedStatement) con.prepareStatement("delete from clipshot.acquisto where idUtente=? and idFoto=?;");
			ps.setString(1, acquistiBean.getIdUtente());
			ps.setInt(2, acquistiBean.getIdFoto());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
