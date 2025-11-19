package com.example.projek4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editUrl;
    private EditText editLocation;
    private EditText editShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.editText1);
        editLocation = findViewById(R.id.editText);
        editShare = findViewById(R.id.edit_Text);
    }

    public void openlocation(View view) {
        String lokasi = editLocation.getText().toString();
        Uri address = Uri.parse("geo:0,0?q=" + lokasi);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(intent);
    }

    public void shareText(View view) {
        String share = editShare.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle("Share this text with:")
                .setText(share)
                .setType("text/plain")
                .startChooser();
    }

    public void OpenWebsite(View view) {
        String url = editUrl.getText().toString();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}
