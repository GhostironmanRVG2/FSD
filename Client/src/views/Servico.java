package views;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Servico{
    public Servico(){}
    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
    public void construir(){
        //Inicializar janela principal  
        JFrame janela=new JFrame();
        //TAMANHO DA JANELA
        janela.setBounds(300,0,500,480);
        //BACKGROUND COLOR
        janela.setBackground(Color.lightGray);

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

        //TEXT FIELD USER
        JTextField t_ip=new JTextField();
        //TAMANHO
        t_ip.setBounds(130,85,210,30);

        //LABEL CC 
        JLabel j_ts=new JLabel("INTRODUZA O TIMESTAMP:");
        //DEF DE TEXTO
        j_ts.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_ts.setBounds(130,135,200,12);
                
        //TEXT FIELD CC
        JTextField t_ts=new JTextField();
        //TAMANHO
        t_ts.setBounds(130,150,210,30);

        //LABEL CC 
        JLabel j_tipo=new JLabel("TIPO DE CONEXAO:");
        //DEF DE TEXTO
        j_tipo.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_tipo.setBounds(130,200,200,12);

        //COMBOBOX TIPO DE CONEXAO
        String s1[] = { "SOCKET", "RMI"};
        JComboBox c_tipo=new JComboBox(s1);
        c_tipo.setBounds(130, 215, 210, 30);


        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 265, 140, 40);
        b.setBackground(Color.GRAY);

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

        janela.setLayout(null);
        janela.setVisible(true);

    }

}