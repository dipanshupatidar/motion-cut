package starter.account;



import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	private String password;
	private String newPassword;
	
	@Autowired
	AccountRepository accountRepository;
	public boolean checkAccount(String accId) 
	{
		
		if(accountRepository.findOneByUsername(accId) != null)
		
		{	
			return false;
		}
		
		else 
		{
			return true;
		  
		}
		
	}
	
	public String addAccount(String accId)
	{
		
		password=RandomStringUtils.randomAlphanumeric(8);
		
		BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder(11);
		
		newPassword=cryptPasswordEncoder.encode(password);
		
		accountRepository.save(new Account(accId, newPassword));
		
		return password;
	}
	

	
	
	
}
