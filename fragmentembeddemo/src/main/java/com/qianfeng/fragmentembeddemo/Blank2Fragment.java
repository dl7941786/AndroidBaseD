package com.qianfeng.fragmentembeddemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Blank2Fragment extends Fragment implements View.OnClickListener {


    private Button button;
    private InnerFragment innerFragment = new InnerFragment();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        //getChildFragmentManager(),用于管理 fragment 内部嵌套 fragment的 manager
        button = ((Button) view.findViewById(R.id.add));
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (!innerFragment.isAdded()) {
            getChildFragmentManager().beginTransaction().add(R.id.container,innerFragment).commit();
        }

    }
}
