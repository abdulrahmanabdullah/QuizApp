package abdulrahmanjavanrd.com.quizapp_project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class MainActivity extends AppCompatActivity {
    /**
     *  pure app for copy and past in future .
     * @param savedInstanceState
     */
    TextView tx  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_layout);
        tx = findViewById(R.id.txv_name);
        setTx();
        Toast.makeText(this,tx.getText().toString(),Toast.LENGTH_LONG).show();
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
       setUpAnim();
    }

    /**
     * menu methods ..
     * @param menu  set menu file layout .
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    /**
     *
     * @param item setting, id = setting .
     * @return true
     */
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

    /**
     * Appear MainActivity with Explode animations .
     */
    public void setUpAnim(){
        Explode explode = new Explode();
        explode.setDuration(1000);
        getWindow().setEnterTransition(explode);
    }

    public void setTx(){
        String str = getIntent().getStringExtra(ConstantValues.NAME).toString() ;
        tx.setText(str);
    }
   public String receiveStudentName(){
       String str =  tx.getText().toString();
       return  str ;
   }

  public void goToNextSlide(View v){
       Intent intent = new Intent(this,SecondQuestion.class);
       //TODO:  put student name .
      intent.putExtra(ConstantValues.NAME,receiveStudentName());
      startActivity(intent);
  }
}
