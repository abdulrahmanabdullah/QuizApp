package abdulrahmanjavanrd.com.quizapp_project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import abdulrahmanjavanrd.com.quizapp_project3.adapter.ChoiceQuestionRecycler;
import abdulrahmanjavanrd.com.quizapp_project3.model.ChoiceQue;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        recyclerView = findViewById(R.id.recycler_v);
        /**  call {@link #setUpAnim()} for  animations */
       setUpAnim();
       setUpRecycler();
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
        explode.setDuration(500);
        getWindow().setEnterTransition(explode);
    }
    public void setUpRecycler(){
        ChoiceQuestionRecycler recycler = new ChoiceQuestionRecycler(this,ChoiceQue.getData());
        recyclerView.setAdapter(recycler);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(),linearLayout.getOrientation());
        recyclerView.addItemDecoration(divider);
        recyclerView.setLayoutManager(linearLayout);

    }

    /**
     * @param v button on main_app_layout , This Button send all answers in this <p>MainActivity</p> Page And Student Name .
     *          Inside this method i called {@link #receiveStudentName()} to get Student Name .
     */
  public void goToNextSlide(View v){
       Intent intent = new Intent(this,SecondQuestion.class);
      startActivity(intent);
      this.finish();
  }
}
