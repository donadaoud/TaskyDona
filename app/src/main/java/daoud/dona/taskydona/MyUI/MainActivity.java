package daoud.dona.taskydona.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import daoud.dona.taskydona.Data.MyTaskAdapter;
import daoud.dona.taskydona.R;
//1
public class MainActivity extends AppCompatActivity {
    private ImageButton btnAdd;
    //1 after building the arry adapter
    ListView lstTask;
    //adapter
    MyTaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=findViewById(R.id.btnAdd);
        //LISTNER
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Add_Task.class);
                startActivity(i);
            }
        });
        //3.
        lstTask=findViewById(R.id.lstTask);
        //4.
        taskAdapter=new MyTaskAdapter(getBaseContext(),R.layout.activity_item_task_view);
        //5. connect listview to the adaptor
        lstTask.setAdapter(taskAdapter);
        //7
        downloadFromFireBase();
    }
    //6.
    public void downloadFromFireBase(){
        //where we saved before we need to contact to download
        //1.
        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        //2.
        DatabaseReference reference= database.getReference();
        //3. user id
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();
        //4.
        reference.child("All Task").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

}