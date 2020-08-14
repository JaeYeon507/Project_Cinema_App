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

public class Movie01 extends Fragment {

    MainActivity activity;
    int movieIndex = 1;

    String title = "군도",
            releaseDate = "2014.07.23 개봉",
            showTimes = "액션/137분",
            ticketSales = "5위 1.8%",
            story = "  군도, 백성을 구하라!\n  양반과 탐관오리들의 착취가 극에 달했던 조선 철종 13년. \n  힘 없는 백성의 편이 되어\n" +
                    "  세상을 바로잡고자 하는 의적떼인 \n  군도(群盜), 지리산 추설이 있었다.\n\n  쌍칼 도치 vs 백성의 적 조윤\n  잦은 자연재해, 기근과 관의 횡포까지 겹쳐 백성들의 삶이 \n  날로 피폐해 져 가는 사이,\n" +
                    "  나주 대부호의 서자로 조선 \n  최고의 무관 출신인 조윤은 극악한 수법으로 양민들을 수탈,\n  삼남지방 최고의 대부호로 성장한다. \n\n  한편 소, 돼지를 잡아 \n  근근이 살아가던 천한 백정 돌무치는\n" +
                    "  죽어도 잊지 못할 \n  끔찍한 일을 당한 뒤 군도에 합류. 지리산 추설의 신 거성(新 巨星) \n  도치로 거듭난다.\n\n  뭉치면 백성, 흩어지면 도적!\n  망할 세상을 뒤집기 위해, 백성이 주인인 새 세상을 향해 \n  도치를 필두로 한 군도는 백성의 적,\n" +
                    "  조윤과 한 판 승부를 \n  시작하는데...\n",
            director = "윤종빈",
            actors = "하정우(도치), 강동원(조윤)";

    int posterResID = R.drawable.image1,
            totalAttendance = 839399;

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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie01,container,false);

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

        if(activity.movieIndex == 1){
            comments = activity.items;
            activity.dataChanged = false;
        }

    }
}
