package vn.edu.stu.doandidong.sanpham;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.stu.doandidong.MainActivityQL;
import vn.edu.stu.doandidong.R;
import vn.edu.stu.doandidong.model.SanPham;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHoldel>{
    private Context context;
    private List<SanPham> listSanPham;

    public SanPhamAdapter(Context context, List<SanPham> listSanPham) {
        this.context = context;
        this.listSanPham = listSanPham;
    }

    @NonNull
    @Override
    public ViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sanphamitem,parent,false);
        return new ViewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldel holder, @SuppressLint("RecyclerView") int position) {
        SanPham sanpham = listSanPham.get(position);
        holder.onbind(sanpham);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SanPhamActivity.class);
                intent.putExtra("vitri",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSanPham.size();
    }

    public class ViewHoldel extends RecyclerView.ViewHolder{
        private TextView ma;
        private TextView ten;
        private TextView loai;
        private ImageView anh;

        public ViewHoldel(@NonNull View itemView) {
            super(itemView);

            ma = itemView.findViewById(R.id.masp);
            ten = itemView.findViewById(R.id.tensp);
            loai = itemView.findViewById(R.id.loai);
            anh = itemView.findViewById(R.id.avatar);
        }

        public void onbind(SanPham sp){
            ma.setText(sp.getId().toString());
            ten.setText(sp.getTen());
            loai.setText(sp.getKhohang().getTenKhoHang());
            anh.setBackgroundResource(R.drawable.ic_baseline_image_24);
        }
    }


}
