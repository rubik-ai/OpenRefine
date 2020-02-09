package org.openrefine.browsing.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openrefine.browsing.facets.Facet;
import org.openrefine.browsing.facets.FacetState;
import org.openrefine.expr.Evaluable;
import org.openrefine.expr.ExpressionUtils;
import org.openrefine.model.ColumnModel;
import org.openrefine.model.Record;
import org.openrefine.model.Row;
import org.openrefine.util.StringUtils;

/**
 * Gathers statistics about distinct string representations
 * of values generated by an evaluable.
 * 
 * @todo this is not optimized so far (Map<String, Long> could
 * probably be made more memory efficient, the serialization of
 * the object could be controlled).
 * 
 * @author Antonin Delpeuch
 *
 */
public class StringValuesFacetState implements FacetState {
	
	private static final long serialVersionUID = 1L;
	final protected Map<String, Long> _counts;
	final protected long _errors;
	final protected long _blanks;
	
	public StringValuesFacetState() {
	    this(Collections.emptyMap(), 0L, 0L);
	}

	public StringValuesFacetState(Map<String, Long> counts, long errors, long blanks) {
        _counts = counts;
        _errors = errors;
        _blanks = blanks;
    }
	
	public Map<String, Long> getCounts() {
		return _counts;
	}
	
	public long getErrorCount() {
		return _errors;
	}
	
	public long getBlankCount() {
		return _blanks;
	}
}