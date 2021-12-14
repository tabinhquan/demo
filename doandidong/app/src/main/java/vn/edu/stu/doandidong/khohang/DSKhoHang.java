package vn.edu.stu.doandidong.khohang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import vn.edu.stu.doandidong.MainActivityQL;
import vn.edu.stu.doandidong.R;

public class DSKhoHang extends AppCompatActivity {
    private ListView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dskho_hang);

        recyclerView = findViewById(R.id.dsKhoHang);

        showDanhSach();
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DSKhoHang.this, KhoHangActivity.class);
                intent.putExtra("vitri",position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showDanhSach();
    }

    public void showDanhSach(){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivityQL.listKhoHang);
        recyclerView.setAdapter(adapter);

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
                Dialog dialog = new Dialog(DSKhoHang.this);
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