package Manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import Model.FotoBean;

public class FotoDAO {
	
	public FotoDAO() {
		
	}
	
	public void doSave (FotoBean fotoBean) throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		PreparedStatement ps;
		if (fotoBean.getPrezzo()==null) {
			ps=(PreparedStatement) con.prepareStatement("insert into foto (idFoto, path) values(?, ?);");
			ps.setInt(1, fotoBean.getIdFoto());
			ps.setString(2, fotoBean.getPath());
		}
		else {
		ps=(PreparedStatement) con.prepareStatement("insert into foto values(?, ?, ?);");
		ps.setInt(1, fotoBean.getIdFoto());
		ps.setString(2, fotoBean.getPath());
		ps.setDouble(3,fotoBean.getPrezzo());
		}
		ps.executeUpdate();
		ps.close();
		DriverManagerConnectionPool.releaseConnection(con);
	}
	
	public void doDelete (FotoBean fotoBean) throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from foto where idFoto=?;");
		ps.setInt(1, fotoBean.getIdFoto());
		ps.executeUpdate();
		ps.close();
		DriverManagerConnectionPool.releaseConnection(con);
	}
	
	public FotoBean doRetrieveByKey (int idFoto) throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from foto where idFoto=?;");
		ps.setInt(1, idFoto);
		ResultSet resultSet=ps.executeQuery();
		FotoBean fotoBean= new FotoBean();
		if (resultSet.next()) {
			fotoBean.setIdFoto(resultSet.getInt("idFoto"));
			fotoBean.setPath(resultSet.getString("path"));
			fotoBean.setPrezzo(resultSet.getDouble("prezzo"));
		}
		ps.close();
		DriverManagerConnectionPool.releaseConnection(con);
		return fotoBean;
	}
	
	public void doSaveOrUpdate(FotoBean fotoBean) throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from foto where idFoto=?;");
		ps.setInt(1, fotoBean.getIdFoto());
		ResultSet resultSet=ps.executeQuery();
		if (resultSet.next()) {
			ps=(PreparedStatement) con.prepareStatement("update foto set path=?, prezzo=? where idFoto=?;");
			ps.setString(1, fotoBean.getPath());
			ps.setDouble(2, fotoBean.getPrezzo());
			ps.setInt(3, fotoBean.getIdFoto());
			ps.executeUpdate();
		}
		else {
			doSave(fotoBean);
		}
		ps.close();
		DriverManagerConnectionPool.releaseConnection(con);
	}
	
	public ArrayList<FotoBean> doRetrieveByAll() throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		ArrayList<FotoBean> listaFoto= new ArrayList<FotoBean>();
		Statement query=(Statement) con.createStatement();
		ResultSet resultSet=query.executeQuery("select * from foto;");
		while (resultSet.next()) {
			FotoBean fotoBean= new FotoBean();
			fotoBean.setIdFoto(resultSet.getInt("idFoto"));
			fotoBean.setPath(resultSet.getString("path"));
			fotoBean.setPrezzo(resultSet.getDouble("prezzo"));
			listaFoto.add(fotoBean);
		}
		query.close();
		DriverManagerConnectionPool.releaseConnection(con);
		return listaFoto;	
	}
	
	public FotoBean doRetrieveByCond (String idUtente, int idFoto) throws SQLException {
		Connection con=DriverManagerConnectionPool.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT f.path FROM acquisto a JOIN foto f ON (a.idFoto = f.idFoto) WHERE a.idUtente = '?' AND a.idFoto = '?'");
		ps.setString(1, idUtente);
		ps.setInt(2, idFoto);
		ResultSet resultSet=ps.executeQuery();
		FotoBean fotoBean= new FotoBean();
		if (resultSet.next()) {
			fotoBean.setPath(resultSet.getString("path"));
		}
		ps.close();
		DriverManagerConnectionPool.releaseConnection(con);
		return fotoBean;
	}
	
}