package sg.edu.rp.id19037610.firebasestudentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class AddStudentActivity extends AppCompatActivity {

    private static final String TAG = "AddStudentActivity";

    private EditText etName, etAge;
    private Button btnAdd;

    // TODO: Task 1 - Declare Firebase variables
    private FirebaseFirestore db;
    private CollectionReference colRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etName = (EditText) findViewById(R.id.editTextName);
        etAge = (EditText) findViewById(R.id.editTextAge);
        btnAdd = (Button) findViewById(R.id.buttonAdd);


        // TODO: Task 2: Get FirebaseFirestore instance and collection reference to "students"
        db = FirebaseFirestore.getInstance();
        colRef = db.collection("students");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: Task 3: Retrieve name and age from EditText and instantiate a new Student object
                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
                Student student = new Student(name, age);

                //TODO: Task 4: Add student to database and go back to main screen
                colRef.add(student);

                finish();

            }
        });


    }
}
