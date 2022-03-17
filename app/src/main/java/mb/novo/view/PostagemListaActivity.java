package mb.novo.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.util.Log;
import java.util.List;
import java.util.Locale;

import mb.novo.R;
import mb.novo.adapter.PostagemAdapter;
import mb.novo.databinding.ActivityPostagemListaBinding;
import mb.novo.model.PostagemModel;
import mb.novo.viewmodel.PostagemViewModel;

public class PostagemListaActivity extends AppCompatActivity {
    //Atributos
    private Integer                         id = 10;                                                //  ***
    private ActivityPostagemListaBinding    binding;                //Arquivo XML Desta Tela
    private PostagemViewModel               postagemViewModel;
    private PostagemAdapter                 postagemAdapter;
    private LinearLayoutManager             listaLayout    = new LinearLayoutManager(this);

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Tela e View Model
        binding = DataBindingUtil.setContentView(this, R.layout.activity_postagem_lista);
        postagemViewModel = new ViewModelProvider(this).get(PostagemViewModel.class);

        ////////////////////////////////////////////////////////////////////////////////////////////

        //Só Enviar (Salvar, Editar, Deletar)
        PostagemModel postagem = new PostagemModel("1", "5", "Título", "Corpo");
            postagemViewModel.salvarVM(postagem).observe(this, new Observer<String>() {
                 @Override public void onChanged(String textoRetornado) {
                Log.d("meuLogS_V", textoRetornado);
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////

        //Receber (Todos e Por Id)
        postagemViewModel.buscarTodosVM().observe(this, new Observer<List<PostagemModel>>() {
        @Override public void onChanged(List<PostagemModel> postagemModelsV) {
            if(postagemModelsV.isEmpty()){
               Log.d("meuLogBT_V", "Lista Vazia!");
            }else{
               Log.d("meuLogBT_V", postagemModelsV.toString());
                binding.listcliRecycleXml.setLayoutManager(listaLayout);
                postagemAdapter = new PostagemAdapter(PostagemListaActivity.this, postagemModelsV);
                binding.listcliRecycleXml.setAdapter(postagemAdapter);

                for(PostagemModel item : postagemModelsV){
                    if(item.getId().equalsIgnoreCase("99")) {
                        Log.d("meuLogBT_V", "Tem Id 99");
                    }
                }
            }
        }});

        postagemViewModel.buscarPorIdVM(99).observe(this, new Observer<PostagemModel>() {
            @Override public void onChanged(PostagemModel postagemModelX) {

              //  Log.d("meuLogBE_V", postagemModelX.toString());
                //String idObjeto = postagemModelX.getId();

                if(postagemModelX == null){
                    Log.d("meuLogBE_V", "Cliente Não Encontrado");
                    PostagemModel postagem = new PostagemModel("1", "5", "Título", "Corpo");
                    postagemViewModel.salvarVM(postagem);

                }else{
                    Log.d("meuLogBE_V", postagemModelX.toString());

                }
            }
        });

        postagemViewModel.postagemSalvar.observe(this, new Observer<String>() {
            @Override public void onChanged(String s) {
                Log.d("meuLogZZZ", s);
            }
        });



        //View Model - Observer's
//        postagemViewModel.saudacaoVM().observe(this, new Observer<String>() {
//        @Override public void onChanged(String s) {
//            Log.d("meuLog", s.toString());
//        }});
//        postagemViewModel.buscaPorIdVM(id).observe(this, new Observer<ClienteModel>(){
//        @Override public void onChanged(ClienteModel clienteModelV) {
//            if(clienteModelV.getId() == null){
//                Log.d("meuLog", "Cliente Não Encontrado!");
//            }else{
//                Log.d("meuLog", String.valueOf(clienteModelV.getId()) + " " +clienteModelV.getNome());
//            }
//        }});
    }

    //Método Depois Inicial (Quando Volta Para Tela) - Chama o Atualizar Lista do Adapter, ETc
    @Override protected void onResume() {
        super.onResume();
        //postagemAdapter.atualizarLista();
    }
}





//Activity
//- Carregar Tela:          OnCreate    Ver Ciclo de Vida da Activity;
//- Atualizar Tela:         OnResume    Útil Quando Voltar P/ a Mesma Activity Após Objeto Alterado;
//- Identificar Tela:       View Binding e Data Binding;
//- Identificar Objs Tela:  View Binding;
//- View Model:             Pegar Dados;
//- Observer's:             Pegar Dados Atualizados, Caso Mude os Dados do BD, API's, Etc;

////////////////////////////////////////////////////////////////////////////////////////////////////

//Observações Gerais
//- Requisitos:			ArrayList com Classe;
//- Conteúdo Linha:     String, Integer, Imagem, Botão Comando;
//- Ação Linha:         Na Linha e/ou Nos Objetos da Linha;
//- RecyclerView:       Lista Utilizada. Tem a ListView, Mas Não é Padrão e Da Leg Carregamento
//- Orientation:        Utilizado Na Ordem Vertical no Layout (Xml), Mas Funcionou Sem Também
//- ScrollView:         Não Utilizada Barra de Rolagem no Layout (Xml), Pois a RecyclerView Já Tem
//- Traço Linha:        Utilizado o Objeto View no Layout (XML). Poderia Ficar Sem o Traço Também
//- Imagens:            Colar os Arquivos na Pasta Res/Drawable
//* ArrayList:          Aqui Esta Em Quem Utiliza (View, Controller,Etc)    Fazer Na Model           ***
//* Recolher/Expandir:  Tem o Modelo de Listas Recolhidas/Expandidas.       Fazer Este Modelo        ***
//* Com CardView:       Tem o Modelo de Linhas Estilo Cartões.              Fazer Este Modelo        ***

////////////////////////////////////////////////////////////////////////////////////////////////////

//Recycleview (No XML)
//- Antes Funcionava:   android.support.v7.widget.RecyclerView
//- Agora Só Assim:     androidx.recyclerview.widget.RecyclerView

////////////////////////////////////////////////////////////////////////////////////////////////////

//Manifest e Libs
//- Manifest:           Não Aplicável;
//- Build Gradle Mod:   RecyclerView, Embora Testei Sem e Funcionou;
//* Observação:         Se Converter P/ AndroidX, Alertas no Gradle Podem Desaparecer, Mas Objetos
//                      no XML Poderão Ñ Funcionar (aí terá que converter o objeto p/ AndroidX tb)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Lista (Estrutura)
//- Quantidade Arquivos:    7
//- Arquivos Lista:         5       View, Adapter, Entity/Model, Xml View, Xml Linha Lista
//- Arquivos Item:          2       View e Xml View

//- View:                   Java    Programação Tela        (Chama a Programação da Lista, Etc)
//- Adapter:                Java    Programação Lista       (Contem a Sub Classe Holder Tambem)
//- Entity/Model:           Java    Campos Objeto           (Com Serializable ou Parcelable)
//- Layout Tela:            XML     Lista e Outros          (ConstraintLayout e LinearLayout Juntos)
//- Layout Linha Lista:     XML     Conteúdo Linha          (LinearLayout Só)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Lista (Etapas)
//- Manifest:               Não Necessário
//- Build Gradle Project:   Não Necessário
//- Build Gradle Module:    Lib RecyclerView                (Embora Testei Sem e Funcionou)
//- Classe Entity/Model:
//- Layout Linha Lista:
//- Layout Tela Lista:
//- Classe Adapter:
//- Classe View:
//* Fazer Arqu. de Layout (XML) Antes das Classes Java, Sendo as Linhas Primeiro e Depois as Listas;
//* Fazer o Item da Lista Depois (Classe do Item e Arquivo XML do Item)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Linha Lista
//- Nome Arquivo:           Adapter Xml
//- Template - Tipo:        Constraint, Mas Poderia Ser LinearLayout, RelativeLayout, Etc;
//- Template - Tamanho:     Width (Match) e Height (Wrap)                                            ***
//* Observação:             No Layout, DEVE Ser Exibido a Simulação de 1 Linha !!!

//Lista
//- Nome Arquivo:           Activity Xml
//- Template - Tipo:        ConstraintLayout e LinearLayout (eu prefiro assim)
//- Template - Tamanho:     Width (Match) e Height (Match)                                           ***
//* Observação:             No Layout, DEVE Ser Exibido a Simulação de VÁRIAS LINHAS IGUAIS !!!

////////////////////////////////////////////////////////////////////////////////////////////////////

//XML - Tools:Context
//- Conceito:           Configuração Nos Templates do XML (Caminho da Respectiva Classe Java);
//- Observação:         No Arquivo XML de Itens da Linha Eu Não Utilizo;                             ***

//XML - Android:Id
//- Conceito:           Identificação do Template Deste Arquivo e dos Objetos Deste Arquivo;
//- Observação:         Caso Tal Objeto Não Seja Manipulado, Então Não Precisa, mas recomendado ter;

//XML - Width/Height
//- Conceito:           É o Tamanho do Template e Objetos (Width - Comprimento e Heigth - Altura)
//- Observação1:        Match (Espaço Total) ou Wrap (Só o Necessário) ou "Tamanho Definido" (-20sp)
//- Observação2:        Recomendado Utilizar o Tamanho com o "SP", Podendo Ser Positivo ou Negativo;

//XML - Posição:
//- Conceito:           É o Alinhamento e Posição dos Objetos na Tela;
//- Observação1:        Layout_Margin, Padding, Gravity, Layout_Gravity, TextAlignment
//- Observação2:        Recomendado Utilizar o Tamanho com o "SP", Podendo Ser Positivo ou Negativo
//- Observação3:        Se Utilizado o Constraint no Template e os "Apps" no Objeto, é Só Arrastar


