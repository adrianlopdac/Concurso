package com.example.adrian.concurso;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    Button boton;
    String nombre;

    EditText codigoET;
    EditText usuarioET;
    TextView mensaje;
    ImageView imagenPremio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensaje = (TextView)findViewById(R.id.mensaje);
        imagenPremio = (ImageView)findViewById(R.id.imagen_premio);
        codigoET=(EditText)findViewById(R.id.codigo);
        usuarioET=(EditText)findViewById(R.id.usuario);
        boton = (Button)findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compruebaPremio();
            }
        });
    }

    private void compruebaPremio(){
        String usuario = usuarioET.getText().toString();
        int codigoPremio = Integer.parseInt(codigoET.getText().toString());
        mensaje.setTextColor(Color.RED);
        if ((codigoPremio>30000)&(codigoPremio<31000)){
            String mens=usuario+getString(R.string.ganador);
            mensaje.setText(mens);
            mensaje.setVisibility(View.VISIBLE);
            imagenPremio.setVisibility(View.VISIBLE);
        }else{
            String mens=usuario+getString(R.string.no_ganador);
            mensaje.setText(mens);
            mensaje.setVisibility(View.VISIBLE);
            imagenPremio.setVisibility(View.INVISIBLE);
        }
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
