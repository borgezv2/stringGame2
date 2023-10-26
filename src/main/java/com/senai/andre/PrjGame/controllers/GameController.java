package com.senai.andre.PrjGame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.andre.PrjGame.entities.Game;
import com.senai.andre.PrjGame.servicies.GameService;

@RestController
@RequestMapping("/jogos")
public class GameController {
	private final GameService gameService;
	
	 @GetMapping("/home")
	    public String paginaInicial() {
			return "index";
		}

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@PostMapping
	public Game createJogo(@RequestBody Game game) {
		return gameService.saveGame(game);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Game> getGame(@PathVariable Long id) {
		Game game = gameService.getGameById(id);
		if (game != null) {
			return ResponseEntity.ok(game);
		}else {
			return ResponseEntity.notFound() .build();
		}
	}
    @DeleteMapping("/{id}")
	public void deleteGame(@PathVariable Long id) {
		gameService.deleteGame(id);
	}
    

  	@GetMapping
  	public ResponseEntity<List<Game>> getAllJogos(RequestEntity<Void> requestEntity) {
  		String method = requestEntity.getMethod().name();
  		String contentType = requestEntity.getHeaders().getContentType().toString();
  		List<Game> jogos = gameService.getAllgame();
  		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
  				.body(jogos);
  	}
  	
  	@PutMapping("/{id}")
  	public Game updateJogo(@PathVariable Long id, @RequestBody Game game) {
  	    return gameService.updateGame(id, game);
  	}
   

	
}
