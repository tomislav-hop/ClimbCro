/**
 * Klasa za popunjavanje liste sa rutama
 */

package hr.foi.air.climbcro;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivity extends Activity {

	//lista ruta
	ArrayList<String> lista_ruta;

	public void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		setContentView(R.layout.fragment_main);

		// dohvaæanje liste
		final ListView popisRuta = (ListView) findViewById(R.id.moje_rute);

		lista_ruta = new ArrayList<String>();
		dohvatRuta();
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lista_ruta);
		// postavljanje adaptera
		popisRuta.setAdapter(arrayAdapter);

		// onClickListener za upravljanje svakog klika na element liste
		popisRuta.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> myAdapter, View myView,
					int myItemInt, long mylng) {
				//dohvaæanje selektirane rute
				String selectedFromList = (String) (popisRuta.getItemAtPosition(myItemInt));
				Toast toast = Toast.makeText(getApplicationContext(),
						selectedFromList, Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}

	// TODO Auto-generated method stub

	void dohvatRuta() {
		lista_ruta.add("Ruta Ivanšæica");
		lista_ruta.add("Ruta Ravna Gora");
		lista_ruta.add("Ruta Kalnik");
		lista_ruta.add("Ruta Dinara");
		lista_ruta.add("Ruta Velebit");
		lista_ruta.add("Ruta Ivanšæica-sjever");
		lista_ruta.add("Ruta Petrov vrh");
		lista_ruta.add("Ruta Velebit - sjever");
		lista_ruta.add("Ruta Uæka");
		lista_ruta.add("Ruta 5");
		lista_ruta.add("Ruta 6");
		lista_ruta.add("Ruta 7");
		lista_ruta.add("Ruta 8");
		lista_ruta.add("Ruta 9");
		lista_ruta.add("Ruta 10");

	}
}