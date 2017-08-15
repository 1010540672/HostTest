package com.hosttest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class MyhostActivity extends Activity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhost);
        loadPlugin(this);
        mButton=(Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("OOOOOOOOO",",,,,,,,,,,,,,,,,,,,,,,,,,,,,");

               doPlugin();
            }
        });
    }


    private  void doPlugin(){
        //com.plugintest

        final String pkg = "com.plugintest";
        if (PluginManager.getInstance(this).getLoadedPlugin(pkg) == null) {
            Toast.makeText(this, "plugin [com.plugintest] not loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(MyhostActivity.this,"插件加载成功",0).show();

//        final String pkg = "com.didi.virtualapk.demo";
//        if (PluginManager.getInstance(this).getLoadedPlugin(pkg) == null) {
//            Toast.makeText(this, "plugin [com.didi.virtualapk.demo] not loaded", Toast.LENGTH_SHORT).show();
//            return;
//        }

//        String pluginPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/app-debug.apk");
//        File plugin = new File(pluginPath);
//        try {
//            PluginManager.getInstance(this).loadPlugin(plugin);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

// Given "com.didi.virtualapk.demo" is the package name of plugin APK,
// and there is an activity called `MainActivity`.
        Intent intent = new Intent();

       intent.setClassName(pkg, "com.plugintest.MyActivity");
       startActivity(intent);



    }



    private void loadPlugin(Context base) {
        PluginManager pluginManager = PluginManager.getInstance(base);
        File apk = new File(Environment.getExternalStorageDirectory(), "Yqq123.apk");
        if (apk.exists()) {
            try {
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
