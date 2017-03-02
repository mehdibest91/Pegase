package com.pegase.objets;

public class GameSingleton {
		private String nom;
		private boolean inProgress;
		
		private GameSingleton()
		{}
	 
		private static GameSingleton INSTANCE = new GameSingleton();
	 
		public static GameSingleton getInstance()
		{	return INSTANCE;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public boolean isInProgress() {
			return inProgress;
		}

		public void setInProgress(boolean inProgress) {
			this.inProgress = inProgress;
		}
}
