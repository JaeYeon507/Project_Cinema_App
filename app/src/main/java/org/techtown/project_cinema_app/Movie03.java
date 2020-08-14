package org.techtown.project_cinema_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Movie03 extends Fragment {

    MainActivity activity;
    int movieIndex = 3;

    String title = "더킹",
            releaseDate = "2017.01.18 개봉",
            showTimes = "범죄, 드라마/134분",
            ticketSales = "5위 1.8%",
            story = "  대한민국의 왕은 누구인가?\n" +
                    "  무소불위 권력을 쥐고 폼 나게 살고 싶었던 태수는\n" +
                    "  우여곡절 끝에 권력의 설계자 한강식을 만나\n" +
                    "  핵심 라인을 타고 승승장구 하게 된다\n" +
                    "  \n" +
                    "  정권이 교체되는 중요한 시기,\n" +
                    "  새로운 판을 짜며 기회를 노리던 이들 앞에\n" +
                    "  예상치 못한 위기가 닥치는데…\n" +
                    "  \n" +
                    "  대한민국이 속 시원하게 뒤집힌다!\n",
            director = "한재림",
            actors = "조인성(박태수), 정우성(한강식), 배성우(양동철)";

    int posterResID = R.drawable.image3,
            totalAttendance = 5318007;

    float mark = 8.2f;

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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie03,container,false);

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

        if(activity.movieIndex == 3){
            comments = activity.items;
            activity.dataChanged = false;
        }

    }
}
