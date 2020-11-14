package daoud.dona.taskydona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

//1 xml
public class itemTaskView extends AppCompatActivity {
    //2
    private TextView itmTvTittle, itmTvSubject, itmTvImportant, itmTvNecessary;
    private ImageButton imgBtnDelete, imgBtnEdit, imgBtnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_task_view);
        //3
        itmTvTittle = findViewById(R.id.itmTvTittle);
        itmTvSubject = findViewById(R.id.itmTvSubject);
        itmTvImportant = findViewById(R.id.itmTvImportant);
        itmTvNecessary = findViewById(R.id.itmTvNecessary);
        imgBtnDelete = findViewById(R.id.imgBtnDelete);
        imgBtnEdit = findViewById(R.id.imgBtnEdit);
        imgBtnCall = findViewById(R.id.imgBtnCall);


    }
}


