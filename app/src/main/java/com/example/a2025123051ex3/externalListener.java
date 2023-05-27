package com.example.a2025123051ex3;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class externalListener implements View.OnClickListener {
    TextView show;
    public externalListener(TextView show){
        this.show = show;
    }


    @Override
    public void onClick(View view) {
    show.setText("这是外部类作为监听器");

    }
}
