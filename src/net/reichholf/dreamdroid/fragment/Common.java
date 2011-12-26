package net.reichholf.dreamdroid.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Some common functions shared by different Fragment classes.
 *
 * @author Stefan Endrullis &lt;stefan@endrullis.de&gt;
 */
public class Common {
	public static void findSimilarEvents(Fragment fragment, String title) {
		// TODO
		showNotYetImplemented(fragment);
	}

	public static void showNotYetImplemented(Fragment fragment) {
		Context context = fragment.getActivity().getApplicationContext();
		Toast.makeText(context, "Not yet implemented!", Toast.LENGTH_SHORT).show();
	}
}
