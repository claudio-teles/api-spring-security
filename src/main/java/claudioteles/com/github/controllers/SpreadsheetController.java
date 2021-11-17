package claudioteles.com.github.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import claudioteles.com.github.models.Spreadsheet;
import claudioteles.com.github.services.SpreadshetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class SpreadsheetController {
	
	@Autowired
	private SpreadshetService spreadshetService;
	
	@PostMapping("/spreadsheet")
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Spreadsheet", authorizations = { @Authorization(value="basicAuth") })
	@PreAuthorize("hasRole('ROLE_USER')")
	public Spreadsheet save(@RequestBody String fileLocationWithExtension) throws IOException {
		return spreadshetService.save(fileLocationWithExtension);
	}
	
	@GetMapping("/spreadsheet/{id}")
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Spreadsheet", authorizations = { @Authorization(value="basicAuth") })
	@PreAuthorize("hasRole('ROLE_USER')")
	public Spreadsheet getById(@PathVariable("id") Long id) {
		return spreadshetService.getById(id);
	}
	
	@GetMapping("/spreadsheets")
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gets Spreadsheets", authorizations = { @Authorization(value="basicAuth") } )
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Spreadsheet> getAllSpreadsheet() {
		return spreadshetService.getAllSpreadsheet();
	}

}
