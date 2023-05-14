# Componentes principales de un proyecto

## Módulos

Un *módulo* es una colección de archivos de origen y parámetros de configuración de compilación que te permiten dividir tu proyecto en unidades de funcionalidad discretas.

Tu proyecto puede tener uno o más módulos, y un módulo puede usar otro como dependencia.

Puedes compilar, probar y depurar cada módulo por separado.

Los módulos son útiles para crear bibliotecas dentro del mismo proyecto o para separarlo para diferentes dispositivos, cómo teléfonos y wearables y al mismo tiempo mantener todos los archivos almacenados dentro del mismo proyecto.

Para agregar un módulo nuevo a un proyecto, haz clic en **File > New > New Module**.

**Módulo de app para Android**

    Proporciona un contenedor para el código fuente de tu app, los archivos de recursos y los parámetros de configuración de niveles de app, como el archivo de compilación de nivel de modulo y el manifiesto de Android. Cuando creas un proyecto nuevo, el módulo predeterminado de la app se llama "app".

    En la ventana **Create New Moduel** Android ofrece los siguientes tipos de módulos de apps:

* Módulo de telefono y tablet
* Módulo de Automotive
* Módulo de Wear OS
* Módulo de Android TV
* Módulo de comparativas

**Módulo de funciones**

    Representa una función modularizada de la app que puede aprovechar *Play Feature Delivery*. Por medio de funciones, se puede proporcionar a los usuarios determinadas funciones de tu app a pedido o como experiencias instantáneas por medio de Google Play Instant.

* Módulo de funciones dinámicas
* Módulo de biblioteca de la función Instant Dynamic Feature

**Módulo de biblioteca**

    Proporciona un contenedor para tu código reutilizable, que puedes usar como dependencias en otros módulos de app o importar a otros proyectos. A nivel estructural, un módulo de biblioteca es lo mismo que un módulo de app, pero cuando se compila, crea un archivo de código en lugar de un APK, por lo que no se puede instalar en un dispositivo.

* Biblioteca de Android. Este tipo de biblioteca puede contener todos los tipos de archivos admitidos en un proyecto de Android, excepto código C++ nativo. El resultado es un Android Archive (AAR) que se puede agregar como dependencia a los módulos de tu app.
* Biblioteca nativa de Android. Este es igual al anterior, excepto que puede contener código C++ nativo. Igualmente genera un archivo Android Archive (AAR).
* Biblioteca de Java o Kotlin. Este tipo de biblioteca solo contiene archivos fuente Kotlin y Java. El resultado de compilación es un archivo de Java (JAR) que se puede agregar como dependencia para una app o otros proyectos de Kotlin o Java.

Para agregar un módulo de biblioteca y deseas agregarlo como dependencia, debes declararlo de la siguiente manera:

```kotlin
dependencies {
    implementation(project(":my-library-module"))
}
```

# Tipos de vista de Proyecto

## Vista de Android

* Se muestran todos los archivos de configuración relacionados con la compilación de proyecto en un grupo de nivel superior **Gradle Script**
* Se muestran todos los archivos de manifiesto para cada módulo en un gruipo de nivel de módulo cuando tienes diferentes archivos de manifiesto para diferentes variantes de productos y tipos de compilación.
* Se muestran todos los archivos de recursos alternativos en un único grupo, en lugar de carpetas separadas por calificador de recursos.

Dentro de cada módulo:

* `manifest` Contiene el archivo `AndroidManifest.xml`
* `java` Contiene los archivos de código fuente Kotlin (Java), separados por nombres de paquetes, incluido el código de prueba JUnit.
* `res` Contiene todos los recursos sin código (XML), strings, imágenes, etc.

## Vista Project

module-name/
    build/(Contiene resultados de compilación)
    libs/(Contiene bibliotecas privadas)
    src/(Contiene todos los archivos de código y recursos)
        androidTest/(Contiene código para las pruebas de instrumentación)
        cpp/(Contiene código C o C++ nativo en el cual se usa la interfaz nativa de Java (JNI))
        main/(Contiene todos los archivos de conjunto de orígenes "principales")
            AndroidManifest.xml
            java/(Contiene fuentes de código Kotlin o Java)
            kotlin/(Contiene solo fuentes de código Kotlin)
            res/(Contiene recursos de aplicación)
            assets/(Contiene archivos para compilar en un archivo APK tal como está.)
        test/(Contiene código para pruebas locales)
    build.gradle.kts (módulo)(Este archivo define las configuraciones de compilación del módulo)
build.gradle.kts (proyecto)(Este archivo define la configuración de compilación que se aplica a todos los módulos)

## Parámetros de configuración de la estructura de proyecto

Para cambiar opciones en el proyecto ir a **File > Project Structure**:

* **Project**: Fija la versión de Gradle y el complemento para Gradle y el nombre de la ubicación del repositorio.
* **SDK Location**: Configura la ubicación del JDK, SDK de Android y NDK de Android de tu proyecto.
* **Variables**: Te permite editar variables que se usan dentro de las secuencias de comandos de compilación.
* **Modules**: Te permite editar configuraciones de compilaciones específicas del módulo, lo que incluye SDK mínimo y de destino, la firma de apps y las dependencias de bibliotecas.
  * **Properties**: Especifica las versiones del SDK y de las herramientas de compilación de módulo
  * **Signing**: Especifica el certificado que debe usarse para firma tu app.
* **Dependencias**: Ubica en una lista la biblioteca, el archivo y las dependencias para este módulo. 
* **Build Variants**: Te permite configurar diferentes variantes y tipos de compilación para tu proyecto
  * **Flavors**: Te permite crear múltiples variantes; cada variante especifica un conjunto de opciones de configuración, como al versión SDK mínima y de destino del módulo, y el código y nombre de la versión.
  * **Build Types**: Te permite crear y modificar configuraciones de compilación. De manera predeterminada, cada módulo tiene tipos de compilación de depuración y lanzamiento, se pueden definir más.

## Control de Versiones (VCS)

Android Studio admite diferentes sistemas de control de versión (VCS), incluidos Git, GitHub, CVS, Mercurial, Subversión y Google Cloud Source Repositories.

### ¿Qué es Git?

Es un sistema de guardado para versiones diferentes de un mismo proyecto (como partidas guardadas).

También sirve para que varios programadores trabajen sobre un mismo proyecto. 

Algunos comandos utiles:

* `pwd`. Nos dice la ruta en donde estamos.
* `ls`. Salen todos los directorios que hay en la ubicación actual
* `cd`. change directory, funciona igual que el de linux
* `cd ..`. retroceder
* `mkdir 'nombre'`. Crea un directorio con el 'nombre'.
* `rm 'nombre archivo'`. Borra un archivo con nombre 'nombre archivo'
* `rmdir 'nombre directorio'`. Borra un directorio 'nombre directorio'

**Inicializar un proyecto**

Crear un archivo en un directorio en específico, navegar hasta el. En el daremos el siguiente comando:

* `git init`. Se van a crear algunos archivos especiales. Los podemos ver con el comando `ls -a` (archivos ocultos).

Específicamente en el directorio oculto .git, navegando a el podremos visualizar una estructura de directorios, pues esto es la estructura de git.

Volvemos al directorio principal del proyecto creado y damos el siguiente comando para ver el estado del proyecto:

* `git status`. Podremos ver el estatus del proyecto git.

Nos saldran los archivos que tengamos en este directorio en rojo (no los hemos agregado **commit**).

* `git add 'nombre_fichero'`. Agregamos el archivo al proyecto git.

Una vez editados los archivos que tengamos en el proyecto git (commit), estos pueden guardarse con el siguiente comando:

* `git commit -m "He creado el fichero"`

Al dar enter se ha creado una versión del proyecto. Para ver los commit que hemos hecho:

* `git log`. Nos permite ver las modificaciones con los mensajes que hayamos pasado a las versiones y también quien ha hecho los cambios.

Si se modifica el fiechero, git detectará que se ha modificado y lo volvera poner en rojo. Para deterctar las diferencias:

* `git diff 'fichero'`. Mostrara la versión guardada y la versión modificada que no ha sido guardada.

Con `git add 'fichero'` podría guardar esos nuevos cambios y haciendo un `commit -m "mensaje"` guardaría la versión con su comentario apropiado.

**Para volver a una versión anterior**. Copiar el código de commit

`git checkout 'código_commit'`. Se volvera a la versión anterior del archivo.

Esto va borrar la versión desechada. Para hacerlo de mejor forma, utilizaremos las ramas.

* `git checkout -b develop`. Crea la rama develop y entra a esta rama.

Se hacen las modificaciones que sean necesarias, otros ficheros, etc. Para guardar todos los cambios

* `git add .`. Guarda todos los cambios.

Agregamos su respectivo commit para dejar la versión lista.

* `git commit -m "versión :-)"`

Si queremos traer todo lo de la rama creada al primer proyecto:

* `git merge develop`. Va a combinar (excepto con los archivos iguales). 

Esto no pasa en los IDE (Android Studio). Con el IDE es más sencillo al tener las opciones en automático.

