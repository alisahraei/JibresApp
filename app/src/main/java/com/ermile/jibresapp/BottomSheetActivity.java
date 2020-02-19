package com.ermile.jibresapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomSheetActivity extends BottomSheetFragment {


    listenerBottomSheet mListener;

    public void setListener(listenerBottomSheet listener) {
        mListener = listener;
    }

    public BottomSheetActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_bottom_sheet, container, false);
        view.findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                mListener.refreh();
            }
        });
        return view;
    }

    public interface listenerBottomSheet{
        void refreh();
    }
}
