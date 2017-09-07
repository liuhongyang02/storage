package com.example.liuhongyang.storage;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button buttonWrite;
    Button buttonRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String FILE_NAME = "fileDemo.txt";
        buttonWrite = (Button)findViewById(R.id.button1);
        buttonRead = (Button)findViewById(R.id.button2);
        buttonWrite.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                OutputStream out = null;
                try
                {
                    FileOutputStream fileOutputStream = openFileOutput(FILE_NAME,MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);

                    String content = "刘红杨";
                    try
                    {
                        out.write(content.getBytes("UTF-8"));
                    }finally {
                        if(out!=null)
                            out.close();
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                InputStream in = null;
                try
                {
                    FileInputStream fileInputStream = openFileInput(FILE_NAME);
                    in = new BufferedInputStream(fileInputStream);
                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try
                    {
                        while ((c=in.read())!=-1)
                        {
                            stringBuilder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_LONG).show();

                    }finally {
                        if(in!=null)
                            in.close();
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            }

        });


    }
}
