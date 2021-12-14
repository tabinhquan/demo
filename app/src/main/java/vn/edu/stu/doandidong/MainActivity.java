package vn.edu.stu.doandidong;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.btnDangNhap);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = username.getText().toString();
                String ps = password.getText().toString();
                if(us.equals("quan") && ps.equals("123")){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivityQL.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAbout:
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Thông tin cá nhân.");
                dialog.setContentView(R.layout.activity_dial);
                dialog.show();

                break;
            case R.id.menuExit:
                finish();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}