package abdulrahmanjavanrd.com.quizapp_project3;

import android.content.Context;
import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        Toolbar toolbar = findViewById(R.id.second_toolBar);
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

    /**
     *
     * @param view for result Button in activity_second_question.xml
     *
     *             When user click this Button :
     *            First:<P> Get input from {@link #etAnswer8} and check if the input answer is correct Or not.</P>
     *            Second: <P>{@link #answerCheckBox()} check the checkBox answer.</P>
     *            Third: <P> get the correct answer in choice question {@link #getPreviouslyAnswer()}</P>
     *            Four : <p> Create new AlertDialog page and pass the student name And correct answer value. </p>
     */
    public void showQuizResult(View view) {
        String str = etAnswer8.getText().toString() ;
        checkAnswer8(str);
        answerCheckBox();
        getPreviouslyAnswer();
        // TODO: call Dialog here .
        AlertDialog.Builder dailog = new AlertDialog.Builder(this);
        /** This View for dialog layout,And pass student name and correct Answer to Dialog page.*/
        View v =getLayoutInflater().inflate(R.layout.dialog_layout,null);
        TextView txvStudentName = v.findViewById(R.id.txv_student_name);
        TextView txvCorrectAnswer = v.findViewById(R.id.txv_correct_answer);
        txvStudentName.setText(studentName);
        txvCorrectAnswer.setText(String.valueOf(correctAnswer)+"/9");
        dailog.setView(v);
        dailog.show();

    }
    public void getPreviouslyAnswer(){
        SharedPreferences mShared = getSharedPreferences(getPackageName()+ConstantValues.FILE_NAME,Context.MODE_PRIVATE);
        /** save previously correct answer, Then remove it .*/
        int temperedNumber = mShared.getInt(ConstantValues.SCORE_VALUE,00);
        correctAnswer += temperedNumber;
        /** Now remove values in the xml, Because when user retry quiz */
        SharedPreferences.Editor editor = mShared.edit();
        editor.remove(ConstantValues.SCORE_VALUE);
        /** save the student name in local variable, Then remove the save Values in xml file */
        studentName = mShared.getString(ConstantValues.NAME,"null");
        editor.remove(ConstantValues.NAME);
        editor.apply();
        Toast.makeText(this," Okay you receive this "+ correctAnswer +" Name = "+studentName,Toast.LENGTH_LONG).show();
    }

    /**
     * CheckBox Questions.
     */
    public void answerCheckBox(){
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
        this.finish();
    }

    public void retryQuiz(View v){
        Intent  mIntent = new Intent(this,SplashScreen.class);
        startActivity(mIntent);
    }
}
