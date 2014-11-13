package hr.foi.air.climbcro;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends Activity {

	// ono sta se vrti
	private ProgressDialog pDialog;

	// varijable
	JSONParser jsonParser = new JSONParser();
	EditText korisnicko_ime;
	EditText lozinka;
	EditText email;
	
	// link na php skriptu
	//private static String url_create_product = "http://192.168.1.108/spajanje/dodaj_korisnika.php";
	//private static String url_create_product = "http://arka.foi.hr/~thop/spajanje/dodaj_korisnika.php";
	private static String url_create_product = "http://climbcro.net63.net/spajanje/dodaj_korisnika.php";
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registracija);

		// hvatanje unesenoga
		korisnicko_ime = (EditText) findViewById(R.id.korisnicko_ime);
		lozinka = (EditText) findViewById(R.id.lozinka);
		email = (EditText) findViewById(R.id.email);

		// button
		Button btnDodajKorisnika = (Button) findViewById(R.id.btnDodajKorisnika);

		// button click event
		btnDodajKorisnika.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// pozovi funkciju za kreiranje korisnika
				new KreirajNovogKorisnika().execute();
			}
		});
	}

	/**
	 * Background Async Task
	 * */
	class KreirajNovogKorisnika extends AsyncTask<String, String, String> {

		/**
		 * prikazi ono sta se vrti
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(RegistrationActivity.this);
			pDialog.setMessage("Creating Product..");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		/**
		 * Kreiraj korisnika
		 * */
		protected String doInBackground(String... args) {
			String korisnicko_ime_S = korisnicko_ime.getText().toString();
			String lozinka_S = lozinka.getText().toString();
			String email_S = email.getText().toString();

			// graðenje parametara
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("korisnicko_ime", korisnicko_ime_S));
			params.add(new BasicNameValuePair("email", lozinka_S));
			params.add(new BasicNameValuePair("lozinka", email_S));

			// hvatanje json objekta
			JSONObject json = jsonParser.makeHttpRequest(url_create_product,"POST", params);
			
			
			return null;
		}

		/**
		 * da se makne ono sta se vrti kad sve zavrsi
		 * **/
		protected void onPostExecute(String file_url) {
			pDialog.dismiss();
		}

	}
}
