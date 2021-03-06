/* © 2010 Stephan Reichholf <stephan at reichholf dot net>
 * 
 * Licensed under the Create-Commons Attribution-Noncommercial-Share Alike 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package net.reichholf.dreamdroid.helpers.enigma2;

import java.util.ArrayList;

import net.reichholf.dreamdroid.dataProviders.SaxDataProvider;
import net.reichholf.dreamdroid.helpers.ExtendedHashMap;
import net.reichholf.dreamdroid.helpers.SimpleHttpClient;
import net.reichholf.dreamdroid.parsers.GenericSaxParser;
import net.reichholf.dreamdroid.parsers.enigma2.saxhandler.E2PowerStateHandler;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author sre
 *
 */
public class PowerState {
	public static String IN_STANDBY = "standby";
	public static String SET = "set";
	
	public static String STATE_GET = "-1";
	public static String STATE_TOGGLE = "0";
	public static String STATE_SHUTDOWN = "1";
	public static String STATE_SYSTEM_REBOOT = "2";
	public static String STATE_GUI_RESTART = "3";
	
	public static String set(SimpleHttpClient shc, String state) {
		
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("newstate", state) );		
		if (shc.fetchPageContent(URIStore.POWERSTATE, params)) {
			return shc.getPageContentString();
		}

		return null;
	}
	
	public static ExtendedHashMap parseResult(String xml){
		ExtendedHashMap result = new ExtendedHashMap();
		
		SaxDataProvider sdp = new SaxDataProvider(new GenericSaxParser());

		E2PowerStateHandler handler = new E2PowerStateHandler(result);
		sdp.getParser().setHandler(handler);

		if (sdp.parse(xml)) {
			return result;
		}

		return null;		
	}
}
