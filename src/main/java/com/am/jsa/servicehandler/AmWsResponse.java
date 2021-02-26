/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.jsa.servicehandler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmWsResponse {
	private String message;
	private Integer httpStatusCode;
	private String errorLevelCode;
	private String errorCode;
	private Integer severityLevel;
	private String errorMessage;
	private String apiPath;
	private String httpMethod;

	public AmWsResponse() {
		// TODO Auto-generated constructor stub
	}

	public AmWsResponse(Integer httpStatusCode, String errorLevelCode, String errorCode, Integer severityLevel,
                        String errorMessage) {
		super();
		this.httpStatusCode = httpStatusCode;
		this.errorLevelCode = errorLevelCode;
		this.errorCode = errorCode;
		this.severityLevel = severityLevel;
		this.errorMessage = errorMessage;
	}

	public AmWsResponse(Integer statusCode, String Msg) {
		this.httpStatusCode = statusCode;
		this.message = Msg;
	}
	
	public static AmWsResponse createResponse(Integer status, String msg) {
		return new AmWsResponse(status, msg);
	}


	@JsonProperty
	public String getMessage() {
		/* Don't override the message for successfully completed requests */
		if (httpStatusCode != null && !httpStatusCode.equals(200)) {
			message = "" + httpStatusCode + "-" + errorLevelCode + "-" + errorCode + "-" + severityLevel;
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public String getErrorLevelCode() {
		return errorLevelCode;
	}

	public void setErrorLevelCode(String errorLevelCode) {
		this.errorLevelCode = errorLevelCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(Integer severityLevel) {
		this.severityLevel = severityLevel;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

}
