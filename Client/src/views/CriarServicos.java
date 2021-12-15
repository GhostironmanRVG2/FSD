package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
public class CriarServicos implements ActionListener{
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
    
    
    
        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 220, 140, 40);
        b.setBackground(lil);
        //LER O BOTÃO
        b.addActionListener(this);
         
        //FAZER O BOTAO CLICAVEL
        backb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                //dispose da janela
                janela.dispose();
                //CRIAR NOVA JANELA
                TipoOperacao t=new TipoOperacao();
      
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
        janela.add(backd);
    
        janela.setLayout(null);
        janela.setVisible(true);
    
    
        }


        @Override
        //FUNÇÃO PARA CRIAR UM SERVIÇO, VERIFICANDO SE OS ESPAÇOS ESTÃO PREENCHIDOS
        public void actionPerformed(ActionEvent e) {
            if(textfieldip.getText().length() > 0 && textfieldservice.getText().length() > 0){
                System.out.println("funciona");
            } else {
                JOptionPane.showMessageDialog(null, "Os campos tem de ser todos preenchidos!");
            }
            
        }
    
        //FUNÇÃO PARA CORRER O PROGRAMA
        public CriarServicos(){
            construir();
        }


}
