package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL=1;
    TextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDesc = findViewById(R.id.txtDesc);
        txtDesc.setMovementMethod(new ScrollingMovementMethod());
    }

    public void alamat(View v){
        //implicit intent
        Uri map = Uri.parse("https://www.google.com/maps/place/Universitas+Dian+Nuswantoro/@-6.9826317,110.4070121,17z/data=!3m1!4b1!4m5!3m4!1s0x2e708b4ec52229d7:0xc791d6abc9236c7!8m2!3d-6.9826317!4d110.4092008");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,map);

        startActivity(mapIntent);
    }

    public void email(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jan@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));

        startActivity(emailIntent);
    }

    public void telp(View v){
        Uri number = Uri.parse("tel:88889999123");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        startActivity(callIntent);

    }


}