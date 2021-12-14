package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class ListarServicos implements ActionListener{

    //Inicializar janela principal  
    JFrame janela=new JFrame();
    //COMBOBOX TIPO DE CONEXAO
    String s1[] = {"HUMIDADE", "TEMPERATURA"};
    JComboBox c_tipo=new JComboBox(s1);

    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
    public void construir(){
        //COLOCAR NO CENTRO DA TELA
        janela.setLocationRelativeTo(null);
        //DESATIVAR O BOTÃO DE AUMENTAR A JANELA
        janela.setResizable(false);
        //FECHAR O PROGRAMA NO BOTÃO 'X'
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TAMANHO DA JANELA
        janela.setBounds(300,0,500,480);
        //COLOCAR NO CENTRO DA TELA
        janela.setLocationRelativeTo(null);
        //DESATIVAR O BOTÃO DE AUMENTAR A JANELA
        janela.setResizable(false);
        //FECHAR O PROGRAMA NO BOTÃO 'X'
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //BACKGROUND COLOR
        janela.setBackground(Color.lightGray);

        //COLOR
        Color lil = new Color(173,216,230);

        //CRIAR PANEL
        JPanel panel=new JPanel();
        //TAMANHO DO PAINEL
        panel.setBounds(80,10,300,28);

        //CRIAR LABEL
        JLabel Titulo = new JLabel("LISTA DE SERVICOS");
        //DEFINICAO DO TEXTO
        Titulo.setFont(new Font("Italic",Font.BOLD,20));
        Titulo.setSize(100, 100);

        //Rectangulo
        JPanel borda=new JPanel();
        //SETTAR A BORDA
        borda.setBackground(Color.black);
        //SITIO 
        borda.setBounds(130,40,200,1);

        //LABEL CC 
        JLabel j_tipo=new JLabel("TIPO DE CONEXAO:");
        //DEF DE TEXTO
        j_tipo.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_tipo.setBounds(180,80,200,12);

        //TAMANH0 DO COMBOBOX
        c_tipo.setBounds(130, 95, 210, 30);

        //LABEL HASH
        JLabel j_resp=new JLabel("RESPOSTA DO SERVIDOR:");
        //DEF DE TEXTO
        j_resp.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_resp.setBounds(160,160,200,30);

        //TEXT FIELD RESPOSTA COM HASH
        JTextField t_resp = new JTextField();
        //TAMANHO
        t_resp.setBounds(130, 190, 210, 100);

        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 360, 140, 40);
        b.setBackground(lil);
        //LER O BOTÃO
        b.addActionListener(this);

        //ADICIONAR LABEL AO PANEL
        panel.add(Titulo);
        //ADICIONAR ITENS NA JANELA
        janela.add(panel);
        janela.add(borda);
        janela.add(b);
        janela.add(j_resp);
        janela.add(t_resp); 
        janela.add(j_tipo);
        janela.add(c_tipo);

        janela.setLayout(null);
        janela.setVisible(true);

    }



    @Override
    //FUNÇÃO PARA GUARDAR A OPÇÃO SELECIONADA NA COMBOBOX
    public void actionPerformed(ActionEvent e) {
        String tipo = c_tipo.getSelectedItem().toString();
        
    }

    //FUNÇÃO PARA EXECUTAR O PROGRAMA
    public ListarServicos(){
        construir();
    }
}