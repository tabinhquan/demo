package vn.edu.stu.doandidong.khohang;

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

import vn.edu.stu.doandidong.MainActivityQL;
import vn.edu.stu.doandidong.R;
import vn.edu.stu.doandidong.model.KhoHang;

public class KhoHangActivity extends AppCompatActivity {

    private EditText ma,ten;
    private Button them,sua,xoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kho_hang);

        ma = findViewById(R.id.maKhoHang);
        ten = findViewById(R.id.tenKhoHang);
        them = findViewById(R.id.them);
        sua = findViewById(R.id.sua);
        xoa = findViewById(R.id.xoa);

        Intent intent = getIntent();
        int position = intent.getIntExtra("vitri",0);
        KhoHang loai = MainActivityQL.listKhoHang.get(position);
        showThongTin(loai);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String makh = ten.getText().toString();
                MainActivityQL.listKhoHang.add(new KhoHang(makh));
                Toast.makeText(KhoHangActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loai.setTenkhohang(ten.getText().toString());
                MainActivityQL.listKhoHang.set(position,loai);
                Toast.makeText(KhoHangActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityQL.listKhoHang.remove(position);
                finish();
            }
        });
    }

    private void showThongTin(KhoHang khohang){
        ma.setText(khohang.getMa().toString());
        ten.setText(khohang.getTenKhoHang());
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
                Dialog dialog = new Dialog(KhoHangActivity.this);
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