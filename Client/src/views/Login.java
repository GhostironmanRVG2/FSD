package views;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
    public Login(){}

    public void construir(){
    //criacao de janela
    JFrame janela=new JFrame();
      //LOAD ICON
      Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/icon.PNG");
      //SET IT
      janela.setIconImage(icon); 
    //TAMANHO DA JANELA
    janela.setBounds(300,0,500,400);
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
    //TEXT FIELD
    JTextField textfieldip=new JTextField();
    //TAMANHO
    textfieldip.setBounds(130,85,210,30);



     //CRIAR LABEL
     JLabel labelporta = new JLabel("INTRODUZA A PORTA");
     //DEFINICAO DO TEXTO
     labelporta.setFont(new Font("Italic",Font.BOLD,12));
     //POSICAO E TAMANHO
     labelporta.setBounds(170,140,135,12);
     //TEXT FIELD
     JTextField textfieldporta=new JTextField();
     //TAMANHO
     textfieldporta.setBounds(130,155,210,30);



     //CRIAR LABEL
     JLabel labelHASH = new JLabel("INTRODUZA A HASH");
     //DEFINICAO DO TEXTO
     labelHASH.setFont(new Font("Italic",Font.BOLD,12));
     //POSICAO E TAMANHO
     labelHASH.setBounds(175,210,135,12);
     //TEXT FIELD
     JTextField textfieldHASH=new JTextField();
     //TAMANHO
     textfieldHASH.setBounds(130,225,210,30);


    //BOTAO
    JButton b=new JButton("CONFIRMAR");
    b.setBounds(165, 280, 140, 40);
    b.setBackground(lil);
     

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

    janela.setLayout(null);
    janela.setVisible(true);


    }
}
