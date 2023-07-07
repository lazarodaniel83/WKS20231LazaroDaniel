package br.edu.ifba.inf011.decorator;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.PlayerMode;
import br.edu.ifba.inf011.model.resources.ResourceLoader;


public class MusicaNotas extends PlayMusicDecorator{
	
	private List<String> notas;
	private String nome;
	private Integer linha;
	
	
	public MusicaNotas(String nome) throws IOException {
		this.nome = nome;
		this.notas = ResourceLoader.instance().loadNotas(nome);
		this.reset();
	}	
	
	public String getNome() {
		return this.nome;
	}
	
	public void reset() {
		 this.linha = 0;
	}
	
	public Boolean finish() {
		return this.linha >= this.notas.size();
	}
	
	public String play() {
		return this.notas.get(this.linha++);
	}

	public void setAcordes(List<String> notas) {
		this.notas = notas;
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