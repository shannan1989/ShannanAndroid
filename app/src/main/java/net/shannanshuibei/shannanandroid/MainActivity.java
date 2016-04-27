package net.shannanshuibei.shannanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_tab_viewpager = (Button) findViewById(R.id.btn_tab_viewpager);
        btn_tab_viewpager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabViewpagerActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
