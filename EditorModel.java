package textEditor;

import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class EditorModel {

	
	
	public void save(TextFile file){
		 try {
			Files.write(file.getFile(), file.getContents() , StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	

	public void close(){
		System.exit(0);
	}
	
	public IOresult<TextFile> load(Path file){
		try {
			List<String> lines = Files.readAllLines(file);
			return new IOresult<>(true, new TextFile(file, lines)); 
			//could make static methods in Ioresult such as iosuccess because someone reading would not know true or false
		} catch (IOException e) {
			e.printStackTrace();
			return new IOresult<>(false, null);
		}
		
	}
	
	
	
}
