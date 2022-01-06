package in.mymeze.chem.io;

import java.util.Optional;

import in.mymeze.chem.model.chemComp;

public class ChemicalFormula extends BaseResponse{

	/*
	 * private String commonName; private String compundName; private String
	 * formula; private String composition;
	 * 
	 * public String getCommonName() { return commonName; } public void
	 * setCommonName(String commonName) { this.commonName = commonName; } public
	 * String getCompundName() { return compundName; } public void
	 * setCompundName(String compundName) { this.compundName = compundName; } public
	 * String getFoumula() { return formula; } public void setFoumula(String
	 * foumula) { this.formula = foumula; } public String getComposition() { return
	 * composition; } public void setComposition(String composition) {
	 * this.composition = composition; }
	 */

	private Optional <chemComp> chemComp;

	public Optional<chemComp> getChemComp() {
		return chemComp;
	}

	public void setChemComp(Optional<chemComp> chemComp) {
		this.chemComp = chemComp;
	}


	
}
