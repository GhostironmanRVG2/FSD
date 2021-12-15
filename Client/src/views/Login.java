package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import ops.ConVerify;;

public class Login implements ActionListener{
//LABEL IMAGEM
JLabel backb=new JLabel(new ImageIcon("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/l.png"));
  //TEXT FIELD
  JTextField textfieldip=new JTextField();
  //TEXT FIELD
  JTextField textfieldporta=new JTextField();
  //TEXT FIELD
  JTextField textfieldHASH=new JTextField();
  //criacao de janela
  JFrame janela=new JFrame();


  public void construir(){

    //LOAD ICON
    Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/icon.PNG");
    //SET IT
    janela.setIconImage(icon); 
    //TAMANHO DA JANELA
    janela.setBounds(300,0,500,400);
    //COLOCAR NO CENTRO DA TELA
    janela.setLocationRelativeTo(null);
    //DESATIVAR O BOTÃO DE AUMENTAR A JANELA
    janela.setResizable(false);
    //FECHAR O PROGRAMA NO BOTÃO 'X'
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //COLOR
    Color lil = new Color(173,216,230);
    //BACKGROUND COLOR
    janela.setBackground(Color.lightGray);
    //CRIAR PANEL
    JPanel panel=new JPanel();
    //TAMANHO DO PAINEL
    panel.setBounds(130,10,210,28);
    //CRIAR LABEL
    JLabel Titulo = new JLabel("SISTEMA DE TICKING");
    //DEFINICAO DO TEXTO
    Titulo.setFont(new Font("Italic",Font.BOLD,20));
    //Rectangulo
    JPanel borda=new JPanel();
    //SETTAR A BORDA
    borda.setBackground(Color.black);
    //SITIO 
    borda.setBounds(130,40,210,1);



    //CRIAR LABEL
    JLabel labelip = new JLabel("INTRODUZA O IP");
    //DEFINICAO DO TEXTO
    labelip.setFont(new Font("Italic",Font.BOLD,12));
    //POSICAO E TAMANHO
    labelip.setBounds(185,70,130,12);
    //TAMANHO DO TEXT FIELD DO IP
    textfieldip.setBounds(130,85,210,30);



     //CRIAR LABEL
     JLabel labelporta = new JLabel("INTRODUZA A PORTA");
     //DEFINICAO DO TEXTO
     labelporta.setFont(new Font("Italic",Font.BOLD,12));
     //POSICAO E TAMANHO
     labelporta.setBounds(170,140,135,12);
     //TAMANHO DO TEXT FIELD DA PORTA
     textfieldporta.setBounds(130,155,210,30);



     //CRIAR LABEL
     JLabel labelHASH = new JLabel("INTRODUZA A HASH");
     //DEFINICAO DO TEXTO
     labelHASH.setFont(new Font("Italic",Font.BOLD,12));
     //POSICAO E TAMANHO
     labelHASH.setBounds(175,210,135,12);
     //TAMANHO DO TEXT FIELD DA HASH
     textfieldHASH.setBounds(130,225,210,30);


    //BOTAO
    JButton b=new JButton("CONFIRMAR");
    b.setBounds(165, 280, 140, 40);
    b.setBackground(lil);
    b.addActionListener(this);
    
    //FAZER O BOTAO CLICAVEL
    backb.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent me) {
          //dispose da janela
          janela.dispose();
          //CRIAR NOVA JANELA
          TipoServico t=new TipoServico();

        }
    });
    //SELECIONAR POSI E TAMANHO
    backb.setBounds(40, 15, 32, 32);
    //SELECIONA

    //ADICIONAR LABEL AO PANEL
    panel.add(Titulo);
    //ADICIONAR COISAS a JANELA
    janela.add(panel);
    janela.add(borda);
    janela.add(labelip);
    janela.add(textfieldip);
    janela.add(labelporta);
    janela.add(textfieldporta);
    janela.add(labelHASH);
    janela.add(textfieldHASH);
    janela.add(b);
    janela.add(backb);

    janela.setLayout(null);
    janela.setVisible(true);

    }

    
    @Override
    //FUNÇÃO PARA FAZER LOGIN, VERIFICANDO SE OS CAMPOS ESTÃO TODOS PREENCHIDOS
    public void actionPerformed(ActionEvent e) {
      if(textfieldip.getText().length() > 0 && textfieldHASH.getText().length() > 0 && textfieldporta.getText().length() > 0){
        //SACAR OS DADOS DO IP
        String ip=textfieldip.getText();
        //SACAR DADOS DA PORTA
        String portastr=textfieldporta.getText();
        //INICIALIZAR DADOS COMO 0 , CASO DE EXEPTION VAI IR COMO 0 E DA SIMPLESMENTE ERRO EM BAIXO
        int porta=-1;
        try{
        porta=Integer.valueOf(portastr);
        }catch(Exception convertEx){}
        //SACAR DADOS DA HASH
        String Hash=textfieldHASH.getText();
        //CODIGO DE VERIFICACAO
        String cod_verificacao;
        //FAZER A CONEXAO
        try{
        //VERIFICAR A CONEXAO
        ConVerify conexao=new ConVerify(ip, porta,Hash);
        //BUSCAR CODIGO DE VERIFICACAO
        cod_verificacao=conexao.go();
        }catch(Exception ex){
        //CASO DE EXCEPTION ATRIBUIR UM CODIGO DE ERRO 400
        cod_verificacao="400";
        }
        //FAZER VERIFICACAO DO CODIGO DE ERRO QUE DEU
        if(cod_verificacao.equals("200")){
        //SE O CODIGO FOR 200 PASSAMOS PARA A PROXIMA WINDOW
        janela.dispose();
        TipoOperacao to = new TipoOperacao(ip,Hash,porta);
        }else{
        //MENSAGEM DE ERRO
        JOptionPane.showMessageDialog(null,"Algo deu errado com o seu login");
        
        }
      }else {
        JOptionPane.showMessageDialog(null, "Os campos tem de ser todos preenchidos!");
      }
    }


    //FUNÇÃO PARA CORRER O PROGRAMA
    public Login(){
      construir();
    }

}
