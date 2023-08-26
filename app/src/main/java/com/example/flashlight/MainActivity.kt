package com.example.flashlight

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onButton = findViewById<Button>(R.id.flash_on_btn)
        val offButton = findViewById<Button>(R.id.flash_off_btn)


        onButton.setOnClickListener {
            onFlash()

        }

        offButton.setOnClickListener {
            offFlash()
        }
    }
    private fun  onFlash(){
        var cameraManager : CameraManager? = null
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

        try{
            var cameraId: String? = null
            cameraId = cameraManager.cameraIdList[0]
            cameraManager!!.setTorchMode(cameraId,true)
            Toast.makeText(this,"Flash ON",Toast.LENGTH_SHORT).show()

        }catch (e : CameraAccessException){
        //    Toast.makeText(this,"Exception: "+e.message).show()

        }
    }

    private fun offFlash(){
        val cameraManage =  getSystemService(CAMERA_SERVICE) as CameraManager

        try{
            val cameraId = cameraManage.cameraIdList[0]
            cameraManage.setTorchMode(cameraId,false)
            Toast.makeText(this,"Flash OFF",Toast.LENGTH_SHORT).show()

        }catch (e: CameraAccessException){

        }
    }
}