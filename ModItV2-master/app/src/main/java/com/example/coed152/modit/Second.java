package com.example.coed152.modit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewAnimator;
import android.widget.ZoomButton;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by coed152 on 10/1/18.
 */

public class Second extends Activity implements AdapterView.OnItemSelectedListener {

    ZoomButton zoom,zoom1;
    ImageView img;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button btn_share=(Button)findViewById(R.id.btn_share);
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(),Third.class);
                startActivity(intent1);
            }
        });
        ImageView image = (ImageView) findViewById(R.id.viewImage1);
        Intent intent = getIntent();
        String imagePath = intent.getStringExtra("imagePath");
        File f = new File(imagePath);
        Bundle bundle=this.getIntent().getExtras();
        String data=bundle.get("operation").toString();
        if(f.exists())
        {
            Drawable d = Drawable.createFromPath(imagePath);
            if (data.equals("0")) {
                image.setRotation((float) 90.0);
                image.setImageDrawable(d);
            }
            else if(data.equals("1"))
            {
                image.setRotation((float) -90.0);
                image.setImageDrawable(d);
            }
            else if(data.equals("2"))
            {
                image.setImageDrawable(d);
                zoom = (ZoomButton) findViewById(R.id.zoomButton1);
                zoom1 = (ZoomButton) findViewById(R.id.zoomButton2);

                img = (ImageView) findViewById(R.id.viewImage1);

                zoom.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        float x = img.getScaleX();
                        float y = img.getScaleY();

                        img.setScaleX(x+1);
                        img.setScaleY(y+1);
                    }
                });

                zoom1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float x = img.getScaleX();
                        float y = img.getScaleY();
                        if (img.getScaleX() > 1 && img.getScaleY() > 1) {
                            img.setScaleX(x - 1);
                            img.setScaleY(y - 1);
                        }
                    }
                });

            }

        }

        //t3.setText(data);


    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}