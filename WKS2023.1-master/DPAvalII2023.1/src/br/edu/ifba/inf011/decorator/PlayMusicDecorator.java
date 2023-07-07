package br.edu.ifba.inf011.decorator;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.PlayerMode;

public abstract class PlayMusicDecorator implements Musica {
	Musica musica;
	public abstract Musica tocarMusica(PlayerMode tipo); 
}
