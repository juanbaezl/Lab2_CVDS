# Lab2_CVDS
Repositorio para Lab2_CVDS

# Integrantes
- Juan Baez
- Nicolas Palacios

# Maven

1. Cuál es su mayor utilidad
    La estandarización de la estructura de un proyecto, y de las técnicas relacionadas con éste. De esta forma, se mejora la adaptación de los desarrolladores y la homogeneización del software. Maven propone una estructura estándar de un proyecto: El proyecto se describe en su totalidad en el fichero pom.xml, y existe una localización estándar para el código fuente, los recursos, el código de la aplicación Web, etc.
2. Fases de Maven
    | Fase | Plugin:objetivo |
    | --- | ---: |
    | process-resources | resources:resources |
    | compile | compiler:compile |
    | process-test-resources | resources:testResources |
    | test-compile | compiler:testCompile |
    | test | surefire:test |
    | package | jar:jar |
    | install | install:install |
    | deploy | deploy:deploy |
3. Ciclo de vida y construccion
    El otro concepto fundamental de Maven para la gestión de la construcción de un proyecto es el ciclo de vida. Un ciclo de vida está compuesto por un conjunto de fases. En Maven se definen tres ciclos de vida por defecto y normalmente nunca te vas a ver en la necesidad de definir ninguno adicional. Los tres ciclos de vida de Maven son:
    - El ciclo de vida default, que gestiona la construcción y despliegue del proyecto.
    - El ciclo de vida clean, que gestiona la limpieza del directorio del proyecto. Es decir, se encarga de eliminar todos los archivos generados en el proceso de construcción y despliegue.
    - El ciclo de vida site, que gestiona la creación de la documentación del proyecto.
4. Para qué sirven los plugins
    Un concepto clave de Maven son los plugins. Toda la funcionalidad de Maven se realiza a través de plugins. Hay plugins encargados de gestionar las dependencias, plugins encargados de compilar código Java, plugins encargados de ejecutar pruebas de JUnit, plugins encargados de empaquetar el código en un fichero JAR, etc. Los plugins ofrecen su funcionalidad a través de lo que se conoce como objetivos (goals). Por ejemplo, el plugin encargado de la compilación de código (compiler) tiene dos objetivos:
    - compiler:compile que compila el código fuente del proyecto, que está en la carpeta main/src/java
    - compiler:testCompile que compila el código de las pruebas del proyecto, que está en la carpeta main/src/test
5. Qué es y para qué sirve el repositorio central de maven
    es un repositorio que contiene cientos de librerías constantemente actualizadas por sus creadores. Maven permite incluso buscar versiones más recientes o más antiguas de un código dado y agregarlas a nuestro proyecto. Todo se hará de forma automática sin que el usuario tenga que hacer nada más que definir las dependencias.
# HACER EL ESQUELETO DE LA APLICACION
- Cree el paquete edu.eci.cvds.patterns.shapes y el paquete edu.eci.cvds.patterns.shapes.concrete.
- Cree una interfaz llamada Shape.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes de la siguiente manera:

<pre>package edu.eci.cvds.patterns.shapes;

public interface Shape {
    public int getNumberOfEdges();
} </pre>
- Cree una enumeración llamada RegularShapeType.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes así:

<pre>package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {
    Triangle, Quadrilateral, Pentagon, Hexagon
}</pre>
- En el directorio src/main/java/edu/eci/cvds/patterns/shapes/concrete cree las diferentes clases (Triangle, Quadrilateral, Pentagon, Hexagon), que implementen la interfaz creada y retornen el número correspondiente de vértices que tiene la figura. Siguiendo el ejemplo del triangulo:

<pre>package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {
    public int getNumberOfEdges() {
        return 3;
    }
}</pre>
- Cree el archivo ShapeMain.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes con el metodo main:

<pre> package edu.eci.cvds.patterns.shapes;

public class ShapeMain {
    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            System.err.println("Parameter of type RegularShapeType is required.");
            return;
        }
        try {

            RegularShapeType type = RegularShapeType.valueOf(args[0]);
            Shape shape = ShapeFactory.create(type);
            
            System.out.println(String.format("Successfully created a %s with %s sides.", type, shape.getNumberOfEdges()));

        } catch (IllegalArgumentException ex) {
            System.err.println("Parameter '" + args[0] + "' is not a valid RegularShapeType");
            return;
        }
    }
}</pre>
- Analice y asegúrese de entender cada una de las instrucciones que se encuentran en todas las clases que se crearon anteriormente.
- Cree el archivo ShapeFactory.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes implementando el patrón fábrica, haciendo uso de la instrucción switch-case de Java y usando las enumeraciones.

- Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:

    - Sin parámetros
    - Parámetro: qwerty
    - Parámetro: pentagon
    - Parámetro Hexagon
- ¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?
# ENTREGAR
- Se espera al menos que durante la sesión de laboratorio, se termine el ejercicio del saludo y haya un avance del ejercicio de las figuras.
- Dentro del directorio del proyecto, cree un archivo de texto integrantes.txt con el nombre de los dos integrantes del taller.
- Crear un repositorio para este proyecto y agregar la url del mismo, como entrega del laboratorio.
- Investigue para qué sirve "gitignore" y cómo se usa. Para futuras entregas, debe estar configurado.