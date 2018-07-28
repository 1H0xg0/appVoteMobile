package com.hackathon;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class menu_principale extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout D;
    private ActionBarDrawerToggle T;
    private AlertDialog.Builder B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principale);

        D = (DrawerLayout) findViewById(R.id.menu_defilant);
        T = new ActionBarDrawerToggle(this,D,R.string.open,R.string.close);
        D.addDrawerListener(T);
        T.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView N = (NavigationView) findViewById(R.id.nav_menu);
        N.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (T.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        B1 = new AlertDialog.Builder(this);
        B1.setMessage("Vous voulez vraiment Quitter?");
        B1.setCancelable(true);

        B1.setPositiveButton(
                "OUI",
                new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                        System.exit(0);
                    }
                });

        B1.setNegativeButton(
                "NON",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        int id = item.getItemId();
        if (id == R.id.accueil){
            Toast.makeText(this, "Accueil", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.resultat ){
            Toast.makeText(this, "Resultat", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.vote ){
            Toast.makeText(this, "Vote", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.deconnecter ){
            AlertDialog alert = B1.create();
            alert.show();
        }
        return false;
    }
}
