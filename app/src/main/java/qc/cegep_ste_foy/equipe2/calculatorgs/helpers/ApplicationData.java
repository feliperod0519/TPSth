package qc.cegep_ste_foy.equipe2.calculatorgs.helpers;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;

import qc.cegep_ste_foy.equipe2.calculatorgs.AppConstants;

public class ApplicationData {
	
	public static void saveCurrentSessionId(Context context, String CurrentSessionId) {
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = pref.edit();
		editor.putString(AppConstants.CURRENT_SESSION_ID, CurrentSessionId);
		editor.commit();		
	}
	
	public static String getCurrentSessionId(Context context) {
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);		
		return pref.getString(AppConstants.CURRENT_SESSION_ID, null);
	}
	

    public static String getSessionId(Context context) {
        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDeviceId, tmSerialNumber, androidId;
        tmDeviceId = "" + tm.getDeviceId();
        tmSerialNumber = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDeviceId.hashCode() << 32) | tmSerialNumber.hashCode());
        String deviceId = deviceUuid.toString();

        return deviceId;
    }


}
