package com.qianfeng.fragmentembeddemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {

    private Button button;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        button = ((Button) view.findViewById(R.id.startblank2));
        button.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        //跳转到 blank2   getActivity获取装载这个 fragment的 activity
//        Toast.makeText(getActivity(), "要跳转", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "要跳转", Toast.LENGTH_SHORT).show();
//        ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container,new Blank2Fragment()).commit();
        // getFragmentManager 获取的是谁管理的我,我就获取谁,获取父级管理者,这个只能管理与当前 fragment 同级的 fragment
        getFragmentManager().beginTransaction().replace(R.id.container, new Blank2Fragment()).commit();
    }
}
