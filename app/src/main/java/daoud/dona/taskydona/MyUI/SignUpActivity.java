package daoud.dona.taskydona.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import daoud.dona.taskydona.R;

public class SignUpActivity extends AppCompatActivity {

    // 1. XML Design
    //2. Ta3reef al Items

    private EditText etFirstName, etLastName, etPhone, etEmail, etPassword1, etPassword2;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 3. Find view bu Id
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPassword1 = findViewById(R.id.etPassword1);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSave = findViewById(R.id.btnSave);
    }


    private void checkForm()
    /**
     * the method checks if the (index) data is true and comfirmed
     */
    {
        String fName = etFirstName.getText().toString();
        String lName = etLastName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String pass1 = etPassword1.getText().toString();
        String pass2 = etPassword2.getText().toString();
        String saveBtn = btnSave.getText().toString();
        boolean isOK= true;
        if(fName.length()<2)
        {
            isOK=false;
            etFirstName.setError("At least two letters");
        }
        if (email.length()<5||(email.indexOf('@')==0)||email.indexOf('@')>=email.length()-2|| email.indexOf('.')==0
        ||email.indexOf('.')>=email.length()-1||email.indexOf('.')<email.indexOf('@'))
        {
            isOK=false;
            etEmail.setError("Wrong E-mail Adress. Try Again!");
        }



    }
}




