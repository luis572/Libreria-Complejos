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
### Utilidades: Basado en el libro Quantum Computing for Computing Scientists se cuenta con las siguientes funciones.

    Capítulos 1 y 2:
    - Suma de complejos y matrices
    - Resta de complejos y matrices 
    - Conjugado de un complejo y una matriz
    - Inverso de un complejo y una matriz 
    - Producto entre complejos, complejo - matriz y entre matrices
    - Division entre complejos y matrices
    - Modulo de un complejo y matriz
    - Fase de un complejo
    - Adjunta de una matriz
    - Traspuesta de una matriz
    - Producto Interno
    - Producto Tensor
    
    Capítulo 3:
    - Experimento de las canicas con una Matriz Binaria
    - Experimentos de las múltiples rendijas clásico probabilístico, con más de dos rendijas.
    - Experimentos de las múltiples rendijas cuántico.
    - Función para graficar 
    
    Capítulo 4:
    - El sistema calcula la probabilidad de encontrarlo en una posición en particular.
    - El sistema si se le da otro vector Ket busca la probabilidad de transitar del primer vector al segundo.
    
## Experimentos capitulo 3 Implementacion

#### Experimento de las canicas con una Matriz Binaria
-codigo: 
```java 
@Test
    public void canicas_con_coeficiente_booleanos() {
        System.out.println("---------Canicas_Con_Coeficiente_Booleanos Test---------");
        System.out.println(" ");
        System.out.println("-------Libro Ejemplo-----------");
        int[][] m = {{0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 1},
        {0, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 1, 0}};
        Double[] v = {6.0, 2.0, 1.0, 5.0, 3.0, 10.0};
        int Clicks = 1;
        Double[] r = ComplejoLib.CanicasEsperimentoNormal(m, v, Clicks);
        for (Double e : r) {
            System.out.println(e);
        }
        Double[] resp = {0.0, 0.0, 12.0, 5.0, 1.0, 9.0};
        assertArrayEquals(r, resp);
        System.out.println(" ");
        System.out.println("-------Quiz pregunta 2------------");
        int[][] m2 = {{0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 0},
        {1, 0, 0, 0, 0, 0}};

        Double[] v2 = {6.0, 0.0, 3.0, 5.0, 3.0, 8.0};
        Clicks = 5000;
        r = ComplejoLib.CanicasEsperimentoNormal(m2, v2, Clicks);
        Double[] resp2 = {0.0, 3.0, 11.0, 8.0, 3.0, 0.0};
        for (Double e : r) {
            System.out.println(e);
        }
        assertArrayEquals(r, resp2);
        System.out.println(" ");
        ComplejoLib.graficarEstado(r, "canicas_con_coeficiente_booleanos_quiz");
    }
```
#### Experimentos de las múltiples rendijas clásico probabilístico, con dos o más  rendijas: 
-codigo: 
```java 
/**
     * Calcula la probabilidad de que una particula se encuentr en un objetivo despuesde ciertos click en el tiempo. 
     *
     * @param m1 //Double[][]
     * @param v //Double[] 
     * @param clics //HashMap<String, Double>
     * @return int
     */
public static Double[] Experimentosdelasmúltiplesrendijasclásico(Double[][] m1, Double[] v, int clics) {
        Double[] r = v;
        for (int i = 0; i < clics; i++) {
            r = multiplicacionMatrisVectorDouble(m1, r);
        }
        return r;
    }
/**
     * Crea la matriz correspondiente con las probabilidades dadas entre el punto de partida, las rendijas y objetivos 
     *
     * @param rendijas //int 
     * @param objetivos //int
     * @param probabilidades //HashMap<String, Double>
     * @return Double[][]
     */
public static Double[][] getMatrizXmatriz(int rendijas, int objetivos, HashMap<String, Double> probabilidades) {
        Double[][] m = new Double[rendijas + objetivos + 1][rendijas + objetivos + 1];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == j && j > rendijas) {
                    m[i][j] = 1.00;
                } else {
                    m[i][j] = 0.00;
                }

            }
        }
        for (String key : probabilidades.keySet()) {
            String[] p = key.split("-");
            m[Integer.parseInt(p[1])][Integer.parseInt(p[0])] = probabilidades.get(key);
        }
        Double[][] m2 = productoMatricesReales(m, m);
        for (Double[] e : m2) {
            System.out.println(Arrays.toString(e));
        }
        return m2;
    }


@Test
    public void MultiplesRendijasExperiemnto() {
        System.out.println("---------Multiples Rendijas Experiemnto Clasico ---------");
        System.out.println(" ");
        HashMap<String, Double> probabilidades = new HashMap<>();
        probabilidades.put("0-1", 0.50);
        probabilidades.put("0-2", 0.50);
        probabilidades.put("1-3", 0.33);
        probabilidades.put("1-4", 0.33);
        probabilidades.put("1-5", 0.33);
        probabilidades.put("2-5", 0.33);
        probabilidades.put("2-6", 0.33);
        probabilidades.put("2-7", 0.33);
        Double[][] m = ComplejoLib.getMatrizXmatriz(2, 5, probabilidades);
        Double[] v2 = {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        Double[] r = ComplejoLib.Experimentosdelasmúltiplesrendijasclásico(m, v2, 1);
        for (Double e : r) {
            System.out.println(e);
        }
        ComplejoLib.graficarEstado(r, "Multiples_Rendijas_Experiemnto");
    }
```
#### Experimentos de las múltiples rendijas clásico probabilístico, con dos o más  rendijas: 
```java 
/**
     * Crea la matriz correspondiente con las probabilidades dadas entre el punto de partida, las rendijas y objetivos 
     *
     * @param rendijas //int 
     * @param objetivos //int
     * @param probabilidades //HashMap<String, Complejo>
     * @return Double[][]
     */
public static Double[][] getMatrizXmatrizCuantico(int rendijas, int objetivos, HashMap<String, Complejo> probabilidades) {
        Complejo[][] m = new Complejo[rendijas + objetivos + 1][rendijas + objetivos + 1];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == j && j > rendijas) {
                    m[i][j] = new Complejo(1.0, 0.0);
                } else {
                    m[i][j] = new Complejo(0.0, 0.0);
                }

            }
        }

        for (String key : probabilidades.keySet()) {
            String[] p = key.split("-");
            m[Integer.parseInt(p[1])][Integer.parseInt(p[0])] = probabilidades.get(key);

        }
        Double[][] resp = new Double[m.length][m[0].length];
        Complejo[][] m2 = productoMatrices(m, m).getMatriz();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                resp[i][j] = Mod(m2[i][j]);
            }
        }
        return resp;
    }
 @Test
    public void MultiplesRendijasExperiemntoCuantico() {
        System.out.println("---------Multiples Rendijas Experiemnto Cuantico ---------");
        System.out.println(" ");
        DecimalFormat df = new DecimalFormat("#.00");
        HashMap<String, Complejo> probabilidades = new HashMap<>();
        probabilidades.put("0-1", new Complejo(1 / Math.sqrt(2), 0.0));
        probabilidades.put("0-2", new Complejo(1 / Math.sqrt(2), 0.0));
        probabilidades.put("1-3", new Complejo(-1 / Math.sqrt(6), 1 / Math.sqrt(6)));
        probabilidades.put("1-4", new Complejo(-1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        probabilidades.put("1-5", new Complejo(1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        probabilidades.put("2-5", new Complejo(-1 / Math.sqrt(6), 1 / Math.sqrt(6)));
        probabilidades.put("2-6", new Complejo(-1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        probabilidades.put("2-7", new Complejo(1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        Double[][] m = ComplejoLib.getMatrizXmatrizCuantico(2, 5, probabilidades);
        Double[] v2 = {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        Double[] r = ComplejoLib.Experimentosdelasmúltiplesrendijasclásico(m, v2, 1);
        for (Double[] e : m) {
            System.out.println(Arrays.toString(e));
        }
        for (Double e : r) {
            System.out.println(e);
        }
        ComplejoLib.graficarEstado(r, "Multiples_Rendijas_Experiemnto_Cuantico");
    }
```
#### Función para graficar:
```java 
/**
     * Crea una imagen mediante un vector de estado  y la guarda en el directorio raiz de nuestro proyecto.
     * @param EstadoVector //Double[]
     * @param name //String
     */
public static void graficarEstado(Double[] EstadoVector,String name) {
        try {
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            for(int i=0;i<EstadoVector.length;i++){
                ds.addValue(EstadoVector[i],"Vertice"+Integer.toString(i),"");
            }
            JFreeChart jf = ChartFactory.createBarChart3D("Estado", "Vertices", "Probabilidad", ds, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame f = new ChartFrame("Estados", jf);
            f.setSize(1000, 600);
            f.setLocationRelativeTo(null);
            f.setVisible(false);
            ChartUtilities.saveChartAsPNG(new File(name+".png"),jf, 1000,600,null);
            
        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
```
## Ejecutando Pruebas: 
![alt text](https://github.com/luis572/Libreria-Complejos/blob/master/test1.JPG " Resultado")
![alt text](https://github.com/luis572/Libreria-Complejos/blob/master/test2.JPG " Resultado")

#### Graficando Multiples Rendijas Experiemnto clasico

![alt text](https://github.com/luis572/Libreria-Complejos/blob/master/Multiples_Rendijas_Experiemnto.png " Resultado")

#### Graficando Multiples Rendijas Experiemnto Cuantico

![alt text](https://github.com/luis572/Libreria-Complejos/blob/master/Multiples_Rendijas_Experiemnto_Cuantico.png " Resultado")



## Authors

* **Luis Pizza** - *Develop* -(https://github.com/luis572)

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/heredikon/SHOP-FILES-FRONT/blob/master/LICENSE) file for details
