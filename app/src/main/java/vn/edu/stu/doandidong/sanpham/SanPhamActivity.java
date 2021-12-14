package vn.edu.stu.doandidong.sanpham;

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
import vn.edu.stu.doandidong.model.SanPham;

public class SanPhamActivity extends AppCompatActivity {

    private EditText ma,ten,loai,gia, ngayphathanh;
    private Button them,sua,xoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);

        ma = findViewById(R.id.masanpham);
        ten = findViewById(R.id.tensanpham);
        loai = findViewById(R.id.loaisanpham);
        gia = findViewById(R.id.gia);
        ngayphathanh = findViewById(R.id.ngayphathanh);
        them = findViewById(R.id.them);
        sua = findViewById(R.id.sua);
        xoa = findViewById(R.id.xoa);


        Intent intent = getIntent();
        int position = intent.getIntExtra("vitri",0);
        SanPham sanpham = MainActivityQL.listSanPham.get(position);
        showThongTin(sanpham);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer idsp = Integer.parseInt(ma.getText().toString());
                String tensp = ten.getText().toString();
                KhoHang kh = null;
                boolean ck = false;
                for(int i = 0;i<MainActivityQL.listKhoHang.size();i++){
                    KhoHang loaisanpham = MainActivityQL.listKhoHang.get(i);
                    if (loaisanpham.getTenKhoHang().equals(loai.getText().toString())){
                        kh = loaisanpham;
                        ck = true;
                        break;
                    }
                }
                if(!ck){
                    kh = new KhoHang(loai.getText().toString());
                    MainActivityQL.listKhoHang.add(kh);
                }
                String giasp = gia.getText().toString();
                String  ngayphathanhsp = ngayphathanh.getText().toString();
                MainActivityQL.listSanPham.add(new SanPham(idsp, tensp,null, kh,giasp,ngayphathanhsp));
                Toast.makeText(SanPhamActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanpham.setTen(ten.getText().toString());
                boolean ck = false;
                for(int i = 0;i<MainActivityQL.listKhoHang.size();i++){
                    KhoHang loaisanpham = MainActivityQL.listKhoHang.get(i);
                    if (loaisanpham.getTenKhoHang().equals(loaisanpham.getTenKhoHang().toString())){
                        sanpham.setKhohang(loaisanpham);
                        ck = true;
                        break;
                    }
                }
                if(!ck){
                    KhoHang kh = new KhoHang(loai.getText().toString());
                    MainActivityQL.listKhoHang.add(kh);
                    sanpham.setKhohang(kh);
                }
                sanpham.setGia(gia.getText().toString());
                sanpham.setNgayphathanh(ngayphathanh.getText().toString());
                MainActivityQL.listSanPham.set(position, sanpham);
                Toast.makeText(SanPhamActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityQL.listSanPham.remove(position);
                finish();
            }
        });
    }

    private void showThongTin(SanPham sanPham){
        ma.setText(sanPham.getId().toString());
        ten.setText(sanPham.getTen());
        loai.setText(sanPham.getKhohang().getTenKhoHang());
        gia.setText(sanPham.getGia());
        ngayphathanh.setText(sanPham.getNgayphathanh());
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
                Dialog dialog = new Dialog(SanPhamActivity.this);
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