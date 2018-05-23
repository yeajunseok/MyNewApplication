package com.example.yeajunseoked.mynewapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //이게 activity_main 과 연결시켜줌

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                ArrayList<String> names = new ArrayList<String>();
                names.add("pc방");

                intent.putExtra("names", names);

                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);//캐싱을 미리 3개까지 함(미리 item(프레그먼드)를 담아둔다.

        ADPagerAdapter adapter = new ADPagerAdapter(getSupportFragmentManager());
        Ad1Fragment1 fragment1 = new Ad1Fragment1();
        adapter.addItem(fragment1);
        Ad1Fragment2 fragment2 = new Ad1Fragment2();
        adapter.addItem(fragment2);
        Ad1Fragment3 fragment3 = new Ad1Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);
    }
    class ADPagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<Fragment>(); //아이템(프래그먼트들을...) 관리위해서

        public ADPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){ //프레그먼트를 하나의 아이템으로 추가한다.
            items.add(item); //프레그먼트를 ArrayList에 추가한다.
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {//인텍스 값을 받아서 아이템을 리턴해준다.
            return items.get(position);
        }

        @Override
        public int getCount() { //Arraylist안의 item갯수 리턴한다.
            return items.size();
        }
    }
}
