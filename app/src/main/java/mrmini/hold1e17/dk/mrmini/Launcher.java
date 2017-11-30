package mrmini.hold1e17.dk.mrmini;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;

/**
 * Created by Simon on 30-10-2017.
 */

public class Launcher extends AppCompatActivity {

    String login = "";
    String hospital = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadData();

        if (login == "" && hospital == "") {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
            finish();
        } else {
            Intent i = new Intent(this, Hovedmenu.class);
            i.putExtra("login", login);
            i.putExtra("hospital", hospital);
            startActivity(i);
            finish();
        }

        setTitle("MR Scanner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void loadData() {
        // Function that loads the data stored in the SharedPreferences

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        login = preferences.getString("login", "");
        hospital = preferences.getString("hospital", "");

    }

}
