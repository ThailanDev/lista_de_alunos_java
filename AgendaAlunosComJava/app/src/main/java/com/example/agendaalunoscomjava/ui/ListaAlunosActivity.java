package com.example.agendaalunoscomjava.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendaalunoscomjava.R;
import com.example.agendaalunoscomjava.dao.AlunoDao;
import com.example.agendaalunoscomjava.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ListaAlunosActivity extends AppCompatActivity {

    AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos_lista);

        setTitle("Lista de Alunos");

        FloatingActionButton botaoNovoAluno = findViewById(R.id.floatingActionButton);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioAlunoActivity();
            }
        });

        dao.salva(new Aluno("Thalan","5564454", "@"));
        dao.salva(new Aluno("Thalan","5564454", "@"));
        dao.salva(new Aluno("Thalan","5564454", "@"));

    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configLista();
    }

    private void configLista() {
        ListView listaDeAlunos = findViewById(R.id.activitymainlistadealunos);
        List<Aluno> alunos = dao.todos();
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, dao.todos()));
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Aluno alunoEscolhido = alunos.get(position);
                Log.i("posicao do aluno", "" + alunoEscolhido);
            }
        });
    }
}