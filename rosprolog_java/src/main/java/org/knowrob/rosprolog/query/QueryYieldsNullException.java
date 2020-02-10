package org.knowrob.rosprolog.query;

import org.jpl7.Query;

public class QueryYieldsNullException extends Exception {
	private static final long serialVersionUID = -2345651829510699915L;
	
	public QueryYieldsNullException(Query query) {
		super("The query did not yield in any results.");
	}
}
