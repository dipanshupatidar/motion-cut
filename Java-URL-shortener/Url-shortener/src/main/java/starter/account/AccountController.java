package starter.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;



@RestController 

public class AccountController 
{
	@Autowired
	private AccountService accountService;
	
	private boolean status;
	

@PostMapping("/account")

		public AccountResponse addAccount(@RequestBody(required=true) JSONObject accId) 
	{		
	  
	
    	String username = accId.get("AccountId").toString();
	     
    	status=accountService.checkAccount(username);	
		
    	if (status == false)
				{ 
					
				
					return new AccountResponse(status,"This account already exists",null);
			
			
				}
		else
				{ 	
			
			
				return new AccountResponse(status,"Account successfully created", accountService.addAccount(username));
			
				}
		
		
	}




}

