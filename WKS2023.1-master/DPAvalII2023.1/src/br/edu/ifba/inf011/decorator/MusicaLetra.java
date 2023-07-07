package br.edu.ifba.inf011.decorator;



import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.PlayerMode;
import br.edu.ifba.inf011.model.resources.ResourceLoader;


public class MusicaLetra extends PlayMusicDecorator{

	
	private List<String> letra;
	private String nome;
	private Integer linha;
	
	public MusicaLetra(String nome) throws IOException {
		this.nome = nome;
		this.letra = ResourceLoader.instance().loadLetra(nome);
		this.reset();
	}	
	
	public String getNome() {
		return this.nome;
	}
	
	public void reset() {
		 this.linha = 0;
	}
	
	public Boolean finish() {
		return this.linha >= this.letra.size();
	}
	
	public String play() {
		return this.letra.get(this.linha++);
	}

	public void setLetra(List<String> letra) {
		this.letra = letra;
	}
	
	public String execute() {
		StringBuffer str = new StringBuffer();
		this.reset();
		while(!this.finish())
			str.append(this.play() + "\n");
		return str.toString();	
	}

	
	@Override
	public Musica tocarMusica(PlayerMode tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
