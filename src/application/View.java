package application;

public enum View {
	TITLE("titleScreen.fxml"),
	MAPTEST("MapTest.fxml"),
	SETTINGS("settingsScreen.fxml"),
	ENDSCREEN("endScreen.fxml");
	private String fileName;
	
	View(String fileName){
		this.fileName = fileName;
	}
	public String getFileName() {
		return fileName;
	}
}
