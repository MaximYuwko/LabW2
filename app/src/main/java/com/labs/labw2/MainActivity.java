package com.labs.labw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.os.Bundle;

import static com.labs.labw2.R.id.fragment2;

public class MainActivity extends AppCompatActivity implements FragmentQuestion.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(CharSequence answer) {
       FragmentAnswer fragmentAnswer = (FragmentAnswer) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if (fragmentAnswer != null && fragmentAnswer.isInLayout()) {
            fragmentAnswer.setAnswer(answer);
        }
    }
}
