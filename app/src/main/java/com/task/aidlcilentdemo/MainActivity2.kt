package com.task.aidlcilentdemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import com.task.aidlservicedemo.IAIDLColorInterface

class MainActivity2 : AppCompatActivity() {
    var iAIDLColorService: IAIDLColorInterface?= null

    val mConnection =object:ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            iAIDLColorService=IAIDLColorInterface.Stub.asInterface(p1)
            Log.e(" service connection","service connection $p1 $iAIDLColorService")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button= findViewById<Button>(R.id.button)
        button.setOnClickListener {
            var color=iAIDLColorService?.color
            Log.e("color","color name ${iAIDLColorService?.color}")
            if (color != null) {
                it.setBackgroundColor(color)
            }
        }
    }


    override fun onStart() {
        super.onStart()
        var intent= Intent("com.task.aidlservicedemo.AIDLColorService")
        intent.setPackage("com.task.aidlservicedemo")
        bindService(intent,mConnection,Context.BIND_AUTO_CREATE)
    }
    override fun onStop() {
        super.onStop()
        unbindService(mConnection)
    }
}