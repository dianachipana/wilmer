package mx.unac.ipd2;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;


public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    Button eyeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.Username);
        password=(EditText) findViewById(R.id.password);
        loginButton=(Button) findViewById(R.id.loginButton);
        eyeButton=(Button) findViewById(R.id.eyeButton);
    }
 public Connection conexionBD() {
     Connection conexion = null;
     try {
         StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
         StrictMode.setThreadPolicy(policy);
         Class.forName("net.sourceforge.jtdc.jdbc.Driver");
         conexion= DriverManager.getConnection("jdbc:jtds:sqlserver://190.237.183.229:1433/IPD;user=empresa;password=admin");
     } catch (Exception e) {
         Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

     }
     return conexion;
 }

}
