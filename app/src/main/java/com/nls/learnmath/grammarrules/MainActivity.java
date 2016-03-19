package com.nls.learnmath.grammarrules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método que muda de tela.
     * @param view
     */
    public void iniciar(View view) {
        Intent intent = new Intent(MainActivity.this, GrammarActivity.class);
        startActivity(intent);
    }
}
