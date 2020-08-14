package org.techtown.project_cinema_app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentMovieDetail extends Fragment {

    ItemAdapter adapter;

    Button thumb_up_button, thumb_down_button, viewAllButton;
    TextView goodindex, badindex, tv_write;

    boolean upState = false, downState = false;
    int gindex = 15 , bindex = 1;

    MainActivity activity;

    FragmentMovieDetailArgs args;

    int movieIndex = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_movie_detail, container, false);

        ImageView imageView4 = rootView.findViewById(R.id.imageView4);
        TextView textView = rootView.findViewById(R.id.textView);
        TextView textView2 = rootView.findViewById(R.id.textView2);
        TextView textView3 = rootView.findViewById(R.id.textView3);
        TextView textView15 = rootView.findViewById(R.id.textView15);
        TextView textView17 = rootView.findViewById(R.id.textView17);
        TextView textView16 = rootView.findViewById(R.id.textView16);
        TextView textView19 = rootView.findViewById(R.id.textView19);
        TextView textView22 = rootView.findViewById(R.id.textView22);
        TextView textView24 = rootView.findViewById(R.id.textView24);

        if(getArguments() != null){
            args = FragmentMovieDetailArgs.fromBundle(getArguments());
            movieIndex = args.getMovieIndex();
            MovieData movieData = args.getDetailMovieData();
            imageView4.setImageResource(movieData.getPosterResID());
            textView.setText(movieData.getTitle());
            textView2.setText(movieData.getReleaseDate());
            textView3.setText(movieData.getShowTimes());
            textView15.setText(movieData.getTicketSales());
            textView17.setText(String.valueOf(movieData.getMark()));
            textView16.setText(String.valueOf(movieData.getTotalAttendance()));
            textView19.setText(movieData.getStory());
            textView22.setText(movieData.getDirector());
            textView24.setText(movieData.getActors());
        }

        ListView listView = rootView.findViewById(R.id.listView);

        adapter = new ItemAdapter();

        adapter.items = args.getComments();
        activity.items = adapter.items;

        activity.setMovieIndex(movieIndex);

        listView.setAdapter(adapter);


        //작성하기 버튼
        tv_write = rootView.findViewById(R.id.tv_write);
        tv_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.goToWritingActivity();
            }
        });


        //모두보기 버튼
        viewAllButton = rootView.findViewById(R.id.button3);
        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { activity.goToViewAllActivity();
            }
        });


        thumb_up_button = rootView.findViewById(R.id.thumb_up_Button);
        thumb_down_button = rootView.findViewById(R.id.thumb_down_Button);
        goodindex = rootView.findViewById(R.id.goodindex);
        badindex = rootView.findViewById(R.id.badindex);


        thumb_up_button.setOnClickListener(new View.OnClickListener() { //thumb_up button 이 눌렸을 때의 처리
            @Override
            public void onClick(View view) {
                upState = !upState;

                if(upState){
                    incrgood();
                    if(downState){
                        decrgbad();
                        downState = !downState;
                    }
                }
                else {
                    decrgood();
                }
            }
        });

        thumb_down_button.setOnClickListener(new View.OnClickListener() {   //thumb_down button 이 눌렸을 때의 처리
            @Override
            public void onClick(View view) {
                downState = !downState;

                if(downState){
                    incrgbad();
                    if(upState){
                        decrgood();
                        upState = !upState;
                    }
                }
                else {
                    decrgbad();
                }
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(activity.dataChanged) {
            adapter.items = activity.items;
            adapter.notifyDataSetChanged();
        }
    }

    public void incrgood(){
        gindex++;
        goodindex.setText(String.valueOf(gindex));
        thumb_up_button.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }
    public  void decrgood(){
        gindex--;
        goodindex.setText(String.valueOf(gindex));
        thumb_up_button.setBackgroundResource(R.drawable.ic_thumb_up);
    }

    public void incrgbad(){
        bindex++;
        badindex.setText(String.valueOf(bindex));
        thumb_down_button.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrgbad(){
        bindex--;
        badindex.setText(String.valueOf(bindex));
        thumb_down_button.setBackgroundResource(R.drawable.ic_thumb_down);
    }

    public class ItemAdapter extends BaseAdapter {

        public ArrayList<Item> items = new ArrayList<>();

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

            if(itemView == null){
                itemView = new itemView(activity);
            } else {
                itemView = (itemView) view;
            }

            Item item = items.get(i);
            itemView.setTextView6(item.getUserId());
            itemView.setTextView7(item.getTime());
            itemView.setTextView9(item.getComment());
            itemView.setImageView3(item.getResId());
            itemView.setRatingBar2(item.getStar_num());

            return itemView;
        }

        public void addItem(Item item){
            items.add(item);
        }

    }

}
