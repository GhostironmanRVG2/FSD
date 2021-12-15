package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TipoServico implements ActionListener{

//Inicializar janela principal  
JFrame janela=new JFrame();
//BOTAO
JButton b=new JButton("CONFIRMAR");
//Buffer
String ops[]={"Registo","Login","Servico"}; 
//COMBO BOX
JComboBox cb=new JComboBox(ops);
//METODO QUE VAI CONSTRUIR A NOSSA JANELA
public void construir(){
    //LOAD ICON
    Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/icon.PNG");
    //SET IT
    janela.setIconImage(icon);
    Color lil = new Color(173,216,230);
    //TAMANHO DA JANELA
    janela.setBounds(300,0,500,250);
    //COLOCAR NO CENTRO DA TELA
    janela.setLocationRelativeTo(null);
    //DESATIVAR O BOTÃO DE AUMENTAR A JANELA
    janela.setResizable(false);
    //FECHAR O PROGRAMA NO BOTÃO 'X'
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //CRIAR PANEL
    JPanel panel=new JPanel();
    //TAMANHO DO PAINEL
    panel.setBounds(150,10,174,28);
    //CRIAR LABEL
    JLabel Titulo = new JLabel("TIPO DE SERVICO");
    //DEFINICAO DO TEXTO
    Titulo.setFont(new Font("Italic",Font.BOLD,20));
    //Rectangulo
    JPanel borda=new JPanel();
    //SETTAR A BORDA
    borda.setBackground(Color.black);
    //SITIO 
    borda.setBounds(150,40,174,1);
    //Texto op
    JLabel op=new JLabel("SELECIONE UMA:");
    //DEF DE TEXTO
    op.setFont(new Font("Italic",Font.BOLD,12));
    //POSICAO E TAMANHO DO TEXTO
    op.setBounds(130,70,130,12);
    //Tamanho
    cb.setBounds(250,67,90,20);
    //COLOR
    cb.setBackground(lil);
    //BOTAO
    b.setBounds(165, 120, 140, 40);
    //LER O BOTAO
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
//AO CARREGAR NO BOTAO O SISTEMA VERIFICA O SELECIONADO NA COMBOBOX E ABRE A RESPETIVA JANELA
public void actionPerformed(ActionEvent e) {
  //GET DO VALOR SELECIONADO NA COMBOBOX
  String selectedValue = cb.getSelectedItem().toString();
  String e1 = "Registo";
  String e2 = "Login";
  String e3 = "Servico"; 
  //CASO SEJA IGUAL A "REGISTO" ABRE UMA NOVA JANELA E ELIMINA A ATUAL 
  if(e1.equals(selectedValue)){
    janela.dispose();
    SisIdenti s=new SisIdenti();
  }
  //CASO SEJA IGUAL A "LOGIN" ABRE UMA NOVA JANELA E ELIMINA A ATUAL
  else if(e2.equals(selectedValue)){
    janela.dispose();
    Login login = new Login();
  }
  //CASO SEJA IGUAL A "SERVICO" ABRE UMA NOVA JANELA E ELIMINA A ATUAL
  else if(e3.equals(selectedValue)){
    janela.dispose();
    Servico servico = new Servico();
  }
}
//FUNÇÃO PARA CORRER A JANELA
public TipoServico(){
construir();
}

}


