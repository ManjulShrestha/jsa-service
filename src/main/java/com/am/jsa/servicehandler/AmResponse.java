package com.am.jsa.servicehandler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class AmResponse {
	/**
	 * Success response from service
	 *
	 * @param message
	 * @return
	 */
	public static ResponseEntity successResponse(String message) {
		AmWsResponse r = new AmWsResponse();
		r.setMessage(message);
		r.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8").body(r);

	}

	public static ResponseEntity successResponse(Object object) {
		AmWsResponse r = new AmWsResponse();
		r.setMessage("success");
		r.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8").body(object);

	}

	public static ResponseEntity successResponse(List<Object> listObject) {
		AmWsResponse r = new AmWsResponse();
		r.setMessage("success");
		r.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8").body(listObject);

	}

	/**
	 * In case we need response for custom http status
	 *
	 * @param statusCode
	 * @param message
	 * @return
	 */
	public static ResponseEntity Response(Integer statusCode, String message) {
		AmWsResponse r = new AmWsResponse();
		r.setMessage(message);
		r.setHttpStatusCode(statusCode);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8").body(r);

	}

	public static ResponseEntity Response(AmWsResponse amWsResponse) {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8").body(amWsResponse);

	}

}
