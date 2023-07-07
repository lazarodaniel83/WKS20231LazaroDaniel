package br.edu.ifba.inf011;

import br.edu.ifba.inf011.criacional.fm.TermometroFactory;
import br.edu.ifba.inf011.criacional.fm.TipoTermometro;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.criacional.fm.AtuadorCreator;
import br.edu.ifba.inf011.criacional.fm.TermometroBaseFactory;
import br.edu.ifba.inf011.criacional.fm.TermometroCreator;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.atuadores.AtuadorDummy;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;

public class Aplicacao2 {
	
	private Ambiente ambiente;
	private Termometro termometro;
	private Atuador atuador;
	
	public Aplicacao2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		
		TermometroCreator factory = new TermometroCreator();
		this.ambiente = new AmbienteBasico("AMB01");
		this.termometro = factory.getTermometroWithProp("ALTA", this.ambiente);
		
		AtuadorCreator atuadorFactory = new AtuadorCreator();
		this.atuador = atuadorFactory.getAtuadorWithProp("RESFRIADOR");
	}
	
	public void monitorar() throws InterruptedException {
		
		while(true) {
			double temperatura;
			this.ambiente.randomizar(2);
			temperatura = this.termometro.lerTemperatura();
			this.ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
			Thread.sleep(100);
		}		
	}
}
