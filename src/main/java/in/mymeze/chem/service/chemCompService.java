package in.mymeze.chem.service;

import in.mymeze.chem.io.BaseResponse;
import in.mymeze.chem.io.ChemicalFormula;
import in.mymeze.chem.model.chemComp;

public interface chemCompService {
	ChemicalFormula addChem(chemComp chemComp);
	ChemicalFormula getChem(String chemName);
	ChemicalFormula updateChem(chemComp chemComp);
	BaseResponse deleteChem(String chemName);

}
