package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JLabel lbl_titulo;

    private JTextField txt_visor;

    private JButton btn_0;
    private JButton btn_1;
    private JButton btn_2;
    private JButton btn_3;
    private JButton btn_4;
    private JButton btn_5;
    private JButton btn_6;
    private JButton btn_7;
    private JButton btn_8;
    private JButton btn_9;

    private JButton btn_soma;
    private JButton btn_subtrai;
    private JButton btn_multiplica;
    private JButton btn_divide;
    private JButton btn_igual;

    private double valor1;
    private String operador;

    public Calculadora() {
        //JANELA
        super.getContentPane().setLayout(null);
        super.getContentPane().setBackground(new Color(0,0,0));
        super.setSize(400,350);
        super.setTitle("Calculadora Step");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocation(200,200);

        //Titulo LABEL
        lbl_titulo = new JLabel("CALCULADORA");
        lbl_titulo.setBounds(150,20,320,25);
        lbl_titulo.setForeground(new Color(255,255,255));
        super.getContentPane().add(lbl_titulo);

        //VISOR
        txt_visor = new JTextField(15);
        txt_visor.setBounds(40,60,300,25);
        super.getContentPane().add(txt_visor);

        //LINHA 1-----------------------------------------------

        btn_divide = new JButton("/");
        btn_divide.setBounds(290,100,50,25);
        super.getContentPane().add(btn_divide);

        //LINHA 2--------------------------------------------

        btn_7 = new JButton("7");
        btn_7.setBounds(40,140,50,25);
        super.getContentPane().add(btn_7);

        btn_8 = new JButton("8");
        btn_8.setBounds(120,140,50,25);
        super.getContentPane().add(btn_8);

        btn_9 = new JButton("9");
        btn_9.setBounds(200,140,50,25);
        super.getContentPane().add(btn_9);

        btn_multiplica = new JButton("*");
        btn_multiplica.setBounds(290,140,50,25);
        super.getContentPane().add(btn_multiplica);

        //LINHA 3--------------------------------------------

        btn_4 = new JButton("4");
        btn_4.setBounds(40,180,50,25);
        super.getContentPane().add(btn_4);

        btn_5 = new JButton("5");
        btn_5.setBounds(120,180,50,25);
        super.getContentPane().add(btn_5);

        btn_6 = new JButton("6");
        btn_6.setBounds(200,180,50,25);
        super.getContentPane().add(btn_6);

        btn_subtrai = new JButton("-");
        btn_subtrai.setBounds(290,180,50,25);
        super.getContentPane().add(btn_subtrai);

        //LINHA 4--------------------------------------------

        btn_1 = new JButton("1");
        btn_1.setBounds(40,220,50,25);
        super.getContentPane().add(btn_1);

        btn_2 = new JButton("2");
        btn_2.setBounds(120,220,50,25);
        super.getContentPane().add(btn_2);

        btn_3 = new JButton("3");
        btn_3.setBounds(200,220,50,25);
        super.getContentPane().add(btn_3);

        btn_soma = new JButton("+");
        btn_soma.setBounds(290,220,50,25);
        super.getContentPane().add(btn_soma);

        //LINHA 5--------------------------------------------

        btn_0 = new JButton("0");
        btn_0.setBounds(120,260,50,25);
        super.getContentPane().add(btn_0);

        btn_igual = new JButton("=");
        btn_igual.setBounds(290,260,50,25);
        super.getContentPane().add(btn_igual);

        this.eventosBtnNumeros();
        this.eventosBtnOperador();
    }

    private void eventosBtnNumeros(){

        btn_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txt_visor.getText().equals("0"))
                    txt_visor.setText(txt_visor.getText() + "0");
            }
        });

        btn_1.addActionListener(btnNum("1"));
        btn_2.addActionListener(btnNum("2"));
        btn_3.addActionListener(btnNum("3"));
        btn_4.addActionListener(btnNum("4"));
        btn_5.addActionListener(btnNum("5"));
        btn_6.addActionListener(btnNum("6"));
        btn_7.addActionListener(btnNum("7"));
        btn_8.addActionListener(btnNum("8"));
        btn_9.addActionListener(btnNum("9"));

    }

    private ActionListener btnNum(String num) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_visor.getText().equals("0"))
                    txt_visor.setText(num);
                else
                    txt_visor.setText(txt_visor.getText() + num);
            }
        };
    }

    private void eventosBtnOperador(){
        btn_soma.addActionListener(btnOp("+"));
        btn_subtrai.addActionListener(btnOp("-"));
        btn_multiplica.addActionListener(btnOp("*"));
        btn_divide.addActionListener(btnOp("/"));

        btn_igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor2 = Double.parseDouble(txt_visor.getText());

                switch (operador){
                    case "+":
                        txt_visor.setText(String.valueOf(valor1 + valor2));
                        break;
                    case "-":
                        txt_visor.setText(String.valueOf(valor1 - valor2));
                        break;
                    case "*":
                        txt_visor.setText(String.valueOf(valor1 * valor2));
                        break;
                    case "/":
                        if(valor2 == 0){
                            txt_visor.setText("0");
                        } else {
                            txt_visor.setText(String.valueOf(valor1 / valor2));
                        }
                        break;
                }
            }
        });
    }

    public ActionListener btnOp(String op){

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor1 = Double.parseDouble(txt_visor.getText());
                txt_visor.setText("");
                operador = op;
            }
        };
    }
}
