package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import ops.*;
import javax.swing.*;
import java.awt.event.*;
public class ListarServicos implements ActionListener{
    //INICIALIZAR PARAMETROS CONSTANTES
    String ip,hash;
    int porta;
    //LABEL IMAGEM
    JLabel backb=new JLabel(new ImageIcon("./views/assets/l.png"));
    //Inicializar janela principal  
    JFrame janela=new JFrame();
    //COMBOBOX TIPO DE CONEXAO
    String s1[] = {"RMI", "SOCKET"};
    JComboBox c_tipo=new JComboBox(s1);
    //criar painel
    JPanel panel_scroll = new JPanel();
    //LISTA
    DefaultListModel<String> lista=new DefaultListModel<String>();
    //lista onde inserimos a list
    final JList<String> list = new JList<String>(lista);
    //scrollpane
    JScrollPane scrollPane = new JScrollPane();
    //TEXT AREA
    JTextArea a=new JTextArea();
    
    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
    public void construir(){
        //LOAD ICON
        Image icon = Toolkit.getDefaultToolkit().getImage("./views/assets/icon.PNG");
        //SET IT
        janela.setIconImage(icon);
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
         //FAZER COM QUE SEJA SCROLLABEL
         scrollPane.setViewportView(list);
         //TAMANHO DO PANEL
         scrollPane.setBounds(0,0,380,200);
         list.setLayoutOrientation(JList.VERTICAL);
         //TAMANHO DO PANEL
         panel_scroll.setBounds(40,200,400,200);
         //ADICIONAR O SCROLL AO PANEL
         panel_scroll.add(scrollPane);
        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 360, 140, 40);
        b.setBackground(lil);
        //LER O BOTÃO
        b.addActionListener(this);

        //SET POS
        a.setBounds(110,410,250,18);

        //FAZER O BOTAO CLICAVEL
        backb.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            //dispose da janela
            janela.dispose();
            //CRIAR NOVA JANELA
            TipoOperacao t=new TipoOperacao(ip,hash,porta);
  
          }
        });
        //SELECIONAR POSI E TAMANHO
        backb.setBounds(40, 15, 32, 32);

        //ADICIONAR LABEL AO PANEL
        panel.add(Titulo);
        //ADICIONAR ITENS NA JANELA
        janela.add(panel);
        janela.add(borda);
        janela.add(b);
        janela.add(j_resp);
        janela.add(j_tipo);
        janela.add(c_tipo);
        janela.add(panel_scroll);
        janela.add(a);
        janela.add(backb);

        janela.setLayout(null);
        janela.setVisible(true);

    }



    @Override
    //FUNÇÃO PARA GUARDAR A OPÇÃO SELECIONADA NA COMBOBOX
    public void actionPerformed(ActionEvent e) {
        //BUSCAR OP
        String tipo = c_tipo.getSelectedItem().toString();
        //INIT OPCOES
        String op1="RMI";
        String op2="SOCKET";
        if(op1.equals(tipo)){
        //INICIALIZAR O OBJETO QUE CONECTA AO SERVIDOR DE IDENTIFICACAO
        One one=new One(ip,porta,hash,1);
        //RESULTADO E INSERIR RESULTADO NA LISTA
        try {
            List result=one.go();
            lista.clear();
        //INSERIOR O RESULTADO NUMA LISTA
        for (int i = 0; i < result.size(); i++) {
            lista.addElement((String)result.get(i));
        }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        }else{
//INICIALIZAR O OBJETO QUE CONECTA AO SERVIDOR DE IDENTIFICACAO
One one=new One(ip,porta,hash,2);
//RESULTADO E INSERIR RESULTADO NA LISTA
try {
    List result=one.go();
    lista.clear();
//INSERIOR O RESULTADO NUMA LISTA
for (int i = 0; i < result.size(); i++) {
    lista.addElement((String)result.get(i));
}
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}

        }

        //SETTAR TEXTO COM TIMESTAMP
 a.setText("TimeStamp:"+Instant.now());
    }

    //FUNÇÃO PARA EXECUTAR O PROGRAMA
    public ListarServicos(String ip,int porta,String hash){
        this.ip=ip;
        this.porta=porta;
        this.hash=hash;
        construir();
    }
}