package in.mymeze.chem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.mymeze.chem.model.chemComp;

@Repository
public interface chemCompRepo extends CrudRepository<chemComp,String>{

}
