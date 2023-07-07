package br.edu.ifba.inf011.decorator;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.PlayerMode;
import br.edu.ifba.inf011.model.resources.ResourceLoader;


public class MusicaTraducao extends PlayMusicDecorator{

	private List<String> pt;
	private String nome;
	private Integer linha;
	
	public MusicaTraducao(String nome) throws IOException {
		this.nome = nome;
		this.pt = ResourceLoader.instance().loadTraducao(nome);
		this.reset();
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void reset() {
		 this.linha = 0;
	}
	
	public Boolean finish() {
		return this.linha >= this.pt.size();
	}
	
	public String play() {
		return this.pt.get(this.linha++);
	}

	public void setAcordes(List<String> pt) {
		this.pt = pt;
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
