package com.example.yeajunseoked.mynewapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {
    private FirebaseAuth mFirebaseAuth;
    private GoogleApiClient mGoogleApiClient; //구글 계정과 뭔가를 하려면 필요한 것.

    private EditText editText_email;
    private EditText editText_password;
    public static final int RC_SIGN_IN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_password = (EditText) findViewById(R.id.editText_password);

        mFirebaseAuth = FirebaseAuth.getInstance();//FirebaseAuth는 어떤 플랫폼을 사용해서 인증을 할 것 인가에 따라서 코드가 달라진다.

        // Configure Google Sign In, 구글sign 옵션
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //mGoogleApiClient 초기화과정
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)//(사용할 Api, 옵션)
                .build();

        //버튼을 눌렀을때
        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }
    //커넥션 실패 인터페이스
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onClick(View v) {
        Intent singInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient); //암시적 인텐트, 여기가 구글계정 선택하는 창이다.
        startActivityForResult(singInIntent, RC_SIGN_IN);
    }
    //로그인 결과는 여기서 처리한다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()) { //사용자가 로그인에 성공했을때
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            }else { //로그인 실패했을떄
                Toast.makeText(this, "google 로그인 실패", Toast.LENGTH_SHORT).show(); //구글계정 선택하는 창에서 다른 곳 누를때.
            }
        }
    }
    //firebase랑 google하고 연동하는 과정  성공시 화면전환일어남.
    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(SignInActivity.this, MainActivity.class)); //드디어 MainActivity.class로 넘어간다.<A-1>
                            Toast.makeText(SignInActivity.this, "google 로그인 성공", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignInActivity.this, "인증 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
