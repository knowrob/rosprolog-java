package org.knowrob.rosprolog.query;

public class NextSolutionCommand extends QueryCommand {
	@Override
	public Object execute(org.jpl7.Query query) {
		return query.nextElement();
	}
}
