package mb.novo.repository;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import mb.novo.R;
import mb.novo.api.PostagemAPI;
import mb.novo.model.PostagemModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostagemRepository {
    //Atributos - Diversos
    private List<PostagemModel> listaPostagens  = new ArrayList<>();
    private final PostagemAPI   postagemAPI;

    //Atributos - LiveData (Tipos de Retorno)
    private MutableLiveData<String>                 salvarLiveData        = new MutableLiveData<>();
    private MutableLiveData<List<PostagemModel>>    buscarTodosLiveData   = new MutableLiveData<>();
    private MutableLiveData<PostagemModel>          buscarPorIdLiveData   = new MutableLiveData<>();

    //Construtor
    public PostagemRepository() {
        Retrofit postagemRetrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();
            postagemAPI = postagemRetrofit.create(PostagemAPI.class);
    }

    //Salvar                Retorna String
    public MutableLiveData<String> salvarRepository(PostagemModel postagemModelX){
        Call<PostagemModel> callSalvar = postagemAPI.salvarPostagem(postagemModelX);
        callSalvar.enqueue(new Callback<PostagemModel>() {
            @Override public void onResponse(Call<PostagemModel> call, Response<PostagemModel> responseX) {
                if(responseX.isSuccessful()){
                    PostagemModel postagemResposta = responseX.body();
                    Log.d("meuLogS_R", String.valueOf(responseX.code()));
                    Log.d("meuLogS_R", postagemResposta.toString());
                    salvarLiveData.setValue("Postagem Salva com Sucesso!");
                } else {
                    salvarLiveData.setValue(null);                                                   // ***
                }
            }
            @Override public void onFailure(Call<PostagemModel> call, Throwable t) {
                Log.d("meuLog", t.toString());
            }
        });
        return salvarLiveData;
    }

    //Buscar Todos          Retorna Lista
    public MutableLiveData<List<PostagemModel>> buscarTodosRepository(){
        Call<List<PostagemModel>> callBuscarTodos = postagemAPI.buscarTodosPostagem();
        callBuscarTodos.enqueue(new Callback<List<PostagemModel>>() {
            @Override public void onResponse(Call<List<PostagemModel>> call, Response<List<PostagemModel>> responseX) {
                if(responseX.isSuccessful()){
                    listaPostagens = responseX.body();
                    Log.d("meuLogBT_R", listaPostagens.toString());
                    buscarTodosLiveData.setValue(listaPostagens);
                } else {
                    buscarTodosLiveData.setValue(null);
                }
            }
            @Override public void onFailure(Call<List<PostagemModel>> call, Throwable t) {
                Log.d("meuLog", "Erro Inesperado");
            }
        });
        return buscarTodosLiveData;
    }

    //Buscar Especifico     Retorna Objeto
    public MutableLiveData<PostagemModel> buscarPorIdRepository(Integer idV) {
        Call<PostagemModel> callBusca = postagemAPI.buscarPorIdPostagem(idV);
        callBusca.enqueue(new Callback<PostagemModel>() {
            @Override
            public void onResponse(Call<PostagemModel> call, Response<PostagemModel> responseX) {
                if (responseX.isSuccessful()) {
                    PostagemModel postagem = responseX.body();
                    Log.d("meuLogBE_R", postagem.toString());
                    buscarPorIdLiveData.setValue(postagem);
                } else {
                    buscarPorIdLiveData.setValue(null);
                }
            }
            @Override public void onFailure(Call<PostagemModel> call, Throwable t) {
                Log.d("meuLog", "Erro Inesperado" + " " + t.toString());
            }
        });
        return buscarPorIdLiveData;
    }







//    //Método - Variável
//    public MutableLiveData<String> saudacaoRepository(){
//        saudacaoLiveData.setValue("Bom Dia!");                      //setar livedata !!!
//        return saudacaoLiveData;
//    }
//
//    //Método - Objeto Model
//    public MutableLiveData<ClienteModel> buscaPorIdRepository(Integer idV){
//        if(idV == 10){
//            clienteModel.setId(idV);
//            clienteModel.setNome("Marcelo");
//        }
//
//        buscarPorIdLiveData.setValue(clienteModel);
//        return buscarPorIdLiveData;
//    }
//
//
}

//Live Data:
//- Objetivo:   Trabalhar com Camadas (Controllers, ViewModels, Etc) e com Métodos Assíncronos;
//- Tipos:      LiveData (Imútável - Nâo Permite o .SetValue) e MutableLiveData (Mutável);


//private final MutableLiveData<String>             saudacaoLiveData    = new MutableLiveData<>();
//private final MutableLiveData<ClienteModel>       buscarPorIdLiveData = new MutableLiveData<>();
//private final MutableLiveData<List<ClienteModel>> buscarTodosLiveData = new MutableLiveData<>();




