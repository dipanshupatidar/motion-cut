package starter.register;

import java.util.Optional;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UrlService
{


	@Autowired
	private URLRepository urlRepository;

	private final String domain="http://short.com/";


	public String saveUrl(String originalURL, String redirect)
	{
		Url url = new Url();
		String[] schemes = {"http","https"};
		UrlValidator valid = new UrlValidator(schemes);

		if (valid.isValid(originalURL))
		{
			Optional<Url> exitURL = urlRepository.findBylongUrl(originalURL);

			if(exitURL.isPresent())
			{

				url = exitURL.get();
			}

			else
			{
				url = urlRepository.save(new Url (originalURL, redirect));
			}
		}

		return generateURLShorterner(url);
	}

	private String generateURLShorterner(Url url) {

		String shortenedURL = this.domain + Base62.toBase62(url.getIdUrl());

		return shortenedURL;
	}

}
