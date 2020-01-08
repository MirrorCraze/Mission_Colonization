package com.example.spaceinvaders;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.constraintlayout.solver.widgets.Rectangle;

        import android.content.Intent;
        import android.media.Image;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.util.Log;
        import android.util.TimeUtils;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.Date;
        import java.sql.Time;
        import java.util.List;
        import java.util.Random;
        import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ImageView bulletImage;
    ImageView bot;
    ImageView mainImage;
    int startingPosition = 70;

    public class Bullets {
        ImageView mainImage;
        ImageView bulletImage;

        int position = 70;

        public void show(ImageView imageView) {
            imageView.setVisibility(View.VISIBLE);
        }


        public float bulletGetX() {

            return this.position;

        }

    }
    int position = 900;
    public boolean onTouchEvent(MotionEvent event) {
        bulletImage = findViewById(R.id.bulletImage);
        mainImage = findViewById(R.id.mainImage);
        int fingerX = (int) event.getX();
        int fingerY = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mainImage.setX(fingerX - mainImage.getWidth()/2);
                mainImage.setImageResource(R.drawable.player_in_action);
                break;
            case MotionEvent.ACTION_DOWN:
                bulletImage.setVisibility(View.VISIBLE);
                new CountDownTimer(30000, 1500) {
                    public void onTick(long millisUntilFinished) {
                        for (int m = 0; m < 10; ) {
                            bulletImage.setY(position);
                            position -= 10;
                            m++;
                        }
                    }

                    public void onFinish() {
                        bulletImage.setY(position);
                    }

                }.start();
                break;
            case MotionEvent.ACTION_UP:
                mainImage.setImageResource(R.drawable.player_idle);
                bulletImage.setVisibility(View.INVISIBLE);
                position = 900;
                bulletImage.setY(position);
                break;

        }

        Log.i("test", "X: " + fingerX + ", Y: " + fingerY);
        return false;
    }

    public class enemyShip extends Bullets{
        int x = 30;
        int width = 100;
        int position = 900;
        final int startingPosition = 70;


        CountDownTimer ct = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                bot = findViewById(R.id.bot);
                for (int i = 0; i < 10; ) {
                    bot.setY(x);
                    x += 30;
                    i++;
                }
            }

            public void onFinish() {
                x = startingPosition;
                bot.setY(x);
            }



        }.start();

        public float shipGetX() {
            return this.x;

        }

        public float shipGetWidth() {
            return this.width;
        }
    }
    public void startGame (View view) {

        List BulletList = new ArrayList();
        Bullets bl = new Bullets();
        BulletList.add(bl);

        List enemyShipList = new ArrayList();
        enemyShip sl = new enemyShip();
        enemyShipList.add(sl);

        if (bl.bulletGetX() >= sl.shipGetX() && bl.bulletGetX() <= sl.shipGetX() + sl.shipGetWidth()) {
            Log.i("Info", "test");

        }

         /*if (bulletx >= enemyshipx && bulletx <= enemyshipx+enemyshipwidth) {
        if (bullety >= enemyshipy && bullety <= this.y+enemyshipheight) {
            return true; //return true means that it has hit

        }
    }
    return false; // otherwise it has not hit


    run show
        show places image at finger x and finger y coordinate
        update - lowers y coordinate

        */


    }




    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button returnHome = findViewById(R.id.homeButton);
        returnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainScreen.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}
