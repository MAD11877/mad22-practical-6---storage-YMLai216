package sg.edu.np.mad.madpractical2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView desc;
    ImageView imageList;
    ImageView largeImg;
    public ViewHolder(View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.name);
        desc = itemView.findViewById(R.id.description);
        imageList = itemView.findViewById(R.id.imageList);
        largeImg = itemView.findViewById(R.id.largeImg);
    }

}
