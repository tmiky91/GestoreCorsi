package it.polito.tdp.corsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {

	public List<Studente> elencaStudenti(String codins) {
		String sql = "SELECT s.matricola, s.cognome, s.nome, s.CDS " + 
				"FROM studente AS s, iscrizione AS i " + 
				"WHERE s.matricola= i.matricola and i.codins = ?";
		List<Studente> studenti = new ArrayList<Studente>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				studenti.add(new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS")));
			}
			conn.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return studenti;
	}

}
