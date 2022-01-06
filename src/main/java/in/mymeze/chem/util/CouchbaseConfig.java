package in.mymeze.chem.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
//import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.couchbase.client.core.env.QueryServiceConfig;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"in.mymeze.chem.repository"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Value("${spring.couchbase.bucket.name}")
	private String bucketName;
	
	@Value("${spring.couchbase.bucket.password}")
	private String bucketPassword;

	@Value("${spring.couchbase.bucket.bootstrap-hosts}")
	private String hostName;

	
	  @Override protected List<String> getBootstrapHosts() { return
	  Collections.singletonList(hostName); }
	  
	  @Override 
	  public String getBucketName() { return bucketName; }
	  
	  @Override 
	  protected String getBucketPassword() { return bucketPassword; }
	  
	  @Override
	  protected CouchbaseEnvironment getEnvironment() {
		  CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
				  .queryServiceConfig(QueryServiceConfig.create(0, 12, 5)).build();
		  return env;
	  }

}