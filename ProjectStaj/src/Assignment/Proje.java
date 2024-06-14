package Assignment;
import java.util.Scanner;

public class Proje {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);	/*Input almak için Scanner kütüphanemizi importladıktan sonra
         											  burada scanner adındaki bir isme yüklendiriyoruz ki scannerı 
         											  çağırdığımız zaman input fonksiyonu çağırılsın*/

        System.out.println("Welcome to the Calculator!");
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (x)");
        System.out.println("4. Division (/)");
        System.out.println("5. Square Root (√)");
        System.out.println("6. Power (^)");
        
        /*Int değerini kullanıcıdan alarak üstteki hangi operasyonu gerçekleştirmek istediğine bakıyoruz*/
        
        int operation = scanner.nextInt(); 
        int numberOfInputs = 0;
        
        /*köklü ifadede 1 den çok üslü ifadede de 2 den çok variable olmayacağı için sınırlandırmayı 
         * if else kullanarak yaratıyoruz*/
       
        if (operation == 5) {	
        	
            numberOfInputs = 1;
        } else if (operation == 6) {
            numberOfInputs = 2;
        } else {
            System.out.println("How many numbers do you want to enter?");
            
            /*Eğer belirlenen işlem köklü yada üslü değilse alacağımız input sayısını kullanıcının 
             * girdiğiyle güncellememiz gerekiyor*/
            
            numberOfInputs = scanner.nextInt();
        }
        
        /*numberOfInputsa girilen değer genişliğinde yeni bir array oluşturuyoruz*/
        
        double[] numbers = new double[numberOfInputs]; 
        
        /*girilmek istenen sayı kadar input alacağımız için i değişkenine 0 verip 
         * kullanıcının istediği sayıya gelene kadar for loopunu dönderiyoruz*/
        
        for (int i = 0; i < numberOfInputs; i++) {
        	
        	/*Arrayler 0. diziden başladığından dolayı usera anlaşılabilir 
        	 * bir output vermek için +1 kullanıyoruz ki0-1-2. sayı olarak değil 1-2-3 olarak artış göstersin.*/
        	
            System.out.println("Enter number " + (i + 1) + ":");
            
            /*Input aldığımız değerleri numbers arrayinin içine dolduruyor ve sonra for loopu tekrarlanırken i++ 
             * olduğundan dolayı arrayimiz input sayımız kadar genişliyor*/
            
            numbers[i] = scanner.nextDouble();
        }

        double result = 0;

        switch (operation) {	/*Hangi işlemi yapacağımızı konsoldan belirtiyoruz*/
            case 1:
                result = add(numbers);	/*add substract gibi methodlarımız aşağıda tanımlandı onları çağırıp */
                break;					/*userdan aldığımız inputlarla belirlenen değerleri doldurduk*/
            case 2:
                result = subtract(numbers);
                break;
            case 3:
                result = multiply(numbers);
                break;
            case 4:
                result = divide(numbers);
                break;
            case 5:
                result = Math.sqrt(numbers[0]);  /*Diğer dillerde de kullanılan math kütüphanesini */
                break;								/*kullandım işlem kolaylığı ve tutarlılığı için*/
            case 6:
                result = Math.pow(numbers[0], numbers[1]);
                break;
            default:
                System.out.println("Invalid operation selected.");/*Geçersiz işlem numarasında hata olarak verilecek output*/
                return;
        }

        System.out.println("The result is: " + result);
    }

    public static double add(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {	/*For loopu ile kaç input verilmişse ona göre işlem yapılıyor*/
            sum += numbers[i];						/*Arraydeki elementler baştan başlanılarak toplanarak sum değişkenine eşitleniyor*/
        }											/*Örnek vermek gerekise array[1,2] diye düşünürsek bu durumda ilk olarak 1+0 */
        return sum;									/*yaparak suma eşitler sonra sum 1 ile güncellendikten sonra 1+2 yaparak 3 ile sum değerini günceller*/
    }

    public static double subtract(double[] numbers) {
        double result = numbers[0];		/*Result bu sefer ilk inputa eşit olmak zorunda çünkü ilk inputtan diğer inputların tamamı çıkarılacak*/
        for (int i = 1; i < numbers.length; i++) {   /*int değeri 1 girildi çünkü 0 da ilk girilen ana sayı var ve diğer sayılar o sayıdan çıkarılacak*/
            result -= numbers[i];
        }
        return result;
    }

    public static double multiply(double[] numbers) {
        double result = 1;			/*Diğer resultlardan farklı olarak 1 konulur çünkü çarpım işleminde 0 yok eden elemandır*/
        for (int i = 0; i < numbers.length; i++) {
            result *= numbers[i];  /*Input değerleri çarpılarak resulta doldurulur*/
        }
        return result;
    }

    public static double divide(double[] numbers) {
        double result = numbers[0]; /*İlk sayımızı resultta tutucaz çünkü bölünecek sayı ilk sayı olucak*/
        for (int i = 1; i < numbers.length; i++) {	/*i değeri 1 den başlayacak çünkü bölen değerler arrayin 2. elementinden başlamalı*/
            if (numbers[i] == 0) {
                System.out.println("Error: Division by zero.");		/*Sayılar 0 a bölününce tanımsız olacağı için Not a Numbera dönmesini sağladık*/
                return Double.NaN;
            }
            result /= numbers[i];
        }
        return result;
    }						/*Math kütüphanesi kullandığım için Method olarak işlemleri yapmadım */
    						/*kütüphanelerin doğruluk oranı daha yüksek olduğu için*/
}
