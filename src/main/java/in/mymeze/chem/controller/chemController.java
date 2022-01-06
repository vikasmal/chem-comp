package in.mymeze.chem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.mymeze.chem.io.BaseResponse;
import in.mymeze.chem.io.ChemicalFormula;
import in.mymeze.chem.model.chemComp;
import in.mymeze.chem.service.chemCompService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class chemController {
	
	private chemCompService chemCompService;
	
	@Autowired
	public chemController(chemCompService chemCompService) {
		this.chemCompService = chemCompService;
	}
	
	@RequestMapping(value = "chemComp/chem/{chemName}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ChemicalFormula getChem (@PathVariable ("chemName") String chemName) {
		return chemCompService.getChem(chemName);
		
	}
	
	@RequestMapping(value = "chemComp/chem",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ChemicalFormula addChem(@RequestBody chemComp chemComp) {
		return chemCompService.addChem(chemComp);
	}
	
	@RequestMapping(value = "chemComp/chem",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public ChemicalFormula updateChem(@RequestBody chemComp chemComp) {
		return chemCompService.updateChem(chemComp);	
	}
	
	@RequestMapping(value = "chemComp/chem/{chemName}",method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public BaseResponse deleteChem(@PathVariable ("chemName") String chemName) {
		return chemCompService.deleteChem(chemName);
	}

}
