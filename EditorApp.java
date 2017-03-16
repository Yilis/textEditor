package textEditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditorApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
		loader.setControllerFactory(t -> new EditorController(new EditorModel()));
		
		primaryStage.setScene(new Scene(loader.load()));
		
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
