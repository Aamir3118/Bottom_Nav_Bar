package com.example.bottomnavigationexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {
    TextView textView;
    EditText etFname,etLname;
    Button btnSubmit;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        String value = null;
//        if (getArguments() != null) {
//            value = getArguments().getString("key");
//
//        }
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        textView = view.findViewById(R.id.tvValue);
        etFname = view.findViewById(R.id.fname);
        etLname = view.findViewById(R.id.lname);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) requireActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
                Bundle bundle1 = new Bundle();
                bundle1.putString("fname",etFname.getText().toString());
                bundle1.putString("lname",etLname.getText().toString());
                getParentFragmentManager().setFragmentResult("student",bundle1);
                etFname.setText("");
                etLname.setText("");

                Toast.makeText(view.getContext(), "Submitted sucessfully", Toast.LENGTH_SHORT).show();

            }
        });
//        textView.setText(value);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) requireActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
        });
        return view;

    }

}