//Sebastian Alejos Acosta A00344555
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelCredito extends JPanel implements ActionListener {
    private JTextField tfNombre,
                                  tfMonto,
                                  tfTasa,
                                  tfFecha,
                                  tfSaldo,
                                  tfPago,
                                 tfAbonoCap,
                                 tfIntereses;
    private JLabel lNombre,
                            lMonto,
                            lTasa,
                            lFecha,
                            lSaldo,
                            lPago,
                            lAbono,
                            lIntereses;

    private JButton btnBuscar,
                              btnGuardar,
                              btnPago,
                              btnRegistrar,
                              btnLimpiar,
                              btnAbrir;
    private Cartera creditos;
    private Credito c1;

    //Se crea el panel con los text fields y los botones
    public PanelCredito(){
        super();
        this.setPreferredSize(new Dimension(550,300));
        this.setLayout(new GridLayout(0,2));  

        this.lNombre=new JLabel("Nombre del cliente: ");
        this.add(lNombre);
        this.tfNombre=new JTextField(25);
        this.add(tfNombre);
        this.tfNombre.setBackground(new Color(220,220,220));

        this.btnBuscar=new JButton("Buscar");
        this.add(btnBuscar);
        this.btnBuscar.addActionListener(this);

        this.btnLimpiar=new JButton("Limpiar");
        this.add(btnLimpiar);
        this.btnLimpiar.addActionListener(this);
        
        this.lMonto=new JLabel("Monto de préstamo: ");
        this.add(lMonto);
        this.tfMonto=new JTextField(12);
        this.add(tfMonto);
        this.tfMonto.setBackground(new Color(220,220,220));

        this.lTasa=new JLabel("Tasa de interés: ");
        this.add(lTasa);
        this.tfTasa=new JTextField(12);
        this.add(tfTasa);
        this.tfTasa.setBackground(new Color(220,220,220));

        this.lFecha= new JLabel("Fecha de préstamo: ");
        this.add(lFecha);
        this.tfFecha=new JTextField(12);
        this.add(tfFecha);
        this.tfFecha.setBackground(new Color(220,220,220));

        this.lSaldo=new JLabel("Saldo restante: ");
        this.add(lSaldo);
        this.tfSaldo=new JTextField(12);
        this.add(tfSaldo);
        this.tfSaldo.setBackground(new Color(220,220,220));
        this.tfSaldo.setEditable(false);

        this.btnGuardar= new JButton("Guardar archivo");
        this.add(btnGuardar);
        this.btnGuardar.addActionListener(this);

        this.btnRegistrar=new JButton("Registrar");
        this.add(btnRegistrar);
        this.btnRegistrar.addActionListener(this);

        this.lPago=new JLabel("Monto del pago: ");
        this.add(lPago);
        this.tfPago=new JTextField(18);
        this.add(tfPago);
        this.tfPago.setBackground(new Color(220,220,220));

        this.lAbono=new JLabel("Abono a capital: ");
        this.add(lAbono);
        this.tfAbonoCap=new JTextField(10);
        this.add(tfAbonoCap);
        this.tfAbonoCap.setBackground(new Color(220,220,220));
        this.tfAbonoCap.setEditable(false);

        this.lIntereses=new JLabel("Pago de intereses: ");
        this.add(lIntereses);
        this.tfIntereses=new JTextField(10);
        this.add(tfIntereses);
        this.tfIntereses.setBackground(new Color(220,220,220));
        this.tfIntereses.setEditable(false);

        this.btnPago=new JButton("Registrar Pago");
        this.add(btnPago);
        this.btnPago.addActionListener(this);

        this.btnAbrir= new JButton("Abrir archivo");
        this.add(btnAbrir);
        this.btnAbrir.addActionListener(this);

        this.creditos=new Cartera(this);
    }

    public void setCredito(Credito credito){
        this.c1=credito;
        this.tfFecha.setText(this.c1.getFecha());
        this.tfTasa.setText(Double.toString(this.c1.getTasa()));
        this.tfMonto.setText(Double.toString(this.c1.getMonto()));
        this.tfNombre.setText(this.c1.getNombre());
        this.tfSaldo.setText(Double.toString(this.c1.getSaldo()));
    }


    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource()==this.btnBuscar){
            String nom=this.tfNombre.getText();
            this.creditos.buscarCredito(nom);
        }

        if(evt.getSource()==this.btnRegistrar){
            String nom=this.tfNombre.getText();
            String fec=this.tfFecha.getText();
            double mon=Double.parseDouble(this.tfMonto.getText());
            double tas=Double.parseDouble(this.tfTasa.getText());
            this.creditos.agregarCliente(nom, fec, mon, tas);
            double sal=this.c1.getSaldo();
            this.tfSaldo.setText(Double.toString(sal));
        }

        if(evt.getSource()==this.btnLimpiar){
            this.tfNombre.setText("");
            this.tfMonto.setText("");
            this.tfTasa.setText("");
            this.tfFecha.setText("");
            this.tfSaldo.setText("");
            this.tfPago.setText("");
            this.tfAbonoCap.setText("");
            this.tfIntereses.setText("");
        }

       if(evt.getSource()==this.btnGuardar){
            this.creditos.guardarCreditos();
        }

        if(evt.getSource()==this.btnAbrir){
            this.creditos.abrirArchivo();
        }

        if(evt.getSource()==this.btnPago){
            double ab=this.c1.calculaAbono(Double.parseDouble(this.tfPago.getText()));
            this.tfAbonoCap.setText(Double.toString(ab));
            double inte=this.c1.calculaIntereses();
            this.tfIntereses.setText(Double.toString(inte));
            double sal=this.c1.calculaSaldo(Double.parseDouble(this.tfPago.getText()));
            this.tfSaldo.setText(Double.toString(sal));

        }

    }
    
}