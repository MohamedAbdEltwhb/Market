package com.example.dell.market;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by DELL on 03/01/2019.
 */

public class DisplayScreen extends AppCompatActivity {

    private  PreferencesStorage preferencesStorage;

    ListView mListView ;
    int[] images = {R.drawable.shoa,
                    R.drawable.shob,
                    R.drawable.shoc,
                    R.drawable.shod,
                    R.drawable.shoe,
                    R.drawable.shof,
                    R.drawable.shog,
                    R.drawable.shoh,
                    R.drawable.shoi,
                    R.drawable.shoj,
                    R.drawable.shok,
                    R.drawable.shol,
                    R.drawable.shom,
                    R.drawable.shpn };

    String [] Names = {"Green Shose",
                       "Black And White Shose",
                       "More White Shose" ,
                       "Silver Shose",
                       "Black Shose 1",
                       "Red And White Shose" ,
                       "Silver And White Shose",
                       "Silver And Black Shose",
                       "Black And White 2 Shose",
                       "White Shose",
                       "Black Shose 2",
                       "Pink Shose",
                       "Black Shose 3",
                       "Silver And White Shose " };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);

        preferencesStorage = new PreferencesStorage(DisplayScreen.this);

        mListView=  findViewById(R.id.ListView);
        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int getId = item.getItemId();
        switch (getId){
            case R.id.logout:
                userLogout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void userLogout() {
        preferencesStorage.putEmail(null);
        preferencesStorage.putPassword(null);

        Intent toLogin = new Intent(this, MainActivity.class);
        toLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        toLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(toLogin);
        finish();
    }








    class CustomAdaptor extends BaseAdapter {


        @Override
        public int getCount() {
            return  images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView mImageView = view.findViewById(R.id.imageView);
            TextView mTextView = view.findViewById(R.id.LName);

            mImageView.setImageResource(images[position]);
            mTextView.setText(Names[position]);
            return view;
        }
    }
}