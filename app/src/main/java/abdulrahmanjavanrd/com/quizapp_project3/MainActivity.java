package abdulrahmanjavanrd.com.quizapp_project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class MainActivity extends AppCompatActivity {
    /**
     *  pure app for copy and past in future .
     * @param savedInstanceState
     */
    TextView txvStudentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        txvStudentName = findViewById(R.id.txv_name);
        /** call {@link #setTxvStudentName()}  method  to set student name */
        setTxvStudentName();
        Toast.makeText(this, txvStudentName.getText().toString(),Toast.LENGTH_LONG).show();
        /**  call {@link #setUpAnim()} for  animations */
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

    /**
     * First call the student name from Splash screen
     * second set the student name in textView <p>This TextView gone Visibility</p>
     */
    public void setTxvStudentName(){
        String str = getIntent().getStringExtra(ConstantValues.NAME) ;
        txvStudentName.setText(str);
    }

    /**
     * @return The Text in TextView .
     */
   public String receiveStudentName(){
       String str =  txvStudentName.getText().toString();
       return  str ;
   }

    /**
     * @param v button on main_app_layout , This Button send all answers in this <p>MainActivity</p> Page And Student Name .
     *          Inside this method i called {@link #receiveStudentName()} to get Student Name .
     */
  public void goToNextSlide(View v){
       Intent intent = new Intent(this,SecondQuestion.class);
      intent.putExtra(ConstantValues.NAME,receiveStudentName());
      startActivity(intent);
  }
}
