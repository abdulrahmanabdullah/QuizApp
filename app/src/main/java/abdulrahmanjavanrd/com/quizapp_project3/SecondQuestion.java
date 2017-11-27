package abdulrahmanjavanrd.com.quizapp_project3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class SecondQuestion extends AppCompatActivity {

    EditText etAnswer7 ;
    CheckBox yesAnswer , noAnswer ;
    int calcuScore ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        Toolbar toolbar = findViewById(R.id.second_toolBar);
        etAnswer7 = findViewById(R.id.et_answer_7);
        yesAnswer = findViewById(R.id.checkBox_yes);
        noAnswer = findViewById(R.id.checkBox_no);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setSubtitle(getString(R.string.complete_question));
    }

    /**
     *
     * @param str to check what the student wrote.
     * @return string  what the etAnswer is .
     */
    public String checkAnswer7(String str){
        if (str.equalsIgnoreCase("jvm")){
            etAnswer7.setBackgroundColor(Color.GREEN);
           calcuScore++;
        }else {
            etAnswer7.setBackgroundColor(Color.RED);
        }
        return str ;
    }
    public void showQuizResult(View view) {
        String str = etAnswer7.getText().toString() ;
        checkAnswer7(str);
        if (yesAnswer.isChecked()){
            yesAnswer.setBackgroundColor(Color.RED);
            noAnswer.setChecked(true);
            noAnswer.setBackgroundColor(Color.GREEN);
        }
        if(noAnswer.isChecked()){
           noAnswer.setBackgroundColor(Color.GREEN);
        }
        // TODO: call Dialog here .
        Toast.makeText(this," correct  = " + calcuScore,Toast.LENGTH_LONG).show();
        getPreviouslyAnswer();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return  true ;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.setting :
//                Toast.makeText(this,"settings clicked ",Toast.LENGTH_LONG).show();
//                break;
//            default:
//                break;
//        }
//        return true ;
//    }

    public void getPreviouslyAnswer(){
        // First get student name .
        String studentName = getIntent().getStringExtra(ConstantValues.NAME);
        Toast.makeText(this," student name = " + studentName, Toast.LENGTH_LONG).show();
    }
}
