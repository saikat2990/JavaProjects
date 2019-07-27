package com.example.asus.adddataindatabase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//import com.example.AddDataInDatabase.R;

public class Register extends Activity {

    EditText ET_NAME,ET_USER_NAME,ET_USER_PASS;
    String name,user_name,user_pass;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
       setContentView(R.layout.login_xml);
       ET_NAME = (EditText)findViewById(R.id.name);
       ET_USER_NAME=(EditText)findViewById(R.id.user_name);
       ET_USER_PASS=(EditText)findViewById(R.id.user_pass);

    }
    public void userReg(View view){

        name = ET_NAME.getText().toString();
        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        String method  = "register";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,user_name,user_pass);
        finish();

    }

}
