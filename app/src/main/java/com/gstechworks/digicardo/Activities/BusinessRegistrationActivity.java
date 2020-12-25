package com.gstechworks.digicardo.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityBusinessRegistrationBinding;

import java.util.Calendar;

public class BusinessRegistrationActivity extends AppCompatActivity {
    ActivityBusinessRegistrationBinding binding;
    private int mDate, mYear, mMonth;
    private static final int REQUEST_WRITE_PERMISSION = 1;
    Uri FilePathUri;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_business_registration);

        binding.DatePicker.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDate = c.get(Calendar.DATE);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthofYear, int dayofMonth) {
                    binding.YearEst.setText(dayofMonth+ "/" + (monthofYear + 1)+ "/" +year);
                }
            }, mYear, mMonth, mDate);
            datePickerDialog.show();
        });

        binding.ChooseImg.setOnClickListener(view -> {
            requestPermission();

        });

        binding.nextbtn.setOnClickListener(view -> {
            Intent i = new Intent(BusinessRegistrationActivity.this, AddProductActivity.class);
            startActivity(i);
        });


    }
    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
        } else {
            openFilePicker();//do your job
        }
    }
    public void openFilePicker() {
        Intent imagepicker = new Intent(Intent.ACTION_PICK);
        imagepicker.setType("image/*");
        startActivityForResult(imagepicker, 101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            try {

                FilePathUri = data.getData();
                Cursor returnCursor =
                        getContentResolver().query(FilePathUri, null, null, null, null);
                int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                returnCursor.moveToFirst();
                binding.FounderImgText.setText(returnCursor.getString(nameIndex));
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);
                binding.PreviewFounderImg.setImageBitmap(bitmap);
                binding.ChooseImg.setText("Upload");
                binding.PreviewFounderImg.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                Log.e("AddImage", "onActivityResult: " + e);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openFilePicker();//do your job
        }
    }
}