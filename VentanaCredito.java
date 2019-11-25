//Sebastian Alejos Acosta A00344555
import javax.swing.JFrame;
public class VentanaCredito extends JFrame{
	public VentanaCredito(){
		super("Control de Créditos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelCredito pc=new PanelCredito();
		this.add(pc);
        this.pack();
		this.setVisible(true);
	}
	public static void main(String []args) {
		VentanaCredito vc= new VentanaCredito();
	}
}