package in.mymeze.chem.model;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document (expiryExpression = "${document.exipry}")
//@Document
public class chemComp {
	

	@JsonIgnore
	@Id
	private String id;
	
	
	private String type = "chemComp";

	@Field("commonName")
	private String commonName;
	@Field("compoundName")
	private String compoundName;
	@Field("formula")
	private String formula;
	@Field("composition")
	private String composition;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getCompoundName() {
		return compoundName;
	}
	public void setCompoundName(String compundName) {
		this.compoundName = compundName;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	
}
