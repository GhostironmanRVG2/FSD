package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class TipoOperacao implements ActionListener{
    //Inicializar janela principal  
    JFrame janela=new JFrame();
    //Buffer
    String ops[]={"Consultar","Criar"}; 
    //COMBO BOX
    JComboBox cb=new JComboBox(ops);

    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
public void construir(){
    //TAMANHO DA JANELA
    janela.setBounds(300,0,500,250);
    //COLOCAR NO CENTRO DA TELA
    janela.setLocationRelativeTo(null);
    //DESATIVAR O BOTÃO DE AUMENTAR A JANELA
    janela.setResizable(false);
    //FECHAR O PROGRAMA NO BOTÃO 'X'
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //COLOR
    Color lil = new Color(173,216,230);
    //LOAD ICON
    Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/icon.PNG");
    //SET IT
    janela.setIconImage(icon); 
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
    op.setBounds(140,70,130,12);
    //TAMANHO DO COMBO BOX
    cb.setBounds(250,67,90,20);
    //COLOR
    cb.setBackground(lil);
    //BOTAO
    JButton b=new JButton("CONFIRMAR");
    b.setBounds(165, 120, 140, 40);
    b.setBackground(lil);
    b.addActionListener(this);

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


@Override
//FUNÇÃO PARA SELECIONAR UMA DAS OPÇÕES PARA ABRIR A RESPETIVA JANELA
public void actionPerformed(ActionEvent e) {
    String selectCB = cb.getSelectedItem().toString();
    String e1 = "Consultar";
    String e2 = "Criar";
    if(selectCB.equals(e1)){
      janela.dispose();
      ListarServicos ls = new ListarServicos();
    }else if (selectCB.equals(e2)){
      janela.dispose();
      CriarServicos cs = new CriarServicos();
    }
}

//FUNÇÃO PARA EXECUTAR O PROGRAMA
public TipoOperacao(){
  construir();
}

}
