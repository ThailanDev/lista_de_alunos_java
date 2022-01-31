package com.example.agendaalunoscomjava.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendaalunoscomjava.R;
import com.example.agendaalunoscomjava.dao.AlunoDao;
import com.example.agendaalunoscomjava.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITLE_APP_BAR = "Novo aluno";
    EditText campoTelefone;
    EditText campoNome;
    EditText campoEmail;
    AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_formulario);
        setTitle(TITLE_APP_BAR);
        iniciandoCampos();
        configButtonSalvar();
    }

    private void configButtonSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_button);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criarAluno();
                salva(alunoCriado);
            }
        });
    }

    private void iniciandoCampos() {
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salva(Aluno alunoCriado) {
        dao.salva(alunoCriado);
        finish();
    }

    private Aluno criarAluno() {
        String nome = campoNome.getText().toString();
        String email = campoTelefone.getText().toString();
        String telefone = campoEmail.getText().toString();
        return new Aluno(nome, email, telefone);
    }

}