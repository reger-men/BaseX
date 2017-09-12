package org.basex.examples.api;

import java.io.*;

import javax.swing.JOptionPane;

import org.basex.core.cmd.XQuery;
import org.basex.examples.api.BaseXClient.Query;
import org.basex.examples.local.RunQueries;
import org.basex.query.QueryException;


/**
 * This example shows how new databases can be created.
 *
 * This example requires a running database server instance.
 * Documentation: http://docs.basex.org/wiki/Clients
 *
 * @author BaseX Team 2005-17, BSD License
 */
public final class CreateExample {

  /**
   * Main method.
   * @param args command-line arguments
   * @throws IOException I/O exception
   */
    public boolean insertUser(String Name, String Email, String Password, String Address) {
    	String query;
    	
    	// create session
        try(BaseXClient session = new BaseXClient("localhost", 1984, "admin", "admin")) {
          // define input stream
          //final InputStream bais = new ByteArrayInputStream("<xml>Hello World!</xml>".getBytes());

          // create new database
          //session.create("database", bais);
          
          // open database
          String response = session.execute("OPEN ADILDB");
          
          //check if User exists
          query = String.format("xquery for $s in Users/User where $s/UserName='%s' return $s/UserName", Name);
          response = session.execute(query);  
          if(response != null && !response.isEmpty()) {
        	  return false;
          }
          
          
          //insert new user
          String node = "<User>"
        	         + "<UserName>"+ Name +"</UserName>"
        	         + "<UserEmail>"+ Email +"</UserEmail>"
        	         + "<UserPassword>"
        	         + Password
        	         + "</UserPassword>"
        	         + "<UserAddress>"+ Address +"</UserAddress>"
        	         + "</User>";
          
          
          query = String.format("xquery insert node %s into Users[last()]", node);
          response = session.execute(query);  


          
          System.out.println(session.info());

          // run query on database
          System.out.println(session.execute("xquery doc('ADILDB')"));

          // drop database
          //session.execute("drop db database");
          
          
          //Close Database
          response = session.execute("CLOSE");
          
          
        }catch (IOException e){
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Connect error: " + "Connect error", JOptionPane.ERROR_MESSAGE);
        	return false;
        }
        
        return true;
        
    }
  
    //method to validate user
    public boolean validateUser(String Name, String Password){
    	if(checkLogin(Name, Password)){
    		return true;
    	}else{
    		//this.addActionError("Incorect username or password!!!");
    		return false;
    	}
    }
    
  //method to validate user
    public boolean checkLogin(String Name, String Password){
    	String query;
    	
    	// create session
        try(BaseXClient session = new BaseXClient("localhost", 1984, "admin", "admin")) {
          
          // open database
          String response = session.execute("OPEN ADILDB");
          
         
          
          //check if User exists
          query = String.format("xquery for $s in Users/User where $s/UserName='%s' return data($s/UserPassword)", Name);
          response = session.execute(query);  
          
          System.out.println(session.info());
          
          if(response != null && !response.isEmpty()) {
        	  if(response.equals(Password)){
        		  return true;
        	  }else{
        		  return false;
        	  }
        	  
          }
          
        }catch (IOException e){
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Connect error: " + "Connect error", JOptionPane.ERROR_MESSAGE);
        	return false;
        }
        
        return false;
    }
    
    
}



