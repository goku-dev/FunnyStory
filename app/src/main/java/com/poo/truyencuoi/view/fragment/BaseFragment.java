package com.poo.truyencuoi.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poo.truyencuoi.view.event.OnCallBack;

public abstract class BaseFragment<C extends OnCallBack> extends Fragment implements View.OnClickListener {
    protected Context mContext;
    protected View rootView;
    protected C callBack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;

    }
    public void setOnCallBack(C event){
        callBack=event;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getByID(), container, false);
        initView();

        return rootView;

    }


    public  <T extends View> T findViewById(int id, View.OnClickListener event) {
        View view = rootView.findViewById(id);
        if (view != null && event != null) {
            view.setOnClickListener(event);
        }
        return (T) view;
    }

    public  <T extends View> T findViewById(int id) {
        return rootView.findViewById(id);
    }

    protected abstract void initView();

    protected abstract int getByID();

    @Override
    public void onDestroy() {
        mContext=null;
        rootView=null;
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        //do nothing
    }
}
