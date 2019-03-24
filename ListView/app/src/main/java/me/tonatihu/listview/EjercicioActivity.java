package me.tonatihu.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EjercicioActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio);
        List<ListaEntrada> entradaList;
        int tipo = getIntent().getIntExtra("TIPO", 1);
        if (tipo == 1) {
            entradaList = obtenerAves();
        } else {
            entradaList = obtenerPerros();
        }


        listView = findViewById(R.id.list_view);
        listView.setAdapter(new ListaAdapter(this, R.layout.list_item, entradaList) {

            @Override
            void onEntrada(Object o, View v) {
                if (o != null) {
                    TextView textViewSuperior = v.findViewById(R.id.tv_superior);
                    if (textViewSuperior != null)
                        textViewSuperior.setText(((ListaEntrada) o).getA());
                    TextView textViewInferior = v.findViewById(R.id.tv_inferior);
                    if ( textViewInferior != null)
                        textViewInferior.setText(((ListaEntrada) o).getD());
                    ImageView imageView = v.findViewById(R.id.image_view);
                    if (imageView != null)
                        imageView.setImageResource(((ListaEntrada) o).getIdim());
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListaEntrada listaEntrada = (ListaEntrada) parent.getItemAtPosition(position);
                CharSequence cs = "Seleccionado: " + listaEntrada.getD();
                Toast t = Toast.makeText(EjercicioActivity.this, cs, Toast.LENGTH_LONG);
                t.show();
            }
        });
    }

    private List<ListaEntrada> obtenerPerros() {
        List<ListaEntrada>  entradaList = new ArrayList<>();
        entradaList.add(new ListaEntrada(R.drawable.pastor, "PASTOR ALEMÁN", "El pastor " +
                "alemán es una de las razas más reconocidas en del mundo. De aspecto noble y " +
                "carácter leal, ágil e inteligente, fuerte e intrépido, es un perro muy versátil " +
                "que puede desempeñar una gran variedad de actividades. Los pastores alemanes " +
                "son también excelentes como perros de compañía."));
        entradaList.add(new ListaEntrada(R.drawable.husky, "HUSKY SIBERIANO", "El Husky " +
                "siberiano es un perro de trabajo de tamaño mediano, rápido y ligero. " +
                "Su movimiento es libre y gracioso. Su cuerpo moderadamente compacto y bien " +
                "cubierto de pelo, las orejas erguidas y la cola tupida con pelo de cepillo " +
                "sugieren su herencia nórdica."));
        entradaList.add(new ListaEntrada(R.drawable.san, "SAN BERNARDO", "Los suizos " +
                "tienen fama de ser gente pacífica y previsora. Prueba de ello es que, mucho " +
                "tiempo antes de crear la Cruz Roja, ya criaban el San Bernardo, ese gigante de " +
                "las montañas cuya intuición y abnegación son legendarias."));
        entradaList.add(new ListaEntrada(R.drawable.labrador, "LABRADOR RETRIEVER", "El " +
                "Labrador Retriever es posiblemente la raza de perro más popular que existe en " +
                "el presente. En los Estados Unidos, durante los últimos catorce años, ha " +
                "tenido el registro anual de cachorros más alto de todas las razas reconocidas " +
                "(de acuerdo a las estadísticas del AKC)."));
        entradaList.add(new ListaEntrada(R.drawable.golden, "GOLDEN RETRIEVER", "El Golden " +
                "Retriever tiene un caracter migable y confiable, carece de agresividad, tanto " +
                "hacia las personas como hacia sus congéneres (aunque tal vez desconfie de los " +
                "extraños). Su mirada tierna y melancólica manifiesta su necesidad de afecto. " +
                "Incapaz de una reacción adversa, responderá a todo."));
        entradaList.add(new ListaEntrada(R.drawable.samoyedo, "SAMOYEDO", "El Samoyedo es un " +
                "perro de buen tamaño con un pelo blanco precioso. A simple vista aparenta ser " +
                "un inmenso juguete de peluche creado para lucir su belleza estética."));
        entradaList.add(new ListaEntrada(R.drawable.alaska, "MALAMUTE DE ALASKA", "Historia " +
                "Etimológicamente la palabra Malamute, deriva de Mahlemute o Mahlemuit, aunque " +
                "con el paso del tiempo a derivado a la palabra tal y como la conocemos."));
        entradaList.add(new ListaEntrada(R.drawable.braco, "BRACO DE WEIMAR", "Existen " +
                "muchas teorías acerca del origen del perro de muestra Weimaraner. Sólo se " +
                "tiene la certeza que el Weimaraner, que en aquel entonces aún conservaba " +
                "sangre de perro de guía, ya se criaba en el primer tercio del siglo XIX " +
                "en la corte de Weimar."));
        return entradaList;
    }

    private List<ListaEntrada> obtenerAves() {
        List<ListaEntrada>  entradaList = new ArrayList<>();
        entradaList.add(new ListaEntrada(R.drawable.buho, "BUHO", "Búho es el nombre " +
                "común de aves de la familia Strigidae, del orden de las estrigiformes o aves " +
                "rapaces nocturnas. Habitualmente designa especies que, a diferencia de las " +
                "lechuzas, tienen plumas alzadas que parecen orejas."));
        entradaList.add(new ListaEntrada(R.drawable.colibri, "COLIBRÍ", "Los troquilinos " +
                "(Trochilinae) son una subfamilia de aves apodiformes de la familia Trochilidae, " +
                "conocidas vulgarmente como colibríes, quindes, tucusitos, picaflores, " +
                "chupamirtos, chuparrosas, huichichiquis (idioma nahuatl), mainumby (idioma " +
                "guaraní) o guanumby."));
        entradaList.add(new ListaEntrada(R.drawable.cuervo, "CUERVO", "El cuervo común " +
                "(Corvus corax) es una especie de ave paseriforme de la familia de los córvidos " +
                "(Corvidae). Presente en todo el hemisferio septentrional, es la especie de " +
                "córvido con la mayor superficie de distribución."));
        entradaList.add(new ListaEntrada(R.drawable.flamenco, "FLAMENCO", "Los " +
                "fenicopteriformes (Phoenicopteriformes), los cuales reciben el nombre vulgar de " +
                "flamencos, son un orden de aves neognatas, con un único género viviente: " +
                "Phoenicopterus."));
        entradaList.add(new ListaEntrada(R.drawable.kiwi, "KIWI", "Los kiwis (Apterix, gr. " +
                "'sin alas') son un género de aves paleognatas compuesto por cinco especies " +
                "endémicas de Nueva Zelanda.1 2 Son aves no voladoras pequeñas, aproximadamente " +
                "del tamaño de una gallina."));
        entradaList.add(new ListaEntrada(R.drawable.loro, "LORO", "Las Psitácidas " +
                "(Psittacidae) son una familia de aves psitaciformes llamadas comúnmente loros o " +
                "papagayos, e incluye a los guacamayos, las cotorras, los periquitos, los " +
                "agapornis y formas afines."));
        entradaList.add(new ListaEntrada(R.drawable.pavo, "PAVO", "Pavo es un género de " +
                "aves galliformes de la familia Phasianidae, que incluye dos especies, el pavo " +
                "real común (Pavo cristatus) y el pavo real cuelliverde (Pavo muticus).1"));
        entradaList.add(new ListaEntrada(R.drawable.pinguino, "PINGÜINO", "Los pingüinos " +
                "(familia Spheniscidae, orden Sphenisciformes) son un grupo de aves marinas, no " +
                "voladoras, que se distribuyen únicamente en el Hemisferio Sur, sobre todo en " +
                "sus altas latitudes."));
        return entradaList;
    }
}

