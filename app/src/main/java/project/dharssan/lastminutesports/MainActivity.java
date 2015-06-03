package project.dharssan.lastminutesports;
import android.app.PendingIntent;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import android.util.Log;
import android.content.Intent;
import android.widget.Toast;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.util.AttributeSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private boolean firstTime = true;
    private ImageButton ducks;
    private ImageButton coyotes;
    private ImageButton bruins;
    private ImageButton sabres;
    private ImageButton flames;
    private ImageButton hurricanes;
    private ImageButton hawks;
    private ImageButton avalanche;
    private ImageButton jackets;
    private ImageButton stars;
    private ImageButton wings;
    private ImageButton oilers;
    private ImageButton panthers;
    private ImageButton kings;
    private ImageButton wild;
    private ImageButton habs;
    private ImageButton predators;
    private ImageButton devils;
    private ImageButton islanders;
    private ImageButton rangers;
    private ImageButton flyers;
    private ImageButton penguins;
    private ImageButton senators;
    private ImageButton sharks;
    private ImageButton blues;
    private ImageButton lightning;
    private ImageButton leafs;
    private ImageButton canucks;
    private ImageButton capitals;
    private ImageButton jets;
    private String title;
    private boolean toggle_ducks = false;
    private boolean toggle_coyotes = false;
    private boolean toggle_bruins = false;
    private boolean toggle_sabres = false;
    private boolean toggle_flames = false;
    private boolean toggle_hurricanes = false;
    private boolean toggle_hawks = false;
    private boolean toggle_avalanche = false;
    private boolean toggle_jackets = false;
    private boolean toggle_stars = false;
    private boolean toggle_wings = false;
    private boolean toggle_oilers = false;
    private boolean toggle_panthers = false;
    private boolean toggle_kings = false;
    private boolean toggle_wild = false;
    private boolean toggle_habs = false;
    private boolean toggle_predators = false;
    private boolean toggle_devils = false;
    private boolean toggle_islanders = false;
    private boolean toggle_rangers = false;
    private boolean toggle_flyers = false;
    private boolean toggle_penguins = false;
    private boolean toggle_senators = false;
    private boolean toggle_sharks = false;
    private boolean toggle_blues = false;
    private boolean toggle_lightning = false;
    private boolean toggle_leafs = false;
    private boolean toggle_canucks = false;
    private boolean toggle_jets = false;
    private boolean toggle_capitals = false;

    public static ArrayList<String> on_teams = new ArrayList<String>();
    private String url = "http://www.androidbegin.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shared = getSharedPreferences("mydata", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = shared.edit();





        if(shared.getBoolean("firstTime",true)){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);
            alertDialogBuilder.setTitle("Welcome to Last Minute Sports");
            alertDialogBuilder.setMessage("Tap on your favourite teams to get warnings when 5 minutes are left in the game. Make sure to keep the app running in the background when you want to receive Alerts");
            alertDialogBuilder.setPositiveButton("OK", null);
            alertDialogBuilder.show();

            firstTime = false;
            editor.putBoolean("firstTime",firstTime);
            editor.commit();
        }

        ducks = (ImageButton) findViewById(R.id.ducks);
        coyotes = (ImageButton) findViewById(R.id.coyotes);
        bruins = (ImageButton) findViewById(R.id.bruins);
        sabres = (ImageButton)findViewById(R.id.sabres);
        flames = (ImageButton)findViewById(R.id.flames);
        hurricanes = (ImageButton)findViewById(R.id.hurricanes);
        hawks = (ImageButton)findViewById(R.id.hawks);
        avalanche = (ImageButton)findViewById(R.id.avs);
        jackets = (ImageButton)findViewById(R.id.bluejackets);
        stars = (ImageButton)findViewById(R.id.stars);
        wings = (ImageButton)findViewById(R.id.redwings);
        oilers = (ImageButton)findViewById(R.id.oilers);
        panthers = (ImageButton)findViewById(R.id.panthers);
        kings = (ImageButton)findViewById(R.id.kings);
        wild = (ImageButton)findViewById(R.id.wild);
        habs = (ImageButton)findViewById(R.id.montreal);
        predators = (ImageButton)findViewById(R.id.predators);
        devils = (ImageButton)findViewById(R.id.devils);
        islanders= (ImageButton)findViewById(R.id.islanders);
        rangers = (ImageButton)findViewById(R.id.rangers);
        flyers = (ImageButton)findViewById(R.id.flyers);
        penguins = (ImageButton)findViewById(R.id.penguins);
        senators = (ImageButton)findViewById(R.id.senators);
        sharks = (ImageButton)findViewById(R.id.sharks);
        blues = (ImageButton)findViewById(R.id.blues);
        lightning = (ImageButton)findViewById(R.id.lightning);
        leafs = (ImageButton)findViewById(R.id.leafs);
        canucks = (ImageButton)findViewById(R.id.canucks);
        capitals = (ImageButton)findViewById(R.id.capitals);
        jets = (ImageButton)findViewById(R.id.jets);


                ducks.setOnClickListener(this);
        coyotes.setOnClickListener(this);
        bruins.setOnClickListener(this);
        sabres.setOnClickListener(this);
        flames.setOnClickListener(this);
        hurricanes.setOnClickListener(this);
        hawks.setOnClickListener(this);
        avalanche.setOnClickListener(this);
        jackets.setOnClickListener(this);
        stars.setOnClickListener(this);
        wings.setOnClickListener(this);
        oilers.setOnClickListener(this);
        panthers.setOnClickListener(this);
        kings.setOnClickListener(this);
        wild.setOnClickListener(this);
        habs.setOnClickListener(this);
        predators.setOnClickListener(this);
        devils.setOnClickListener(this);
        islanders.setOnClickListener(this);
        rangers.setOnClickListener(this);
        flyers.setOnClickListener(this);
        penguins.setOnClickListener(this);
        senators.setOnClickListener(this);
        sharks.setOnClickListener(this);
        blues.setOnClickListener(this);
        lightning.setOnClickListener(this);
        leafs.setOnClickListener(this);
        canucks.setOnClickListener(this);
        jets.setOnClickListener(this);
        capitals.setOnClickListener(this);

       // SharedPreferences shared2 = getSharedPreferences("mydata",Context.MODE_PRIVATE);
        if(shared.getBoolean("ducks",false)){
            toggle_ducks = true;
            MyService.ducks_sent = false;
            on_teams.add("Anaheim");
            ducks.setImageResource(R.drawable.on_ducks);
        } if(shared.getBoolean("coyotes",false)){
            toggle_coyotes = true;
            MyService.coyotes_sent = false;
            on_teams.add("Arizona");
            coyotes.setImageResource(R.drawable.on_coyotes);
        }if(shared.getBoolean("bruins",false)){
            toggle_bruins = true;
            MyService.bruins_sent = false;
            on_teams.add("Boston");
            bruins.setImageResource(R.drawable.on_boston);
        }if(shared.getBoolean("sabres",false)){
            toggle_sabres = true;
            MyService.sabres_sent = false;
            on_teams.add("Buffalo");
            sabres.setImageResource(R.drawable.on_sabres);
        }if(shared.getBoolean("flames",false)){
            toggle_flames = true;
            MyService.flames_sent = false;
            on_teams.add("Calgary");
            flames.setImageResource(R.drawable.on_flames);
        }if(shared.getBoolean("hurricanes",false)){
            toggle_hurricanes = true;
            MyService.hurricanes_sent = false;
            on_teams.add("Anaheim");
            hurricanes.setImageResource(R.drawable.on_hurricanes);
        }if(shared.getBoolean("hawks",false)){
            toggle_hawks = true;
            MyService.hawks_sent = false;
            on_teams.add("Chicago");
            hawks.setImageResource(R.drawable.on_hawks);
        }if(shared.getBoolean("avalanche",false)){
            toggle_avalanche = true;
            MyService.avs_sent = false;
            on_teams.add("Colorado");
            avalanche.setImageResource(R.drawable.on_avs);
        }if(shared.getBoolean("jackets",false)){
            toggle_jackets = true;
            MyService.jackets_sent = false;
            on_teams.add("Columbus");
            jackets.setImageResource(R.drawable.on_bluejackets);
        }if(shared.getBoolean("stars",false)){
            toggle_stars = true;
            MyService.stars_sent = false;
            on_teams.add("Dallas");
            stars.setImageResource(R.drawable.on_stars);
        }if(shared.getBoolean("wings",false)){
            toggle_wings = true;
            MyService.wings_sent = false;
            on_teams.add("Detroit");
            wings.setImageResource(R.drawable.on_redwings);
        }if(shared.getBoolean("oilers",false)){
            toggle_oilers = true;
            MyService.oilers_sent = false;
            on_teams.add("Edmonton");
            oilers.setImageResource(R.drawable.on_oilers);
        }if(shared.getBoolean("panthers",false)){
            toggle_panthers = true;
            MyService.panthers_sent = false;
            on_teams.add("Florida");
            panthers.setImageResource(R.drawable.on_panthers);
        }

        if(shared.getBoolean("kings",false)){
            toggle_kings = true;
            MyService.kings_sent = false;
            on_teams.add("Los%20Angeles");
            kings.setImageResource(R.drawable.on_kings);
        }if(shared.getBoolean("wild",false)){
            toggle_wild = true;
            MyService.wild_sent = false;
            on_teams.add("Minnesota");
            wild.setImageResource(R.drawable.on_wild);
        }if(shared.getBoolean("habs",false)){
            toggle_habs = true;
            MyService.habs_sent = false;
            on_teams.add("Montreal");
            habs.setImageResource(R.drawable.on_montreal);
        }if(shared.getBoolean("predators",false)){
            toggle_predators = true;
            MyService.predators_sent = false;
            on_teams.add("Nashville");
            predators.setImageResource(R.drawable.on_predators);
        }if(shared.getBoolean("devils",false)){
            toggle_devils = true;
            MyService.devils_sent = false;
            on_teams.add("New%20Jersey");
            devils.setImageResource(R.drawable.on_devils);
        }if(shared.getBoolean("islanders",false)){
            toggle_islanders = true;
            MyService.islanders_sent = false;
            on_teams.add("NY%20Islanders");
            islanders.setImageResource(R.drawable.on_islanders);
        }if(shared.getBoolean("rangers",false)){
            toggle_rangers = true;
            MyService.rangers_sent = false;
            on_teams.add("NY%20Rangers");
            rangers.setImageResource(R.drawable.on_rangers);
        }if(shared.getBoolean("flyers",false)){
            toggle_flyers = true;
            MyService.flyers_sent = false;
            on_teams.add("Philadelphia");
            flyers.setImageResource(R.drawable.on_flyers);
        }if(shared.getBoolean("penguins",false)){
            toggle_penguins = true;
            MyService.penguins_sent = false;
            on_teams.add("Pittsburgh");
            penguins.setImageResource(R.drawable.on_penguins);
        }if(shared.getBoolean("senators",false)){
            toggle_senators = true;
            MyService.senators_sent = false;
            on_teams.add("Ottawa");
            senators.setImageResource(R.drawable.on_senators);
        }if(shared.getBoolean("sharks",false)){
            toggle_sharks = true;
            MyService.sharks_sent = false;
            on_teams.add("San%20Jose");
            sharks.setImageResource(R.drawable.on_sharks);
        }if(shared.getBoolean("blues",false)){
            toggle_blues = true;
            MyService.blues_sent = false;
            on_teams.add("St.%20Louis");
            blues.setImageResource(R.drawable.on_blues);
        }if(shared.getBoolean("lightning",false)){
            toggle_lightning = true;
            MyService.lightning_sent = false;
            on_teams.add("Tampa%20Bay");
            lightning.setImageResource(R.drawable.on_lightning);
        }if(shared.getBoolean("leafs",false)){
            toggle_leafs = true;
            MyService.leafs_sent = false;
            on_teams.add("Toronto");
            leafs.setImageResource(R.drawable.on_leafs);
        }if(shared.getBoolean("canucks",false)){
            toggle_canucks = true;
            MyService.canucks_sent = false;
            on_teams.add("Vancouver");
            canucks.setImageResource(R.drawable.on_canucks);
        }if(shared.getBoolean("capitals",false)){
            toggle_capitals = true;
            MyService.capitals_sent = false;
            on_teams.add("Washington");
            capitals.setImageResource(R.drawable.on_capitals);
        }if(shared.getBoolean("jets",false)){
            toggle_jets = true;
            MyService.jets_sent = false;
            on_teams.add("Winnipeg");
            jets.setImageResource(R.drawable.on_jets);
        }





        if (on_teams.size() >= 1) {
            //Log.i("", "Sent");
            Intent intent2 = new Intent(this, MyService.class);
            startService(intent2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.instructions){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);
            alertDialogBuilder.setTitle("Welcome to Last Minute Sports");
            alertDialogBuilder.setMessage("Tap on your favourite teams to get warnings when 5 minutes are left in the game. Make sure to keep the app running in the background when you want to receive Alerts");
            alertDialogBuilder.setPositiveButton("OK", null);
            alertDialogBuilder.show();
            return true;
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        SharedPreferences shared = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        if (on_teams.size() == 0) {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        }

        if (v == ducks) {
            if (toggle_ducks){
                turnOnTeam(R.drawable.ducks_fade, R.drawable.on_ducks, toggle_ducks, "Anaheim", ducks);
                toggle_ducks = false;

                MyService.ducks_sent = false;
            }
            else {
                turnOnTeam(R.drawable.ducks_fade, R.drawable.on_ducks, toggle_ducks, "Anaheim", ducks);
                toggle_ducks = true;
                MyService.ducks_sent = false;

            }
            editor.putBoolean("ducks",toggle_ducks);
        } else if (v == coyotes) {
            if (toggle_coyotes){
                turnOnTeam(R.drawable.faded_coyotes, R.drawable.on_coyotes, toggle_coyotes, "Arizona", coyotes);
                toggle_coyotes = false;
                MyService.coyotes_sent = false;

            }
            else {
                turnOnTeam(R.drawable.faded_coyotes, R.drawable.on_coyotes, toggle_coyotes, "Arizona", coyotes);
                toggle_coyotes = true;
                MyService.coyotes_sent = false;

            }
            editor.putBoolean("coyotes", toggle_coyotes);

        } else if (v == bruins) {
            if (toggle_bruins){
                turnOnTeam(R.drawable.boston_faded, R.drawable.on_boston, toggle_bruins, "Boston", bruins);
                toggle_bruins = false;
                MyService.bruins_sent = false;
            }
            else {
                turnOnTeam(R.drawable.boston_faded, R.drawable.on_boston, toggle_bruins, "Boston", bruins);
                toggle_bruins = true;
                MyService.bruins_sent = false;

            }
            editor.putBoolean("bruins", toggle_bruins);

        } else if (v == sabres) {

            if (toggle_sabres){
                turnOnTeam(R.drawable.sabres_faded, R.drawable.on_sabres, toggle_sabres, "Buffalo", sabres);
                toggle_sabres = false;
                MyService.sabres_sent = false;
            }
            else {
                turnOnTeam(R.drawable.sabres_faded, R.drawable.on_sabres, toggle_sabres, "Buffalo", sabres);
                toggle_sabres = true;
                MyService.sabres_sent = false;

            }
            editor.putBoolean("sabres", toggle_sabres);

        } else if (v == flames) {

            if (toggle_flames){
                turnOnTeam(R.drawable.flames_copy, R.drawable.on_flames, toggle_flames, "Calgary", flames);
                toggle_flames = false;
                MyService.flames_sent = false;
            }
            else {
                turnOnTeam(R.drawable.flames_copy, R.drawable.on_flames, toggle_flames, "Calgary", flames);
                toggle_flames = true;
                MyService.flames_sent = false;

            }
            editor.putBoolean("flames", toggle_flames);
        } else if (v == hurricanes) {
            if (toggle_hurricanes){
                turnOnTeam(R.drawable.hurricanes_faded, R.drawable.on_hurricanes, toggle_hurricanes, "Carolina", hurricanes);
                toggle_hurricanes = false;
                MyService.hurricanes_sent = false;
            }
            else {
                turnOnTeam(R.drawable.hurricanes_faded, R.drawable.on_hurricanes, toggle_hurricanes, "Carolina", hurricanes);
                toggle_hurricanes = true;
                MyService.hurricanes_sent = false;

            }
            editor.putBoolean("hurricanes", toggle_hurricanes);

        } else if (v == hawks) {
            if (toggle_hawks){
                turnOnTeam(R.drawable.off_hawks, R.drawable.on_hawks, toggle_hawks, "Chicago", hawks);
                toggle_hawks = false;
                MyService.hawks_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_hawks, R.drawable.on_hawks, toggle_hawks, "Chicago", hawks);
                toggle_hawks = true;
                MyService.hawks_sent = false;

            }
            editor.putBoolean("hawks", toggle_hawks);


        } else if (v == avalanche) {
            if (toggle_avalanche){
                turnOnTeam(R.drawable.off_avs, R.drawable.on_avs, toggle_avalanche, "Colorado", avalanche);
                toggle_avalanche = false;
                MyService.avs_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_avs, R.drawable.on_avs, toggle_avalanche, "Colorado", avalanche);
                toggle_avalanche = true;
                MyService.avs_sent = false;

            }
            editor.putBoolean("avalanche", toggle_avalanche);
        } else if (v == jackets) {
            if (toggle_jackets){
                turnOnTeam(R.drawable.off_bluejackets, R.drawable.on_bluejackets, toggle_jackets, "Columbus", jackets);
                toggle_jackets = false;
                MyService.jackets_sent = false;

            }
            else {
                turnOnTeam(R.drawable.off_bluejackets, R.drawable.on_bluejackets, toggle_jackets, "Columbus", jackets);
                toggle_jackets = true;
                MyService.jackets_sent = false;

            }
            editor.putBoolean("jackets", toggle_jackets);
        } else if (v == stars) {
            if (toggle_stars){
                turnOnTeam(R.drawable.off_stars, R.drawable.on_stars, toggle_stars, "Dallas", stars);
                toggle_stars = false;
                MyService.stars_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_stars, R.drawable.on_stars, toggle_stars, "Dallas", stars);
                toggle_stars = true;
                MyService.stars_sent = false;

            }
            editor.putBoolean("stars", toggle_stars);


        } else if (v == wings) {
            if (toggle_wings){
                turnOnTeam(R.drawable.off_redwings, R.drawable.on_redwings, toggle_wings, "Detroit", wings);
                toggle_wings = false;
                MyService.wings_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_redwings, R.drawable.on_redwings, toggle_wings, "Detroit", wings);
                toggle_wings = true;
                MyService.wings_sent = false;

            }
            editor.putBoolean("wings", toggle_wings);

        } else if (v == oilers) {
            if (toggle_oilers){
                turnOnTeam(R.drawable.off_oilers, R.drawable.on_oilers, toggle_oilers, "Edmonton", oilers);
                toggle_oilers = false;
                MyService.oilers_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_oilers, R.drawable.on_oilers, toggle_oilers, "Edmonton", oilers);
                toggle_oilers = true;
                MyService.oilers_sent = false;

            }

            editor.putBoolean("oilers", toggle_oilers);

        } else if (v == panthers) {
            if (toggle_panthers){
                turnOnTeam(R.drawable.off_panthers, R.drawable.on_panthers, toggle_panthers, "Florida", panthers);
                toggle_panthers = false;
                MyService.panthers_sent = false;

            }
            else {
                turnOnTeam(R.drawable.off_panthers, R.drawable.on_panthers, toggle_panthers, "Florida", panthers);
                toggle_panthers = true;
                MyService.panthers_sent = false;

            }
            editor.putBoolean("panthers", toggle_panthers);

        } else if (v == kings) {
            if (toggle_kings){
                turnOnTeam(R.drawable.off_kings, R.drawable.on_kings, toggle_kings, "Los%20Angeles", kings);
                toggle_kings = false;
                MyService.kings_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_kings, R.drawable.on_kings, toggle_kings, "Los%20Angeles", kings);
                toggle_kings = true;
                MyService.kings_sent = false;

            }
            editor.putBoolean("kings", toggle_kings);
        } else if (v == wild){
            if (toggle_wild){
                turnOnTeam(R.drawable.off_wild, R.drawable.on_wild, toggle_wild, "Minnesota", wild);
                toggle_wild = false;
                MyService.wild_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_wild, R.drawable.on_wild, toggle_wild, "Minnesota", wild);
                toggle_wild = true;
                MyService.wild_sent = false;

            }
            editor.putBoolean("wild", toggle_wild);

        }else if (v == habs) {
            if (toggle_habs) {
                turnOnTeam(R.drawable.off_montreal, R.drawable.on_montreal, toggle_habs, "Montreal", habs);
                toggle_habs = false;
                MyService.habs_sent = false;
            } else {
                turnOnTeam(R.drawable.off_montreal, R.drawable.on_montreal, toggle_habs, "Montreal", habs);
                toggle_habs = true;
                MyService.habs_sent = false;

            }
            editor.putBoolean("habs", toggle_habs);

        }else if (v == predators){
            if (toggle_predators) {
                turnOnTeam(R.drawable.off_predators, R.drawable.on_predators, toggle_predators, "Nashville", predators);
                toggle_predators = false;
                MyService.predators_sent = false;

            } else {
                turnOnTeam(R.drawable.off_predators, R.drawable.on_predators, toggle_predators, "Nashville", predators);
                toggle_predators = true;
                MyService.predators_sent = false;


            }
            editor.putBoolean("predators", toggle_predators);

        }else if (v==devils){
            if (toggle_devils) {
                turnOnTeam(R.drawable.off_devils, R.drawable.on_devils, toggle_devils, "New%20Jersey", devils);
                toggle_devils = false;
                MyService.devils_sent = false;
            } else {
                turnOnTeam(R.drawable.off_devils, R.drawable.on_devils, toggle_devils, "New%20Jersey", devils);
                toggle_devils = true;
                MyService.devils_sent = false;


            }
            editor.putBoolean("devils", toggle_devils);
        }else if (v == islanders) {
            if (toggle_islanders) {
                turnOnTeam(R.drawable.off_islanders, R.drawable.on_islanders, toggle_islanders, "NY%Islanders", islanders);
                toggle_islanders = false;
                MyService.islanders_sent = false;

            } else {
                turnOnTeam(R.drawable.off_islanders, R.drawable.on_islanders, toggle_islanders, "NY%Islanders", islanders);
                toggle_islanders = true;
                MyService.islanders_sent = false;


            }
            editor.putBoolean("islanders", toggle_islanders);
        }else if (v == rangers){

            if (toggle_rangers) {
                turnOnTeam(R.drawable.off_rangers, R.drawable.on_rangers, toggle_rangers, "NY%Rangers", rangers);
                toggle_rangers = false;
                MyService.rangers_sent = false;

            } else {
                turnOnTeam(R.drawable.off_rangers, R.drawable.on_rangers, toggle_rangers, "NY%Rangers", rangers);
                toggle_rangers = true;
                MyService.rangers_sent = false;


            }
            editor.putBoolean("rangers", toggle_rangers);

        }else if (v == flyers){
            if (toggle_flyers) {
                turnOnTeam(R.drawable.off_flyers, R.drawable.on_flyers, toggle_flyers, "Philadelphia", flyers);
                toggle_flyers = false;
                MyService.flyers_sent = false;
            } else {
                turnOnTeam(R.drawable.off_flyers, R.drawable.on_flyers, toggle_flyers, "Philadelphia", flyers);
                toggle_flyers = true;
                MyService.flyers_sent = false;


            }
            editor.putBoolean("flyers", toggle_flyers);
        }else if (v == penguins ){
            if (toggle_penguins) {
                turnOnTeam(R.drawable.off_penguins, R.drawable.on_penguins, toggle_penguins, "Pittsburgh", penguins);
                toggle_penguins = false;
                MyService.penguins_sent = false;
            } else {
                turnOnTeam(R.drawable.off_penguins, R.drawable.on_penguins, toggle_penguins, "Pittsburgh", penguins);
                toggle_penguins = true;
                MyService.penguins_sent = false;


            }
            editor.putBoolean("penguins", toggle_penguins);

        }else if (v == senators){
            if (toggle_senators) {
                turnOnTeam(R.drawable.off_senators, R.drawable.on_senators, toggle_senators, "Ottawa", senators);
                toggle_senators = false;
                MyService.senators_sent = false;

            } else {
                turnOnTeam(R.drawable.off_senators, R.drawable.on_senators, toggle_senators, "Ottawa", senators);
                toggle_senators = true;
                MyService.senators_sent = false;

            }
            editor.putBoolean("senators", toggle_senators);

        }else if (v == sharks){
            if (toggle_sharks) {
                turnOnTeam(R.drawable.off_sharks, R.drawable.on_sharks, toggle_sharks, "San%20Jose", sharks);
                toggle_sharks = false;
                MyService.sharks_sent = false;

            } else {
                turnOnTeam(R.drawable.off_sharks, R.drawable.on_sharks, toggle_sharks, "San%20Jose", sharks);
                toggle_sharks = true;
                MyService.sharks_sent = false;

            }
            editor.putBoolean("sharks", toggle_sharks);

        }else if (v == blues){
            if (toggle_blues) {
                turnOnTeam(R.drawable.off_blues, R.drawable.on_blues, toggle_blues, "St.%20Blues", blues);
                toggle_blues = false;
                MyService.blues_sent = false;
            } else {
                turnOnTeam(R.drawable.off_blues, R.drawable.on_blues, toggle_blues, "St.%20Blues", blues);
                toggle_blues = true;
                MyService.blues_sent = false;

            }
            editor.putBoolean("blues", toggle_blues);

        }else if (v == lightning){

            if (toggle_lightning) {
                turnOnTeam(R.drawable.off_lightning, R.drawable.on_lightning, toggle_lightning, "Tampa%20Bay", lightning);
                toggle_lightning = false;
                MyService.lightning_sent= false;
            } else {
                turnOnTeam(R.drawable.off_lightning, R.drawable.on_lightning, toggle_lightning, "Tampa%20Bay", lightning);
                toggle_lightning = true;
                MyService.lightning_sent= false;

            }
            editor.putBoolean("lightning", toggle_lightning);
        }else if (v == leafs){
            if (toggle_leafs) {
                turnOnTeam(R.drawable.off_leafs, R.drawable.on_leafs, toggle_leafs, "Toronto", leafs);
                toggle_leafs = false;
                MyService.leafs_sent = false;

            } else {
                turnOnTeam(R.drawable.off_leafs, R.drawable.on_leafs, toggle_leafs, "Toronto", leafs);
                toggle_leafs = true;
                MyService.leafs_sent = false;

            }
            editor.putBoolean("leafs", toggle_leafs);
        }else if (v == canucks){
            if (toggle_canucks) {
                turnOnTeam(R.drawable.off_canucks, R.drawable.on_canucks, toggle_canucks, "Vancouver", canucks);
                toggle_canucks = false;

            } else {
                turnOnTeam(R.drawable.off_canucks, R.drawable.on_canucks, toggle_canucks, "Vancouver", canucks);
                toggle_canucks = true;
            }
            MyService.canucks_sent = false;
            editor.putBoolean("canucks", toggle_canucks);

        }else if (v == capitals){
            if (toggle_capitals) {
                turnOnTeam(R.drawable.off_capitals, R.drawable.on_capitals, toggle_capitals, "Washington", capitals);
                toggle_capitals = false;

            } else {
                turnOnTeam(R.drawable.off_capitals, R.drawable.on_capitals, toggle_capitals, "Washington", capitals);
                toggle_capitals = true;
            }
            MyService.capitals_sent = false;
            editor.putBoolean("capitals", toggle_capitals);

        }else if (v == jets){
            if (toggle_jets) {
                turnOnTeam(R.drawable.off_jets, R.drawable.on_jets, toggle_jets, "Winnipeg", jets);
                toggle_jets = false;
                MyService.jets_sent = false;

            } else {
                turnOnTeam(R.drawable.off_jets, R.drawable.on_jets, toggle_jets, "Winnipeg", jets);
                toggle_jets = true;
                MyService.jets_sent = false;
            }
            editor.putBoolean("jets", toggle_jets);

        }

        editor.commit();
        //save preferences
    }


    private void turnOnTeam(int teamOff, int teamOn, boolean toggle, String teamName,ImageButton team  ) {
        if(toggle) {
            team.setImageResource(teamOff);
            on_teams.remove(teamName);
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            team.setImageResource(teamOn);
            on_teams.add(teamName);
            if (teamName.contains("%20"))
            {
                teamName = teamName.replace("%20"," ");
            }
            Toast.makeText(this, "Sending Notification Alerts for " + teamName, Toast.LENGTH_LONG).show();
        }

    }













}
