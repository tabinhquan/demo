package vn.edu.stu.doandidong.sanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import vn.edu.stu.doandidong.MainActivityQL;
import vn.edu.stu.doandidong.R;

public class DSSanPham extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SanPhamAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssan_pham);

        recyclerView = findViewById(R.id.dsSanPham);

        showDanhSach();


    }

    @Override
    protected void onResume() {
        super.onResume();
        showDanhSach();
    }

    private void showDanhSach(){
        adapter = new SanPhamAdapter(this, MainActivityQL.listSanPham);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
                Dialog dialog = new Dialog(DSSanPham.this);
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