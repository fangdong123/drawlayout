package com.fdd.adroid_drawlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawlayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        ViewGroup.LayoutParams layoutParams = navigationView.getLayoutParams();
        WindowManager windowManager = getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
        width -= 112;
        layoutParams.width = width;
        navigationView.setLayoutParams(layoutParams);
        navigationView.setItemIconTintList(null);

        //监听drawerLayout
        drawlayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                View content = drawlayout.getChildAt(0);
                int offest = (int) (drawerView.getWidth()*slideOffset);
                content.setTranslationX(offest);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //在这里处理item的点击事件
                switch (item.getItemId()){
                    case R.id.nav_camera:
                        Toast.makeText(MainActivity.this, ""+0, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_gallery:
                        Toast.makeText(MainActivity.this, ""+1, Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



    }

    private void initView() {
        drawlayout = (DrawerLayout) findViewById(R.id.drawlayout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
    }
}
