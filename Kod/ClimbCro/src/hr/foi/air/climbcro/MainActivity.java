package hr.foi.air.climbcro;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Glavna klasa u kojoj se pozivaju ostale klase aplikacije i 
 * definiraju se glavne funkcionalnosti.
 * @author H3
 *
 */

public class MainActivity extends Activity 
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
	private static Context mContext;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        
    	super.onCreate(savedInstanceState);
    	mContext = this.getApplicationContext();
    	setContentView(R.layout.activity_main);
        
      
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }
    
    

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        
        
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }
    
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = null; 

            /**
             * Provjera koji element u izborniku je odabra
             * Ovisno o odabranom izborniku, otvara se odgovarajuæi layout
             */
            int i = getArguments().getInt(ARG_SECTION_NUMBER);
            
            if (i == 1){
            	
            	//onDestroyView();
            	rootView = inflater.inflate(R.layout.fragment_main, container, false);
            }
            if (i == 2){
            	//onDestroyView();
            	rootView = inflater.inflate(R.layout.tab2, container, false);
            }if (i==3){
            	rootView = inflater.inflate(R.layout.detalji_rute, container, false);
            }
            if (i==4){
            	//karta();
            	//onDestroyView();
            	rootView = inflater.inflate(R.layout.kreiraj_rutu, container, false);
            }
            if (i==5){
            	karta();
            }
            
            return rootView;
        }
        
        //Funkcija koja kartu otvara u novom activitiyu
        
    	private void karta(){
    		Intent i = new Intent(mContext, MapActivity.class);
        	startActivity(i);
    		
    	}

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public static Context getAppContext(){
        return mContext;
     }
    
    
    //FUnkcija koja brise staru kartu i nakon ponovnog otvaranja opet kreira mapu(NE RADI)
    /*
    protected void onDestroyView() {
    	FragmentManager fragmentManager = getFragmentManager();
    	Fragment oldMapFrag = getFragmentManager().findFragmentById(R.id.map);
    	if(oldMapFrag != null) {
    	    getFragmentManager().beginTransaction().remove(oldMapFrag).commit();
    	    
    	    fragmentManager.popBackStack();
    	    
    	}
    }  	*/
}
