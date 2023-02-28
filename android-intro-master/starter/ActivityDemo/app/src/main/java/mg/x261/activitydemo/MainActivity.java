package mg.x261.activitydemo;

import static java.lang.Class.forName;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView activityListView;

    private String[] activityNames = {"ActivityCheckbox", "ActivityDatePicker", "ActivityDatePickerDialog",
            "ActivityListView", "ActivityProgressBar", "ActivityRadioButton", "ActivityRating",
            "ActivityRunnableThreadHandler", "ActivityScrollView", "ActivitySpinner", "ActivitySwitch",
            "ActivityTimePicker", "LoadImage", "MainButton", "MainCalendarView", "MainDialog",
            "MainEditText", "MainImageView", "MainLinearLayout", "MainRelativeLayout", "MainSeekBar",
            "MainTable", "MainTextView", "MainToast"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1: Find the activity list view in the layout by id (R.id.activity_list_view).
        ListView myListView = findViewById(R.id.activity_list_view);
        // TODO 2: Create an array adapter with the activity names and the layout for the item view.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                activityNames);
        // TODO 3: Set the adapter to the activity list view.
        myListView.setAdapter(adapter);
        // TODO 4:
        //   Set an item click listener for the activity list view.
        //   In the listener, use a switch statement to start the corresponding activity based on the name of the clicked item.
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the text of the clicked item
                String itemText = parent.getItemAtPosition(position).toString();

                // Show a Toast with the text of the clicked item
                Toast.makeText(MainActivity.this, itemText, Toast.LENGTH_SHORT).show();

                String classText = "mg.x261.activitydemo." + itemText;

                try {
                    startActivity(new Intent(MainActivity.this, forName(classText)));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }
}