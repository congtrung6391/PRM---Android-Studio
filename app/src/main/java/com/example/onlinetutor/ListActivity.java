package com.example.onlinetutor;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ArrayList<Course> mCourses;
    private RecyclerView mRecyclerCourse;
    private CourseAdapter mCourseAdapter;
    private String filterType;
    private String filterName = null;
    private ArrayList<Course> initialCourses = new ArrayList<Course>();

    private Intent myCourseIntent;
    private Intent detailIntent;

    private void initData() {
        initialCourses.add(new Course("1", "Math level 1", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("2", "Math level 2", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("3", "Math level 3", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("4", "Math level 4", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("5", "Math level 5", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("6", "Math level 6", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("7", "Math level 7", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("8", "Math level 8", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("9", "Math level 9", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("10", "Math level 10", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("11", "Math level 11", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("12", "Math level 12", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("13", "Math level 13", "Basic math", new CourseType("math")));
        initialCourses.add(new Course("14", "English level 1", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("15", "English level 2", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("16", "English level 3", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("17", "English level 4", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("18", "English level 5", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("19", "English level 6", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("20", "English level 7", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("21", "English level 8", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("22", "English level 9", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("23", "English level 10", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("24", "English level 11", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("25", "English level 12", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("26", "English level 13", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("27", "English level 14", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("28", "English level 15", "Basic english", new CourseType("english")));
        initialCourses.add(new Course("29", "France level 1", "France math", new CourseType("france")));
        initialCourses.add(new Course("30", "France level 2", "France math", new CourseType("france")));
        initialCourses.add(new Course("31", "France level 3", "France math", new CourseType("france")));
        initialCourses.add(new Course("32", "France level 4", "France math", new CourseType("france")));
        initialCourses.add(new Course("33", "France level 5", "France math", new CourseType("france")));
        initialCourses.add(new Course("34", "France level 6", "France math", new CourseType("france")));
        initialCourses.add(new Course("35", "France level 7", "France math", new CourseType("france")));
        initialCourses.add(new Course("36", "France level 8", "France math", new CourseType("france")));
        initialCourses.add(new Course("37", "France level 9", "France math", new CourseType("france")));
        initialCourses.add(new Course("38", "France level 10", "France math", new CourseType("france")));
        initialCourses.add(new Course("39", "France level 11", "France math", new CourseType("france")));
        initialCourses.add(new Course("40", "France level 12", "France math", new CourseType("france")));
        initialCourses.add(new Course("41", "France level 13", "France math", new CourseType("france")));
        initialCourses.add(new Course("42", "France level 14", "France math", new CourseType("france")));
        initialCourses.add(new Course("42", "France level 15", "France math", new CourseType("france")));
        initialCourses.add(new Course("44", "France level 16", "France math", new CourseType("france")));
        initialCourses.add(new Course("45", "France level 17", "France math", new CourseType("france")));
        initialCourses.add(new Course("46", "France level 18", "France math", new CourseType("france")));
        initialCourses.add(new Course("47", "France level 19", "France math", new CourseType("france")));
        initialCourses.add(new Course("48", "France level 20", "France math", new CourseType("france")));
        initialCourses.add(new Course("49", "France level 21", "France math", new CourseType("france")));
        initialCourses.add(new Course("50", "Physic level 1", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("51", "Physic level 2", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("52", "Physic level 3", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("53", "Physic level 4", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("54", "Physic level 5", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("55", "Physic level 6", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("56", "Physic level 7", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("57", "Physic level 8", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("58", "Physic level 9", "Physic math", new CourseType("physic")));
        initialCourses.add(new Course("59", "Physic level 10", "Physic math", new CourseType("physic")));
    }

    private void setupIntent() {
        myCourseIntent = new Intent(ListActivity.this, MyCourseActivity.class);
        detailIntent = new Intent(ListActivity.this, DetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initData();
        setupIntent();

        handleIntent(getIntent());

        mRecyclerCourse = findViewById(R.id.recycler_list);
        registerForContextMenu(mRecyclerCourse);

        mCourses = new ArrayList<Course>();
        createHeroList(filterType, filterName);

        mCourseAdapter = new CourseAdapter(this, mCourses);

        mRecyclerCourse.setAdapter(mCourseAdapter);
        mRecyclerCourse.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String courseId = String.valueOf(item.getGroupId());
        switch (item.getItemId()) {
            case R.id.add_course:
                addCourse(courseId);
                break;
            case R.id.view_course:
                openDetail(courseId);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_activity_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search_course_name).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.my_course:
                openMyCourse();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            filterName = query;
        }
        filterType = intent.getStringExtra("class_type");
    }

    private void createHeroList(String type, String filter) {
        for (Course course : initialCourses) {
            if ((type == null || (type != null && course.getCourseType().getTypeName().equals(type)))
                && (filter == null || (filter != null && course.getCourseName().contains(filter)))) {
                mCourses.add(course);
            }
        }
    }

    private void openMyCourse() {
        startActivity(myCourseIntent);
    }

    private void openDetail(String id) {
        detailIntent.putExtra("course_id", id);
        detailIntent.putExtra("course_name", id);
        startActivity(detailIntent);
    }

    private void addCourse(String id) {
        Toast.makeText(ListActivity.this, "Course is added", Toast.LENGTH_LONG).show();
    }
}