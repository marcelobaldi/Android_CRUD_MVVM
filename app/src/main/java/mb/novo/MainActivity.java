package mb.novo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import mb.novo.view.PostagemListaActivity;

public class MainActivity extends AppCompatActivity {
    //Atributos
    //...

    @Override protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        //Tela Inicial
        setContentView(R.layout.activity_main);

        //Redirecionamento
        Intent intentX = new Intent(this, PostagemListaActivity.class);
        startActivity(intentX);
        //startActivity(new Intent(this, LsCliActivity.class));
    }
}


//view model trata os dados. outros não ?!?!


//Estrutura Pastas
//Helper/Utils:             Suporte, Úteis, Etc
//Model/Entity:             Objetos
//API:                      Dados Externos
//Repository:               Dados Projeto (Internos e Externos)
//ViewModel:                Tratamento Dados
//Adapter:                  Listas
//View:                     Telas



//Tecnologias
//- Design Patterns:        MVVM
//- Identificar Objetos:    View Binding
//- Layout XML:             Data Binding
//- Camadas Projeto:        Live Data
//- Camdas Telas:           Serializable
//- Métodos Assíncronos:    Observer
//- Listas:                 RecyclerView
//- API:                    Retrofit



//Estrutura
//- Projeto:        MVVM Básico             (Sem Lista e Sem API)
//- Manifest:       Configurações App       (Permissões, Telas, Tela Inicial, Ícone, Etc)
//- Build Gradle:   Config e Libs App       (SDK Mínimo, Dependências, Etc)
//* DataBind:       Recursos Tela           (Programação Na Tela e Identificação Otimizada Tela)
//* LiveData:       Recursos Projeto        (Trabalhar com Camadas)

//- Main:           Arquivo Inicial         (Configurado no Manifest)
//- Model's:        Objetos Manipulados     (Usuários, Clientes, Funcionários, Produtos, Etc)
//- Repository's:   Dados                   (Fixos, Buscados BD, Buscados API's, Etc)
//- View Model's:   Tratamento Dados        (Pega Dados dos Repository's)
//- View's:         Exibição Tela           (Pega Dados das View's Model's)
//- Adapter's:      Programação Lista       (Manipulação das Listas e Item's das Listas)

//- lista = declarar como lista e instanciar como arraylist ou list;
//- livedadta = delcarar como mutable, pois pode modificar (setar);
//- evendtos  = setonclick ou onclick no objeto ou data bind  = 3 formas;

//Quando Copiar código !!!
//- sincronizar gradle, aí funcionou o constraint na tela .. !!!!
//activyt no manifest