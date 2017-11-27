package abdulrahmanjavanrd.com.quizapp_project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class SplashScreen extends AppCompatActivity {

    /**
     * @a
     * {@link #studentName} EditText to take student name.
     */
    EditText studentName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        studentName = findViewById(R.id.et_student_name);
    }
    /**
     *
     * @param view to access button in activity_splash_screen .
     *             After that .
     * Create new Intent, and call MainActivity With studentName,
     *             ConstantValues.Name = "studentName" ;
     */
    public void callMainActivity(View view){
        String str = studentName.getText().toString() ;
        Intent  intent = new Intent(this,MainActivity.class);
        intent.putExtra(ConstantValues.NAME,str);
//        Transition tran  = TransitionInflater.from(this).inflateTransition(R.transition.first_screen_transisiton);
//        tran.setDuration(500);
//        getWindow().setEnterTransition(tran);
        startActivity(intent);
        this.finish();
    }
}
