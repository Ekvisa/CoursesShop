package com.ekvisa.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ekvisa.e_commerce.adapter.CategoryAdapter;
import com.ekvisa.e_commerce.adapter.CourseAdapter;
import com.ekvisa.e_commerce.model.Category;
import com.ekvisa.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);


        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "1 пьянваря", "начальный", "#424345",
                "Вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!", 3));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "10 усабря", "начальный", "#00b0b0",
                "Идейные соображения высшего порядка, а также укрепление и развитие структуры представляет собой интересный эксперимент проверки направлений прогрессивного развития.", 3));
        courseList.add(new Course(3, "android", "Профессия Android\nразработчик", "3 февраля", "продвинутый", "#a4c639",
                "Укрепление и развитие структуры в значительной степени обуславливает создание существенных финансовых и административных условий.", 3));
        courseList.add(new Course(4, "php", "Профессия PHP\nразработчик", "29 февраля", "начальный", "#7d5393",
                "Зачастую у пользователей нет доступа к HTML-тегам – именно здесь такой генератор может пригодиться.", 3));
        courseList.add(new Course(5, "unity", "Профессия Unity\nразработчик", "1 котября", "начальный", "#666666",
                "Как бы там ни было, но в этом году версии Windows 95 OSR2 исполнилось 25 лет", 1));
        courseList.add(new Course(6, "front", "Профессия Frontend\nразработчик", "20 инктября", "начальный", "#927a29",
                "Товарищи! постоянное информационно-пропагандистское обеспечение нашей деятельности способствует реализации соответствующий условий активизации.",2));
        courseList.add(new Course(7, "back", "Профессия Backend\nразработчик", "1 апреля", "средний", "#cd3c45",
                "Если вы любите попивать смузи сидя в коворкинге, обсуждая новый стартап под 8-битную версию диско 80-х, этот генератор Lorem Ipsum именно для вас.", 2));
        courseList.add(new Course(8, "fullstack", "Профессия Fullstack\nразработчик", "15 небриября", "продвинутый", "#e0672e",
                "Покраснение объектов обычно не воспринимается как нечто, отражающее их удаление.", 2));
        courseList.add(new Course(9, "figma", "Адаптивный дизайн\nв Figma", "1 дикабря", "средний", "#333333",
                "Большую волну негодования вызывают слова-паразиты и речевые штампы, которые типа вроде как призваны упростить общение. Стань специалистом по дизайну!", 4));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category) {

        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c: courseList) {
            if (c.getCategory() == category)
                filterCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();

    }
}