package com.example.launch;


import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
public class AppModel {
    private final ApplicationInfo applicationInfo;
    private final PackageManager packageManager;
    public AppModel(ApplicationInfo applicationInfo, PackageManager packageManager) {
        this.applicationInfo = applicationInfo;
        this.packageManager = packageManager;
    }
    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }
    public String getAppName() {
        return applicationInfo.loadLabel(packageManager).toString();
    }
    public Drawable getAppIcon() {
        return applicationInfo.loadIcon(packageManager);
    }
}