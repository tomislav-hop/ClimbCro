package hr.foi.air.climbcro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.login);
		
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		
		Button btnLogin = (Button) findViewById(R.id.logIn);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				checkLogin();
			}
		});
		
		Button btnRegistracija = (Button) findViewById(R.id.gumb_registriraj_se);
		btnRegistracija.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				register();
			}
		});
		super.onResume();
	}
	
	private void checkLogin(){
		String user = "";
		String pass = "";
		
		EditText username = (EditText) findViewById(R.id.username);
		EditText userpass = (EditText) findViewById(R.id.userpass);
		
		user = username.getText().toString();
		pass = userpass.getText().toString();
		Log.d("User i pass", user + " " + pass);
		
		if (user.equals("admin") && pass.equals("0000")){
							
				Toast.makeText(this, "Uspjesno logiranje", Toast.LENGTH_LONG).show();
				Intent i = new Intent(this, MainActivity.class);
		    	startActivity(i);
			
		}
		else if(user.equals("") && pass.equals("")) {
			Toast.makeText(this, "Unesite lozinku i kor ime", Toast.LENGTH_LONG).show();

			
		}
		
		else {
			Toast.makeText(this, "Pogrešno korisnièko ime ili lozinka", Toast.LENGTH_LONG).show();

		}
	}
	
	private void register(){
		Intent i = new Intent(this, RegistrationActivity.class);
    	startActivity(i);
		
	}
	
}
