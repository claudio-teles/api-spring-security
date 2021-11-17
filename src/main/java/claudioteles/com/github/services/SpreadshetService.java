package claudioteles.com.github.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.dao.SpreadsheetDao;
import claudioteles.com.github.models.Spreadsheet;

@Service
public class SpreadshetService {
	
	@Autowired
	private SpreadsheetDao spreadsheetDao;
	
	public Spreadsheet save(String fileLocationWithExtension) throws IOException {
		int startOfName = 0;
		int endOfName = 0;
		String name = "";
		
		// Windows file system
		if (fileLocationWithExtension.contains("\\")) {
			startOfName = fileLocationWithExtension.lastIndexOf("\\");
			endOfName = fileLocationWithExtension.length();
			name = fileLocationWithExtension.substring(startOfName + 1, endOfName);
		}
		
		// Linux file system
		if (fileLocationWithExtension.contains("/")) {
			startOfName = fileLocationWithExtension.lastIndexOf("/");
			endOfName = fileLocationWithExtension.length();
			name = fileLocationWithExtension.substring(startOfName + 1, endOfName);
		}
		
		Spreadsheet spreadsheet = new Spreadsheet(null, name, Files.readAllBytes(Path.of(fileLocationWithExtension).toAbsolutePath()));
		return spreadsheetDao.save(spreadsheet);
	}
	
	public Spreadsheet getById(Long id) {
		return spreadsheetDao.findById(id).get();
	}
	
	public List<Spreadsheet> getAllSpreadsheet() {
		return spreadsheetDao.findAll();
	}

}
