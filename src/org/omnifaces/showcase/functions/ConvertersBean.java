package org.omnifaces.showcase.functions;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ConvertersBean {

	private String[] array;
	private Set<String> set;
	private Map<String, String> map;

	@PostConstruct
	public void init() {
		array = new String[] { "item1", "item2", "item3" };

		set = new LinkedHashSet<String>(3);
		set.add("item1");
		set.add("item2");
		set.add("item3");

		map = new LinkedHashMap<String, String>(3);
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
	}

	public String[] getArray() {
		return array;
	}

	public Set<String> getSet() {
		return set;
	}

	public Map<String, String> getMap() {
		return map;
	}
	
	public Iterable<Integer> getIterable() {
		return new TestIterable();
	}

	private static class TestIterable implements Iterable<Integer> {

		@Override
		public Iterator<Integer> iterator() {
			return new Iterator<Integer>() {

				int index = 0;

				@Override
				public boolean hasNext() {
					return index < 3;
				}

				@Override
				public Integer next() {
					return index++;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

			};
		}

	}
	
}