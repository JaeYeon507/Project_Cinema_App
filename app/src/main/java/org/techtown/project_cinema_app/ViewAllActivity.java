package org.techtown.project_cinema_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import org.techtown.project_cinema_app.itemView;

import java.util.ArrayList;
import java.util.Collections;

public class ViewAllActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Item> items;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        listView = findViewById(R.id.listView);

        TextView tv_write = findViewById(R.id.tv_write);
        tv_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WritingActivity.class);
                startActivityForResult(intent,109);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            processIntent(intent);
        }

        if(items != null) {
            adapter = new ItemAdapter();
            listView.setAdapter(adapter);
        }
    }

    private  void processIntent(Intent intent){
        if(intent != null){
            items = intent.getParcelableArrayListExtra("data");
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("items",items);
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 109) {
            if (intent != null) {
                RatedItem data = intent.getParcelableExtra("items");

                if (data != null) {
                    float rb_num = data.getNum();
                    String et = data.getEt();

                    Collections.reverse(items);
                    adapter.addItem(new Item("익명", "방금", et, R.drawable.user1, rb_num));
                    Collections.reverse(items);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    private class ItemAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            itemView itemView = null;

            if (itemView == null) {
                itemView = new itemView(getApplicationContext());
            } else {
                itemView = (org.techtown.project_cinema_app.itemView) view;
            }

            Item item = items.get(i);
            itemView.setTextView6(item.getUserId());
            itemView.setTextView7(item.getTime());
            itemView.setTextView9(item.getComment());
            itemView.setImageView3(item.getResId());
            itemView.setRatingBar2(item.getStar_num());

            return itemView;
        }

        public void addItem(Item item) {
            items.add(item);
        }

    }
}
