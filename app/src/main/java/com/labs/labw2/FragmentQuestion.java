package com.labs.labw2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.ContentFrameLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class FragmentQuestion extends Fragment {


    private RadioGroup radioGroup;
    private Button buttonOK;
    private OnFragmentInteractionListener listener;
    private CharSequence selectedText = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_question, container, false);
        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup1);
        buttonOK = (Button)view.findViewById(R.id.button);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                buttonOK.setEnabled(true);
                RadioButton selectedRadioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                selectedText = selectedRadioButton.getText();
            }
        });
        buttonOK.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                listener.onFragmentInteraction(selectedText);
            }
        });
        return view;
    }

    interface OnFragmentInteractionListener{
        void onFragmentInteraction(CharSequence answer);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentInteractionListener) context;
    }
}

