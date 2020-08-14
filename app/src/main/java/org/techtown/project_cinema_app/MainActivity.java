package org.techtown.project_cinema_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    NavController navController;

    FragmentManager fragmentManager;

    DrawerLayout drawer;

    ArrayList<Item> items;

    Boolean dataChanged = false;

    int movieIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations. //아직 지켜지지않음
        mAppBarConfiguration = new AppBarConfiguration.Builder( //activity_main_drawer 의 각 메뉴 id는 연결될 프래그먼트의 mobile_navigation.xml 파일의 프래그먼트 id 와 동일 해야한다.
                R.id.fragmentMovieList)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 101) {
            processIntent(101, intent);
            dataChanged = true;
        }

        if (requestCode == 109) {
            items = intent.getParcelableArrayListExtra("items");
            dataChanged = true;
        }

    }

    private void processIntent(int requestCode, Intent intent) {
        if (requestCode == 101) {
            if (intent != null) {
                RatedItem data = intent.getParcelableExtra("items");

                if (data != null) {
                    float rb_num = data.getNum();
                    String et = data.getEt();

                    if(items != null) {
                        Collections.reverse(items);
                        items.add(new Item("익명", "방금", et, R.drawable.user1, rb_num));
                        Collections.reverse(items);
                    }
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) { //드로어가 열려있을 때, 시스템 백 버튼이 눌릴경우 드로어를 닫는다.
            drawer.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();  //그렇지 않을경우, 기존의 동작 수행
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void goToWritingActivity(String title) {
        Intent intent = new Intent(getApplicationContext(), WritingActivity.class);
        intent.putExtra("title",title);
        startActivityForResult(intent, 101);
    }

    public void goToViewAllActivity(String title) {
        Intent intent = new Intent(getApplicationContext(), ViewAllActivity.class);
        intent.putExtra("title",title);
        intent.putParcelableArrayListExtra("data", items);
        startActivityForResult(intent, 109);

    }

    public void setMovieIndex(int index){
        this.movieIndex = index;
    }   //다른 영화 프래그먼트의 상세보기 버튼이 눌리기 전까지 이 인덱스값은 유지됨
}

