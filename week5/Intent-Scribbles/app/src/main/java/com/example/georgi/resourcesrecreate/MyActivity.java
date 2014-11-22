package com.example.georgi.resourcesrecreate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MyActivity extends Activity {

    private Intent result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent getToMyOtherActivity = new Intent(this, LoginActivity.class);
        startActivity(getToMyOtherActivity);
        finish();

//        setContentView(R.layout.activity_my);
//
//        Intent i = new Intent();
//        i.setType("text/plain");
//
//
//        i.setClass("com.example.georgi.resourcesRecreate", MyOtherActivity.class);
//        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
////        i.setData(Uri.parse("mailto:ch_bg@abv.bg"));
//        i.putExtra(Intent.EXTRA_SUBJECT, "meh");
//        i.putExtra(Intent.EXTRA_EMAIL, new String[] { "ch_bg@abv.bg" });

        startActivity(i);

        int requestCode = 0xBABE;
        startActivityForResult(i, requestCode);

        getIntent().getStringExtra("photoLocation");

        setResult(RESULT_OK, new Intent());
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 0xBABE:
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("contacts", new ArrayList<String>());
        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
