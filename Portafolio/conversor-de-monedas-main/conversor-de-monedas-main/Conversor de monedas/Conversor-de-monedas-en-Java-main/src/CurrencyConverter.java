import com.aluracurso.conversormoneda.exception.TargetCurrencyNotFoundException;
import com.aluracurso.conversormoneda.models.ApiRequest;
import com.aluracurso.conversormoneda.models.Currency;

import java.security.InvalidKeyException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**ARS - Peso argentino
 BOB - Boliviano boliviano
 BRL - Real brasileño
 CLP - Peso chileno
 COP - Peso colombiano
 USD - Dólar estadounidense**/
public class CurrencyConverter {
    public static void main(String[] args) {
        String targetCode;
        String baseCode;
        boolean salir = false;
        double amount = 0;

        while (!salir) {
            showMenu();
            System.out.println("Ingrese una opción: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if (option != 8){
            System.out.println("Ingresa la cantidad a convertir: ");
             amount = scanner.nextDouble();
            }


            ApiRequest request = new ApiRequest();

            Currency currency = request.getDataApi("USD");
            switch (option) {
                case 1:
                    targetCode = "COP";
                    changeProcess(currency, amount, targetCode);
                    break;
                case 2:
                    targetCode = "USD";
                    currency = request.getDataApi("COP");
                    changeProcess(currency, amount, targetCode);
                    break;
                case 3:
                    targetCode = "ARS";
                    changeProcess(currency, amount, targetCode);
                    break;
                case 4:
                    targetCode = "USD";
                    currency = request.getDataApi("ARS");
                    changeProcess(currency, amount, targetCode);
                    break;
                case 5:
                    targetCode = "BRL";
                    changeProcess(currency, amount, targetCode);
                    break;
                case 6:
                    targetCode = "USD";
                    currency = request.getDataApi("BRL");
                    changeProcess(currency, amount, targetCode);
                    break;
                case 7:
                    System.out.println("Ingrese el codigo de moneda ingresado en la cantidad: ");
                    baseCode = scanner.next();
                    baseCode = baseCode.toUpperCase();
                    System.out.println("Ingrese el codigo de la moneda de cambio: ");
                    targetCode = scanner.next();
                    targetCode = targetCode.toUpperCase();
                    currency = request.getDataApi(baseCode);
                    changeProcess(currency, amount, targetCode);
                    break;

                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }
        public static void showMenu () {
            System.out.println("***********************************");
            System.out.println("CONVERSOR DE MONEDA");
            System.out.println("************************************");
            ;
            System.out.println("1. Convertir Dolar a Peso colombiano");
            System.out.println("2. Convertir Peso colombiano a Dolar");
            System.out.println("3. Convertir Dolar a Peso argentino");
            System.out.println("4. Convertir Peso argentino a Dolar");
            System.out.println("5. Convertir Dolar a Real brasileño ");
            System.out.println("6. Convertir Real brasileño a Dolar");
            System.out.println("7. Otros Conversiones");
            System.out.println("8. Salir");
            System.out.println("______________________________________________________");
        }


    public static void changeProcess(Currency currency, double amount, String targetCode){
        double exchangeRate = 0;
        try {
             exchangeRate = currency.currencyFilter(currency.conversion_rates(), targetCode);
        } catch (TargetCurrencyNotFoundException | NullPointerException e ) {
            System.out.println("Error: codigo invalido: " + e.getMessage());
        }
        currency.convertAmount(amount, exchangeRate, targetCode );
    }



}
