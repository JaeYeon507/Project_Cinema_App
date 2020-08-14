package org.techtown.project_cinema_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class itemView extends ConstraintLayout {

    TextView textView6, textView7, textView9;
    ImageView imageView3;
    RatingBar ratingBar2;


    public itemView(Context context) {
        super(context);
        init(context);
    }

    public itemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @SuppressLint("ResourceType")
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_view,this,true);

        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView9 = findViewById(R.id.textView9);
        imageView3 = findViewById(R.id.imageView3);
        ratingBar2 = findViewById(R.id.ratingBar2);
    }

    public void setTextView6(String userId){
        textView6.setText(userId);
    }

    public void setTextView7(String time){
        textView7.setText(time);
    }

    public void setTextView9(String comment){
        textView9.setText(comment);
    }

    public void setImageView3(int resId){
        imageView3.setBackgroundResource(resId);
    }

    public void setRatingBar2(float star_num){
        ratingBar2.setRating(star_num);
    }


}
