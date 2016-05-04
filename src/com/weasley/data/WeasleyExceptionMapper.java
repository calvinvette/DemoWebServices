package com.weasley.data;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class WeasleyExceptionMapper implements ExceptionMapper<Throwable> {
	Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;  // HTTP 500

	@Override
	public Response toResponse(Throwable exception) {
		if (exception instanceof NullPointerException) {
			// Nothing to tell the client here
		}
		
		if (exception instanceof NotAuthorizedException) {
			status = Response.Status.FORBIDDEN; // Is this right?
		}
		
		if (exception instanceof CustomerNotFoundException) {
			status = Response.Status.NOT_FOUND; // HTTP 404 
		}
		
		return Response.status(status)
				// absolutley do not send them the exception object
				.entity("Our internal problem, no your fault")
//				.cookie(NewCookie.DEFAULT_MAX_AGE, )
//				.cookie(new Cookie("userId", "hpotter"))
//				.header("Language", "Klingon")
				.build();
	}

}
