package qc.cegep_ste_foy.equipe2.calculatorgs.helpers;

import qc.cegep_ste_foy.equipe2.calculatorgs.AppConstants;
import retrofit.RestAdapter;

public class NetworkRequest {
		
	private static NetworkRequestApiRetrofit api;
	
	public static NetworkRequestApiRetrofit api() {
		
		if (api == null) {
			RestAdapter adapter = new RestAdapter.Builder()
			.setEndpoint(AppConstants.ENDPOINT)
			.build();
			api = adapter.create(NetworkRequestApiRetrofit.class);
		}
		
		return api;
	}
	
	

}
