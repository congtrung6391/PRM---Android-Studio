package com.example.onlinetutor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.item_name);
            descriptionTextView = itemView.findViewById(R.id.item_description);
        }
    }

    private Context mContext;
    private ArrayList<Course> mCourses;

    public CourseAdapter(Context mContext, ArrayList<Course> mCourses) {
        this.mContext = mContext;
        this.mCourses = mCourses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.list_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course course = mCourses.get(position);
        holder.nameTextView.setText(course.getCourseName());
        holder.descriptionTextView.setText(course.getCourseDescription());
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }
}