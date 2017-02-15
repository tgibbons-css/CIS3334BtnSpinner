package css.cis3334.menusample2017;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerXML, spinnerJava, spinnerCustom;
    TextView tvDisplayItem;
    Button btnDisplay,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //--------------------------------------
        spinnerXML = (Spinner) findViewById(R.id.spinnerXML);
        spinnerJava = (Spinner) findViewById(R.id.spinnerJava);
        spinnerCustom = (Spinner) findViewById(R.id.spinnerCustom);
        tvDisplayItem = (TextView) findViewById(R.id.textViewDisplayItem);
        btnDisplay = (Button) findViewById(R.id.buttonDisplay);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        //--------------------------------------
        btn2.setOnClickListener(buttonClick2);
        //--------------------------------------
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                tvDisplayItem.setText("Button Click 3 method called");
            }
        });
        //--------------------------------------
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayList<String> items = new ArrayList<String>();
        items.add("Red");
        items.add("Green");
        items.add("Blue");
        items.add("Grey");
        items.add("Orange");
        items.add("Yellow");
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerJava.setAdapter(itemsAdapter);
        //------------
        spinnerJava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvDisplayItem.setText("Spinner Java selected : "+ parent.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //--------------------------------------
        spinnerXML.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvDisplayItem.setText("Spinner XML selected : "+ parent.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //--------------------------------------


        final ArrayList<Planet> planetList = new ArrayList<Planet>();
        // planet data from http://www.enchantedlearning.com/subjects/astronomy/planets/
        planetList.add(new Planet("Mercury", 57.9, 4800.0));
        planetList.add(new Planet("Venus", 108.2, 12104.0));
        planetList.add(new Planet("Mars", 227.9, 6787.0));
        planetList.add(new Planet("Mars2", 227.9, 6787.0));
        planetList.add(new Planet("Mars3", 227.9, 6787.0));
        planetList.add(new Planet("Mars4", 227.9, 6787.0));
        planetList.add(new Planet("Mars5", 227.9, 6787.0));
        planetList.add(new Planet("Mars6", 227.9, 6787.0));
//        ArrayAdapter<Planet> planetAdapter = new ArrayAdapter<Planet>(this, android.R.layout.simple_list_item_1, planetList);
//        planetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerCustom.setAdapter(planetAdapter);
        
        // create the custom array adapter. The 3rd parameter is just a placeholder for the parent class pointing to any textview in the new layout.
        ArrayAdapter<Planet> planetAdapter = new PlanetAdapter(this, R.layout.planet_row, R.id.textViewPlanetName, planetList);
        planetAdapter.setDropDownViewResource(R.layout.planet_row);
        spinnerCustom.setAdapter(planetAdapter);
        spinnerCustom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Planet planet = planetList.get(position);
                tvDisplayItem.setText("Custom Spinner selected : "+ planet.getName());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });


        //--------------------------------------
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //--------------------------------------
    }
    //--------------------------------------
    /** Called when the user touches the button */
    public void buttonClick1(View view) {
        // Do something in response to button click
        tvDisplayItem.setText("Button Click 1 method called");
    }
    //--------------------------------------
    private View.OnClickListener buttonClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvDisplayItem.setText("Button Click 2 method called");
        }
    };
    //--------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
