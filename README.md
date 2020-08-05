# PermissionX

A light and easy way to request Android runtime permission

Use this down way add to your project

```groovy
dependencies {
    ...
    implementation 'com.zmj:premissionlib:1.0.0'
}
```

Then request permission by this :

```kotlin
PermissionX.request(this,Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE){allGranted,deniedList ->
    if (allGranted){
        //doSomeThing
    }else{
        Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
    }
}
```
