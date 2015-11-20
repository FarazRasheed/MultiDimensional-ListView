package onebyte.mutlidimensional_listview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        LinearLayout main = (LinearLayout)findViewById(R.id.main);
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
        LinearLayout.LayoutParams parms2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams parms3 = new LinearLayout.LayoutParams(100, 100);
        LinearLayout.LayoutParams parms4 = new LinearLayout.LayoutParams(100, 100);
        parms3.setMargins(30, 30, 0, 0);
        parms.setMargins(0, 0, 0, 30);




        for (int j=0; j<9; j++){
            HorizontalScrollView scrollView = new HorizontalScrollView(this);
            scrollView.setLayoutParams(parms);
            scrollView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            LinearLayout main2 = new LinearLayout(this);
            main2.setLayoutParams(parms2);
            main2.setOrientation(LinearLayout.HORIZONTAL);
            for (int k=0; k<10; k++){


                ImageView img= new ImageView(this);
                img.setLayoutParams(parms3);
                img.setId(k);
                img.setBackgroundResource(R.drawable.images);
                img.setOnClickListener(viewOnClickListener);
                main2.addView(img);
            }

            scrollView.addView(main2);
            main.addView(scrollView);
            //scrollView.setOnClickListener(viewOnClickListener);
        }


    }
    View.OnClickListener viewOnClickListener
            = new View.OnClickListener(){

        @Override
        public void onClick(View v) {


            int myId = v.getId();



            Log.e("IDDDS", "" + myId);


        }};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
