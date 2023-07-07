package br.edu.ifba.inf011.strategy;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.PlayerMode;

public interface PlayMusicStrategy {
	Musica playMusic(PlayerMode mode, String playlist);
}
