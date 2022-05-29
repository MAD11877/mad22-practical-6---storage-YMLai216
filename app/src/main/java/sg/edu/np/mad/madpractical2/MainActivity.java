package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();
    private final static String TAG = "Main Activity";
    public String GLOBAL_PREFS = "MyPrefs";
    public String MY_NAME = "MyName";
    public String MY_PASSWORD = "MyDescription";
    public Integer MY_ID = 0;
    public Boolean MY_FOLLOWED = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receiving = getIntent();
        String nameValue = receiving.getStringExtra("Name");
        String descValue = receiving.getStringExtra("Description");
        TextView intro = findViewById(R.id.Intro);
        TextView desc = findViewById(R.id.Desc);
        intro.setText(nameValue);
        desc.setText(descValue);

    }

    User test = new User();

    public void fb(View view){
        Button btn = findViewById(R.id.Follow);
        if (test.followed){
            test.followed = false;
            btn.setText("Unfollow");
            Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
        }
        else {
            test.followed = true;
            btn.setText("Follow");
        }
    }


    public void mb(View v){
        Intent msgIntent = new Intent(MainActivity.this, MessageGroup.class);
        startActivity(msgIntent);
    }
}