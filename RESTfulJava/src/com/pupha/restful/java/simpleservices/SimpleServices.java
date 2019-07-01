package com.pupha.restful.java.simpleservices;

import java.util.Arrays;

import javax.ws.rs.*;
import org.json.*;

@Path("/")
public class SimpleServices {

	public String InputPattern = "{\"input\":%s}";
	public String OutputPattern = "{\"output\":%s}";
	public String OutputPattern2 = "{\"output\":\"%s\"}";
	
	@POST 
	@Path("/api/firstfactorial/")
	@Consumes("application/json")
	@Produces("application/json")
    public String FirstFactorial(FactorialObject input)
    {
        try {
			if(input.getInput()>1) 
			{
				long temp = input.getInput();
				
			     FactorialObject tempObj 
			     = new FactorialObject( input.getInput()- 1 , 0);

			     JSONObject tempObj2
			     = new JSONObject( FirstFactorial(tempObj) );
			     
			     temp = temp * tempObj2.getLong("output");
			     
								
			    return String.format(OutputPattern, temp );
			}
			else return String.format(OutputPattern, 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.format(OutputPattern, "Error");
    }
	

	@POST 
	@Path("/api/firstreverse/")
	@Consumes("application/json")
	@Produces("application/json")
    public String FirstReverse(ObjectOfInterest str)
    {
//        String rts = new StringBuilder(str).reverse().toString();

        StringBuilder rts = new StringBuilder();
        for(int i = str.getInput().length() - 1; i >= 0; i--)
        {
            rts.append(str.getInput().charAt(i));
        }
	    return String.format(OutputPattern, rts.toString() );
    }
	
	@POST 
	@Path("/api/alphabetsoup/")
	@Consumes("application/json")
	@Produces("application/json")
    public String AlphabetSoup(ObjectOfInterest str)
    {

        char[] sorted = str.getInput().toCharArray();
        Arrays.sort(sorted);

        String soup = new String(sorted);

        return soup;
    }
    
	@POST 
	@Path("/api/palindrome/")
	@Consumes("application/json")
	@Produces("application/json")
	private String PalindromeCheck(ObjectOfInterest str)
    {
		
		StringBuilder rts = new StringBuilder();
        for(int i = str.getInput().length() - 1; i >= 0; i--)
        {
            rts.append(str.getInput().charAt(i));
        }
        		
        if(str.getInput().equals(rts))
    	    return String.format(OutputPattern, "true" );
        else
    	    return String.format(OutputPattern, "false" );
    }
	
}
