package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Data> dataList = new ArrayList<>();
    public String GLOBAL_PREFS = "MyPrefs";
    public String MY_NAME = "MyName";
    public String MY_PASSWORD = "MyDescription";
    public Integer MY_ID = 0;
    public Boolean MY_FOLLOWED = true;
    DBHandler dbHandler = new DBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        Random random = new Random();
        for (int i = 1; i < 21; i++){
            Integer rName = random.nextInt();
            Integer rDesc = random.nextInt();

            User d = new User();
            Data f = new Data();
            d.name = "Name" + rName;
            d.description = "Description" + rDesc;
            d.id = i;
            d.followed = random.nextBoolean();

            f.name = "Name" + rName;
            f.description = "Description" + rDesc;

            dataList.add(f);
            dbHandler.addUsers(d);
            userList.add(d);
        }
        RecyclerView recyclerView = findViewById(R.id.listImage);
        Adapter myAdapter = new Adapter(ListActivity.this, dataList);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);


    }
}