package mb.novo.viewmodel;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.List;

import mb.novo.model.PostagemModel;
import mb.novo.repository.PostagemRepository;

public class PostagemViewModel extends ViewModel {
    //Atributos - Model e Repositório
    PostagemModel       postagemModel       = new PostagemModel();
    PostagemRepository  postagemRepository  = new PostagemRepository();

    //Atributos - Retornos do Repositório
    public MutableLiveData<String>                 postagemSalvar       = new MutableLiveData<>();
    MutableLiveData<List<PostagemModel>>    postagemBuscarTodos  = new MutableLiveData<>();
    MutableLiveData<PostagemModel>          postagemBuscarPorId  = new MutableLiveData<>();
    MutableLiveData<Boolean>                isLoading            = new MutableLiveData<>(false);

    //Método Salvar         (Retorno String)                           // Antes Verificar Se Já Existe ????
    public LiveData<String> salvarVM(PostagemModel postagemModel){
        postagemSalvar = postagemRepository.salvarRepository(postagemModel);
        return postagemSalvar;
    }

    //Método Buscar Todos   (Retorno Lista)
    public LiveData<List<PostagemModel>> buscarTodosVM(){
        postagemBuscarTodos = postagemRepository.buscarTodosRepository();
        return postagemBuscarTodos;
    }

    //Método Buscar Por Id  (Retorno Objeto)
    public LiveData<PostagemModel> buscarPorIdVM(Integer idV){
        isLoading.setValue(true);

        postagemBuscarPorId = postagemRepository.buscarPorIdRepository(idV);

        Log.d("meuLog223", String.valueOf(postagemBuscarPorId)); // Observer aqui ?!?
        if(postagemBuscarPorId == null){                                      // ???????????????????????
            Log.d("meuLog223", "Não Encontraddddoooo");
        }
        return postagemBuscarPorId;
    }











    //Método Saudação       (Retorno String)
//    public LiveData<String> saudacaoVM(){
//        msgSaudacao = clienteRepository.saudacaoRepository();
//        if(msgSaudacao.getValue().isEmpty()){
//            String msg = "Não Tem Mensagens!";
//            msgSaudacao.setValue(msg);
//        }
//        return msgSaudacao;
//    }
//
//    //Método Buscar Por ID  (Retorno Objeto)
//    public LiveData<ClienteModel>buscaPorIdVM(Integer idV){
//        clientePorId = clienteRepository.buscaPorIdRepository(idV);
//        if(clientePorId == null){
//            return clientePorId;
//        }else{
//            clienteModel.setId(clientePorId.getValue().getId());
//            clienteModel.setNome(clientePorId.getValue().getNome());
//            clientePorId.setValue(clienteModel);
//        }
//        return clientePorId;
//    }


}


//tratamentos aqui ?!?!?!




//  Log.d("meuLogA", clienteRepository.saudacaoRepository());
//  Log.d("meuLogA", clienteRepository.saudacaoRepository().getValue().toString());

//  Log.d("meuLogA", clienteRepository.buscaPorIdRepository(2).getValue().toString());
//  Log.d("meuLogA", clienteRepository.buscaPorIdRepository(2).getValue().getNome().toString());

//  Log.d("meuLogA", clienteRepository.buscarTodosRepository().getValue().toString());
//  Log.d("meuLogA", clienteRepository.buscarTodosRepository().getValue().get(0).getNome().toString());


