package com.example.launch;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview_apps);

        PackageManager packageManager = getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> appList = packageManager.queryIntentActivities(mainIntent, 0);
        List<AppModel> apps = new ArrayList<>();
        for (ResolveInfo info : appList) {
            String appName = info.loadLabel(packageManager).toString();
            Drawable appIcon = info.loadIcon(packageManager);
            apps.add(new AppModel(info.activityInfo.applicationInfo, packageManager));
        }
        AppAdapter adapter = new AppAdapter(this, R.layout.item_lista, apps);
        listView.setAdapter(adapter);
    }

}