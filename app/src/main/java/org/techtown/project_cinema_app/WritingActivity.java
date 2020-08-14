package org.techtown.project_cinema_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WritingActivity extends AppCompatActivity {

    RatingBar rb;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        rb = findViewById(R.id.rb);
        et = findViewById(R.id.et);
        tv = findViewById(R.id.textView4);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                RatedItem items = new RatedItem(rb.getRating(), et.getText().toString());

                intent.putExtra("items",items);

                setResult(RESULT_OK,intent);

                Toast.makeText(getApplicationContext(), "한줄평이 저장 되었습니다. ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"한줄평 작성이 취소되었습니다. ",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {   //button2 의 기능과 똑같다.
        Toast.makeText(getApplicationContext(),"한줄평 작성이 취소되었습니다. ",Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}