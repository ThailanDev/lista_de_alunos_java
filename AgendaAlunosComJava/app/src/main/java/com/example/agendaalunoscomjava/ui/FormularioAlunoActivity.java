package com.example.agendaalunoscomjava.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        iniciandoCampos();
        configButtonSalvar();
    }

    private void configButtonSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_button);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validCamposVazios(campoNome, campoTelefone, campoEmail);
            }
        });
    }

    private void iniciandoCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void validCamposVazios(EditText validNome, EditText validTelefone,  EditText validEmail){
        String nomeIsEmpity = validNome.getText().toString();
        String telefoneIsEmpity = validTelefone.getText().toString();
        String emailIsEmpity = validEmail.getText().toString();
        if(TextUtils.isEmpty(nomeIsEmpity) || TextUtils.isEmpty(telefoneIsEmpity)  ||  TextUtils.isEmpty(emailIsEmpity) ){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        Aluno alunoCriado = criarAluno();
        salva(alunoCriado);
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