package it.polito.tdp.corsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	public List<Corso> listAll(int periodo) {
		String sql = "SELECT * FROM corso";
		List<Corso> result = new LinkedList<Corso>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.add(c);
			}
			conn.close();
		}
		
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public Map<String, Integer> getIscrittiCorsi(int periodo) {
		String sql = "SELECT c.codins, c.nome, COUNT(*) AS tot "+
				 "FROM corso AS c, iscrizione AS i "+
				 "WHERE c.codins=i.codins and c.pd=? "+
				 "GROUP BY c.codins, c.nome";
		Map<String, Integer> result = new HashMap<String, Integer>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result.put(rs.getString("codins"), rs.getInt("tot"));
			}
			conn.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	

}
