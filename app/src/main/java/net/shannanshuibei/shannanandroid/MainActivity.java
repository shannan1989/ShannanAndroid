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

        Button btn_tab_fragment = (Button) findViewById(R.id.btn_tab_fragment);
        btn_tab_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabFragmentActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button btn_flip_card = (Button) findViewById(R.id.btn_flip_card);
        btn_flip_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FlipCardActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button btn_widgets_demo = (Button) findViewById(R.id.btn_widgets_demo);
        btn_widgets_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WidgetsDemoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
