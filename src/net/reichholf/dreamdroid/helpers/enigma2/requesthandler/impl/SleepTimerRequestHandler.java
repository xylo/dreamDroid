/* © 2010 Stephan Reichholf <stephan at reichholf dot net>
 * 
 * Licensed under the Create-Commons Attribution-Noncommercial-Share Alike 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package net.reichholf.dreamdroid.helpers.enigma2.requesthandler.impl;

import java.util.ArrayList;

import net.reichholf.dreamdroid.helpers.ExtendedHashMap;
import net.reichholf.dreamdroid.helpers.SimpleHttpClient;
import net.reichholf.dreamdroid.helpers.enigma2.SleepTimer;
import net.reichholf.dreamdroid.helpers.enigma2.URIStore;

import org.apache.http.NameValuePair;

/**
 * @author sre
 *
 */
public class SleepTimerRequestHandler {	
	public String get(SimpleHttpClient shc, ArrayList<NameValuePair> params){
		if (shc.fetchPageContent(URIStore.SLEEPTIMER, params)) {
			return shc.getPageContentString();
		}

		return null;
	}
	
	public ExtendedHashMap parse(String xml){
		return SleepTimer.parse(xml);
	}
}
