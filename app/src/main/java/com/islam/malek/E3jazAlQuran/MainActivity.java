package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends Activity {
    String listoption[];
    ListView listdrawer;
    DrawerLayout drawerlayout;
    ActionBarDrawerToggle drawerToogle;
    int currentposition;
    private InterstitialAd mInterstitialAd;
    //for show add when count==2;
    int count = 0;

    //Class To Listen on Click is ListDrawer and pass The position To on Click ..........
    private class DrawerOnClickListner implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            count++;
            if (count == 3) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                count = 0;
            }
            selectItem(position);
        }
    }

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //add inestrial app .....
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6570381802681746/6102101712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


        // Initialize Drawer layout....
        drawerlayout = (DrawerLayout) findViewById(R.id.activity_main);


        //Initialize listDrawer and put the options in The list ...
        listoption = getResources().getStringArray(R.array.options);
        listdrawer = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, listoption);
        listdrawer.setAdapter(arrayAdapter);

        //To listen to click on list drawer from class DrawerOnClickListener......
        listdrawer.setOnItemClickListener(new DrawerOnClickListner());

        // Open List Drawer When On Create after 1 second ........
        if (savedInstanceState == null) {
            selectItem(0);
            listdrawer.setItemChecked(0, true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    drawerlayout.openDrawer(listdrawer);

                }
            }, 1000);

        }

        //Create The ActionBarDrawerTooggle....
        drawerToogle = new ActionBarDrawerToggle(this, drawerlayout, R.string.openDrawer, R.string.closeDrawer) {


            // Now These Method we did not use it
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            //and This Method we didn not use it
            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                invalidateOptionsMenu();
            }

        };




        //To set drawer toggle to listner to listdrawer.....
        drawerlayout.setDrawerListener(drawerToogle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        //To begin app to Home Fragment .....
        if (savedInstanceState != null) {
            currentposition = savedInstanceState.getInt("position");
            setTitleActionBar(currentposition);

        }

        //To backStack  and set title true......
        getFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        FragmentManager fm = getFragmentManager();
                        Fragment fragment = fm.findFragmentByTag("visible fragment");
                        if (fragment instanceof EarthFragment) {
                            currentposition = 0;
                        }
                        if (fragment instanceof SkyFragment) {
                            currentposition = 1;
                        }
                        if (fragment instanceof WaterFragment) {
                            currentposition = 2;
                        }
                        if (fragment instanceof DoctorFragment) {
                            currentposition = 3;
                        }
                        if (fragment instanceof Tashree3Fragment) {
                            currentposition = 4;
                        }
                        if (fragment instanceof BalaghiFragment) {
                            currentposition = 5;
                        }
                        if (fragment instanceof SecretCreatureFragment) {
                            currentposition = 6;
                        }
                        if (fragment instanceof SecretFoodFragment) {
                            currentposition = 7;
                        }
                        if (fragment instanceof SonnaNabawiFragment) {
                            currentposition = 8;
                        }
                        if (fragment instanceof DoctorQuranFragment) {
                            currentposition = 9;
                        }
                        setTitleActionBar(currentposition);
                        listdrawer.setItemChecked(currentposition, true);
                    }
                }
        );

    }

    //These Method To Select Item and Select Fragment Whose Show in Fragment Container .....

    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {

            case 0:
                fragment = new EarthFragment();
                break;
            case 1:
                fragment = new SkyFragment();
                break;
            case 2:
                fragment = new WaterFragment();
                break;
            case 3:
                fragment = new DoctorFragment();
                break;
            case 4:
                fragment = new Tashree3Fragment();
                break;
            case 5:
                fragment = new BalaghiFragment();
                break;
            case 6:
                fragment = new SecretCreatureFragment();
                break;
            case 7:
                fragment = new SecretFoodFragment();
                break;
            case 8:
                fragment = new SonnaNabawiFragment();
                break;
            case 9:
                fragment = new DoctorQuranFragment();
                break;
            case 10:
                finish();
            default:
                fragment = new EarthFragment();
                break;

        }

        //These code to set Fragment to Fragment_container ......
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        //The visible fragment to initialize visible value to back stack .......
        ft.replace(R.id.fragment_container, fragment, "visible fragment");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        //set title to Action bar.....
        setTitleActionBar(position);

        //These code To Close listdrawer when Click on one item In Listdrawer.....
        drawerlayout.closeDrawer(listdrawer);


        //These code to set currentpossition to back stack on saveInstanceState....
        currentposition = position;


    }

    //Method to set title....
    public void setTitleActionBar(int position) {
        String title = "";
        title = listoption[position];
        getActionBar().setTitle(title);
    }

    //set menu item in action bar.....
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }


    //onOptionsItemSelected....
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToogle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.info) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
            builder.setMessage(
                    "يحتوي البرنامج على موسوعة من مظاهر الاعجاز في القران الكريم\n \n" +
                            "المصدر : موقع الشيخ عبد الدائم كحيل\n \n " +

                            " النسخة :1.0\n \n" +

                            "وضعت بواسطة : Malek Jaber")


                    .setCancelable(false)
                    .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //These Method To convert the -> item to drawerToggle item when close listdrawer and complement ....
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToogle.syncState();
    }


    //These Method To save any Changed on this List drawer....
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToogle.onConfigurationChanged(newConfig);
    }


    //These Method To put position on currentposition and pass to onCreate To save the Position To Title .....
    @Override
    public void onSaveInstanceState(Bundle outsave) {
        super.onSaveInstanceState(outsave);
        outsave.putInt("position", currentposition);
    }


    //Method To Exit When Pressed Twice in Back Button ...........
    boolean twice;

    @Override
    public void onBackPressed() {

        if (twice == true) {
            finish();
        }
        if (currentposition != 0) {
            selectItem(0);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    drawerlayout.openDrawer(listdrawer);
                    listdrawer.setItemChecked(0, true);
                }
            }, 700);
        } else
            drawerlayout.openDrawer(listdrawer);

        Toast.makeText(this, "أنقر مرة أخرى للخروج", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
            }
        }, 3000);
        twice = true;

    }

}






