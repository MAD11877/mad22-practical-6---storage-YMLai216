package sg.edu.np.mad.madpractical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<Data> data;
    Context context;
    public Adapter (Context context, ArrayList<Data> input){
        this.context = context;
        this.data = input;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(item);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Data s = data.get(position);
        holder.name.setText(s.name);
        holder.desc.setText(s.description);

        if (s.name.endsWith("7")){
            holder.largeImg.setVisibility(View.VISIBLE);
        }

        holder.imageList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert= new AlertDialog.Builder(context);

                alert.setTitle("Profile");
                alert.setMessage("MADness");
                alert.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent myIntent= new Intent(context, MainActivity.class);
                        Bundle stringContent = new Bundle();
                        stringContent.putString("Name", s.name);
                        stringContent.putString("Description", s.description);
                        myIntent.putExtras(stringContent);
                        context.startActivity(myIntent);
                    }
                });
                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        });
    }

    public int getItemCount(){
        return data.size();
    }
}
