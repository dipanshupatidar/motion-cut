package starter.redirect;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import starter.register.URLRepository;
import starter.register.Url;
import starter.statistics.Statistics;
import starter.statistics.StatisticsRepository;



@Service
public class RedirectService {

	@Autowired
	URLRepository urlRepository;
	@Autowired
	StatisticsRepository statisticsRepository;







	public ModelAndView getURL(String shortenURL, Principal principal) throws Exception  {

		long id = Base10.reverseUrl(shortenURL);

		Optional<Url> originalUrl = urlRepository.findByidUrl(id);

		if(originalUrl.isPresent())
		{

			Url org =  originalUrl.get();
			Statistics stat = statisticsRepository.findByUrlStatAndUserStat(org.getLongUrl(), principal.getName());
			if(stat == null)
			{
				statisticsRepository.save(new Statistics (principal.getName(),org.getLongUrl(),1));
			}
			else
			{
				stat.setNumberOfRedirects(stat.getNumberOfRedirects()+1);
				statisticsRepository.save(stat);
			}

			return redirect(org.getLongUrl(), org.getRedirectType());


		}
		else
		{
			return renderErrorPage();

		}




	}
	private ModelAndView renderErrorPage() throws Exception
	{
		throw new Exception("This URL must be registered");
	}


	private ModelAndView redirect(String originarUrl, String redirectType)
	{
		RedirectView rv = new RedirectView();

		if (redirectType.equals("301"))
		{
			rv.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		}
		else
		{
			rv.setStatusCode(HttpStatus.FOUND);
		}

		rv.setUrl(originarUrl);

		ModelAndView mv = new ModelAndView(rv);


		return mv;
	}





}





