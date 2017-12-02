package abdulrahmanjavanrd.com.quizapp_project3;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class SecondQuestion extends AppCompatActivity {

    EditText etAnswer8;
    CheckBox yesAnswer , noAnswer ;
    int correctAnswer;
    String studentName ;
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
    }

    /**
     *
     * @param str to check what the student wrote.
     * @return string  what the etAnswer is .
     */
    public String checkAnswer8(String str){
        if (str.equalsIgnoreCase("jvm")){
            etAnswer8.setBackgroundColor(Color.GREEN);
           correctAnswer++;
        }else {
            etAnswer8.setBackgroundColor(Color.RED);
        }
        return str ;
    }
    public void showQuizResult(View view) {
        String str = etAnswer8.getText().toString() ;
        checkAnswer8(str);
        answerCheckBox();
        getPreviouslyAnswer();
        // TODO: call Dialog here .
        AlertDialog.Builder dailog = new AlertDialog.Builder(this);
        /** This View for dialog layout, and passing student name and correctAnswer to there . */
        View v =getLayoutInflater().inflate(R.layout.dialog_layout,null);
        TextView txvStudentName = v.findViewById(R.id.txv_student_name);
        TextView txvCorrectAnswer = v.findViewById(R.id.txv_correct_answer);
        txvStudentName.setText(studentName);
        txvCorrectAnswer.setText(String.valueOf(correctAnswer));
        dailog.setView(v);
        dailog.show();

    }
    public void getPreviouslyAnswer(){
        SharedPreferences mShared = getSharedPreferences(getPackageName()+ConstantValues.FILE_NAME,Context.MODE_PRIVATE);
        correctAnswer += mShared.getInt(ConstantValues.SCORE_VALUE,-1);
        studentName = mShared.getString(ConstantValues.NAME,"null");
        Toast.makeText(this," Okay you receive this "+ correctAnswer +" Name = "+studentName,Toast.LENGTH_LONG).show();
    }

    public void answerCheckBox(){
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
            correctAnswer++;
        }
    }
    public void exitQuiz(View v){
        SharedPreferences mShared = getSharedPreferences(getPackageName()+ConstantValues.FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor edtior = mShared.edit();
        edtior.clear();
        this.finish();
    }
}
