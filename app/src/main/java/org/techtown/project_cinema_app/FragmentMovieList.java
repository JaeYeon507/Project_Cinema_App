package org.techtown.project_cinema_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import org.techtown.project_cinema_app.Movie01;
import org.techtown.project_cinema_app.Movie02;
import org.techtown.project_cinema_app.Movie03;

import java.util.ArrayList;

public class FragmentMovieList extends Fragment {

    MainActivity activity;
    ViewPager pager;

    Movie01 movie01;
    Movie02 movie02;
    Movie03 movie03;
    Movie04 movie04;
    Movie05 movie05;
    Movie06 movie06;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_movie_list, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pager = view.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(6);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViewPager(pager);
    }

    private void setupViewPager(ViewPager pager) {

        MoviePagerAdapter adapter = new MoviePagerAdapter(getChildFragmentManager());

        movie01 = new Movie01();
        movie02 = new Movie02();
        movie03 = new Movie03();
        movie04 = new Movie04();
        movie05 = new Movie05();
        movie06 = new Movie06();

        adapter.addItem(movie01);
        adapter.addItem(movie02);
        adapter.addItem(movie03);
        adapter.addItem(movie04);
        adapter.addItem(movie05);
        adapter.addItem(movie06);

        pager.setAdapter(adapter);

    }

    class MoviePagerAdapter extends FragmentStatePagerAdapter {

        ArrayList<Fragment> items = new ArrayList<>();

        public MoviePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Fragment item){
            items.add(item);
        }

    }
}
