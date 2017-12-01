package abdulrahmanjavanrd.com.quizapp_project3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class SecondQuestion extends AppCompatActivity {

    EditText etAnswer8;
    CheckBox yesAnswer , noAnswer ;
    int calcuScore ;
    LocalBroadcastManager manager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        Toolbar toolbar = findViewById(R.id.second_toolBar);
        manager = LocalBroadcastManager.getInstance(this);
        etAnswer8 = findViewById(R.id.et_answer_8);
        yesAnswer = findViewById(R.id.checkBox_yes);
        noAnswer = findViewById(R.id.checkBox_no);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setSubtitle(getString(R.string.complete_question));
        getAllScore();
    }

    /**
     *
     * @param str to check what the student wrote.
     * @return string  what the etAnswer is .
     */
    public String checkAnswer8(String str){
        if (str.equalsIgnoreCase("jvm")){
            etAnswer8.setBackgroundColor(Color.GREEN);
           calcuScore++;
        }else {
            etAnswer8.setBackgroundColor(Color.RED);
        }
        return str ;
    }
    public void showQuizResult(View view) {
        String str = etAnswer8.getText().toString() ;
        checkAnswer8(str);
        /**
         * CheckBox Questions.
         */
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
    public void getPreviouslyAnswer(){
        // First get student name .
        String studentName = getIntent().getStringExtra(ConstantValues.NAME);
        Toast.makeText(this," student name = " + studentName, Toast.LENGTH_LONG).show();

    }
    public void getAllScore(){
        SharedPreferences mShared = getSharedPreferences(getPackageName()+ConstantValues.FILE_NAME,Context.MODE_PRIVATE);
        int xy = mShared.getInt(ConstantValues.SCORE_VALUE,-1);
        String str = mShared.getString(ConstantValues.NAME,"null");
        Toast.makeText(this," Okay you receive this "+xy+" Name = "+str,Toast.LENGTH_LONG).show();
    }
}
