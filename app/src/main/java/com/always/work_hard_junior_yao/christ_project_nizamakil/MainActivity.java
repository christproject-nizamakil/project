package com.always.work_hard_junior_yao.christ_project_nizamakil;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.always.work_hard_junior_yao.christ_project_nizamakil.Junias.fragment_order;
import com.always.work_hard_junior_yao.christ_project_nizamakil.Junior_yao.JuniorFeedback_fragment;
import com.always.work_hard_junior_yao.christ_project_nizamakil.Junior_yao.JuniorProfileFragment;

import com.always.work_hard_junior_yao.christ_project_nizamakil.cartFragment.OnFragmentInteractionListener;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.O;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,OnFragmentInteractionListener,JuniorProfileFragment.OnFragmentInteractionListener,JuniorFeedback_fragment.OnFragmentInteractionListener {
FragmentTransaction fragmentTransaction;
private static final  int Request_call= 1;
private ViewFlipper viewFlipper;
private RecyclerView recyclerView1;
private RecyclerView.Adapter adapter;
private  RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<ContentItems> ContentList= new ArrayList<>();
        ContentList.add(new ContentItems(R.drawable.imag1, " Miggos Christ", "Open 24/7"));
        ContentList.add(new ContentItems(R.drawable.imag2, " Block4 Christ", "Open 24/7"));
        ContentList.add(new ContentItems(R.drawable.imag3, " Central Block Christ", "Open 24/7"));

        recyclerView1= (RecyclerView)findViewById(R.id.RecyclerView);
        recyclerView1.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        adapter= new ContentAdapter(ContentList);


        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(adapter);



        int images[]= {R.drawable.im1, R.drawable.im2, R.drawable.im3};

        viewFlipper =(ViewFlipper)findViewById(R.id.auto_image);
        for(int i=0; i< images.length; i++ )
        {
            flipperImages(images[i]);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id== R.id.cart_button)

        {
            return true;
        }
        else if(id==R.id.search_button)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("MissingPermission")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();

        if (id == R.id.Profile) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentMain,new JuniorProfileFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Profile");
            item.setChecked(true);

        } else if (id == R.id.nav_share) {

        }

        else if (id == R.id.car) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.cartcontainer,new cartFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Cart");
        item.setChecked(true);
        }

        else if (id == R.id.coin) {

        }
         else if (id == R.id.Feedback) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentMain,new JuniorFeedback_fragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Feedback");
            item.setChecked(true);

        }
        else if(id == R.id.order_history)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new fragment_order()).commit();
            getSupportActionBar().setTitle("Order_history");
            item.setChecked(true);
        }
        else if (id== R.id.Contact_Us)
        {
            String number="+917349524729";

            if(number.trim().length() >0)
            {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE},Request_call);

                }else
                {
                    String dial ="tel:" + number;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

                }

            }else
            {
                Toast.makeText(this, "call again", Toast.LENGTH_SHORT).show();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public  void flipperImages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);






    }



}
