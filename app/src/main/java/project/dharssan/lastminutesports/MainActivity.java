package project.dharssan.lastminutesports;
import android.app.PendingIntent;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
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
public class MainActivity extends Activity implements View.OnClickListener{

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
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
            }

        } else if (v == coyotes) {
            if (toggle_coyotes){
                turnOnTeam(R.drawable.faded_coyotes, R.drawable.on_coyotes, toggle_coyotes, "Arizona", coyotes);
                toggle_coyotes = false;
                MyService.coyotes_sent = false;

            }
            else {
                turnOnTeam(R.drawable.faded_coyotes, R.drawable.on_coyotes, toggle_coyotes, "Arizona", coyotes);
                toggle_coyotes = true;
            }

        } else if (v == bruins) {
            if (toggle_bruins){
                turnOnTeam(R.drawable.boston_faded, R.drawable.on_boston, toggle_bruins, "Boston", bruins);
                toggle_bruins = false;
                MyService.bruins_sent = false;
            }
            else {
                turnOnTeam(R.drawable.boston_faded, R.drawable.on_boston, toggle_bruins, "Boston", bruins);
                toggle_bruins = true;
            }
        } else if (v == sabres) {

            if (toggle_sabres){
                turnOnTeam(R.drawable.sabres_faded, R.drawable.on_sabres, toggle_sabres, "Buffalo", sabres);
                toggle_sabres = false;
                MyService.sabres_sent = false;
            }
            else {
                turnOnTeam(R.drawable.sabres_faded, R.drawable.on_sabres, toggle_sabres, "Buffalo", sabres);
                toggle_sabres = true;
            }
        } else if (v == flames) {

            if (toggle_flames){
                turnOnTeam(R.drawable.flames_copy, R.drawable.on_flames, toggle_flames, "Calgary", flames);
                toggle_flames = false;
                MyService.flames_sent = false;
            }
            else {
                turnOnTeam(R.drawable.flames_copy, R.drawable.on_flames, toggle_flames, "Calgary", flames);
                toggle_flames = true;
            }
        } else if (v == hurricanes) {
            if (toggle_hurricanes){
                turnOnTeam(R.drawable.hurricanes_faded, R.drawable.on_hurricanes, toggle_hurricanes, "Carolina", hurricanes);
                toggle_hurricanes = false;
                MyService.hurricanes_sent = false;
            }
            else {
                turnOnTeam(R.drawable.hurricanes_faded, R.drawable.on_hurricanes, toggle_hurricanes, "Carolina", hurricanes);
                toggle_hurricanes = true;
            }
        } else if (v == hawks) {
            if (toggle_hawks){
                turnOnTeam(R.drawable.off_hawks, R.drawable.on_hawks, toggle_hawks, "Chicago", hawks);
                toggle_hawks = false;
                MyService.hawks_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_hawks, R.drawable.on_hawks, toggle_hawks, "Chicago", hawks);
                toggle_hawks = true;
            }


        } else if (v == avalanche) {
            if (toggle_avalanche){
                turnOnTeam(R.drawable.off_avs, R.drawable.on_avs, toggle_avalanche, "Colorado", avalanche);
                toggle_avalanche = false;
                MyService.avs_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_avs, R.drawable.on_avs, toggle_avalanche, "Colorado", avalanche);
                toggle_avalanche = true;
            }
        } else if (v == jackets) {
            if (toggle_jackets){
                turnOnTeam(R.drawable.off_bluejackets, R.drawable.on_bluejackets, toggle_jackets, "Columbus", jackets);
                toggle_jackets = false;
                MyService.jackets_sent = false;

            }
            else {
                turnOnTeam(R.drawable.off_bluejackets, R.drawable.on_bluejackets, toggle_jackets, "Columbus", jackets);
                toggle_jackets = true;
            }

        } else if (v == stars) {
            if (toggle_stars){
                turnOnTeam(R.drawable.off_stars, R.drawable.on_stars, toggle_stars, "Dallas", stars);
                toggle_stars = false;
                MyService.stars_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_stars, R.drawable.on_stars, toggle_stars, "Dallas", stars);
                toggle_stars = true;
            }


        } else if (v == wings) {
            if (toggle_wings){
                turnOnTeam(R.drawable.off_redwings, R.drawable.on_redwings, toggle_wings, "Detroit", wings);
                toggle_wings = false;
                MyService.wings_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_redwings, R.drawable.on_redwings, toggle_wings, "Detroit", wings);
                toggle_wings = true;
            }
        } else if (v == oilers) {
            if (toggle_oilers){
                turnOnTeam(R.drawable.off_oilers, R.drawable.on_oilers, toggle_oilers, "Edmonton", oilers);
                toggle_oilers = false;
                MyService.oilers_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_oilers, R.drawable.on_oilers, toggle_oilers, "Edmonton", oilers);
                toggle_oilers = true;
            }


        } else if (v == panthers) {
            if (toggle_panthers){
                turnOnTeam(R.drawable.off_panthers, R.drawable.on_panthers, toggle_panthers, "Florida", panthers);
                toggle_panthers = false;
                MyService.panthers_sent = false;

            }
            else {
                turnOnTeam(R.drawable.off_panthers, R.drawable.on_panthers, toggle_panthers, "Florida", panthers);
                toggle_panthers = true;
            }

        } else if (v == kings) {
            if (toggle_kings){
                turnOnTeam(R.drawable.off_kings, R.drawable.on_kings, toggle_kings, "Los%20Angeles", kings);
                toggle_kings = false;
                MyService.kings_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_kings, R.drawable.on_kings, toggle_kings, "Los%20Angeles", kings);
                toggle_kings = true;
            }

        } else if (v == wild){
            if (toggle_wild){
                turnOnTeam(R.drawable.off_wild, R.drawable.on_wild, toggle_wild, "Minnesota", wild);
                toggle_wild = false;
                MyService.wild_sent = false;
            }
            else {
                turnOnTeam(R.drawable.off_wild, R.drawable.on_wild, toggle_wild, "Minnesota", wild);
                toggle_wild = true;

            }
        }else if (v == habs) {
            if (toggle_habs) {
                turnOnTeam(R.drawable.off_montreal, R.drawable.on_montreal, toggle_habs, "Montreal", habs);
                toggle_habs = false;
                MyService.habs_sent = false;
            } else {
                turnOnTeam(R.drawable.off_montreal, R.drawable.on_montreal, toggle_habs, "Montreal", habs);
                toggle_habs = true;

            }
        }else if (v == predators){
            if (toggle_predators) {
                turnOnTeam(R.drawable.off_predators, R.drawable.on_predators, toggle_predators, "Nashville", predators);
                toggle_predators = false;
                MyService.predators_sent = false;

            } else {
                turnOnTeam(R.drawable.off_predators, R.drawable.on_predators, toggle_predators, "Nashville", predators);
                toggle_predators = true;

            }

        }else if (v==devils){
            if (toggle_devils) {
                turnOnTeam(R.drawable.off_devils, R.drawable.on_devils, toggle_devils, "New%20Jersey", devils);
                toggle_devils = false;
                MyService.devils_sent = false;
            } else {
                turnOnTeam(R.drawable.off_devils, R.drawable.on_devils, toggle_devils, "New%20Jersey", devils);
                toggle_devils = true;

            }

        }else if (v == islanders) {
            if (toggle_islanders) {
                turnOnTeam(R.drawable.off_islanders, R.drawable.on_islanders, toggle_islanders, "NY%Islanders", islanders);
                toggle_islanders = false;
                MyService.islanders_sent = false;

            } else {
                turnOnTeam(R.drawable.off_islanders, R.drawable.on_islanders, toggle_islanders, "NY%Islanders", islanders);
                toggle_islanders = true;

            }

        }else if (v == rangers){

            if (toggle_rangers) {
                turnOnTeam(R.drawable.off_rangers, R.drawable.on_rangers, toggle_rangers, "NY%Rangers", rangers);
                toggle_rangers = false;
                MyService.rangers_sent = false;

            } else {
                turnOnTeam(R.drawable.off_rangers, R.drawable.on_rangers, toggle_rangers, "NY%Rangers", rangers);
                toggle_rangers = true;

            }
        }else if (v == flyers){
            if (toggle_flyers) {
                turnOnTeam(R.drawable.off_flyers, R.drawable.on_flyers, toggle_flyers, "Philadelphia", flyers);
                toggle_flyers = false;
                MyService.flyers_sent = false;
            } else {
                turnOnTeam(R.drawable.off_flyers, R.drawable.on_flyers, toggle_flyers, "Philadelphia", flyers);
                toggle_flyers = true;

            }

        }else if (v == penguins ){
            if (toggle_penguins) {
                turnOnTeam(R.drawable.off_penguins, R.drawable.on_penguins, toggle_penguins, "Pittsburgh", penguins);
                toggle_penguins = false;
                MyService.penguins_sent = false;
            } else {
                turnOnTeam(R.drawable.off_penguins, R.drawable.on_penguins, toggle_penguins, "Pittsburgh", penguins);
                toggle_penguins = true;

            }

        }else if (v == senators){
            if (toggle_senators) {
                turnOnTeam(R.drawable.off_senators, R.drawable.on_senators, toggle_senators, "Ottawa", senators);
                toggle_senators = false;
                MyService.senators_sent = false;

            } else {
                turnOnTeam(R.drawable.off_senators, R.drawable.on_senators, toggle_senators, "Ottawa", senators);
                toggle_senators = true;

            }

        }else if (v == sharks){
            if (toggle_sharks) {
                turnOnTeam(R.drawable.off_sharks, R.drawable.on_sharks, toggle_sharks, "San%20Jose", sharks);
                toggle_sharks = false;
                MyService.sharks_sent = false;

            } else {
                turnOnTeam(R.drawable.off_sharks, R.drawable.on_sharks, toggle_sharks, "San%20Jose", sharks);
                toggle_sharks = true;
            }
        }else if (v == blues){
            if (toggle_blues) {
                turnOnTeam(R.drawable.off_blues, R.drawable.on_blues, toggle_blues, "St.%20Blues", blues);
                toggle_blues = false;
                MyService.blues_sent = false;
            } else {
                turnOnTeam(R.drawable.off_blues, R.drawable.on_blues, toggle_blues, "St.%20Blues", blues);
                toggle_blues = true;
            }

        }else if (v == lightning){

            if (toggle_lightning) {
                turnOnTeam(R.drawable.off_lightning, R.drawable.on_lightning, toggle_lightning, "Tampa%20Bay", lightning);
                toggle_lightning = false;
                MyService.lightning_sent= false;
            } else {
                turnOnTeam(R.drawable.off_lightning, R.drawable.on_lightning, toggle_lightning, "Tampa%20Bay", lightning);
                toggle_lightning = true;
            }
        }else if (v == leafs){
            if (toggle_leafs) {
                turnOnTeam(R.drawable.off_leafs, R.drawable.on_leafs, toggle_leafs, "Toronto", leafs);
                toggle_leafs = false;
                MyService.leafs_sent = false;

            } else {
                turnOnTeam(R.drawable.off_leafs, R.drawable.on_leafs, toggle_leafs, "Toronto", leafs);
                toggle_leafs = true;
            }
        }else if (v == canucks){
            if (toggle_canucks) {
                turnOnTeam(R.drawable.off_canucks, R.drawable.on_canucks, toggle_canucks, "Vancouver", canucks);
                toggle_canucks = false;
                MyService.canucks_sent = false;

            } else {
                turnOnTeam(R.drawable.off_canucks, R.drawable.on_canucks, toggle_canucks, "Vancouver", canucks);
                toggle_canucks = true;
            }

        }else if (v == capitals){
            if (toggle_capitals) {
                turnOnTeam(R.drawable.off_capitals, R.drawable.on_capitals, toggle_capitals, "Washington", capitals);
                toggle_capitals = false;
                MyService.capitals_sent = false;

            } else {
                turnOnTeam(R.drawable.off_capitals, R.drawable.on_capitals, toggle_capitals, "Washington", capitals);
                toggle_capitals = true;
            }

        }else if (v == jets){
            if (toggle_jets) {
                turnOnTeam(R.drawable.off_jets, R.drawable.on_jets, toggle_jets, "Winnipeg", jets);
                toggle_jets = false;
                MyService.jets_sent = false;

            } else {
                turnOnTeam(R.drawable.off_jets, R.drawable.on_jets, toggle_jets, "Winnipeg", jets);
                toggle_jets = true;
            }

        }
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
        }

    }







    private void turnOnWings( ) {
        if(toggle_wings) {
            wings.setImageResource(R.drawable.off_redwings);
            toggle_wings = false;
            on_teams.remove("Detroit");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            wings.setImageResource(R.drawable.off_redwings);
            toggle_wings = true;
            on_teams.add("Detroit");
        }

    }
    private void turnOnOilers( ) {
        if(toggle_oilers) {
            oilers.setImageResource(R.drawable.off_oilers);
            toggle_oilers = false;
            on_teams.remove("Edmonton");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            oilers.setImageResource(R.drawable.on_oilers);
            toggle_oilers = true;
            on_teams.add("Edmonton");
        }

    }
    private void turnOnpanthers( ) {
        if(toggle_panthers) {
            panthers.setImageResource(R.drawable.off_panthers);
            toggle_panthers = false;
            on_teams.remove("Florida");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            panthers.setImageResource(R.drawable.on_panthers);
            toggle_panthers = true;
            on_teams.add("Florida");
        }
    }
    private void turnOnKings( ) {
        if(toggle_kings) {
            kings.setImageResource(R.drawable.off_kings);
            toggle_kings = false;
            on_teams.remove("Los%20Angeles");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            kings.setImageResource(R.drawable.on_kings);
            toggle_kings = true;
            on_teams.add("Los%20Angeles");
        }

    }










    private void turnOnStars( ) {
        if(toggle_stars) {
            stars.setImageResource(R.drawable.off_stars);
            toggle_stars = false;
            on_teams.remove("Dallas");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            stars.setImageResource(R.drawable.on_stars);
            toggle_stars = true;
            on_teams.add("Dallas");
        }

    }









    private void turnOnHawks( ) {
        if(toggle_hawks) {
            hawks.setImageResource(R.drawable.off_hawks);
            toggle_hawks = false;
            on_teams.remove("Chicago");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            hawks.setImageResource(R.drawable.on_hawks);
            toggle_hawks = true;
            on_teams.add("Chicago");
        }

    }


    private void turnOnAvalanche( ) {
        if(toggle_avalanche) {
            avalanche.setImageResource(R.drawable.off_avs);
            toggle_avalanche = false;
            on_teams.remove("Colorado");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            avalanche.setImageResource(R.drawable.on_avs);
            toggle_avalanche = true;
            on_teams.add("Colorado");
        }

    }



    private void turnOnJackets( ) {
        if(toggle_jackets) {
            jackets.setImageResource(R.drawable.off_bluejackets);
            toggle_jackets = false;
            on_teams.remove("Columbus");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            jackets.setImageResource(R.drawable.on_bluejackets);
            toggle_jackets = true;
            on_teams.add("Columbus");
        }

    }







    private void turnOnHurricanes( ) {
        if(toggle_hurricanes) {
            hurricanes.setImageResource(R.drawable.hurricanes_faded);
            toggle_hurricanes = false;
            on_teams.remove("Carolina");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            hurricanes.setImageResource(R.drawable.on_hurricanes);
            toggle_hurricanes = true;
            on_teams.add("Carolina");
        }

    }

    private void turnOnFlames () {
        if(toggle_flames) {
            flames.setImageResource(R.drawable.flames_copy);
            toggle_flames = false;
            on_teams.remove("Calgary");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }

        }
        else {
            flames.setImageResource(R.drawable.on_flames);
            toggle_flames = true;
            Log.i("j ", "flames");
            Toast.makeText(this, "Notification Set for Flames", Toast.LENGTH_LONG).show();
            on_teams.add("Calgary");

        }
    }


    private void turnOnSabres() {
        if(toggle_sabres) {
            sabres.setImageResource(R.drawable.sabres_faded);
            toggle_sabres = false;
            on_teams.remove("Tampa%20Bay");
            MyService.lightning_sent = false;
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else{
            sabres.setImageResource(R.drawable.on_sabres);
            toggle_sabres = true;
            on_teams.add("Tampa%20Bay");
        }
    }

    private void turnOnBruins() {
        if (toggle_bruins) {
            toggle_bruins = false;
            bruins.setImageResource(R.drawable.boston_faded);
            on_teams.remove("Boston");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        } else {
            bruins.setImageResource(R.drawable.on_boston);
            toggle_bruins = true;
            on_teams.add("Boston");
        }
    }
    private void turnOnCoyotes() {
        if (toggle_coyotes) {
            coyotes.setImageResource(R.drawable.faded_coyotes);
            toggle_coyotes = false;
            on_teams.remove("NY%20Rangers");
            MyService.rangers_sent = false;
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        } else {
            coyotes.setImageResource(R.drawable.on_coyotes);
            toggle_coyotes = true;
            on_teams.add("NY%20Rangers");
        }
    }

    private void turnOnDucks() {
        if (toggle_ducks){
            ducks.setImageResource(R.drawable.ducks_fade);
            toggle_ducks = false;
            on_teams.remove("Anaheim");
            if(on_teams.size() == 0) {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
        }else
        {
            toggle_ducks = true;
            ducks.setImageResource(R.drawable.on_ducks);
            on_teams.add("Anaheim");
        }
    }




}
