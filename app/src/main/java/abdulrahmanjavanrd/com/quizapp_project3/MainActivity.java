package abdulrahmanjavanrd.com.quizapp_project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    /**
     *  pure app for copy and past in future .
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));

        setUpAnim();
    }

    /**
     * menu methods ..
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting :
                Toast.makeText(this,"settings clicked ",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true ;
    }

    public void setUpAnim(){

        Explode expload = new Explode();
        Slide s = new Slide();
        s.setDuration(100);
        expload.setDuration(1000);
        getWindow().setEnterTransition(expload);
    }
}
