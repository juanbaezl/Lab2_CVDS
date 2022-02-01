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
    Es un repositorio que contiene cientos de librerías constantemente actualizadas por sus creadores. Maven permite incluso buscar versiones más recientes o más antiguas de un código dado y agregarlas a nuestro proyecto. Todo se hará de forma automática sin que el usuario tenga que hacer nada más que definir las dependencias.
# Ejercicio de las figuras
## Crear un proyecto con maven
- Buscar cómo se crea un proyecto maven con ayuda de los arquetipos (archetypes).
- Busque cómo ejecutar desde línea de comandos el objetivo "generate" del plugin "archetype", con los siguientes parámetros:
    - Grupo: edu.eci.cvds
    - Id del Artefacto: Patterns
    - Paquete: edu.eci.cvds.patterns
    - archetypeArtifactId: maven-archetype-quickstart

*Se uso el siguiente comando*
<pre>archetype:generate -DgroupId=edu.eci.cvds -DartifactId=Patterns -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=true</pre>

Se debió haber creado en el directorio, un nuevo proyecto Patterns a partir de un modelo o arquetipo, que crea un conjunto de directorios con un conjunto de archivos básicos.

Cambie al directorio Patterns:

$ cd Patterns
Para ver el conjunto de archivos y directorios creados por el comando mvn ejecute el comando tree.

$ tree
En algunos sistemas operativos, este comando no funciona correctamente o puede requerir un parámetro (por ejemplo: tree /f). En caso que funcione, la salida muestra la estructura del proyecto, similar a como se muestra a continuación:


    ├pom.xml
    └───src
        ├───main
        │   └───java
        │       └───edu
        │           └───eci
        │               └───cvds
        │                   └───patterns
        │                           App.java
        │
        └───test
            └───java
                └───edu
                    └───eci
                        └───cvds
                            └───patterns
                                    AppTest.java

## AJUSTAR ALGUNAS CONFIGURACIONES EN EL PROYECTO
- Edite el archivo pom.xml y realize la siguiente actualización:
    - Hay que cambiar la version del compilador de Java a la versión 8, para ello, agregue la sección properties antes de la sección de dependencias:
    ~~~<properties>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.source>1.8</maven.compiler.source>
    </properties>

# COMPILAR Y EJECUTAR
- Para compilar ejecute el comando:
    <pre>$ mvn package</pre>
- Si maven no actualiza las dependencias utilice la opción -U asi:

    <pre>$ mvn -U package</pre>
- Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando mvn.
    Empaqueta el codigo compilado en su formato distribuible, normalmente como un fichero del tipo jar.
- Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase App.java como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html
    <pre>mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.App"</pre>


- Realice el cambio en la clase App.java para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. Utilizar la primera posición del parámetro que llega al método "main" para realizar el saludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente:
    - Buscar cómo enviar parámetros al plugin "exec".
    <pre>mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.App" -Dexec.args=""</pre>
    - Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!  
    *Se ejecuto bien*
    - Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!  
    *Se ejecuto pero dio como resultado "Hello World!"*
    - Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?
    *Se ejecuto pero dio como resultado "Hello World!"*
    - Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido.
    - Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!
    *Tras la modificacion, dio el resultado esperado*
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
    No funciona ya que entra al condicional que evalua cuando los argumentos del metodo son null o tienen una longitud mayor a 1
    - Parámetro: qwerty
    Este parametro no esta definido en RegularShapeType
    - Parámetro: pentagon
    No funciona debido a que esta declarado como "Pentagon"
    - Parámetro Hexagon
    Funciona bien
- ¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?
# ENTREGAR
- Se espera al menos que durante la sesión de laboratorio, se termine el ejercicio del saludo y haya un avance del ejercicio de las figuras.
- Dentro del directorio del proyecto, cree un archivo de texto integrantes.txt con el nombre de los dos integrantes del taller.
- Crear un repositorio para este proyecto y agregar la url del mismo, como entrega del laboratorio.
- Investigue para qué sirve "gitignore" y cómo se usa. Para futuras entregas, debe estar configurado.  
    Es un archivo de texto que sirve para indicarle a GIT que archivos se deben ignorar en un proyecto