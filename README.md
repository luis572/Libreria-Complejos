# Libreria-Complejos
Esta es una libreria donde se encontraran las diferentes funciones de las operaciones entre numeros complejos.

## Prerrequisitos
Se debe tener instalados los siguientes programas en nuestro sistema operativo: 

- Maven 
- Git
- Java

## Empezando
se debe de clonar el proyecto, para esto utilizaremos el comando git clone. ubíquese la carpeta a guardar el proyecto y escriba el siguiente comando en la terminal:
 
### git clone https://github.com/luis572/Libreria-Complejos.git
   
## Instalacion 
- Ejecutar el comando mvn package
- Ejecutando pruebas: mvn test 

## Libreria
```java 
 public class ComplejoLib {
    public ComplejoLib(){
    
    }
     /**
	 * Este metodo permite calcular la suma de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo suma(Complejo a,Complejo b){
        Double x=a.getReal()+b.getReal();
        Double y=a.getImaginrio()+b.getImaginrio();
        return  new Complejo(redondearDecimales(x,2),redondearDecimales(y,2));  
    }
    /**
	 * Este metodo permite calcular la resta de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo resta(Complejo a,Complejo b){
        Double x=a.getReal()-b.getReal();
        Double y=a.getImaginrio()-b.getImaginrio();
        return new Complejo(x,y);   
    }
     /**
	 * Este metodo permite calcular la multiplicacion  de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo multiplicacion(Complejo a,Complejo b){
        Double x=a.getReal()*b.getReal()-a.getImaginrio()*b.getImaginrio();
        Double y=a.getReal()*b.getImaginrio()+a.getImaginrio()*b.getReal();
        return new Complejo(redondearDecimales(x,2),redondearDecimales(y,2)); 
    }
     /**
	 * Este metodo permite calcular la division de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo division(Complejo a,Complejo b){
        Double auxiliar=a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio();
        Double x=(a.getReal()*b.getImaginrio()+a.getImaginrio()*b.getImaginrio())/auxiliar;
        Double y=(a.getImaginrio()*b.getReal()-a.getReal()*b.getImaginrio())/auxiliar; 
        return new Complejo(redondearDecimales(x,2),redondearDecimales(y,2));  
    }
     /**
	 * Este metodo permite calcular el conjugado de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo Conjugado(Complejo a){
         return new Complejo(a.getReal(),a.getImaginrio()*-1);
    }
     /**
	 * Este metodo permite calcular el modulo de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Double Modulo(Complejo a){
        return  Math.sqrt(a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio());
    }
     /**
	 * Este metodo permite calcular el las cordenadas  polares  de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo CartecianasApolares(Complejo a){
        Double angulo=Math.atan(a.getReal()/a.getImaginrio());
        Double p=Math.sqrt(a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio());
        return  new Complejo(p, angulo) ;
    }
      /**
	 * Este metodo permite calcular la fase  de un numero complejo
         * @param a //tipo Complejo
	 * @return Double
	 */
    public static Double fase(Complejo a){
        Double angulo=Math.atan(a.getReal()/a.getImaginrio());
        return  angulo;
    }
    /**
	 * Este metodo permite calcular el inverso  de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo InversaComplejo(Complejo a ){
        return new Complejo(a.getReal()*-1, a.getImaginrio()*-1);
    }
     /**
	 * Este metodo permite calcular el suma de vectores
         * @param a //tipo vector
         * @param b //tipo vector
	 * @return Vector
	 */
    public static Vector sumaVectores(Vector a, Vector b){
        int r= a.getVec().size();
        ArrayList<Complejo> vectorResultado=new ArrayList<Complejo>();
        for(int i=0;i<r;i++){
            vectorResultado.add(suma(a.getVec().get(i),b.getVec().get(i)));
        }
        Vector v =new Vector(vectorResultado);
        return  v;
    }
     /**
	 * Este metodo permite calcular el inverso un de Vector 
         * @param a //tipo vector
	 * @return Vector
         */
    public static Vector  inversaVector(Vector a){
        int r= a.getVec().size();
        ArrayList<Complejo> vectorResultado=new ArrayList<Complejo>();
        for(int i=0;i<r;i++){
            vectorResultado.add(InversaComplejo(a.getVec().get(i)));
        }
        Vector v=new Vector(vectorResultado);
        return v;
    }
     /**
	 * Este metodo permite calcular la multiplicacion entre un vector y un complejo
         * @param a //tipo vector
         * @param b //tipo complejo
	 * @return Vector
         */
    public static Vector VectorXComplejo(Vector a, Complejo b){
        int r= a.getVec().size();
        ArrayList<Complejo> vectorResultado=new ArrayList<Complejo>();
        for(int i=0;i<r;i++){
            vectorResultado.add(multiplicacion(a.getVec().get(i),b));
        }
        Vector v =new Vector(vectorResultado);
        return  v;
    }
     
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
   
    //public static void main(String agr){
        
    //}
}
```
## Pruebas: 
```java 
 public class ComplejoLibTest {

    ComplejoLib libreria = new ComplejoLib();

    public ComplejoLibTest() {
    }

    @Test
    public void TestSuma() {
        Complejo a = new Complejo(3.0, -1.0);
        Complejo b = new Complejo(1.0, 4.0);
        Complejo resp = ComplejoLib.suma(a, b);
        System.out.println(resp.getReal());
        System.out.println(resp.getImaginrio());
        assertTrue(resp.getReal() == 4.0 && resp.getImaginrio() == 3.0);
    }

    @Test
    public void TestResta() {
        Complejo a = new Complejo(3.0, -1.0);
        Complejo b = new Complejo(1.0, 4.0);
        Complejo resp = ComplejoLib.resta(a, b);
        assertTrue(resp.getReal() == 2.0 && resp.getImaginrio() == -5.0);
    }

    @Test
    public void TestMultiplicacion() {
        Complejo a = new Complejo(3.0, -1.0);
        Complejo b = new Complejo(1.0, 4.0);
        Complejo resp = ComplejoLib.multiplicacion(a, b);
        assertTrue(resp.getReal() == 7.0 && resp.getImaginrio() == 11.0);
    }

    @Test
    public void TestDivicion() {
        Complejo a = new Complejo(-2.0, 1.0);
        Complejo b = new Complejo(1.0, 2.0);
        Complejo resp = ComplejoLib.division(a, b);

        assertTrue(Math.round(resp.getReal()) == 0 && resp.getImaginrio() == 1.0);
        //assertTrue(true);

    }

    @Test
    public void TestModulo() {
        Complejo a = new Complejo(1.0, -1.0);
        Double rta = ComplejoLib.Modulo(a);
        assertTrue((Objects.equals(rta, (Double) (Math.sqrt(2)))));
    }

    @Test
    public void TestConjugado() {
        Complejo a = new Complejo(1.0, -1.0);
        Complejo rta = ComplejoLib.Conjugado(a);
        assertTrue(rta.getReal() == 1.0 && rta.getImaginrio() == 1.0);
    }
    @Test
    public void TestPolar() {
        Complejo a = new Complejo(1.0, 1.0);
        Complejo rta = ComplejoLib.CartecianasApolares(a);
        assertTrue(rta.getImaginrio()==0.7853981633974483 && rta.getReal()==1.4142135623730951 );
    }
    @Test
    public void TestFase() {
        Complejo a = new Complejo(1.0, 1.0);
        Double rta = ComplejoLib.fase(a);
        assertTrue(rta==0.7853981633974483 );
    }
}
```
## Ejecutando Pruebas: 
![alt text](https://github.com/luis572/Libreria-Complejos/blob/master/test.JPG " Resultado")

## Authors

* **Luis Pizza** - *Develop* -(https://github.com/luis572)

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/heredikon/SHOP-FILES-FRONT/blob/master/LICENSE) file for details
