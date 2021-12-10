package views;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class TipoOperacao {
    public TipoOperacao(){}

    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
public void construir(){
    //Inicializar janela principal  
    JFrame janela=new JFrame();
    //TAMANHO DA JANELA
    janela.setBounds(300,0,500,250);
    //BACKGROUND COLOR
    janela.setBackground(Color.lightGray);
    //CRIAR PANEL
    JPanel panel=new JPanel();
    //TAMANHO DO PAINEL
    panel.setBounds(140,10,200,28);
    //CRIAR LABEL
    JLabel Titulo = new JLabel("TIPO DE OPERACAO");
    //DEFINICAO DO TEXTO
    Titulo.setFont(new Font("Italic",Font.BOLD,20));
    //Rectangulo
    JPanel borda=new JPanel();
    //SETTAR A BORDA
    borda.setBackground(Color.black);
    //SITIO 
    borda.setBounds(140,40,200,1);
    //Texto op
    JLabel op=new JLabel("SELECIONE UMA:");
    //DEF DE TEXTO
    op.setFont(new Font("Italic",Font.BOLD,12));
    //POSICAO E TAMANHO DO TEXTO
    op.setBounds(130,70,130,12);
    //Buffer
    String ops[]={"Consultar","Criar"}; 
    //COMBO BOX
    JComboBox cb=new JComboBox(ops);
    //Tamanho
    cb.setBounds(250,67,90,20);
    //BOTAO
    JButton b=new JButton("CONFIRMAR");
    b.setBounds(165, 120, 140, 40);
    b.setBackground(Color.GRAY);

    //ADICIONAR LABEL AO PANEL
    panel.add(Titulo);
    //ADICIONAR ITENS NA JANELA
    janela.add(panel);
    janela.add(borda);
    janela.add(op);
    janela.add(cb);
    janela.add(b);

    janela.setLayout(null);
    janela.setVisible(true);
}
}
