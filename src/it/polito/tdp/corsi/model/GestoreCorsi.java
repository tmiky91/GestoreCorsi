package it.polito.tdp.corsi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.DAO.CorsoDAO;
import it.polito.tdp.corsi.DAO.StudenteDAO;

public class GestoreCorsi {

	public List<Corso> getCorsiByPeriodo(int periodo) {
		CorsoDAO dao = new CorsoDAO();
		List<Corso> corsi = dao.listAll(periodo);
		List<Corso> result = new ArrayList<Corso>();
		for(Corso c: corsi) {
			if(c.getPd()==periodo) {
				result.add(c);
			}
		}
		return result;
	}
	
	public Map<String, Integer> getIscrittiCorsi(int periodo){
		CorsoDAO dao = new CorsoDAO();
		return dao.getIscrittiCorsi(periodo);
	}

	public List<Studente> elencaStudenti(String codins) {
		StudenteDAO dao = new StudenteDAO();
		return dao.elencaStudenti(codins);
	}

}
