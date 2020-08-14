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

public class Movie02 extends Fragment {

    MainActivity activity;
    int movieIndex = 2;

    String title = "공조",
            releaseDate = "2017.01.18 개봉",
            showTimes = "액션/125분",
            ticketSales = "5위 1.8%",
            story = "  비밀리에 제작된 위조 지폐 동판을 탈취하려는 내부 조직에 의해\n" +
                    "  작전 중 아내와 동료들을 잃게 된 특수 정예부대 출신의 북한형사\n  ‘림철령’(현빈).\n" +
                    "  \n" +
                    "  동판을 찾아야만 하는 북한은 남한으로 숨어든 조직의 리더\n  ‘차기성’(김주혁)을 잡기 위해\n" +
                    "  역사상 최초의 남북 공조수사를 요청하고, 그 적임자로 철령을 서울에\n  파견한다.\n" +
                    "  \n" +
                    "  한편, 북한의 속내가 의심스런 남한은 먼저 차기성을 잡기 위한 작전을\n  계획하고,\n" +
                    "  정직 처분 중인 생계형 형사 ‘강진태’(유해진)에게 공조수사를 위장한\n  철령의 밀착 감시를 지시한다.\n" +
                    "  \n" +
                    "  임무를 완수해야 하는 철령과 임무를 막아야만 하는 진태.\n" +
                    "  그들에게 주어진 시간은 단 3일,\n" +
                    "  한 팀이 될 수 없는 남북 형사의 예측불가 공조수사가 시작된다!\n",
            director = "김성훈",
            actors = "현빈(임철령), 유해진(강진태), 김주혁(차기성)";

    int posterResID = R.drawable.image2,
            totalAttendance = 7817654;

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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie02,container,false);

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

        if(activity.movieIndex == 2){
            comments = activity.items;
            activity.dataChanged = false;
        }
    }
}
