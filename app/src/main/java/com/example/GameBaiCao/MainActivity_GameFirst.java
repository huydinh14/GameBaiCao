package com.example.GameBaiCao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_GameFirst extends AppCompatActivity {
    int manghinhbai[]={
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};
    Button btnRutNgauNhien;
    TextView txtKetQuaNguoi, txtLanChoi, txtKetQuaMay;
    ImageView iv1, iv2, iv3, iv4, iv5, iv6, ivBack;
    int lanChoi = 0;
    int[] soLanThang_Hoa = new int[3];
    // 0 là so lan may thang, 1 la so lan nguoi thang, 2 la so lan hoa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_first);
        AnhXa();
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        soLanThang_Hoa[0] = soLanThang_Hoa[1] = soLanThang_Hoa[2] = 0;
         btnRutNgauNhien.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 lanChoi++;
                 int[] saulabai = laySauSoNgauNhien(0,51);
                 iv4.setImageResource(manghinhbai[saulabai[3]]);
                 iv5.setImageResource(manghinhbai[saulabai[4]]);
                 iv6.setImageResource(manghinhbai[saulabai[5]]);
                 //SystemClock.sleep(3000);
                 iv1.setImageResource(manghinhbai[saulabai[0]]);
                 iv2.setImageResource(manghinhbai[saulabai[1]]);
                 iv3.setImageResource(manghinhbai[saulabai[2]]);
//                 int iKetQua = 0;
//                 for(int i = 0 ; i < 3; i++) {
//                     if (balabai[i] >= 0 && balabai[i] <= 8) {
//                         iKetQua += balabai[i] + 1;
//                         //Log.d("KQ1",iKetQua + "");
//                     } else if (balabai[i] >= 13 && balabai[i] <= 21) {
//                         iKetQua += balabai[i] - 12;
//                         //Log.d("KQ2",iKetQua + "");
//                     } else if (balabai[i] >= 26 && balabai[i] <= 34) {
//                         iKetQua += balabai[i] - 25;
//                         //Log.d("KQ3",iKetQua + "");
//                     } else if (balabai[i] >= 39 && balabai[i] <= 47) {
//                         iKetQua += balabai[i] - 38;
//                         //Log.d("KQ4",iKetQua + "");
//                     } else
//                     {
//                         iKetQua += 10;
//                         //Log.d("KQ5",iKetQua + "");
//                     }
//
                 //Log.d("KQ",iKetQua + "");
                 txtKetQuaNguoi.setText(tinhKetQua(saulabai, soLanThang_Hoa)[0]);
                 txtKetQuaMay.setText(tinhKetQua(saulabai, soLanThang_Hoa)[1]);
                 txtLanChoi.setText("Lần chơi thứ: " + lanChoi);
                 if(lanChoi == 10) {
                     myDialog.setTitle("Kết quả sau 10 lượt chơi").setMessage("-Số lần máy thắng: " + soLanThang_Hoa[0] / 2 + "\n-Số lần người chơi thắng: " + soLanThang_Hoa[1] / 2 + "\n-Số lần hòa: " + soLanThang_Hoa[2] / 2);
                     myDialog.setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             releaseInstance();
                             Toast.makeText(MainActivity_GameFirst.this, "Choose OK".toString(), Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(MainActivity_GameFirst.this, MainActivity_GameFirst.class); //change it to your main class
                             intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                             finish();
                             startActivity(intent);
                         }
                     });
                     AlertDialog dialog = myDialog.create();
                     dialog.show();
                 }
             }
         });

         ivBack.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onBackPressed();
             }
         });
    }

    private void AnhXa() {
        btnRutNgauNhien = findViewById(R.id.button_rutlabai);
        txtKetQuaNguoi = findViewById(R.id.textview_ketquaNguoi);
        txtKetQuaMay = findViewById(R.id.textview_ketquamay);
        txtLanChoi = findViewById(R.id.textview_lanchoi);
        ivBack = findViewById(R.id.imageBack);
        iv1 = findViewById(R.id.imageview1);
        iv2 = findViewById(R.id.imageview2);
        iv3 = findViewById(R.id.imageview3);
        iv4 = findViewById(R.id.imageview4);
        iv5 = findViewById(R.id.imageview5);
        iv6 = findViewById(R.id.imageview6);
    }

//    private String tinhKetQua(int[]arr)
//    {
//        String ketqua = "";
//        if(tinhSoTay(arr) == 3)
//        {
//            ketqua = "Kết quả 3 tây";
//        }
//        else
//        {
//            int tong = 0;
//            for(int i = 0; i < arr.length; i++)
//            {
//                if(arr[i] % 13 < 10)
//                {
//                    tong += arr[i] % 13 + 1;
//                }
//            }
//            if(tong % 10 == 0)
//            {
//                ketqua = "Kết quả bù, số tây là " + tinhSoTay(arr);
//            }
//            else
//            {
//                ketqua = "Kết quả là " + (tong%10) + " nút, số tây là " + tinhSoTay(arr);
//            }
//        }
//        return ketqua;
//    }

    private String[] tinhKetQua(int[]arr, int[]soLanThang_Hoa)
    {
        String[] ketqua = new String[2];
        int diemNguoiChoi = tinhDiem(arr, false) % 10;
        int diemMay = tinhDiem(arr, true) % 10;
        if(tinhSoTay(arr,true) == 3)
        {
            if(tinhSoTay(arr,false) == 3)
            {
                ketqua[0] = "3 tây, HÒA";
                ketqua[1] = "3 tây, HÒA";
                soLanThang_Hoa[2]++;
                return  ketqua;
            }
            else
            {
                if(diemNguoiChoi == 0)
                {
                    ketqua[0] = "Bù, Bạn Thua";
                    ketqua[1] = "3 tây, Máy Thắng";
                    soLanThang_Hoa[0]++;
                    return ketqua;
                }
                ketqua[0] = (diemNguoiChoi) + " nút, Bạn Thua";
                ketqua[1] =  "3 tây, Máy Thắng";
                soLanThang_Hoa[0]++;
                return  ketqua;
            }
        }
        else
        {
            if(tinhSoTay(arr,false) == 3)
            {
                ketqua[0] = "3 tây, Bạn Thắng";
                ketqua[1] = diemMay + "nút, Máy Thua";
                soLanThang_Hoa[1]++;
                return ketqua;
            }
            else
            {
                if(diemMay == diemNguoiChoi)
                {
                    ketqua[0] = ketqua[1] = (diemNguoiChoi) + " nút, Hòa";
                    soLanThang_Hoa[2]++;
                    return ketqua;
                }
                //ketqua[0] = (diemMay) < (diemNguoiChoi) ? ((diemNguoiChoi) + " nút, Bạn Thắng") : ((diemNguoiChoi) + " nút, Bạn Thua");
                //ketqua[1] = (diemMay) > (diemNguoiChoi) ? ((diemMay) + " nút, Máy Thắng") : ((diemMay) + " nút, Máy Thua");
                if(diemMay < diemNguoiChoi)
                {
                    ketqua[0] = diemNguoiChoi + " nút, Bạn Thắng";
                    ketqua[1] = diemMay + " nút, Máy Thua";
                    soLanThang_Hoa[1]++;
                    return ketqua;
                }
                ketqua[0] = diemNguoiChoi + " nút, Bạn Thua";
                ketqua[1] = diemMay + " nút, Máy Thắng";
                soLanThang_Hoa[0]++;
                return ketqua;
            }
        }
        //return ketqua;
    }

    private int tinhDiem(int[]arr, boolean bool) // True là máy, False là người
    {
        int tongDiem = 0;
        if(bool)
        {
            for(int i = 0; i < 3; i++)
            {
                if(arr[i] % 13 < 10)
                {
                    tongDiem += arr[i] % 13 + 1;
                }
            }
        }
        else
        {
            for(int i = 3; i < 6; i++)
            {
                if(arr[i] % 13 < 10)
                {
                    tongDiem += arr[i] % 13 + 1;
                }
            }
        }

        return tongDiem;
    }

    private int tinhSoTay(int[]arr, boolean bool) // True là máy, False là người
    {
        int k = 0;
        if(bool)
        {
            for(int i = 0; i < 3; i++)
            {
                if(arr[i] % 13 >= 10)
                {
                    k++;
                }
            }
        }
        else
        {
            for(int i = 3; i < 6; i++)
            {
                if(arr[i] % 13 >= 10)
                {
                    k++;
                }
            }
        }
        return k;
    }

    private int[] laySauSoNgauNhien(int min, int max)
    {
        int[] sauso = new int[6];
        int i = 0;
        sauso[i++] = ramdom(min, max);
        do
        {
            int k = ramdom(min,max);
            if(!kiemtraTrung(k,sauso))
            {
                sauso[i++] = k;
            }
        }while(i < 6);
        return  sauso;
    }

    private boolean kiemtraTrung(int k, int[]arr)
    {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == k)
            {
                return true;
            }
        return false;
    }

    private int ramdom(int min, int max) {
        return min + (int)(Math.random()*((max - min) + 1));
    }
}