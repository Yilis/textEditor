package textEditor;

import javafx.scene.control.TextArea;

import java.io.File;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.stage.FileChooser;

public class EditorController {

	@FXML
	private TextArea areaText;
	private EditorModel model;
	private TextFile currentTextFile;
	
	public EditorController(EditorModel model){
		this.model = model;
	}
	@FXML	
	private void onSave(){
		TextFile file = new TextFile(currentTextFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
		model.save(file);
	}
	
	@FXML	
	private void onLoad(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("./"));// current directory you are in
		File file = fileChooser.showOpenDialog(null);
		if (file != null){
			IOresult<TextFile> io = model.load(file.toPath());
			if(io.isOk() && io.hasData()){
				currentTextFile = io.getdata();
				//areaText.s
				currentTextFile.getContents().forEach(line -> areaText.appendText(line + "\n"));;
				
			}else {
				System.out.println("Failed");
			}
		}
		
	}
	
	@FXML	
	private void onClose(){
		model.close();
	}

	@FXML
	private void onAbout (){
	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
	   alert.setHeaderText(null);
	   alert.setTitle("About");
	   alert.setContentText("This is a simple text editor EditorApp");
	   alert.show();
	}
}
