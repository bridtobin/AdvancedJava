package Practical10;
// See README.md for question details

public class ListMap<K, V> implements Map<K, V> {
	public class ListMapEntry implements Entry<K,V> {
		K key;
		V value;
		
		public ListMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K key() {
			return key;
		}

		@Override
		public V value() {
			return value;
		}
		
	}
	
	private List<Entry<K,V>> list = new LinkedList<Entry<K,V>>();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public V get(K k) {
		Position<Entry<K,V>> P = find(k) ;
		if(P==null) {
			return null;
		}
		return P.element().value() ;
	}

	@Override
	public V put(K k, V v) {
		ListMapEntry E = new ListMapEntry(k,v) ;
		Position<Entry <K,V>> P = find(k) ;
		if(P==null) {
			list.insertLast(E) ;
			return null;
		}
        Entry<K, V> temp = list.replace(P,E) ;
		return temp.value();
	}

	@Override
	public V remove(K k) {
		Position<Entry <K,V>> P = find(k) ;
		if(P==null) {
			return null;
		}
		else {
			list.remove(P) ;
			return P.element().value() ;
		}
			
	}

//this is the find operation which is not in an ordinary list but is in a map implemented using a list		
	private Position<Entry <K,V>> find(K key) {
		if(list.isEmpty()) {
			return null;
		} 
		else {
			Position<Entry<K,V>> P = list.first();
			while(P != list.last()) {
				if(P.element().key()==key) {
					return P ;		}
				P = list.next(P) ;		
			}
			if(P.element().key()==key) {
				return P ;
			}
		}
		return null;
	}

	@Override
	public Iterator<K> keys() {
		return new Iterator<K>() {
			Iterator<Entry<K,V>> iterator = list.iterator();
			
			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public K next() {
				return iterator.next().key();
			}
		};
	}

	@Override
	public Iterator<V> values() {
		return new Iterator<V>() {
			Iterator<Entry<K,V>> iterator = list.iterator();
			
			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public V next() {
				return iterator.next().value();
			}
		};
	}

	@Override
	public Iterator<Entry<K, V>> entries() {
		return list.iterator();
	}

	public String toString() {
		Position<Entry<K,V>> c = list.first() ;
		
		String output = "Size:  [" + list.size() + "]    Key        Value   \n"  ;
		output += "------------------------------------------------------\n" ;
		while (c != null) {
			output += "              " + c.element().key() ;
			output += "         " + c.element().value() + "\n";
			c = list.next(c) ;
		}
		return output ;
	}
	public static void main(String[] args) {
		ListMap<String, String> testMap = new ListMap<String, String>() ;
		testMap.put("ie","Ireland") ;
		testMap.put("uk","United Kingdom") ;
		testMap.put("us","USA") ;
		testMap.put("de","Germany") ;
		testMap.put("fr","France") ;
        testMap.remove("uk") ;
		testMap.put("us","United States of America") ;
		testMap.put("es","Spain") ;
		testMap.put("uk","United Kingdom") ;
		System.out.println(testMap.get("us") + "\n") ;
		System.out.println(testMap) ;
	}
}