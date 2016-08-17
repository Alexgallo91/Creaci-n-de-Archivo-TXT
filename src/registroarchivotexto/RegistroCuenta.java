
package registroarchivotexto;

public class RegistroCuenta {
    
   private int numeroDeCuenta;
   private String primerNombre;
   private String apellidoPaterno;
   private double saldo;
   
   public RegistroCuenta()
   {
       this(0,"","",0.0);
   }
   
   public RegistroCuenta(int a, String b, String c, double d)
   {
       this.setCuenta(a);
       this.setPrimerNombre(b);
       this.setApellidoPaterno(c);
       this.setSaldo(d);
   }
   
   public void setCuenta(int a)
   {
       this.numeroDeCuenta = a;
   }
   
   public int getCuenta()
   {
       return this.numeroDeCuenta;
   }
   
   public void setPrimerNombre(String a)
   {
       this.primerNombre = a;
   }
   
   public String getPrimerNombre()
   {
       return this.primerNombre;
   }
   
   public void setApellidoPaterno(String a)
   {
       this.apellidoPaterno = a;
   }
   
   public String getApellidoPaterno()
   {
       return this.apellidoPaterno;
   }
   
   public void setSaldo(double a)
   {
       this.saldo = a;
   }
   
   public double getSaldo()
   {
       return this.saldo;
   }
}
