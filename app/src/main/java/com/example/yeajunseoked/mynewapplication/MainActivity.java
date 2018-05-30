package com.example.yeajunseoked.mynewapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private FirebaseAuth mFirebaseAuth; //인증 객체
    private FirebaseUser mFirebaseUser; //인증이 되면 이 객체를 얻는다.

    private GoogleApiClient mGoogleApiClient; //구글 계정과 뭔가를 하려면 필요한 것.

    //인증이 되면 사용자 이름과 정보를 저장할 변수
    private String mUsername;
    private String mPhotoUrl;

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //이게 activity_main 과 연결시켜줌

        //SignInActivity에서 로그인 성공후 인증이 되어 있기 때문에 mFirebaseUser 값 생긴다(얻었다).<A-2>
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser(); //로그인이 되어있다면 User객체를 얻을수 있다.현재 사용자를 가져올 때 권장하는 방법은 getCurrentUser 메소드를 호출하는 것입니다
        //로그인을 안 한 상태라면
        if (mFirebaseUser == null) { //로그인이 안 되어있다면 mFirebaseUser는 null 이다. 이떄 다른 액티비티로 이동하게 된다.
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else { //로그인이 되었다면 <A-3>
            mUsername = mFirebaseUser.getDisplayName();
            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }
        //mGoogleApiClient 초기화과정, 로그아웃 떄문에 있음
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API)//(사용할 Api, 옵션) 옵션은 로그아웃시가 필요없다.
                .build();

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("pc방");*/
                String a = "PC방";
                intent.putExtra("names", a);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String b = "학원";
                intent.putExtra("names", b);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String c = "미용실";
                intent.putExtra("names", c);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String d = "약국";
                intent.putExtra("names", d);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String e = "음식점";
                intent.putExtra("names", e);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String f = "푸드트럭";
                intent.putExtra("names", f);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String g = "병원";
                intent.putExtra("names", g);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String h = "법률";
                intent.putExtra("names", h);
                startActivity(intent); //새로운 액티비티 띄우기, 101은 요청코드, startActivity()는 단순히 액티비티를 띄워 하면에 보이도록 함.
            }
        });
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                /*ArrayList<String> names = new ArrayList<String>();
                names.add("학원");*/
                String i = "기타";
                intent.putExtra("names", i);
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
    //메뉴를 설치하기 위해서
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                mFirebaseAuth.signOut(); //mFirebaseAuth 로그아웃.
                Auth.GoogleSignInApi.signOut(mGoogleApiClient); //구글쪽도 로그아웃.
                mUsername = ""; //mUsername 초기화
                startActivity(new Intent(this, SignInActivity.class)); //다시 로그인 창으로
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

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
