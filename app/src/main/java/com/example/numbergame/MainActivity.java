package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtMyNum;

    Button btnGamaeStart,btnResult;

    TextView tvhint;
    //텍스트문으로 힌트를 줄때
    ImageView imagame;
    //틀리거나 맞출 때 이미지 생성
    int mynum,comnum,count;
    //  3개의 변수 선언
    Random rand = new Random();
    //1. 렌덤 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMyNum=(EditText)findViewById(R.id.edtMyNum);
        btnGamaeStart=(Button)findViewById(R.id.btnGamaeStart);
        btnResult=(Button)findViewById(R.id.btnResult);
        tvhint=(TextView)findViewById(R.id.tvhint);
        imagame=(ImageView)findViewById(R.id.imagame);

        btnGamaeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count =0;
//횟수카운터
//                comnum=(int)(Math.random()*100)+1;
// .random 난수를 발생시키는 함수(메소드) 0~99를 발생시키므로 1을 더해줘야 한다

                comnum=rand.nextInt(100)+1;
                //2 . 100을 int값으로 받아서 comum으로 대입(0~99) +1 --> 1~100
                tvhint.setText("자! 게임이 시작되었습니다.");
                //3. 텍스트표시가 변경됨
                btnResult.setEnabled(true);
                //10.앞에서 비활성화 되있는 결과확인 버튼이 활성화 될 수 있도록 함. (엑티비티 메인 먼저 생성)
                btnGamaeStart.setEnabled(false);
                //11.게임이 시작되면, 게임시작버튼이 잠궈지게 한다.
                imagame.setImageResource(R.drawable.number);
                //14.게임이 다시 시작되면 원래 넘버 이미지가 생성


            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4.결과 확인 버튼을 연결 -> 결과확인버튼을 눌러서 게임진행
                mynum=Integer.parseInt(edtMyNum.getText().toString());
                //edtMyNum에 입력되는 것을 확인받아 문자열로 변환하여 대입
                count++;
                        // 틀릴때마다 1회 증가
                if (mynum>comnum) {
                //5.내가 입력한 숫자가 컴퓨터가 생성한 숫자보다 클 경우
                    tvhint.setText("당신의 숫자가 좀 더 커요, 좀 더 작은수를 입력하세요.(틀린횟수 : "+count+")");
                //6.텍스트 표기 추가
                imagame.setImageResource(R.drawable.wrong);
                //7.이미지 추가
                }else if(mynum<comnum){
                 //8.내가 입력한 숫자가 컴퓨터가 생성한 숫자보다 작을 경우
                    tvhint.setText("당신의 숫자가 좀 더 작아요, 좀 더 큰수를 입력하세요.(틀린횟수 : "+count+")");
                    imagame.setImageResource(R.drawable.wrong);
                }else {
                    //9.정답일 경우
                    tvhint.setText("축하합니다. 맞추셨습니다.(총 시도 횟수 : "+count+")");
                    imagame.setImageResource(R.drawable.good);
                    btnGamaeStart.setEnabled(true);
                    //12.정답을 맞출 경우 게임시작버튼 활성화
                    btnResult.setEnabled(false);
                    //13.정답을 맞출 경우 결과확인버튼이 비활성화
                }
            }
        });


                    }
                }




