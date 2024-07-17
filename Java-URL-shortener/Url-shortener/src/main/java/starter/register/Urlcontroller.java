package starter.register;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;




@RestController
public class Urlcontroller {
	private String redirect;

	@Autowired
	UrlService urlService;


	@PostMapping("/register")

	public Map<String, String> getShortenedUrl(@RequestBody(required=true) JSONObject originalUrl) throws  JsonProcessingException, IOException
	{
		final String orgUrl = originalUrl.get("url").toString();
		System.out.println(orgUrl);

		redirect = (String) originalUrl.getOrDefault("redirectType", "302");

		return  Collections.singletonMap("ShortUrl",urlService.saveUrl(orgUrl, redirect));
	}
}


