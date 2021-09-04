package br.com.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButtonIniciar;

    private EditText mEditEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mButtonIniciar = findViewById(R.id.button_iniciar);
        this.mEditEmail = findViewById(R.id.edit_email);

       final MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);

       this.mButtonIniciar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = mEditEmail.getText().toString();
               vm.doLogin(email);
           }
       });

       vm.Login.observe(this, new Observer<Boolean>() {
           @Override
           public void onChanged(Boolean sucesso) {
             if(sucesso){
                 Toast.makeText(getApplicationContext(), "Sucesso :)", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(getApplicationContext(), "Erro :(", Toast.LENGTH_SHORT).show();
             }
           }
       });
    }
}