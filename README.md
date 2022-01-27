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
