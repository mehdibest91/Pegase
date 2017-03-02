package com.pegase.beans;

import com.pegase.objets.GameSingleton;

public class Game {
	private String nom;
	private boolean inProgress;
	private GameSingleton gameSingleton;
	
	public String getNom() {
		return gameSingleton.getNom();
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isInProgress() {
		return gameSingleton.isInProgress();
	}
	
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public GameSingleton getGameSingleton() {
		return gameSingleton;
	}

	public void setGameSingleton(GameSingleton gameSingleton) {
		this.gameSingleton = gameSingleton;
	}
}
