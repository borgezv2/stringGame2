package com.senai.andre.PrjGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.andre.PrjGame.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}