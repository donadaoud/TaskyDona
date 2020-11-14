package daoud.dona.taskydona.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import daoud.dona.taskydona.MyUtils.MyValidations;
import daoud.dona.taskydona.R;
//1 xml
public class logInActivity extends AppCompatActivity {
    //2 ta3reef
    private EditText edEmail,edPassWord;
    private Button btnLogIn,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //3
        edEmail=findViewById(R.id.edEmail);
        edPassWord=findViewById(R.id.edPassWord);
        btnLogIn=findViewById(R.id.btnLogIn);
        btnSignUp=findViewById(R.id.btnSignUp);
        //4
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5
                validateForm();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(logInActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }
    //5
    private void validateForm(){
        //1
        String email=edEmail.getText().toString();
        String passw=edPassWord.getText().toString();
        //2
        boolean isOk=true;
        //3
        if (email.length()<5 || email.indexOf('@')==0 || email.indexOf('@')>=email.length()-2 ||
                email.indexOf('.') == 0 || email.indexOf('.') > email.length() - 1 || email.lastIndexOf('.') < email.indexOf('@')) {
            isOk = false;
            edEmail.setError("Wrong Email Address Please Rewrite");
        }
        //4
        MyValidations myValidations = new MyValidations();
        if (myValidations.validatePasword(passw) == false) {
            isOk = false;
            edPassWord.setError("Invalid Password!");
        }
        //5
        if (isOk){
            logIn(email,passw);
        }
    }
    private void logIn(String email,String passw){
        //5
        FirebaseAuth auth=FirebaseAuth.getInstance();
        //6
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //7
                if(task.isSuccessful()){
                    //8
                    Intent i=new Intent(logInActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else {
                    //9
                    Toast.makeText(logInActivity.this,"Faild",Toast.LENGTH_SHORT).show();
                    edEmail.setError(task.getException().getMessage());
                }
            }
        });
    }


    }
