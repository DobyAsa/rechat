package com.example.Rechat;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class WeChatFragment extends Fragment {
    public WeChatFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private Context context;
    private List<String> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        context = this.getActivity();

            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            // Inflate the layout for this fragment
            return view;
        }

}