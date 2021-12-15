package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
public class Servico implements ActionListener{
<<<<<<< HEAD
//LABEL IMAGEM
JLabel backb=new JLabel(new ImageIcon("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/l.png"));
=======
        //Inicializar janela principal  
        JFrame janela=new JFrame();
>>>>>>> 947a1826c720367afdea6808d5768b84f3aaa317
        //TEXT FIELD USER
        JTextField t_ip=new JTextField();
        //TEXT FIELD CC
        JTextField t_ts=new JTextField();
        //COMBOBOX TIPO DE CONEXAO
        String s1[] = { "SOCKET", "RMI"};
        JComboBox c_tipo=new JComboBox(s1);

    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
    public void construir(){
        //LOAD ICON
        Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/icon.PNG");
        //SET IT
        janela.setIconImage(icon);
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
        JLabel Titulo = new JLabel("SERVICO");
        //DEFINICAO DO TEXTO
        Titulo.setFont(new Font("Italic",Font.BOLD,20));
        Titulo.setSize(100, 100);

        //Rectangulo
        JPanel borda=new JPanel();
        //SETTAR A BORDA
        borda.setBackground(Color.black);
        //SITIO 
        borda.setBounds(190,40,80,1);

        //Texto op USER
        JLabel j_ip=new JLabel("INTRODUZA O IP DO SERVICO:");
        //DEF DE TEXTO
        j_ip.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_ip.setBounds(130,70,200,12);

        //TAMANHO DO TEXT FIELD DO IP
        t_ip.setBounds(130,85,210,30);

        //LABEL CC 
        JLabel j_ts=new JLabel("INTRODUZA O TIMESTAMP:");
        //DEF DE TEXTO
        j_ts.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_ts.setBounds(130,135,200,12);
                
        //TAMANHO DO CC
        t_ts.setBounds(130,150,210,30);

        //LABEL CC 
        JLabel j_tipo=new JLabel("TIPO DE CONEXAO:");
        //DEF DE TEXTO
        j_tipo.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_tipo.setBounds(130,200,200,12);

        //TAMANHO DO COMBOBOX
        c_tipo.setBounds(130, 215, 210, 30);


        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 265, 140, 40);
        b.setBackground(lil);
        //LER O BOTAO
        b.addActionListener(this);

        //LABEL HASH
        JLabel j_resp=new JLabel("RESPOSTA DO SERVIDOR:");
        //DEF DE TEXTO
        j_resp.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_resp.setBounds(130,330,200,30);

        //TEXT FIELD RESPOSTA COM HASH
        JTextField t_resp = new JTextField();
        //TAMANHO
        t_resp.setBounds(130, 360, 210, 30);

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
        //ADICIONAR LABEL AO PANEL
        panel.add(Titulo);
        //ADICIONAR ITENS NA JANELA
        janela.add(panel);
        janela.add(borda);
        janela.add(b);
        janela.add(j_ip);
        janela.add(t_ip);
        janela.add(t_ts);
        janela.add(j_ts);
        janela.add(j_resp);
        janela.add(t_resp); 
        janela.add(j_tipo);
        janela.add(c_tipo);
        janela.add(backb);
        janela.setLayout(null);
        janela.setVisible(true);

    }


    @Override
    //FUNÇÃO PARA VERIFICAR SE OS CAMPOS ESTÃO TODOS PREENCHIDOS
    public void actionPerformed(ActionEvent e) {
        if (t_ip.getText().length() > 0 && t_ts.getText().length() > 0){
            String tipoconex = c_tipo.getSelectedItem().toString();
            
        } else {
            JOptionPane.showMessageDialog(null, "Os campos tem de ser todos preenchidos!");

        }
        

    }

    //FUNÇÃO PARA CORRER O PROGRAMA
    public Servico(){
        construir();
    }


}