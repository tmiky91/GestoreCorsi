package it.polito.tdp.corsi.model;

import java.util.Map;
import java.util.Map.Entry;

public class TestModel {

	public static void main(String[] args) {
		TestModel main = new TestModel();
		main.run();

	}
	
	public void run() {
		GestoreCorsi model = new GestoreCorsi();
		Map<String, Integer> res = model.getIscrittiCorsi(1);
		for(Entry entry: res.entrySet()) { //Entry mi ridà ad ogni ciclo chiave e valore della mappa
			System.out.println(entry.getKey() + "="+ entry.getValue());
		}
	}

}
