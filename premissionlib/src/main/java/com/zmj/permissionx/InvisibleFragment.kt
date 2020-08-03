package com.zmj.permissionx

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/3-
 * Description :
 */

typealias PermissionCallback = (Boolean,List<String>) -> Unit

class InvisibleFragment : Fragment() {

    /**
     * 定义一个回调
     * Boolen表示是否全部获取权限
     * List<String>表示拒绝得权限列表
     */
    private var callback: PermissionCallback? = null

    fun requestNow(cb:PermissionCallback,vararg permissions: String){
        callback = cb
        requestPermissions(permissions,1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == 1){
            val deniedList = ArrayList<String>()
            for ((index,result) in grantResults.withIndex()){
                if (result != PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val allGranted = deniedList.isEmpty()
            callback?.let { it(allGranted,deniedList) }
        }
    }
}