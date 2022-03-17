package mb.novo.api;
import java.util.List;

import mb.novo.model.PostagemModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostagemAPI {
        //Salvar
        @POST("/posts")
        Call<PostagemModel> salvarPostagem (@Body PostagemModel postagemmodel);

        //Buscar Todos
        @GET("/posts")
        Call<List<PostagemModel>> buscarTodosPostagem();

        //Buscar Específico
        @GET("/posts/{idVindo}")
        Call<PostagemModel> buscarPorIdPostagem(@Path("idVindo") int id);

        //Atualizar (Tudo)
        @PUT("/posts/{idVindo}")
        Call<PostagemModel> atualizarTudoPostagem(@Path("idVindo") int id, @Body PostagemModel postagemModel);

        //Atualizar (Só Campos Enviados)
        @PATCH("/posts/{idVindo}")
        Call<PostagemModel> atualizarEnviadoPostagem(@Path("idVindo") int id, @Body PostagemModel postagemModel);

        //Deletar
        @DELETE("/posts/{idVindo}")
        Call<Void> deletarPostagem(@Path("idVindo") int id);
}

//como fazer vindo soh o objeto já com o id, e não o id separado ?????????????????????????????????

// call, Body, Path, etc deve ser do retrofit
//call busca dados e coloca na model;
//model armazena os dados;




//classe interface. Se implemandada, obriga seus métodos ou se instanciada, já tras seus métodos !!!!!!


//se fosse uma lista retornada, então seria um array list, e não a classe model !!!!!!!!!!!!!!!!!!!!!!!!!!!!!1