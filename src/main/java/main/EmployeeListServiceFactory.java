package main;

 
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
 
 
public class EmployeeListServiceFactory extends ODataJPAServiceFactory {
 
  private static final String PERSISTENCE_UNIT_NAME = "emplist-web";
  private  Map<String, String> properties = new HashMap<String, String>(); 
  public static EntityManagerFactory emf;
  
  @Override
  public ODataJPAContext initializeODataJPAContext()
      throws ODataJPARuntimeException {
 
    ODataJPAContext oDatJPAContext = this.getODataJPAContext();
    try {
     
    	
    	setDBproperties();
   //   EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	
     if(emf == null){
         emf =  Persistence.createEntityManagerFactory("default", properties);
     }
      oDatJPAContext.setEntityManagerFactory(emf);
      oDatJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
 
      return oDatJPAContext;
 
    } catch (Exception e) {
 
      throw new RuntimeException(e);
 
    }
 
  }
  
  
  public void setDBproperties() throws URISyntaxException{
	//  String databaseUrl = System.getenv("DATABASE_URL");
	 
	  URI dbUri = new URI(System.getenv("DATABASE_URL"));
	  System.out.println(dbUri);
	  String username = dbUri.getUserInfo().split(":")[0];
      String password = dbUri.getUserInfo().split(":")[1];
      String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	  
	  
	//  String jdbcUrl = String.format("jdbc:postgresql://%s:%s/%s?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", host, port, databaseName);
	 
	  properties.put("javax.persistence.jdbc.url", dbUrl );
	  properties.put("javax.persistence.jdbc.user", username );
	  properties.put("javax.persistence.jdbc.password", password );
	  properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
	  properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	  
	 
  }
 
}