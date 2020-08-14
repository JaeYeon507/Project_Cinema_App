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

public class Movie05 extends Fragment {

    MainActivity activity;
    int movieIndex = 5;

    String title = "럭키",
            releaseDate = "2016.10.13 개봉",
            showTimes = "코미디/112분",
            ticketSales = "5위 1.8%",
            story = "  성공률 100% 완벽한 킬러!\n" +
                    "  목욕탕 Key 때문에 무명배우로 삶이 뒤바뀌다?!\n" +
                    "  냉혹한 킬러 형욱(유해진)은 사건 처리 후 우연히 들른\n" +
                    "  목욕탕에서 비누를 밟고 넘어져 과거의 기억을 잃게 된다.\n" +
                    "  인기도, 삶의 의욕도 없어 죽기로 결심한 무명배우 재성(이준)은 신변 정리를 위해 들른 목욕탕에서\n" +
                    "  그런 형욱을 보게 되고, 자신과 그의 목욕탕 키를 바꿔 도망친다.\n" +
                    "  \n" +
                    "  이후 형욱은 자신이 재성이라고 생각한 채, 배우로 성공하기 위해 노력하는데…\n" +
                    "  \n" +
                    "  인생에 단 한번 찾아온 초대형 기회! 초특급 반전!\n" +
                    "  이것이 LUCK.KEY다!",
            director = "이계벽",
            actors = "유해진(형욱), 이준(재성), 조윤희(리나)";

    int posterResID = R.drawable.image5,
            totalAttendance = 6975631;

    float mark = 8.76f;

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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie05,container,false);

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

        if(activity.movieIndex == 5){
            comments = activity.items;
            activity.dataChanged = false;
        }

    }
}
