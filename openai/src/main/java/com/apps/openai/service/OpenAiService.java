package com.apps.openai.service;

import com.apps.openai.model.BotRequest;
import com.apps.openai.model.OpenAiResponse;

public interface OpenAiService {

	OpenAiResponse askQuestion(BotRequest request);

}
