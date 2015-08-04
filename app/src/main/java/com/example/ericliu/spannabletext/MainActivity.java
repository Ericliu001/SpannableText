package com.example.ericliu.spannabletext;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContent = (TextView) findViewById(R.id.tvContent);
        setSpannableTextContent(tvContent);
    }


    /**
     * display the text content and make terms and conditions with different sytle
     * and clickable
     */
    private void setSpannableTextContent(TextView tvContent) {
        String text = getString(R.string.text_content);


        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // TODO: 4/08/2015 start Terms and Conditions activity
                Toast.makeText(MainActivity.this, "Clicked TC", Toast.LENGTH_SHORT).show();
            }
        };

        SpannableStringBuilder longDescription = new SpannableStringBuilder();
        longDescription.append(text);
        int start = longDescription.length();
        longDescription.append("Terms and Conditions");
        longDescription.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        longDescription.setSpan(clickableSpan, start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // the color span must be set after other spans, otherwise it won't work
        int textColor = Color.parseColor("#36b341");
        longDescription.setSpan(new ForegroundColorSpan(textColor), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvContent.setMovementMethod(LinkMovementMethod.getInstance());
        tvContent.setText(longDescription);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
