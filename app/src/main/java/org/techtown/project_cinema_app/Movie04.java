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

public class Movie04 extends Fragment {

    MainActivity activity;
    int movieIndex = 4;

    String title = "레지던트 이블:\n파멸의 날",
            releaseDate = "2017.01.25 개봉",
            showTimes = "액션, SF, 스릴러/106분",
            ticketSales = "5위 1.8%",
            story = "  엄브렐라가 개발한 치명적인 T-바이러스가 전 세계에 퍼지고," +
                    "  \n" +
                    "  바이러스에 감염된 언데드들이 세상을 뒤덮는다.\n" +
                    "  \n" +
                    "  인류의 유일한 희망인 ‘앨리스’(밀라 요보비치)는 폐허가 된 도시를\n  떠돌던 중 엄브렐라가 T-바이러스를 해독할 백신 개발에 성공했다는 것을\n" +
                    "  알게 된다. " +
                    "  \n" +
                    "  그녀는 백신을 손에 넣기 위해 모든 사건의 시발점이자 엄브렐라의 본거지인 ‘라쿤 시티’로 돌아가\n  모든 것을 끝낼 마지막 전쟁을 시작하는데.\n" +
                    "  \n" +
                    "  생존자들을 구하기 위해 주어진 시간은 48시간.\n" +
                    "  인류 최후의 전사 '앨리스'의 마지막 전쟁이 시작된다!\n"+
                    "  \n",
            director = "폴 앤더슨",
            actors = "밀라 요보비치(앨리스), 알리 라터(클레어 레드필드), 이아인 글렌(알렉산더 박사)...";

    int posterResID = R.drawable.image4,
            totalAttendance = 765259;

    float mark = 8.59f;

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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie04,container,false);

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

        if(activity.movieIndex == 4){
            comments = activity.items;
            activity.dataChanged = false;
        }
    }
}
