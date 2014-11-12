package hr.foi.air.climbcro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Klasa za registriranje novog korisnika.
 * @author Hrgar
 *
 */


public class RegistrationActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.registracija);
		
		super.onCreate(savedInstanceState);
	}

	
	@Override
	protected void onResume() {
		Button btnReg = (Button) findViewById(R.id.registriraj_se);
		btnReg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		super.onResume();
	}

	

	
	
}
