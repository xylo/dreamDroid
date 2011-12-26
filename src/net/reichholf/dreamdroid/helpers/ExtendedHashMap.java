/* © 2010 Stephan Reichholf <stephan at reichholf dot net>
 * 
 * Licensed under the Create-Commons Attribution-Noncommercial-Share Alike 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package net.reichholf.dreamdroid.helpers;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author sreichholf
 * 
 */
public class ExtendedHashMap extends HashMap<String, Object> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExtendedHashMap() {
		super();
	}

	@Override
	public ExtendedHashMap clone() {
		return (ExtendedHashMap) super.clone();
	}

	/**
	 * Like standard put but concatenates the value if value is a
	 * "java.lang.String" and there already was a String value for the key
	 * 
	 * @param key key
	 * @param value value for given
	 */
	public void putOrConcat(String key, Object value) {
		// Exceptions are very expensive in terms of runtime so let's try to
		// avoid them
		if (containsKey(key)) {
			try {
				// TODO: question: Why not using String.class instead of Class.forName("java.lang.String")?
				if (value.getClass().equals(Class.forName("java.lang.String"))) {

					Object old = get(key);
					if ((old.getClass().equals(Class.forName("java.lang.String")))) {
						String oldVal = (String) old;
						String val = (String) value;
						value = oldVal.concat(val);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		put(key, value);
	}

	/**
	 * @param key key
	 * @return value for given key
	 */
	public String getString(String key) {
		return (String) get(key);
	}
	
	/**
	 * @param key key
	 * @param defaultString default value
	 * @return value for given key
	 */
	public String getString(String key, String defaultString) {
		String retVal = (String) get(key);
		if(retVal == null){
			retVal = defaultString;
		}
		return retVal;
	}
}
