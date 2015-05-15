package project.dharssan.lastminutesports;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import java.io.IOException;
import java.io.InputStream;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import android.util.Log;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageButton ducks;
    private ImageButton coyotes;
    private ImageButton bruins;
    private ImageButton sabres;
    private ImageButton flames;
    private ImageButton hurricanes;
    private String title;
    private boolean toggle_ducks = false;
    private boolean toggle_coyotes = false;
    private boolean toggle_bruins = false;
    private boolean toggle_sabres = false;
    private boolean toggle_flames = false;
    private boolean toggle_hurricanes = false;
    private String url = "http://www.androidbegin.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ducks = (ImageButton) findViewById(R.id.ducks);
        coyotes = (ImageButton) findViewById(R.id.coyotes);
        bruins = (ImageButton) findViewById(R.id.bruins);
        sabres = (ImageButton)findViewById(R.id.sabres);
        flames = (ImageButton)findViewById(R.id.flames);
        hurricanes = (ImageButton)findViewById(R.id.hurricanes);




        ducks.setOnClickListener(this);
        coyotes.setOnClickListener(this);
        bruins.setOnClickListener(this);
        sabres.setOnClickListener(this);
        flames.setOnClickListener(this);
        hurricanes.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
        if(v ==ducks){
            turnOnDucks();
        }else if (v == coyotes){

            turnOnCoyotes();

        }
        else if (v== bruins){
            turnOnBruins();
        }
        else if (v==sabres){

            turnOnSabres();
        }
        else if (v==flames){

            turnOnFlames();
        }
        else if (v==hurricanes) {

            turnOnHurricanes();
        }
    }

    private void turnOnHurricanes() {
        if(toggle_hurricanes){
            hurricanes.setImageResource(R.drawable.hurricanes_faded);

            toggle_hurricanes = false;
        }else
        {
            hurricanes.setImageResource(R.drawable.on_hurricanes);
            toggle_hurricanes = true;
        }

    }

    private void turnOnFlames () {
        if(toggle_flames) {
            flames.setImageResource(R.drawable.flames_copy);
            toggle_flames = false;
        }
        else {
            flames.setImageResource(R.drawable.on_flames);
            toggle_flames = true;
        }
    }


    private void turnOnSabres() {
        if(toggle_sabres) {
            sabres.setImageResource(R.drawable.sabres_faded);
            toggle_sabres = false;
        }else{
            sabres.setImageResource(R.drawable.on_sabres);
            toggle_sabres = true;
        }
    }

    private void turnOnBruins() {
        if (toggle_bruins) {
            toggle_bruins = false;
            bruins.setImageResource(R.drawable.boston_faded);
        } else {
            bruins.setImageResource(R.drawable.on_boston);
            toggle_bruins = true;
        }
    }
    private void turnOnCoyotes() {
        if (toggle_coyotes) {
            coyotes.setImageResource(R.drawable.faded_coyotes);
            toggle_coyotes = false;
        } else {
            coyotes.setImageResource(R.drawable.on_coyotes);
            toggle_coyotes = true;
        }
    }

    private void turnOnDucks() {
        if (toggle_ducks){
            ducks.setImageResource(R.drawable.ducks_fade);
            toggle_ducks = false;
        }else
        {
            toggle_ducks = true;
            ducks.setImageResource(R.drawable.on_ducks);
        }
    }


}
