package vn.edu.stu.doandidong;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import vn.edu.stu.doandidong.khohang.DSKhoHang;
import vn.edu.stu.doandidong.model.KhoHang;
import vn.edu.stu.doandidong.model.SanPham;
import vn.edu.stu.doandidong.sanpham.DSSanPham;

public class MainActivityQL extends AppCompatActivity {

    public static List<SanPham> listSanPham = new ArrayList<>();
    public static List<KhoHang> listKhoHang = new ArrayList<>();
    private Button qlsp,qlkh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ql);

        qlsp = findViewById(R.id.qlsanpham);
        qlkh = findViewById(R.id.qlkhohang);

        creatData();

        qlsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityQL.this, DSSanPham.class);
                startActivity(intent);
            }
        });

        qlkh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityQL.this, DSKhoHang.class);
                startActivity(intent);
            }
        });
    }

    private void creatData(){

        listKhoHang.add(new KhoHang("Battle Royale"));
        listKhoHang.add(new KhoHang("Action"));
        listKhoHang.add(new KhoHang("Cartoon"));

        listSanPham.add(new SanPham(1,"Player Unknown BattleGround ",null, listKhoHang.get(0),"340.000","21 Dec 2017"));
        listSanPham.add(new SanPham(2,"Skul: The Hero Slayer",null, listKhoHang.get(1),"188.000","21 Jan 2021"));
        listSanPham.add(new SanPham(3,"CupHead",null, listKhoHang.get(2),"188.000","29 Sep, 2017"));
        listSanPham.add(new SanPham(4,"Ori and the Will of the Wips",null, listKhoHang.get(1),"250.000","11 Mar 2020"));
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
                Dialog dialog = new Dialog(MainActivityQL.this);
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