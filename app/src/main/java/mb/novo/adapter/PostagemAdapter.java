package mb.novo.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import mb.novo.databinding.AdapterPostagemLinhaBinding;
import mb.novo.model.PostagemModel;
import mb.novo.view.PostagemActivity;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.PostagemHolder> {
    //Atributos
    private Context              contexto;
    private List<PostagemModel>  listaPostagens = new ArrayList<PostagemModel>();

    //Construtor
    public PostagemAdapter(Context contexto, List<PostagemModel> listaClientesV) {
        this.contexto = contexto;                   //Contexto  ->  Da Activity Que Chamar
        this.listaPostagens = listaClientesV;        //Lista     ->  Vinda Da Activity Que Chamar
    }

    //Método - Atualizar Lista/Adapter
    public void atualizarLista(){
        notifyDataSetChanged();
    }

//    //Método - Atualizar Lista/Adapter
//    public void atualizarLista(ArrayList<ClienteModel> listaClientesV){
//        listaClientes.clear();
//        listaClientes.addAll(listaClientesV);
//        notifyDataSetChanged();
//    }

    //Lista - Identificação
    @NonNull @Override public PostagemHolder onCreateViewHolder(@NonNull ViewGroup pX, int viewT){
        //Layout
        LayoutInflater inflaterL = LayoutInflater.from(pX.getContext());

        //Linha - Arquivo XML
        AdapterPostagemLinhaBinding adapterBindX = AdapterPostagemLinhaBinding
                                                        .inflate(inflaterL,pX, false );
        //SubClasse Holder
        PostagemHolder postagemHolder = new PostagemHolder(adapterBindX);
        return postagemHolder;
    }

    //Linha - Configuração
    @Override public void onBindViewHolder(@NonNull PostagemHolder ls,
                                           @SuppressLint("RecyclerView")  int iX) {
        //Linha - Objetos
        PostagemModel cliente = listaPostagens.get(iX);
//        ls.bindingAdapter.nomeObjetoXml.setText(cliente.getNome());
//        ls.bindingAdapter.idadeObjetoXML.setText(String.valueOf(cliente.getIdade()));
//        ls.bindingAdapter.fotoObjetoXml.setImageResource(cliente.getImagem());

        //Linha - Ação Nos Objetos
        ls.bindingAdapter.nomeObjetoXml.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            //Toast.makeText(contexto, listaPostagens.get(iX).getNome(),Toast.LENGTH_LONG).show();
        }});
        ls.bindingAdapter.btn1ObjetoXml.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            Toast.makeText(contexto, String.valueOf(listaPostagens.get(iX).getId()),
                                                                        Toast.LENGTH_LONG).show();
        }});

        //Linha - Ação Na Linha (itemView)
        ls.itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            //Log.d("meuLog", listaClientes.get(iX).toString());
            Intent intentX  = new Intent(contexto, PostagemActivity.class);
            intentX.putExtra("chavePostagem", listaPostagens.get(iX));
            contexto.startActivity(intentX);
        }});
    }

    //Lista - Tamanho
    @Override public int getItemCount() {
        return listaPostagens.size();
    }

    //Adapter - Sub Classe Holder
    public static class PostagemHolder extends RecyclerView.ViewHolder{
        //Atributos
        public AdapterPostagemLinhaBinding bindingAdapter;   //Arquivo XML (Item da Linha)

        //Construtor
        public PostagemHolder(@NonNull AdapterPostagemLinhaBinding adapterBindX) {
            super(adapterBindX.getRoot());
            this.bindingAdapter = adapterBindX;
        }
    }
}


//Classe Adapter
//- Conceito:       Configuração da Respectiva Lista Recyclerview;
//- Observação:     Receber a Lista do Objeto e o Contexto (poderes activity - Toast, Intent)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Criar Classe Adapter
//- Criar Classe Java Normal
//- Fazer Herança da Classe Interna RecyclerView.Adapter, Contendo Sua Sub Classe Holder
//- Implementar os 3 Métodos Sugeridos Pela IDE (OnCreateViewHolder, OnBindViewHolder, GetItemCount)
//* A Sua Sub Classe Holder Ainda Não Existe, Mas Necessita Ser Criada (Conforme o Nome Dado);

////////////////////////////////////////////////////////////////////////////////////////////////////

//Criar Classe Secundária Holder
//- Criar Sub Classe Holder, Com o Mesmo Nome Informado na Herança da Sua Classe;
//- Identificar Objetos da Linha da Lista (Declarar como atributos desta sub classe);
//- Criar Construtor Vazio Desta Sub Classe, e Correlacionar (Atributos Declarados x Objetos XML)
//* Esta Sub Classe Poderia Estar Em Arquivo Separado Também (eu não prefiro)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Atributos e Construtor
//- Atributos:      Lista do Objeto (Dados) e Contexto (Variável Com Poder Activity - Toast, Intent)
//- Construtor:     Com Tais Atributos, Para Quando Esta Classe For Instanciada, Já os Passar;
//* Observação:     Alguns Comandos da Activity (startActivity), Agora São Via Contexto Recebido;

////////////////////////////////////////////////////////////////////////////////////////////////////

//- OnCreateViewHolder:     Arquivo XML (Linha da Lista) e Sua Sub Classe Holder
//- OnBindViewHolder:       Configuração da Linha da Lista
//- GetItemCount:           Tamanho da Lista


