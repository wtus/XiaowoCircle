package com.example.wuht.xiaowocircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;
    private XiaoWoCircle dsfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        btn_add = (Button) findViewById(R.id.btn_add);
        dsfa = (XiaoWoCircle) findViewById(R.id.dsa);

        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                dsfa.setM();
                break;
        }
    }
}
