
package CreacionArchivo;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import registroarchivotexto.*;

public class CrearArchivoTexto 
{
    private Formatter salida;
    private boolean decision = false;
    
    /*Metodo para abrir el archivo*/
    public void abrirArchivo()
    {
        try
        {
            salida = new Formatter("Clientes.txt");
        }
        catch(SecurityException e)
        {
            System.out.println(e.getMessage());
            System.err.println("No se tiene acceso de escritura a este archivo");
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.err.println("Error al crear el archivo");
            System.exit(1);
        }
    }
    
    public void agregarRegistros()
    {
        Scanner entrada = new Scanner(System.in);
        RegistroCuenta registro = new RegistroCuenta();
        
        System.out.println("Agregue los registros en el siguiente orden:"
                + "numeroCuenta(>0), primer nombre, apellido paterno y saldo");
        
        System.out.print("?");
        
        while(!decision)
        {
            try
            {
                registro.setCuenta(entrada.nextInt());
                registro.setPrimerNombre(entrada.next());
                registro.setApellidoPaterno(entrada.next());
                registro.setSaldo(entrada.nextDouble());
                
                if(registro.getCuenta() > 0)
                {
                    salida.format("%d %s %s %.2f\n",
                            registro.getCuenta(),
                            registro.getPrimerNombre(),
                            registro.getApellidoPaterno(),
                            registro.getSaldo());
                }
                else
                {
                    System.out.println("El numero de cuenta debe ser mayor que 0!!!");
                }
            }
            catch(FormatterClosedException e)
            {
               System.out.println(e.getMessage());
               System.err.println("Error al escribir en el archivo");
               return;
            }
            catch(NoSuchElementException e)
            {
               System.out.println(e.getMessage());
               System.err.println("Entrada invalida, intente de nuevo");
               entrada.nextLine();
            }
            
            //toma de decision para agregar otro registro
            System.out.println("Desea agregar otro registro?\n");
            System.out.println("1 - SI / 2 - NO\n");
            int opcion = entrada.nextInt();
            
            if(opcion == 1)
            {
                System.out.println("Agregue los registros en el siguiente orden:"
                + "numeroCuenta(>0), primer nombre, apellido paterno y saldo");
        
                System.out.print("?");
            }
            else if(opcion == 2)
            {
                decision = true;
                break;
            }
        }
    }//fin del metodo
    
    public void cerrarArchivo()
    {
        if(salida != null)
        {
            salida.close(); //cerramos el archivo
        }
    }
    
}
