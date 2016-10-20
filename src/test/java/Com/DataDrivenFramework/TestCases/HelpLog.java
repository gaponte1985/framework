package Com.DataDrivenFramework.TestCases;


import org.apache.log4j.Logger;


public class HelpLog {
	
	private static Logger log = Logger.getLogger("Application");
		
	    public static void main (String [] args){
	        int i =0;
	    	log.debug("hello");
	    	System.out.println(i);
	    	log.error("error");
	    	
	 
	    }		
}
