package com.ermile.jibresapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    public static BottomSheetFragment newInstance() {
        BottomSheetFragment fragment = new BottomSheetFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public void setupDialog(Dialog dialog, int style) {
//        View contentView = View.inflate(getContext(), R.layout.activity_bottom_sheet, null);
//        dialog.setContentView(contentView);
//        ((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
//    }

    listenerBottomSheet mListener;

    public void setListener(listenerBottomSheet listener) {
        mListener = listener;
    }

    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_bottom_sheet, container, false);
        view.findViewById(R.id.mammad).setOnClickListener(view1 -> mListener.refresh());
        view.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        return view;

    }

    public interface listenerBottomSheet{
        void refresh();
    }
}