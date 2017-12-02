package abdulrahmanjavanrd.com.quizapp_project3.activities;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import abdulrahmanjavanrd.com.quizapp_project3.app.MainActivity;
import abdulrahmanjavanrd.com.quizapp_project3.R;
import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;

public class SplashScreen extends AppCompatActivity {

    /**
     * {@link #studentName} id = et_student_name ;
     * {@link #upLinear} This LinearLayout contain imageView and TextView, Position Top parent .
     * {@link #downLinear } LinearLayout contain Button , textView . Position Bottom parent .
     */
    EditText studentName;
    LinearLayout upLinear, downLinear;
    Animation upAni, downAni;
    boolean mShouldFinish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        studentName = findViewById(R.id.et_student_name);
        upLinear = findViewById(R.id.up_linear);
        downLinear = findViewById(R.id.down_linear);
        upAni = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downAni = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        upLinear.setAnimation(upAni);
        downLinear.setAnimation(downAni);
        studentName.setAnimation(downAni);
    }

    /**
     * @param view to access button in activity_splash_screen .
     *             After that .
     *             Create new Intent, and call MainActivity With studentName,
     *             ConstantValues.Name = "studentName" ;
     */
    public void callMainActivity(View view) {
        /**
         * check if {@link #str == null } if student forget his name
         *   str = "guest" .
         */
        String str = studentName.getText().toString();
        if (str.equalsIgnoreCase("") || str == null) {
            str = " Guest";
        }
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, MainActivity.class);
        saveStudentName(str);
        mShouldFinish = true;
        startActivity(intent, options.toBundle());
    }

    /**
     * @param str pass The student name Then Create new xml file and save the student name .
     */
    public void saveStudentName(String str) {
        SharedPreferences mShared = getSharedPreferences(getPackageName() + ConstantValues.FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mShared.edit();
        editor.putString(ConstantValues.NAME, str);
        editor.apply();
    }

    /**
     * finish this layout after click {@link #callMainActivity}
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (mShouldFinish) {
            finish();
        }
    }
}
