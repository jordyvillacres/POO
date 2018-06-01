package facci.pm.ta2.poo.pra1;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import facci.pm.ta2.poo.datalevel.DataException;
import facci.pm.ta2.poo.datalevel.DataObject;
import facci.pm.ta2.poo.datalevel.DataQuery;
import facci.pm.ta2.poo.datalevel.GetCallback;

public class DetailActivity extends AppCompatActivity {

    TextView precio, descripcion, nombre;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("PR1 :: Detail");
        nombre = (TextView) findViewById(R.id.nombre);
        precio = (TextView) findViewById((R.id.precio));
        descripcion = (TextView) findViewById(R.id.descripcion);
        imagen = (ImageView) findViewById(R.id.thumbnail);



        // INICIO - CODE6
        //ACCEDER AL object_id
        final DataQuery query = DataQuery.get("item");
        // recibe el parametro
        String parametro = getIntent().getExtras().getString("dato");
        query.getInBackground(parametro, new GetCallback<DataObject>() {
            @Override
            public void done(DataObject object, DataException e) {
                if (e==null){
                    String Precio = (String) object.get("price");
                    String Descripcion = (String) object.get("description");
                    String Nombre = (String) object.get("name");
                    Bitmap bitmap = (Bitmap) object.get("image");


                    precio.setText(Precio+"$");
                    precio.setTextColor(getColor(R.color.precioRojo));
                    descripcion.setText(Descripcion);
                    nombre.setText(Nombre);
                    imagen.setImageBitmap(bitmap);

                }else {
                    //error

                }
            }
        });
        // FIN - CODE6

    }

}
