package daoud.dona.taskydona.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import daoud.dona.taskydona.R;
//1
public class MainActivity extends AppCompatActivity {
    private ImageButton btnAdd;
    //1 after building the aaray adapter
    ListView lstTask;
    // adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=findViewById(R.id.btnAdd);

    }
}