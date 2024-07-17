package starter.redirect;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class RedirectContoller
{
	@Autowired
	RedirectService redirectService;

	@GetMapping("/http://short.com/{seo}")

	public ModelAndView detail(@PathVariable String seo, Principal principal) throws Exception{

		return  redirectService.getURL(seo, principal);

	}


}
