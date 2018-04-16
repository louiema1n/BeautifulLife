package com.bf.lm.beautifullife.pager

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bf.lm.beautifullife.R
import com.bf.lm.beautifullife.base.BasePager

class SportPager : BasePager {

    constructor(context: Context) : super(context)
    var tvSteps = TextView(context)

    override fun initView(): View {
        var view = View.inflate(context, R.layout.pager_sport, null)
        tvSteps = view.findViewById(R.id.tv_steps) as TextView
        tvSteps.text = "6666"
        initData()
        return view
    }


    override fun initData() {
        super.initData()
        // 获取传感器系统服务
        val sensorManager: SensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager
        // 获取计步总数传感器
        val sensorCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        // 获取传感器事件监听器

        if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER)) {
            // 支持计步
            // 注册传感器事件监听器
            sensorManager.registerListener(MySensorEventListener(), sensorCounter, SensorManager.SENSOR_DELAY_FASTEST)
        } else {
            Toast.makeText(context, "您的手机不支持计步", Toast.LENGTH_SHORT).show()
        }
    }

    inner class MySensorEventListener : SensorEventListener {

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

        }

        override fun onSensorChanged(event: SensorEvent?) {
            Toast.makeText(context, this@SportPager.tvSteps.text, Toast.LENGTH_SHORT).show()
        }
    }
}