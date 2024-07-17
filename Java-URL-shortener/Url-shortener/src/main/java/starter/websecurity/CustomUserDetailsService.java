package starter.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import starter.account.Account;
import starter.account.AccountRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public UserDetails loadUserByUsername (String username)
	{
		Account acc = accountRepository.findOneByUsername(username);

		if (acc == null)
		{
			throw new UsernameNotFoundException(username);
		}
		return new MyUserPrincipal(acc);
	}

}
