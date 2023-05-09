package com.apps.openai.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apps.openai.config.OpenAiConfig;
import com.apps.openai.model.BotRequest;
import com.apps.openai.model.OpenAiRequest;
import com.apps.openai.model.OpenAiResponse;

@Service
public class OpenAiServiceImpl implements OpenAiService{
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public HttpEntity<OpenAiRequest> buildHttpEntity(OpenAiRequest request){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(OpenAiConfig.MEDIA_TYPE));
		headers.add(OpenAiConfig.AUTHORIZATION, OpenAiConfig.BEARER + OpenAiConfig.API_KEY);
		return new HttpEntity<>(request, headers);
		
	}
	
	public OpenAiResponse getResponse(HttpEntity<OpenAiRequest> botRequestEntity) {
		ResponseEntity<OpenAiResponse> responseEntity =  restTemplate.postForEntity(
				OpenAiConfig.URL, 
				botRequestEntity, 
				OpenAiResponse.class);
		return responseEntity.getBody();
	}
			
	@Override
	public OpenAiResponse askQuestion(BotRequest request) {
		return this.getResponse(this.buildHttpEntity(
				new OpenAiRequest(
					OpenAiConfig.MODEL,
					request.getMessage(),
					OpenAiConfig.TEMPERATURE,
					OpenAiConfig.MAX_TOKEN,
					OpenAiConfig.TOP_P		
						))); 
	}

}
