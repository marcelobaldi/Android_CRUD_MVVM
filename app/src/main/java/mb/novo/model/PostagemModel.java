package mb.novo.model;               //Pacote    Caminho Arquivo
import java.io.Serializable;         //CI        Serializable

public class PostagemModel implements Serializable {
    //Atributos
    private String userId;
    private String id;
    private String title;
    private String body;

    //Construtor (Vazio, Sem Id, Com Id)
    public PostagemModel() { }
    public PostagemModel(String userId, String title, String body) { this.userId = userId; this.title = title; this.body = body; }
    public PostagemModel(String userId, String id, String title, String body) { this.userId = userId; this.id = id; this.title = title; this.body = body; }

    //GetterSetter
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    //To String
    @Override public String toString() {
        return "PostagemModel{" + "userId='" + userId + '\'' + ", id='" + id + '\'' + ", title='" + title + '\'' + ", body='" + body + '\'' + '}';
    }
}


//Classe Entity/Model
//- Herança:            Serializable/Parcelable, P/ Poder Passar Objeto Instanciado Entre Activies;
//- Atributos:          Private e Campos (UserId, Id, Etc);
//- Construtor(3):      Vazio, Sem ID - Salvar, Com ID - Atualizar. Não Colocar Listas;
//- GetterSetter:       Dos Atributos Private (Inclusive das Listas);
//- Métodos Normais:    Void ou Return
//- Métodos Lista:      CRUD (Adicionar Item, Remover Item, Etc);
//- Método ToString:    Debugar Objeto Instanciado, Bem Como a Lista Deste Objeto;
//- Observação:         Em Alguns Projetos o Entity é Soh os Campos e o Model Possui Tratamentos;







//contem as informações buscadas. colocar nome conforme api. não precisa todos os ddados retornados (gia, ddd, etc)

//
//    {
//            "cep": "01001-000",
//            "logradouro": "Praça da Sé",
//            "complemento": "lado ímpar",
//            "bairro": "Sé",
//            "localidade": "São Paulo",
//            "uf": "SP",
//            "ibge": "3550308",
//            "gia": "1004",
//            "ddd": "11",
//            "siafi": "7107"
//            }


