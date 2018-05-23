package com.example.yeajunseoked.mynewapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    ViewPager pager1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //메인 액티비디로부터 전달 받은 인텐트를 확인합니다.
        Intent intent = getIntent();
        processIntent(intent);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pager1 = (ViewPager) findViewById(R.id.pager1);
        pager1.setOffscreenPageLimit(3); //캐싱을 미리 3개까지 함(미리 item(프레그먼드)를 담아둔다.

        CategoryPagerAdapter adapter = new CategoryPagerAdapter(getSupportFragmentManager());
        CategoryFragment2 fragment2 = new CategoryFragment2();
        adapter.addItem(fragment2);
        CategoryFragment3 fragment3 = new CategoryFragment3();
        adapter.addItem(fragment3);

        pager1.setAdapter(adapter);
    }

    class  CategoryPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();//아이템(프래그먼트들...) 관리위해서

        public CategoryPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){ //프레그먼트를 하나의 아이템으로 추가한다.
            items.add(item);//프레그먼트를 ArrayList에 추가한다.
        }

        @Override
        public Fragment getItem(int position) {//인텍스 값을 받아서 아이템을 리턴해준다.
            return items.get(position);
        }

        @Override
        public int getCount() { //arraylist안의 item갯수 리턴한다.
            return items.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {//페이지마다 타이틀을 붙쳐서 리턴해준다.
            return "페이지 "+position;
        }
    }

    public void processIntent(Intent intent) {
        if(intent != null){
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");
            Toast.makeText(getApplicationContext(), "전달받은 값 :"+ names.get(0), Toast.LENGTH_LONG).show();
        }
    }
}
