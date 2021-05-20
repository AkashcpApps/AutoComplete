package com.akash.cp.vtu.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    AutoCompleteTextView text;
    MultiAutoCompleteTextView text1;
    private MultiAutoCompleteTextView editText;
    private int intCount = 0, initialStringLength = 0;
    private String strText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (MultiAutoCompleteTextView) findViewById(R.id.mactv);
        findViewById(R.id.click123).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String splited = editText.getText().toString();
                Toast.makeText(MainActivity2.this, " " + splited, Toast.LENGTH_SHORT).show();
            }
        });
        String[] COUNTRIES = new String[]{"Akash", "Anush", "Ani", "Ajith", "mohan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        editText.setAdapter(adapter);

        editText.setThreshold(1);

        editText.setTokenizer(new MultiAutoCompleteTextView.Tokenizer() {

            @Override
            public CharSequence terminateToken(CharSequence text) {
                int i = text.length();

                while (i > 0 && text.charAt(i - 1) == ' ') {
                    i--;
                }

                if (i > 0 && text.charAt(i - 1) == ' ') {
                    return text;

                } else {
                    if (text instanceof Spanned) {
                        SpannableString sp = new SpannableString(text + " ");
                        TextUtils.copySpansFrom((Spanned) text, 0, text.length(), Object.class, sp, 0);
                        return sp;
                    } else {
                        return text + " ";
                    }
                }
            }

            @Override
            public int findTokenStart(CharSequence text, int cursor) {
                int i = cursor;

                while (i > 0 && text.charAt(i - 1) != '@') {
                    i--;
                }

                if (i < 1 || text.charAt(i - 1) != '@') {
                    return cursor;
                }

                return i;
            }

            @Override
            public int findTokenEnd(CharSequence text, int cursor) {
                int i = cursor;
                int len = text.length();

                while (i < len) {
                    if (text.charAt(i) == ' ') {
                        return i;
                    } else {
                        i++;
                    }
                }

                return len;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                String strET = editText.getText().toString();
                String[] str = strET.split(" ");
                int cnt = 0;
                if (text.length() != initialStringLength && text.length() != 0) {
                    if (!strET.substring(strET.length() - 1).equals(" ")) {
                        initialStringLength = text.length();
                        cnt = intCount;
                        for (int i = 0; i < str.length; i++)
                            if (str[i].charAt(0) == '@')
                                strText = strText + " " + "<font color='#34B7F1'>" + str[i] + "</font>";
                            else
                                strText = strText + " " + str[i];
                    }
                    if (intCount == cnt) {
                        intCount = str.length;
                        editText.setText(Html.fromHtml(strText));
                        editText.setSelection(editText.getText().toString().length());
                    }
                } else {
                    strText = "";
                }
            }
        });
    }
}