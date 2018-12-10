package com.example.admin.car_it;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        imageView = (imageView) findViewById(R.id.imageView);

        //Disable button if user has no Camera
        if (!hasCamera())
            button.setEnabled(false);


    }
    //Check if user has a Camera
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    //Launching the Camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Take an Image along to onActivityResult
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    //To return the image


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //Get the Picture
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            imageView.setImageBitmap(photo);
        }

    }



}

