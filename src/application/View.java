package application;

public enum View {
	TITLE("titleScreen.fxml"),
	MAPTEST("MapTest.fxml"),
	SETTINGS("settingsScreen.fxml");
	private String fileName;
	
	View(String fileName){
		this.fileName = fileName;
	}
	public String getFileName() {
		return fileName;
	}
}
