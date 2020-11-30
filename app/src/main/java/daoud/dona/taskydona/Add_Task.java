package daoud.dona.taskydona;
//1 xml
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Task extends AppCompatActivity {
    //2.
    protected EditText etTitle, etSubject, etDueDate;
    protected TextView tvImportant, tvNeccesary;
    protected SeekBar skbrNeccesary, skbrImportant;
    protected Button btnSaveTask, btnUpload, btnDatePicker;
    protected ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__task);
        etTitle = findViewById(R.id.etTitle);
        etSubject = findViewById(R.id.etSubject);
        etDueDate = findViewById(R.id.etDueDate);
        skbrImportant = findViewById(R.id.skbrImportant);
        skbrNeccesary = findViewById(R.id.skbrNeccesary);
        btnSaveTask = findViewById(R.id.btnSaveTask);
        imgBtn = findViewById(R.id.imgBtn);
        btnUpload = findViewById(R.id.btnUpload);
        tvImportant = findViewById(R.id.tvImportant);
        tvNeccesary = findViewById(R.id.tvNeccesary);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        //4. listeners
        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //5
    }
        public void validateForm () {
            String title = etTitle.getText().toString();
            String subject = etSubject.getText().toString();
            int imp = skbrImportant.getProgress();
            int nec = skbrNeccesary.getProgress();
            boolean isOk = true;
            if (title.length() == 0) {
                isOk = false;
                etTitle.setError("at least one char");
            }

            if (isOk) {
                //6. save on firebase
                //6.1 build your data object
                MyTask myTask = new MyTask();
                myTask.setTitle(title);
                myTask.setSub(subject);
                myTask.setNecessary(nec);
                myTask.setImportant(imp);
                //6.2
                saveTask(myTask);
            } }


    //6.3 دالة لحفظ البيانات في الغيمة (firebase database)
    private void saveTask(MyTask myTask) {

        //A.
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //B.
        DatabaseReference reference = database.getReference();
        //C.User id
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        //D. My Object key
        String key = reference.child("All Task").push().getKey();
        //E.
        myTask.setOwner(uid);
        myTask.setKey(key);
        //6 actual storing
        reference.child("AllTasls").child(uid).setValue(myTask).addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Add_Task.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Add_Task.this, "add failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }
}





