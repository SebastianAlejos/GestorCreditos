//Sebastian Alejos Acosta A00344555
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Cartera{
    private Credito[] cartera;
    private PanelCredito pc;

    public Cartera(PanelCredito pc){
        this.cartera=new Credito[100];
        this.pc=pc;
    }

    public void agregarCliente(String nombre, String fecha, double monto, double tasa){
        for (int i = 0; i < cartera.length; i++) {
            if(this.cartera[i]==null){
                this.cartera[i]=new Credito(nombre, fecha, monto, tasa);
                this.pc.setCredito(this.cartera[i]);
                break;
            }else{}
        } 
    }

    public void agregarSaldo(String nombre, String fecha, double monto, double tasa, double saldo){
        for (int i = 0; i < cartera.length; i++) {
            if(this.cartera[i]==null){
                this.cartera[i]=new Credito(nombre, fecha, monto, tasa,saldo);
                break;
            }else{}
        } 
    }

    public boolean buscarCredito(String nombre){
        boolean bul=false;
        for (int i = 0; i < this.cartera.length; i++) {
            if(this.cartera[i]!=null){
                if(this.cartera[i].comparaCredito(nombre)){
                    this.pc.setCredito(this.cartera[i]);
                    bul=true;
                    break;
                }else{}
            }else{}
        }
        if(!bul){
            JOptionPane.showMessageDialog(this.pc,"No se encontró el crédito");
        }else{}
        return bul;
    }

    public void guardarCreditos(){
        PrintWriter pw=null;
            try{
                pw=new PrintWriter(new FileWriter("creditos.txt"));
                for (int i = 0; i < this.cartera.length; i++) {
                    if(this.cartera[i]!=null){
                        pw.println(this.cartera[i]);

                    }
                }
            }catch(IOException ex){
                System.out.println("No se puede crear el archivo");
            }finally{
                pw.close();
            }
    }

    public void abrirArchivo(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("creditos.txt"));
            String linea,
                      nombre,
                      fecha;
            double monto,
                        tasa,
                        saldo;
	    	while((linea = br.readLine())!=null){
                StringTokenizer st;
                st=new StringTokenizer(linea, ",");
                nombre=st.nextToken();
                monto=Double.parseDouble(st.nextToken());
                tasa=Double.parseDouble(st.nextToken());
                fecha=st.nextToken();
                saldo=Double.parseDouble(st.nextToken());
                this.agregarSaldo(nombre, fecha, monto, tasa, saldo);
            }
            JOptionPane.showMessageDialog(this.pc,"Archivo abierto");
		    br.close();
        } catch (FileNotFoundException ex){
           System.out.println("No se encontró el archivo");
        }catch(IOException ex){
            System.out.println("No se puede cerrar el archivo");
        }
    }
}
