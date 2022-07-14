package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//ساختن آرایه ای از کلاس کوئسشن
    int current=0;
    Question[] qu=new Question[]{
            new Question("Iranian carpet is the famous in the world", true),
            new Question("Iranian people speak arabic", false),
            new Question("Because the official religion of Iran is Islam, Iran does not have a church", false),
            new Question("Iranian women can't trip lonely", false),
    };
//متد چک کردن درست یا غلط بودن سوال
    private void checkqu(Boolean b){
        boolean answer=qu[current].isMresult();
        if(answer==b){
            Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//تعریف متغیرها

         Button true1=findViewById(R.id.btnt);
         Button false1=findViewById(R.id.btnf);
         TextView textView=findViewById(R.id.text1);
//اولین سوال در تکست ویو قرار بگیرد
        textView.setText(qu[0].getMqu());


         true1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 checkqu(true);
//به سوال بعدی برود و اگر سوال آخر بود به سوال اول برود
                 current = (current + 1) % qu.length;
                 textView.setText(qu[current].getMqu());
             }
         });


        false1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkqu(false);

                current=(current+1)%qu.length;
                textView.setText(qu[current].getMqu());
            }
        });
    }

//تعریف کلاس کوئسشن
    public static class Question {
        public void setMqu(String mqu) {
            this.mqu = mqu;
        }
        public void setMresult(boolean mresult) {
            this.mresult = mresult;
        }
        public String getMqu() {
            return mqu;
        }

        public boolean isMresult() {
            return mresult;
        }
        private String mqu;
        private boolean mresult;
        public Question(String mqu, boolean mresult) {
            this.mqu = mqu;
            this.mresult = mresult;
        }

    }
}
