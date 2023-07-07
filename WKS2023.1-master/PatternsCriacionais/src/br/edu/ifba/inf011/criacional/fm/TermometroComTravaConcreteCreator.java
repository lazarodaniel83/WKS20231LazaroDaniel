package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroComTrava;

public class TermometroComTravaConcreteCreator implements TermometroConcreteCreator {
	
	public Termometro getTermometro() {
		return new TermometroComTrava();
	}

}
