package com.example.joycehsu.dtapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends BaseActivity implements View.OnClickListener{

    private CardView newsCard, learningCard, activitiesCard, settingsCard, quizCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_home, null, false);
        drawer.addView(contentView, 0);
        navigationView.setCheckedItem(R.id.nav_home);

        //link cards
        newsCard = (CardView) findViewById(R.id.newscard);
        learningCard = (CardView) findViewById(R.id.learningcard);
        activitiesCard = (CardView) findViewById(R.id.activitiescard);
        settingsCard = (CardView) findViewById(R.id.settingscard);
        quizCard = (CardView) findViewById(R.id.quizcard);

        //add on click listeners
        newsCard.setOnClickListener(this);
        learningCard.setOnClickListener(this);
        activitiesCard.setOnClickListener(this);
        settingsCard.setOnClickListener(this);
        quizCard.setOnClickListener(this);
    }

    // intents when card is clicked
    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.newscard: i = new Intent(this,NewsActivity.class);
                startActivity(i);
                break;

            case R.id.learningcard: i = new Intent(this,LearningActivity.class);
                startActivity(i);
                break;

            case R.id.activitiescard: i = new Intent(this,ActivitiesActivity.class);
                startActivity(i);
                break;

            case R.id.settingscard: i = new Intent(this,SettingsActivity.class);
                startActivity(i);
                break;

            case R.id.quizcard: i = new Intent(this,QuizStartActivity.class);
                startActivity(i);
                break;

            default:break;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = new Intent(HomeActivity.this, LoginActivity.class);
//                            i.putExtra("Username", name);
        startActivity(i);
        int id = item.getItemId();

        if (id == R.id.action_menu_home) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
