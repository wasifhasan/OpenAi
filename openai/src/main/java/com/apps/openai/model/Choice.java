package com.apps.openai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {

	  private Integer index;
	    private String text;
	    @JsonProperty("finish_reason")
	    private String finishReason;
		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getFinishReason() {
			return finishReason;
		}
		public void setFinishReason(String finishReason) {
			this.finishReason = finishReason;
		}
}
