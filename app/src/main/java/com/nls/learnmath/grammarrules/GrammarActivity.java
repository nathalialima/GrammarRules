package com.nls.learnmath.grammarrules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrammarActivity extends AppCompatActivity {

    private List<String> palavrasCorretas;
    private List<String> palavrasIncorretas;

    private Integer posicaoPalavraLista;
    private Integer pontuacao = 0;
    private Integer contadorTentativas = 3;
    private String mensagem = "";

    private EditText editTextResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        pontuacao = 0;
        displayPontos(pontuacao);

        editTextResposta = (EditText) findViewById(R.id.edit_text_resposta);

        novaPalavra();
    }

    /**
     * Gera uma nova palavra aleatória e mostra na tela.
     * @param view
     */
    public void novaPalavra(View view) {
        carregarListas();
        selecionarPalavra();
        displayPalavra(palavrasIncorretas.get(posicaoPalavraLista));
        Button buttonVerificar = (Button) findViewById(R.id.button_verificar);
        buttonVerificar.setVisibility(View.VISIBLE);
        Button buttonProximaPalavra = (Button) findViewById(R.id.button_proxima_palavra);
        buttonProximaPalavra.setVisibility(View.GONE);
        limparCamposAcerto();
        editTextResposta.setEnabled(true);
    }

    /**
     * Gera uma nova palavra aleatória e mostra na tela.
     */
    private void novaPalavra() {
        carregarListas();
        selecionarPalavra();
        displayPalavra(palavrasIncorretas.get(posicaoPalavraLista));
        editTextResposta.setEnabled(true);
    }

    /**
     * Seleciona uma palavra aleatória da lista.
     */
    private void selecionarPalavra() {
        Random random = new Random();
        posicaoPalavraLista = random.nextInt(20);
    }

    /**
     * Gera lista com as palavras corretas e erradas.
     */
    private void carregarListas() {
        palavrasCorretas = new ArrayList<>();
        palavrasCorretas.add("lamparina");
        palavrasCorretas.add("sambista");
        palavrasCorretas.add("ambíguo");
        palavrasCorretas.add("bêbado");
        palavrasCorretas.add("trazer");
        palavrasCorretas.add("caju");
        palavrasCorretas.add("passível");
        palavrasCorretas.add("tímpano");
        palavrasCorretas.add("supôs");
        palavrasCorretas.add("ímã");
        palavrasCorretas.add("jóquei");
        palavrasCorretas.add("pônei");
        palavrasCorretas.add("assembleia");
        palavrasCorretas.add("ideia");
        palavrasCorretas.add("geleia");
        palavrasCorretas.add("jiboia");
        palavrasCorretas.add("apoia");
        palavrasCorretas.add("paranoico");
        palavrasCorretas.add("voo");
        palavrasCorretas.add("enjoo");
        palavrasCorretas.add("argui");

        palavrasIncorretas = new ArrayList<>();
        palavrasIncorretas.add("lanparina");
        palavrasIncorretas.add("sanbista");
        palavrasIncorretas.add("anbiguo");
        palavrasIncorretas.add("bebado");
        palavrasIncorretas.add("traser");
        palavrasIncorretas.add("cajú");
        palavrasIncorretas.add("pasivel");
        palavrasIncorretas.add("tinpano");
        palavrasIncorretas.add("supos");
        palavrasIncorretas.add("ima");
        palavrasIncorretas.add("joquei");
        palavrasIncorretas.add("ponei");
        palavrasIncorretas.add("assenbléia");
        palavrasIncorretas.add("idéia");
        palavrasIncorretas.add("geléia");
        palavrasIncorretas.add("jibóia");
        palavrasIncorretas.add("apóia");
        palavrasIncorretas.add("paranóico");
        palavrasIncorretas.add("vôo");
        palavrasIncorretas.add("enjôo");
        palavrasIncorretas.add("arguí");
    }

    /**
     * Verifica se a palavra digitada pelo usuário está certa ou errada.
     * @param view
     */
    public void verificaPalavraDigitada (View view){

        Log.i("ERRO", "contador: "+contadorTentativas);

        if(!editTextResposta.getText().toString().trim().equals("")) {

            if (editTextResposta.getText().toString().trim().equals(palavrasCorretas.get(posicaoPalavraLista))) {
                mensagem = "Parabéns, você acertou!";
                displayMensagem(mensagem);

                pontuacao += 10;
                displayPontos(pontuacao);

                Button buttonVerificar = (Button) findViewById(R.id.button_verificar);
                buttonVerificar.setVisibility(View.GONE);

                Button buttonProximaPalavra = (Button) findViewById(R.id.button_proxima_palavra);
                buttonProximaPalavra.setVisibility(View.VISIBLE);

                editTextResposta.setEnabled(false);

            } else {

                if (contadorTentativas > 1) {
                    contadorTentativas--;

                    mensagem = "Ops, você errou! Tente novamente!\n"
                            + "Você tem mais "
                            + contadorTentativas
                            + " tentativas restantes.";

                    displayMensagem(mensagem);
                    displayTentativas(contadorTentativas);

                    Log.i("ERRO", "contador: " + contadorTentativas);
                    limparCamposErro();
                } else {
                    contadorTentativas = 3;
                    displayTentativas(contadorTentativas);
                    limparCamposAcerto();
                    novaPalavra();
                }
            }
        } else {
            mensagem = "Digite uma palavra válida!";
            displayMensagem(mensagem);
        }
    }

    /**
     * Mostra uma mensagem na tela.
     * @param mensagem
     */
    private void displayMensagem(String mensagem){
        TextView textViewMsg = (TextView) findViewById(R.id.text_view_msg);
        textViewMsg.setText(mensagem);
    }

    /**
     * Mostra uma palavra na tela.
     * @param palavra
     */
    private void displayPalavra(String palavra) {
        TextView textViewInfo = (TextView) findViewById(R.id.text_view_palavra);
        textViewInfo.setText(palavra);
    }

    /**
     * Mostra a pontuação na tela.
     * @param pontos
     */
    private void displayPontos(Integer pontos) {
        TextView textViewPontos = (TextView) findViewById(R.id.text_view_pontos);
        textViewPontos.setText(pontos.toString());
    }

    /**
     * Mostra a quantidade de tentativas restantes na tela.
     * @param tentativas
     */
    private void displayTentativas(Integer tentativas) {
        TextView textViewTentativas = (TextView) findViewById(R.id.text_view_tentativas_restantes);
        textViewTentativas.setText(tentativas.toString());
    }

    /**
     * Limpa a mensagem de erro da tela.
     */
    private void limparCamposErro(){
        EditText editTextResposta = (EditText) findViewById(R.id.edit_text_resposta);
        editTextResposta.setText("");
    }

    /**
     * Reseta a quantidade de tentativas e limpa a mensagem da tela.
     */
    private void limparCamposAcerto(){
        contadorTentativas = 3;
        displayTentativas(contadorTentativas);
        mensagem = "";
        displayMensagem(mensagem);
        EditText editTextResposta = (EditText) findViewById(R.id.edit_text_resposta);
        editTextResposta.setText("");
    }
}
