package com.bf.lm.beautifullife.pager

import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bf.lm.beautifullife.R

class SportPager: AppCompatActivity {

    constructor() : super()
    private var tvSteps = TextView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        var view = View.inflate(this, R.layout.pager_sport, null)
        tvSteps = view.findViewById(R.id.tv_steps) as TextView
        initData()
    }

    private fun initData() {
        // 获取传感器系统服务
        val sensorManager: SensorManager = this.getSystemService(SENSOR_SERVICE) as SensorManager
        // 获取计步总数传感器
        val sensorCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        // 获取传感器事件监听器

        if (this.packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER)) {
            // 支持计步
            // 注册传感器事件监听器
            sensorManager.registerListener(MySensorEventListener(), sensorCounter, SensorManager.SENSOR_DELAY_FASTEST)
        } else {
            Toast.makeText(this, "您的手机不支持计步", Toast.LENGTH_SHORT).show()
        }
    }

    inner class MySensorEventListener : SensorEventListener {

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

        }

        override fun onSensorChanged(event: SensorEvent?) {
         this@SportPager.tvSteps.text = event?.values?.get(0).toString()
        }

    }
}