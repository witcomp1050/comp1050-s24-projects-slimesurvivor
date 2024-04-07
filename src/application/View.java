package application;

public enum View {
	TITLE("titleScreen.fxml"),
	MAPTEST("MapTest.fxml"),
	SETTINGS("settingsScreen.fxml"),
	MAP1ENDSCREEN("Map1endScreen.fxml"),
	MAP2ENDSCREEN("Map2endScreen.fxml"),
	MAP3ENDSCREEN("Map3endScreen.fxml"),
	MAPSELECTOR("mapSelect.fxml"),
	MAP1("MAP1.fxml"),
	MAP2("MAP2.fxml"),
	MAP3("MAP3.fxml");
	private String fileName;
	
	View(String fileName){
		this.fileName = fileName;
	}
	public String getFileName() {
		return fileName;
	}
}
