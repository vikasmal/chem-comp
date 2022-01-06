package in.mymeze.chem.service.imp;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;


import in.mymeze.chem.io.BaseResponse;
import in.mymeze.chem.io.ChemicalFormula;
import in.mymeze.chem.model.chemComp;
import in.mymeze.chem.service.chemCompService;
import in.mymeze.chem.util.Constants;
import lombok.extern.slf4j.Slf4j;
import in.mymeze.chem.repository.chemCompRepo;

@Service
@Slf4j
public class chemCompServiceImp implements chemCompService{
	
	private chemCompRepo chemCompRepo;
	
	@Autowired
	public chemCompServiceImp(chemCompRepo chemCompRepo) {
		this.chemCompRepo = chemCompRepo;
	}
	
	@Override  
	public ChemicalFormula addChem(chemComp chemComp){
		ChemicalFormula response = new ChemicalFormula();
		String chemID = Constants.CHEMCOMP_TYPE + Constants.CB_SEPERATOR + chemComp.getCommonName().toUpperCase();
	
	//	log.info("Chem ID in add service: " + chemID);
		try
		{
		Optional <chemComp> existingChem = 	chemCompRepo.findById(chemID);
		if (existingChem.isPresent()) {
			response.setStatus("Failure");
			response.setErrorMessage("Chemical already present");
			return response;
		}
		chemComp newChemComp = new chemComp();
		newChemComp.setId(chemID);
		newChemComp.setCommonName(chemComp.getCommonName().toUpperCase());
		newChemComp.setComposition(chemComp.getComposition());
		newChemComp.setCompoundName(chemComp.getCompoundName());
		newChemComp.setFormula(chemComp.getFormula());
		chemComp savedChem = chemCompRepo.save(newChemComp);
		response.setStatus("SUCCESS");
		response.setErrorMessage("");
		
		return response;
	} catch (HttpStatusCodeException e) {
		response.setStatus("Failure");
		response.setErrorMessage(e.getMessage());
		return response;
		}
		
	}
	
	

	@Override
	public ChemicalFormula getChem(String chemName) {
		ChemicalFormula response = new ChemicalFormula();
	
		String chemID = Constants.CHEMCOMP_TYPE + Constants.CB_SEPERATOR + chemName.toUpperCase();
		try
		{
		Optional <chemComp> existingChem = 	chemCompRepo.findById(chemID);
		if (existingChem.isPresent()) {
			
			response.setChemComp(existingChem);
			response.setStatus("SUCCESS");
			response.setErrorMessage("");
			return response;
			
		}else {
			response.setStatus("Failure");
			response.setErrorMessage("No such chemical present");
			return response;
		}

	} catch (HttpStatusCodeException e) {
		response.setStatus("Failure");
		response.setErrorMessage(e.getMessage());
		return response;
		}

	}
	@Override
	public ChemicalFormula updateChem(chemComp chemComp){
		ChemicalFormula response = new ChemicalFormula();
		String chemID = Constants.CHEMCOMP_TYPE + Constants.CB_SEPERATOR + chemComp.getCommonName().toUpperCase();
		try
		{
		Optional <chemComp> existingChem = 	chemCompRepo.findById(chemID);
		if (existingChem.isPresent()) {
			chemComp newChemComp = new chemComp();
			newChemComp.setId(chemID);
			newChemComp.setCommonName(chemComp.getCommonName().toUpperCase());
			newChemComp.setComposition(chemComp.getComposition());
			newChemComp.setCompoundName(chemComp.getCompoundName());
			newChemComp.setFormula(chemComp.getFormula());
			chemCompRepo.save(newChemComp);
			response.setStatus("SUCCESS");
			response.setErrorMessage("");
			return response;
			
		}else {
			response.setStatus("Failure");
			response.setErrorMessage("No such chemical present");
			return response;
		}
	} catch (HttpStatusCodeException e) {
		response.setStatus("Failure");
		response.setErrorMessage(e.getMessage());
		return response;
		}

	}
	@Override
	public BaseResponse deleteChem(String chemName) {
		BaseResponse response = new BaseResponse();
		String chemID = Constants.CHEMCOMP_TYPE + Constants.CB_SEPERATOR + chemName.toUpperCase();
		try
		{
		Optional <chemComp> existingChem = 	chemCompRepo.findById(chemID);
		if (existingChem.isPresent()) {
			chemCompRepo.deleteById(chemID);
			response.setStatus("SUCCESS");
			response.setErrorMessage("");
			return response;
			
		}else {
			response.setStatus("Failure");
			response.setErrorMessage("No such chemical present");
			return response;
		}
	} catch (HttpStatusCodeException e) {
		response.setStatus("Failure");
		response.setErrorMessage(e.getMessage());
		return response;
		}

	}
}

