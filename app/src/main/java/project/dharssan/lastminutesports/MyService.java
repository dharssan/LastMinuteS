package project.dharssan.lastminutesports;

/**
 * Created by dharssan on 15-05-13.
 */
import java.util.regex.*;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import android.app.IntentService;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.app.PendingIntent;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.TimeZone;
import java.io.IOException;
import java.util.Date;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Integer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MyService extends Service{
    public static String desc;
    public String url = "http://sports.espn.go.com/nhl/bottomline/scores";
    public String teamA;
    public String teamB;
    public boolean stoppage = true;
    private static final String TAG = "MyService";
    private final long[] mVibratePattern = { 0, 200, 200, 300 };
    public int i = 0;
    public static boolean rangers_sent;
    public static boolean lightning_sent;
    public static boolean ducks_sent;
    public static boolean bruins_sent;
    public static boolean coyotes_sent;
    public static boolean sabres_sent;
    public static boolean flames_sent;
    public static boolean hurricanes_sent;
    public static boolean hawks_sent;
    public static boolean avs_sent;
    public static boolean jackets_sent;
    public static boolean stars_sent;
    public static boolean wings_sent;
    public static boolean oilers_sent;
    public static boolean panthers_sent;
    public static boolean kings_sent;
    public static boolean wild_sent;
    public static boolean habs_sent;
    public static boolean predators_sent;
    public static boolean devils_sent;
    public static boolean islanders_sent;
    public static boolean flyers_sent;
    public static boolean penguins_sent;
    public static boolean senators_sent;
    public static boolean sharks_sent;
    public static boolean blues_sent;
    public static boolean leafs_sent;
    public static boolean canucks_sent;
    public static boolean capitals_sent;
    public static boolean jets_sent;




    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
     //   Toast.makeText(this, "My Service Created for Team", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onCreated");

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        /* for (int i = 0; i < 15; i++){

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();
                // Using Elements to get the Meta data
                Elements description = document
                        .select("th[class=left]");
                Elements teamsA = document
                        .select("td[class=team left]");
                Elements teamsB = document
                        .select("tr[class=homeTeam]");
                // Locate the content attribute
                teamA = teamsA.text();
                teamB = teamsB.text();
                desc = description.text();
                desc = desc + " " + teamA;

            } catch (IOException e) {
                e.printStackTrace();
            }

            //Log.i(TAG, "tester");

        }*/
        new Description().execute();
        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        //Log.i(TAG, "Destroy");
        stoppage = false;
        stopForeground(true);

    }



    private class Description extends AsyncTask<Void, Void, Void> {
        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            i = 0;
            while(stoppage){

                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
                dateFormat.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
                int hour = Integer.parseInt(dateFormat.format(new Date()));
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);


                if ((((day>=2 && day<=6)&& (hour >= 20 && hour <=24)) || (hour>=0 && hour <=2))
                || (day == 7 || day == 1 )&& ((hour >= 14 && hour <=24)) || (hour>=0 && hour <=2))
                {
//if statement check time of day M-F @ 7pm to 1am and Saturday and Sunday at 1pm to 1am
                    try {
                        // Connect to the web site
                        Document document = Jsoup.connect(url).get();
                        // Using Elements to get the Meta data
/*
                    Elements description = document
                            .select("th[class=left]");
                    Elements teamsA = document
                            .select("td[class=team left]");
                    Elements teamsB = document
                            .select("tr[class=homeTeam]");
                    // Locate the content attribute
                    teamA = teamsA.text();
                    teamB = teamsB.text();
                    desc = description.text();*/
                        Elements description = document
                                .select("body");
                        desc = description.text();
                        //Log.i(TAG, "test2");
                        //Log.i(desc, "Test");
                        //Log.i(String.valueOf(stoppage),"test2");

                        for (int j = 0; j < MainActivity.on_teams.size(); j++) {
                            if (desc.matches(".*" + MainActivity.on_teams.get(j) + ".*?\\(6:.*3RD\\).*")) {
                               // Log.i(TAG, " 1st Match");


                                final Intent emptyIntent = new Intent();
                                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                if (MainActivity.on_teams.get(j) == "NY%20Rangers" && (!(rangers_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1667);
                                    rangers_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Tampa%20Bay" && (!(lightning_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1668);
                                    lightning_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Anaheim" && (!(ducks_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1669);
                                    ducks_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Arizona" && (!(coyotes_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1670);
                                    coyotes_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Boston" && (!(bruins_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1671);
                                    bruins_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Calgary" && (!(flames_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1672);
                                    flames_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Carolina" && (!(hurricanes_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1673);
                                    hurricanes_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Colorado" && (!(avs_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1674);
                                    avs_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Chicago" && (!(hawks_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1675);
                                    hawks_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Columbus" && (!(jackets_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1676);
                                    jackets_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Detroit" && (!(wings_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1677);
                                    wings_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Dallas" && (!(stars_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1678);
                                    stars_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Edmonton" && (!(oilers_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1679);
                                    oilers_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Florida" && (!(panthers_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1680);
                                    panthers_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Los%20Angeles" && (!(kings_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1681);
                                    kings_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Minnesota" && (!(wild_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1682);
                                    wild_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Montreal" && (!(habs_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1683);
                                    habs_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Nashville" && (!(predators_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1684);
                                    predators_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "New%20Jersey" && (!(devils_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1685);
                                    devils_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "NY%20Islanders" && (!(islanders_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1686);
                                    islanders_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Philadelphia" && (!(flyers_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1687);
                                    flyers_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Pittsburgh" && (!(penguins_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1688);
                                    penguins_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Ottawa" && (!(senators_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1689);
                                    senators_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "San%20Jose" && (!(sharks_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1690);
                                    sharks_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "St.%20Louis" && (!(blues_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1691);
                                    blues_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Toronto" && (!(leafs_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1692);
                                    leafs_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Washington" && (!(capitals_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1693);
                                    capitals_sent = true;
                                } else if (MainActivity.on_teams.get(j) == "Winnipeg" && (!(jets_sent))) {
                                    buildNotif(MainActivity.on_teams.get(j), 1694);
                                    jets_sent = true;
                                }

                            } else if (desc.matches(".*" + MainActivity.on_teams.get(j) + ".*?\\(FINAL\\).*")) {
                                if (MainActivity.on_teams.get(j) == "NY%20Rangers") {
                                    rangers_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Tampa%20Bay") {
                                    lightning_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Anaheim") {
                                    ducks_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Arizona") {
                                    coyotes_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Boston") {
                                    bruins_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Calgary") {
                                    flames_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Carolina") {
                                    hurricanes_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Colorado") {
                                    avs_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Chicago") {
                                    hawks_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Columbus") {
                                    jackets_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Detroit") {
                                    wings_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Dallas") {
                                    stars_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Edmonton") {
                                    oilers_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Florida") {
                                    panthers_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Los%20Angeles") {
                                    kings_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Minnesota") {
                                    wild_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Montreal") {
                                    habs_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Nashville") {
                                    predators_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "New%20Jersey") {
                                    devils_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "NY%20Islanders") {
                                    islanders_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Philadelphia") {
                                    flyers_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Pittsburgh") {
                                    penguins_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Ottawa") {
                                    senators_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "San%20Jose") {
                                    sharks_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "St.%20Louis") {
                                    blues_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Toronto") {
                                    leafs_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Washington") {
                                    capitals_sent = false;
                                } else if (MainActivity.on_teams.get(j) == "Winnipeg") {
                                    jets_sent = false;
                                }
                            }
                        }


                    /*while(i<MainActivity.on_teams.size()){
                        if(desc.contains(MainActivity.on_teams.get(i))) //team is playing
                         {


                        }
                        i++;
                    }*/

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            startForeground(1667, null);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
        }
    }

    private void buildNotif(String teamName, int num){
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (teamName.contains("%20"))
        {
            teamName = teamName.replace("%20"," ");
        }
        NotificationCompat.Builder nhl = new NotificationCompat.Builder(
                getApplicationContext())
                .setSmallIcon(R.drawable.nhl)
                .setContentTitle("Last Minute Sports")
                .setContentText(teamName + " 5 Minute Warning!")
                .setVibrate(mVibratePattern);
        notificationManager.notify(num, nhl.build());

    }
}
