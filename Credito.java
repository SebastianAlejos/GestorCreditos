//Sebastian Alejos Acosta A00344555
public class Credito{
    private String nombre,
                   fecha;
    private double monto,
                   tasa,
                   saldo,
                   abonoCap,
                   pagoCalc;
    private int plazo;

     //Crea el crédito con sus parámetros              
    public Credito(String nombre, String fecha, double monto, double tasa){
        this.nombre=nombre;
        this.fecha=fecha;
        this.monto=monto;
        this.tasa=tasa;
        this.saldo=monto;
    }

    public Credito(String nombre, String fecha, double monto, double tasa, double saldo){
        this.nombre=nombre;
        this.fecha=fecha;
        this.monto=monto;
        this.tasa=tasa;
        this.saldo=saldo;
    }

    //Calcula el pago de intereses mensuales
    public double calculaIntereses(){
        double intereses= (this.tasa/100)*this.saldo;
        return intereses;
    }

    //Calcula el monto que será abonado a capital de acuerdo al pago
    public double calculaAbono(double pago){
        double intereses=this.calculaIntereses();
        if(pago<intereses){
            this.abonoCap=0;
        }
        else{
            this.abonoCap=pago-intereses;
        }
        return this.abonoCap;
    }

    //Calcula el saldo después de el pago
    public double calculaSaldo(double pago){
        double abonoCap=this.calculaAbono(pago);
       this.saldo -= abonoCap;
        return this.saldo;
    }
    public double calculaPago(){
        this.pagoCalc=(monto/plazo)+this.calculaIntereses();
        return this.pagoCalc;
    }
    
    //getters
    public String getFecha() {
        return this.fecha;
    }
    public double getMonto() {
        return this.monto;
    }
    public String getNombre() {
        return this.nombre;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public double getTasa() {
        return this.tasa;
    }

    //Compara créditos
    public boolean comparaCredito(String nom){
        return this.getNombre().equals(nom);
    }

    public String toString(){
        String res=this.nombre+","+this.monto+","+this.tasa+","+this.fecha+","+this.saldo;
        return res;
    }
}