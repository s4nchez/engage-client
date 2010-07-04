package net.isanchez.jengage.http;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class QueryBuilderTest {

	private final QueryBuilder queryBuilder = new QueryBuilder();

	@Test
	public void testNullMapReturnsEmptyString_includingNullValues() throws Exception {
		assertEquals("", queryBuilder.buildQuery(null, true));
	}

	@Test
	public void testNullMapReturnsEmptyString_excludingNullValues() throws Exception {
		assertEquals("", queryBuilder.buildQuery(null, false));
	}

	@Test
	public void testEmptyMapReturnsEmptyString_includingNullValues() throws Exception {
		assertEquals("", queryBuilder.buildQuery(Collections.<String, String>emptyMap(), true));
	}

	@Test
	public void testEmptyMapReturnsEmptyString_excludingNullValues() throws Exception {
		assertEquals("", queryBuilder.buildQuery(Collections.<String, String>emptyMap(), false));
	}

	@Test
	public void testSingleEntryWithValue_includingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", "bar");
		assertEquals("foo=bar", queryBuilder.buildQuery(params, true));
	}

	@Test
	public void testSingleEntryWithValue_excludingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", "bar");
		assertEquals("foo=bar", queryBuilder.buildQuery(params, false));
	}

	@Test
	public void testSingleEntryWithoutValue_includingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", null);
		assertEquals("foo=", queryBuilder.buildQuery(params, true));
	}

	@Test
	public void testSingleEntryWithoutValue_excludingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", null);
		assertEquals("", queryBuilder.buildQuery(params, false));
	}

	@Test
	public void testMultipleEntriesAllValidValues_includingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", "bar");
		params.put("a", "b");
		params.put("c", "d");
		assertEquals("c=d&a=b&foo=bar", queryBuilder.buildQuery(params, true));
	}

	@Test
	public void testMultipleEntriesAllValidValues_excludingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", "bar");
		params.put("a", "b");
		params.put("c", "d");
		assertEquals("c=d&a=b&foo=bar", queryBuilder.buildQuery(params, false));
	}

	@Test
	public void testMultipleEntriesSomeValidValues_includingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", "");
		params.put("a", "b");
		params.put("c", null);
		assertEquals("c=&a=b&foo=", queryBuilder.buildQuery(params, true));
	}

	@Test
	public void testMultipleEntriesSomeValidValues_excludingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", "");
		params.put("a", "b");
		params.put("c", null);
		assertEquals("a=b&foo=", queryBuilder.buildQuery(params, false));
	}

	@Test
	public void testMultipleEntriesAllNullValues_includingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", null);
		params.put("a", null);
		params.put("c", null);
		assertEquals("c=&a=&foo=", queryBuilder.buildQuery(params, true));
	}

	@Test
	public void testMultipleEntriesAllNullValues_excludingNullValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("foo", null);
		params.put("a", null);
		params.put("c", null);
		assertEquals("", queryBuilder.buildQuery(params, false));
	}

}
