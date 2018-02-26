package io.github.tiagofrbarbosa.recyclerviewudemy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.tiagofrbarbosa.recyclerviewudemy.R;
import io.github.tiagofrbarbosa.recyclerviewudemy.adapter.Adapter;
import io.github.tiagofrbarbosa.recyclerviewudemy.model.Filme;
import io.github.tiagofrbarbosa.recyclerviewudemy.model.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        criarFilmes();

        Adapter adapter = new Adapter(listaFilmes);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), listaFilmes.get(position).getTituloFilme(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), listaFilmes.get(position).getTituloFilme(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){

        Filme filme = new Filme("Matrix", "Ação", "1990");
        listaFilmes.add(filme);

        filme = new Filme("Hitman", "Ação", "2001");
        listaFilmes.add(filme);

         filme = new Filme("Exorcista", "Terror", "1985");
        listaFilmes.add(filme);

         filme = new Filme("Ace Ventura", "Comédia", "2001");
        listaFilmes.add(filme);

         filme = new Filme("Esqueceram de mim", "Comédia", "2005");
        listaFilmes.add(filme);

         filme = new Filme("Sillent Hill", "Suspense", "2010");
        listaFilmes.add(filme);

         filme = new Filme("Frozen", "Desenho", "2005");
        listaFilmes.add(filme);

         filme = new Filme("Batman", "Ação", "2004");
        listaFilmes.add(filme);

         filme = new Filme("Spider-Man", "Ação", "2010");
        listaFilmes.add(filme);


    }
}
