package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ops.Two;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CriarServicos implements ActionListener{
    String ip,hash;
    int porta;
    //COMBOBOX TIPO DE CONEXAO
    String s1[] = {"RMI", "SOCKET"};
    JComboBox c_tipo=new JComboBox(s1);
    //LABEL IMAGEM
    JLabel backb=new JLabel(new ImageIcon("./views/assets/l.png"));
    //TEXT FIELD
    JTextField textfieldservice=new JTextField();
    //TEXT FIELD
    JTextField textfieldip=new JTextField();

    public void construir(){
        //criacao de janela
        JFrame janela=new JFrame();
        //COLOCAR NO CENTRO DA TELA
        janela.setLocationRelativeTo(null);
        //DESATIVAR O BOTÃO DE AUMENTAR A JANELA
        janela.setResizable(false);
        //FECHAR O PROGRAMA NO BOTÃO 'X'
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //LOAD ICON
        Image icon = Toolkit.getDefaultToolkit().getImage("./views/assets/icon.PNG");
        //COLOR
        Color lil = new Color(173,216,230);
        //SET IT
        janela.setIconImage(icon); 
        //TAMANHO DA JANELA
        janela.setBounds(300,0,500,330);
        //BACKGROUND COLOR
        janela.setBackground(Color.lightGray);
        //CRIAR PANEL
        JPanel panel=new JPanel();
        //TAMANHO DO PAINEL
        panel.setBounds(120,10,240,28);
        //CRIAR LABEL
        JLabel Titulo = new JLabel("CRIACAO DE SERVICOS");
        //DEFINICAO DO TEXTO
        Titulo.setFont(new Font("Italic",Font.BOLD,20));
        //Rectangulo
        JPanel borda=new JPanel();
        //SETTAR A BORDA
        borda.setBackground(Color.black);
        //SITIO 
        borda.setBounds(120,40,240,1);
    
    
    
        //CRIAR LABEL
        JLabel labelservice = new JLabel("NOME DO SERVICO");
        //DEFINICAO DO TEXTO
        labelservice.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO
        labelservice.setBounds(175,70,130,12);
        //TAMANHO DO TEXT FIELD DO SEVIÇO
        textfieldservice.setBounds(130,85,210,30);
    
    
    
         //CRIAR LABEL
         JLabel labelip = new JLabel("INTRODUZA O ENDERECO IP");
         //DEFINICAO DO TEXTO
         labelip.setFont(new Font("Italic",Font.BOLD,12));
         //POSICAO E TAMANHO
         labelip.setBounds(150,140,200,12);
         //TAMANHO DO TEXT FIELD DO IP
         textfieldip.setBounds(130,155,210,30);

         //TAMANH0 DO COMBOBOX
        c_tipo.setBounds(130, 200, 210, 30);
    
    
    
        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 235, 140, 40);
        b.setBackground(lil);
        //LER O BOTÃO
        b.addActionListener(this);
         
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
        //ADICIONAR COISAS a JANELA
        janela.add(panel);
        janela.add(borda);
        janela.add(labelservice);
        janela.add(textfieldservice);
        janela.add(labelip);
        janela.add(textfieldip);
        janela.add(b);
        janela.add(backb);
        janela.add(c_tipo);
    
        janela.setLayout(null);
        janela.setVisible(true);
    
    
        }


        @Override
        //FUNÇÃO PARA CRIAR UM SERVIÇO, VERIFICANDO SE OS ESPAÇOS ESTÃO PREENCHIDOS
        public void actionPerformed(ActionEvent e) {
            if(textfieldip.getText().length() > 0 && textfieldservice.getText().length() > 0&&textfieldservice.getText().length()<15&&textfieldip.getText().length()<17){
                //SACAR FIELDS
                String ip_criacao=textfieldip.getText();
                String designacao_servico=textfieldservice.getText();
                String tipo = c_tipo.getSelectedItem().toString();
                //VERIFICAR SE É RMI OU SOCKET
                if(tipo.equals("RMI")){
                    int tem_porta;
                //SE FOR RMI FAZ ISTO
                try{
                    //VERIFICA SE TEM UMA PORTA.. SE TIVER PORTA RETORNA ERRO
                    ip_criacao.substring(ip_criacao.lastIndexOf(":"));
                    tem_porta=1;
                    JOptionPane.showMessageDialog(null, "RMI nao tem porta!");
                    }catch(Exception error){
                    tem_porta=0;
                    }
                if(tem_porta==0){
                try {
                    Two two=new Two(ip,porta,hash,designacao_servico,ip_criacao,"RMI");
                    two.go();
                    JOptionPane.showMessageDialog(null, "SERVICO CRIADO!");


                } catch (Exception exC) {
                    //TODO: handle exception
                    JOptionPane.showMessageDialog(null, "ERRO AO CRIAR O SERVICO!");
                }
            }
                
                }else{
                int tem_porta;
                try{
                    //VERIFICA SE TEM UMA PORTA.. SE TIVER PORTA RETORNA ERRO
                    ip_criacao.substring(ip_criacao.lastIndexOf(":"));
                    tem_porta=1;
                    }catch(Exception error){
                    tem_porta=0;
                    JOptionPane.showMessageDialog(null, "SOCKET TEM QUE TER UMA PORTA!");
                    }
                //SENAO FAZ ISTO
                //SE TIVER PORTA ELE VAI
                if(tem_porta==1){
                try {
                    Two two=new Two(ip,porta,hash,designacao_servico,ip_criacao,"SOCKET");
                    two.go();
                    JOptionPane.showMessageDialog(null, "SERVICO CRIADO!");
                } catch (Exception exC) {
                    //TODO: handle exception
                    JOptionPane.showMessageDialog(null, "ERRO AO CRIAR O SERVICO!");
                }
            }
                }
            
                
            } else {
                JOptionPane.showMessageDialog(null, "Os campos tem de ser todos preenchidos/nao pode execer 14 caracteres na designacao/nao pode exceder 16 caracteres no ip!");
            }
            
        }
    
        //FUNÇÃO PARA CORRER O PROGRAMA
        public CriarServicos(String ip,String hash,int porta){
            this.ip=ip;
            this.hash=hash;
            this.porta=porta;
            construir();
        }


}
