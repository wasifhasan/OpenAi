package com.apps.openai.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.openai.model.BotRequest;
import com.apps.openai.model.OpenAiResponse;
import com.apps.openai.service.OpenAiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class OpenAiController {
 
	@Autowired
	private  OpenAiService openAiService ;
	
	@PostMapping("/send")
	public OpenAiResponse sendMessage(@RequestBody BotRequest request) {
		return openAiService.askQuestion(request);
	}
	
}
