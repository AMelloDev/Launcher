package com.example.launch;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class AppAdapter extends ArrayAdapter<AppModel> {

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<AppModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_lista, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textViewAppName = convertView.findViewById(R.id.app_name);
            viewHolder.imageViewAppIcon = convertView.findViewById(R.id.app_icon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        AppModel app = getItem(position);
        if (app != null) {
            viewHolder.textViewAppName.setText(app.getAppName());
            viewHolder.imageViewAppIcon.setImageDrawable(app.getAppIcon());
        }

        return convertView;
    }

    static class ViewHolder {
        TextView textViewAppName;
        ImageView imageViewAppIcon;
    }
}