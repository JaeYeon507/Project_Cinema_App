package org.techtown.project_cinema_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Movie06 extends Fragment {

    MainActivity activity;
    int movieIndex = 6;

    String title = "아수라",
            releaseDate = "2016.09.28 개봉",
            showTimes = "범죄, 액션/132분",
            ticketSales = "5위 1.8%",
            story = "  지옥 같은 세상, 살아남기 위해 싸우는 악인들의 전쟁 <아수라>\n" +
                    "  강력계 형사 한도경(정우성)은 이권과 성공을 위해 각종 범죄를 저지르는\n" +
                    "  악덕시장 박성배(황정민)의 뒷일을 처리해주는 대가로 돈을 받는다. 악에 계속 노출되는 사이,\n" +
                    "  말기 암 환자인 아내의 병원비를 핑계로 돈 되는 건 뭐든 하는 악인의 길로 들어서게 된 한도경.\n" +
                    "  그의 약점을 쥔 독종 검사 김차인(곽도원)과 검찰수사관 도창학(정만식)은\n" +
                    "  그를 협박하고 이용해 박성배의 비리와 범죄 혐의를 캐려 한다.\n" +
                    "  각자의 이익과 목적을 위해 한도경의 목을 짓누르는 검찰과 박성배.\n" +
                    "  그 사이 태풍의 눈처럼 되어 버린 한도경은, 자신을 친형처럼 따르는 후배 형사 문선모(주지훈)를\n" +
                    "  박성배의 수하로 들여보내고, 살아남기 위해 혈안이 된 나쁜 놈들 사이에서 서로 물지 않으면 물리는 지옥도가 펼쳐진다.\n" +
                    "  \n",
            director = "김성수",
            actors = "정우성(한도경), 황정민(박성배), 주지훈(문선모)...";

    int posterResID = R.drawable.image6,
            totalAttendance = 2594778;

    float mark = 6.54f;

    ArrayList<Item> comments = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie06,container,false);

        button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovieData data = new MovieData(title, releaseDate, showTimes, ticketSales, story, director, actors, posterResID, totalAttendance, mark);
                FragmentMovieListDirections.ActionFragmentMovieListToFragmentMovieDetail action = FragmentMovieListDirections.actionFragmentMovieListToFragmentMovieDetail(data, comments, movieIndex);
                activity.navController.navigate(action);
            }
        });

        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();

        if(activity.movieIndex == 6){
            comments = activity.items;
            activity.dataChanged = false;
        }
    }
}
