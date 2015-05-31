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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

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
        Toast.makeText(this, "My Service Created for Team", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onCreate");

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

            Log.i(TAG, "tester");

        }*/
        new Description().execute();
        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "Destroy");
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
                    desc =description.text();
                    Log.i(TAG,"test2");
                    //Log.i(desc, "Test");
                    //Log.i(String.valueOf(stoppage),"test2");

                    for (int j = 0; j< MainActivity.on_teams.size(); j++){
                        if (desc.matches(".*"+MainActivity.on_teams.get(j) +".*?\\(END.*1ST\\).*")) {
                            Log.i(TAG, " 1st Match");



                            final Intent emptyIntent = new Intent();
                            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                            if (MainActivity.on_teams.get(j) == "NY%20Rangers" && (! (rangers_sent))){
                                buildNotif(MainActivity.on_teams.get(j), 1667);
                                rangers_sent = true;
                            }else if (MainActivity.on_teams.get(j) == "Tampa%20Bay" && (!(lightning_sent))) {
                                buildNotif(MainActivity.on_teams.get(j), 1667);
                                lightning_sent = true;
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
        NotificationCompat.Builder nhl = new NotificationCompat.Builder(
                getApplicationContext())
                .setSmallIcon(R.drawable.nhl)
                .setContentTitle("Last Minute Sports")
                .setContentText(teamName + " 5 Minute Warning!")
                .setVibrate(mVibratePattern);
        notificationManager.notify(num, nhl.build());

    }
}
