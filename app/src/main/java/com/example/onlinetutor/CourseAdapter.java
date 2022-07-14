package com.example.onlinetutor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinetutor.dao.CourseDAO;
import com.example.onlinetutor.objects.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private CourseDAO courseDAO;
    private Context mContext;
    private ArrayList<Course> mCourses;
    private int position;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener  {
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageButton editButton;
        private ImageButton deleteButton;
        public String courseId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.item_name);
            descriptionTextView = itemView.findViewById(R.id.item_description);
            editButton = itemView.findViewById((R.id.item_edit_course_button));
            deleteButton = itemView.findViewById(R.id.item_delete_course_button);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(Menu.NONE, R.id.add_course, 0, R.string.add_course);
            menu.add(Menu.NONE, R.id.view_course, 10, R.string.view_course);
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

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
        holder.courseId = course.getId();
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(holder.getPosition());
                return false;
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseDAO = new CourseDAO(mContext);
                if(courseDAO.delete(course.getId())){
                    Toast.makeText(mContext,"xoa thanh cong", Toast.LENGTH_LONG).show();
                    // cập nhật dữ liệu cho list
                    mCourses.remove(course);
                    notifyDataSetChanged();
                }
                else{
                    Toast.makeText(mContext,"xoa khong thanh cong", Toast.LENGTH_LONG).show();
                }
            }
        });
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AddEditCourse.class);
                intent.putExtra("id", course.getId());
                intent.putExtra("name", course.getCourseName());
                intent.putExtra("des", course.getCourseDescription());
                intent.putExtra("type", course.getCourseType());
                intent.putExtra("is_new", "false");
                ((Activity)mContext).startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }
}