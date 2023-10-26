package com.senai.andre.PrjGame.servicies;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.senai.andre.PrjGame.entities.Game;
import com.senai.andre.PrjGame.repository.GameRepository;


@Service
public class GameService {	
	private final GameRepository gameRespository;
	
	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRespository = gameRepository;
	}

	public Game saveGame(Game game) {
		return gameRespository.save(game);
	}

	public Game getGameById(Long id) {
		return gameRespository.findById(id).orElse(null);
	}

	public List<Game> getAllgame() {
		return gameRespository.findAll();
	}

	public void deleteGame(Long id) {
		gameRespository.deleteById(id);
	}
	public Game updateGame(Long id, Game novoGame) {
        Optional<Game> gameOptional = gameRespository.findById(id);
        if (gameOptional.isPresent()) {
        	Game gameExistente = gameOptional.get();
           	gameExistente.setName(novoGame.getName());
        	gameExistente.setPlataform(novoGame.getplataform());          
            return gameRespository.save(gameExistente); 
        } else {
            return null; 
        }
    }
}
