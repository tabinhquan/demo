package vn.edu.stu.doandidong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class dial extends AppCompatActivity {

    TextView sdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        sdt=findViewById(R.id.sdt);
        Uri number = Uri.parse(String.valueOf(sdt));

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(number);
        startActivity(intent);
    }
}