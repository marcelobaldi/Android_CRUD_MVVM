package mb.novo.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import mb.novo.databinding.ActivityPostagemBinding;
import mb.novo.model.PostagemModel;

public class PostagemActivity extends AppCompatActivity {
    //Atributos
    private ActivityPostagemBinding binding;
    private PostagemModel           postagemModel;

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Tela Binding
        binding = ActivityPostagemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Receber Objetos
        Intent intentVindo = getIntent();
        if(intentVindo.getExtras() != null){
            //Objeto - Receber
            postagemModel = (PostagemModel) intentVindo.getExtras().getSerializable("chavePostagem");

            //Objeto - Manipular (Setar)
//            binding.cliTxtTituloXml.setText("Cliente");
//            binding.cliEdtIdXml.setText(String.valueOf(clienteModel.getId()));
//            binding.cliEdtNomeXml.setText(clienteModel.getNome());
//            binding.cliEdtIdadeXml.setText(String.valueOf(clienteModel.getIdade()));
//            binding.cliImgImagem1Xml.setImageResource(clienteModel.getImagem());

            //Objeto - Manipular (Evento)
            binding.cliBtnSalvarXml.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Botão Salvar", Toast.LENGTH_LONG).show();
            }});
        }
    }

    //Obeto - Manipular (Evento)
    public void cli_btn_deletar_xml(View view) {
        Toast.makeText(getBaseContext(), "Botão Deletar", Toast.LENGTH_LONG).show();
    }
}



