package com.example.yeajunseoked.mynewapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    ViewPager pager1;
    String str;

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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("PC방"));
        tabLayout.addTab(tabLayout.newTab().setText("학원"));
        tabLayout.addTab(tabLayout.newTab().setText("미용실"));
        tabLayout.addTab(tabLayout.newTab().setText("약국"));
        tabLayout.addTab(tabLayout.newTab().setText("음식점"));
        tabLayout.addTab(tabLayout.newTab().setText("푸드트럭"));
        tabLayout.addTab(tabLayout.newTab().setText("병원"));
        tabLayout.addTab(tabLayout.newTab().setText("법률"));
        tabLayout.addTab(tabLayout.newTab().setText("기타"));


        pager1 = (ViewPager) findViewById(R.id.pager1);
        pager1.setOffscreenPageLimit(3); //캐싱을 미리 3개까지 함(미리 item(프레그먼드)를 담아둔다.
        CategoryPagerAdapter adapter = new CategoryPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        CategoryFragment1 fragment1 = new CategoryFragment1();
        adapter.addItem(fragment1);
        CategoryFragment2 fragment2 = new CategoryFragment2();
        adapter.addItem(fragment2);
        CategoryFragment3 fragment3 = new CategoryFragment3();
        adapter.addItem(fragment3);
        CategoryFragment4 fragment4 = new CategoryFragment4();
        adapter.addItem(fragment4);
        CategoryFragment5 fragment5 = new CategoryFragment5();
        adapter.addItem(fragment5);
        CategoryFragment6 fragment6 = new CategoryFragment6();
        adapter.addItem(fragment6);
        CategoryFragment7 fragment7 = new CategoryFragment7();
        adapter.addItem(fragment7);
        CategoryFragment8 fragment8 = new CategoryFragment8();
        adapter.addItem(fragment8);
        CategoryFragment9 fragment9 = new CategoryFragment9();
        adapter.addItem(fragment9);

        pager1.setAdapter(adapter);
        //pager1.setCurrentItem(1); //첫 페이지를 선정한다.
        switch (str) {
            case "PC방":
                pager1.setCurrentItem(0); //첫 페이지를 선정한다.
                break;
            case  "학원":
                pager1.setCurrentItem(1); //첫 페이지를 선정한다.
                break;
            case  "미용실":
                pager1.setCurrentItem(2); //첫 페이지를 선정한다.
                break;
            case  "약국":
                pager1.setCurrentItem(3); //첫 페이지를 선정한다.
                break;
            case  "음식점":
                pager1.setCurrentItem(4); //첫 페이지를 선정한다.
                break;
            case  "푸드트럭":
                pager1.setCurrentItem(5); //첫 페이지를 선정한다.
                break;
            case  "병원":
                pager1.setCurrentItem(6); //첫 페이지를 선정한다.
                break;
            case  "법률":
                pager1.setCurrentItem(7); //첫 페이지를 선정한다.
                break;
            case  "기타":
                pager1.setCurrentItem(8); //첫 페이지를 선정한다.
                break;
        }
        pager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class  CategoryPagerAdapter extends FragmentStatePagerAdapter {
        int tabCount;
        ArrayList<Fragment> items = new ArrayList<Fragment>();//아이템(프래그먼트들...) 관리위해서

        public CategoryPagerAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);
            this.tabCount = numberOfTabs;
        }

        public void addItem(Fragment item){ //프레그먼트를 하나의 아이템으로 추가한다.
            items.add(item);//프레그먼트를 ArrayList에 추가한다.
        }

        @Override
        public Fragment getItem(int position) {//인텍스 값을 받아서 아이템을 리턴해준다, 화면에서 스와이프 이벤트가 발생할 때 마다 이 함수가 콜백호출되어 인텍스에 따라 다른 프래그먼트를 생성시켜서 출력되도록 도와준다. 따라서 이 함수의 리턴형태는 프래그먼트여야 한다.
            return items.get(position);
        }

        @Override
        public int getCount() { //arraylist안의 item갯수 리턴한다.
            return items.size();
        }

        /*@Override
        public CharSequence getPageTitle(int position) {//페이지마다 타이틀을 붙쳐서 리턴해준다.
            return "페이지 " + position;
        }*/
    }

    public void processIntent(Intent intent) {
        if(intent != null){
            str = intent.getStringExtra("names");
           /*ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");
            Toast.makeText(getApplicationContext(), "전달받은 값 :"+ names.get(0), Toast.LENGTH_LONG).show();*/
            Toast.makeText(getApplicationContext(), "전달받은 값 :"+ str, Toast.LENGTH_LONG).show();
        }
    }

    public void AAA(int index) {
        if(index == 0){
            Intent intent = new Intent(getApplicationContext(), OostoreActivity.class); //프래그먼트는 intent사용하면 안된다고 함.
            startActivity(intent);
        }
    }
}
