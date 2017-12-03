package abdulrahmanjavanrd.com.quizapp_project3.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import abdulrahmanjavanrd.com.quizapp_project3.R;
import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class SecondActivity extends AppCompatActivity {

    EditText etAnswer8;
    CheckBox firstChoice, secondChoice, thirdChoice, fourthChoice;
    int correctAnswer;
    String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        Toolbar toolbar = findViewById(R.id.second_toolBar);
        etAnswer8 = findViewById(R.id.et_answer_8);
        firstChoice = findViewById(R.id.chBox_first);
        secondChoice = findViewById(R.id.chBox_second);
        thirdChoice = findViewById(R.id.chBox_third);
        fourthChoice = findViewById(R.id.chBox_fourth);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setSubtitle(getString(R.string.complete_question));
    }

    /**
     * @param str to check what the user wrote.
     * @return string  what the etAnswer is .
     */
    public String checkAnswer8(String str) {
        if (str.trim().equalsIgnoreCase("jvm")) {
            etAnswer8.setBackgroundColor(Color.GREEN);
            correctAnswer++;
        } else {
            etAnswer8.setBackgroundColor(Color.RED);
        }
        return str;
    }

    /**
     * @param view for result Button in activity_second_question.xml
     *             When user click this Button :
     *             First:<p> Get input from {@link #etAnswer8} and check if the input answer is correct Or not.</p>
     *             Second: <p>{@link #onCheckBoxClicked(View)} ()} check the checkBox answer.</p>
     *             Third: <p> get the correct answer in choice question {@link #getPreviouslyAnswer()}</p>
     *             Four : <p> Create new AlertDialog page and pass the student name And correct answer value. </p>
     */
    public void showQuizResult(View view) {
        String str = etAnswer8.getText().toString();
        checkAnswer8(str);
        getPreviouslyAnswer();
        // TODO: call Dialog here .
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        /** This View for dialog layout,And pass student name and correct Answer to Dialog page.*/
        View v = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        TextView txvStudentName = v.findViewById(R.id.txv_student_name);
        TextView txvCorrectAnswer = v.findViewById(R.id.txv_correct_answer);
        TextView txvIncorrectAnswer = v.findViewById(R.id.txv_incorrect_answer);
        txvStudentName.setText(studentName);
        txvCorrectAnswer.setText(String.valueOf(correctAnswer) + "/10");
        txvIncorrectAnswer.setText(String.valueOf(10 - correctAnswer));
        dialog.setView(v);
        dialog.show();
    }

    public void getPreviouslyAnswer() {
        SharedPreferences mShared = getSharedPreferences(getPackageName() + ConstantValues.FILE_NAME, Context.MODE_PRIVATE);
        /** save previously correct answer, Then remove it .*/
        int temperedNumber = mShared.getInt(ConstantValues.CORRECT_ANSWER_VALUES, 0);
        correctAnswer += temperedNumber;
        /** Now remove values in the xml, Because when user retry quiz */
        SharedPreferences.Editor editor = mShared.edit();
        editor.remove(ConstantValues.CORRECT_ANSWER_VALUES);
        /** save the student name in local variable, Then remove the save Values in xml file */
        studentName = mShared.getString(ConstantValues.NAME, "null");
        editor.remove(ConstantValues.NAME);
        editor.apply();
    }

    /**
     * CheckBox Questions method .
     *
     * @param v for checkBox Button .
     *          If user select true answer increment  correctAnswer Else decrement answer .
     */
    public void onCheckBoxClicked(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        switch (v.getId()) {
            case R.id.chBox_first:
                if (checked)
                    firstChoice.setBackgroundColor(Color.RED);
                break;
            case R.id.chBox_second:
                if (checked)
                    secondChoice.setBackgroundColor(Color.RED);
                break;
            case R.id.chBox_third:
                if (checked)
                    thirdChoice.setBackgroundColor(Color.GREEN);
                correctAnswer++;
                break;
            case R.id.chBox_fourth:
                if (checked)
                    fourthChoice.setBackgroundColor(Color.GREEN);
                correctAnswer++;
                break;

        }
    }

    /**
     * @param v = Button in the dialog_layout file
     */
    public void retryQuiz(View v) {
        Intent mIntent = new Intent(this, SplashScreen.class);
        startActivity(mIntent);
        this.finish();
    }

    /**
     * @param v = Button in the dialog_layout file .
     */
    public void exitQuiz(View v) {
        this.finish();
    }


}
