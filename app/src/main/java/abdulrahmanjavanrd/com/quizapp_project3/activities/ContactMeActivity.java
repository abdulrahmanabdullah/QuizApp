package abdulrahmanjavanrd.com.quizapp_project3.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import abdulrahmanjavanrd.com.quizapp_project3.R;

/**
 * @author abdulrahman abdullah
 * @since on 04/12/2017.
 * @version  1.0
 */

public class ContactMeActivity extends AppCompatActivity
{

    EditText etWriteNotes;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app_layout);
        etWriteNotes = findViewById(R.id.et_write_notes);
    }

    /**
     * implicit intent
     * @param view -> Button to send my any message .
     */
    public void sendEmailMessage(View view) {
        String message = etWriteNotes.getText().toString();
        Intent  mIntent = new Intent(Intent.ACTION_SENDTO);
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {"nfs056@gmail.com"});
        mIntent.putExtra(Intent.EXTRA_SUBJECT,"Java-quiz app Notes");
        if (!(message.equals("") || message ==null)){
            mIntent.putExtra(Intent.EXTRA_TEXT,message);
            if (mIntent.resolveActivity(getPackageManager()) !=null )
                startActivity(mIntent);
        }else {
            message += "Empty text ";
            mIntent.putExtra(Intent.EXTRA_TEXT,message);
        }
    }

}
