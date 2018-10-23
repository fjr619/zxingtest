package x.fjr.zxingtest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

/**
 * Created by franky.wijanarko on 23,October,2018
 */
public class GeneratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        final ImageView imageView = findViewById(R.id.imageView);
        final EditText editText = findViewById(R.id.editText);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().length() > 0) {
                    try {
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.encodeBitmap(editText.getText().toString(), BarcodeFormat.QR_CODE, 500, 500);
                        imageView.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        Log.d("MainActivity", "failed generate qrcode");
                        Toast.makeText(GeneratorActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}
