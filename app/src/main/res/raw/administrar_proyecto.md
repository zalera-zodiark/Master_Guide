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

## Cómo configurar Android Studio

Hay dos archivos para configurar a través del menú Help:

* studio.vmoptions: permite personalizar opciones para la JVM. (64 bits) studio64.vmoptions.
* idea.properties: permite personalizar las funciones de Android Studio.

## Descripción general de la entrega de funciones en Play

Este modelo se basa en entregar paquetes Android App Bundle a fin de generar y publicar APK optimizados para la configuración del dispositivo del usuario, de manera que tienen el código y lo recursos que su dispositivo puede usar.

Esto también se usa para permitir que ciertas funciones se entreguen a la app de manera condicional o se descarguen a pedido.

Esta funcionalidad esta disponible a partir de Android 5.0 (nivel 21). Ciertas funciones de la app como uso de VR o Cámara se pueden condicionar en algunos dispositivos de manera selectiva.

Las funciones de entrega requieren de una configuración adicional y la modularización de las funciones de la app mediante **módulos de funciones**. 

En el ejemplo de una app que permite comprar y vender bienes en línea. Se puede modularizar las funciones de la app en módulos independientes de la siguiente manera:

* Acceso y creación de cuentas
* Navegación por el mercado
* Colocación de un artículo a la venta
* Procesamiento de pagos

En el ejemplo anterior, se pueden aplicar diferentes opciones de entrega que admiten los módulos de funciones y como se pueden optimizar para que el tamaño de la descarga sea mejor:

**Entrega durante la instalación**

Durante la descarga se instalan los módulos necesarios, los que no configuran ninguna de las opciones anteriores. Esto permite instalar ciertas opciones avanzadas conforme se instalan otras partes. Además puede desintalarse ciertas funciones una vez cumplidos ciertos criterios.

Si la app tiene ciertas actividades de tutorial estas se pueden incluir en la instalación inicial y luego de que el usuario no las necesite se pueden desintalar para que ocupe menos espacio. 

Para comenzar, modulariza tu app con módulos de funciones que no configuren opciones de entrega avanzadas.

**Entrega a pedido**

Permite que la app solicite y descargue módulos de funciones según sea necesario. 

Si la opción de venta la utiliza un 20% de los usuarios, esta opción se puede modularizar (capcidad para tomar fotografias, incluir una descripción y colocar en venta). Si el usuario ya no vende articulos después de cierto tiempo, se puede sugerir la desintalación del módulo para reducir su tamaño.

Crear un módulo de funciones y configurar la entrega a pedido. La app puede usar la biblioteca de Play Core para solicitar la descarga del módulo a pedido.

**Entrega condicional**

Permite especificar ciertos requisitos del dispositivo del usuario, como funciones de hardware, configuración regional y un nivel mínimo de API, para determinar si una función modularizada se descarga cuando se instala la app.

Si la aplicación de Marketplace tiene alcance global, puede ser necesario admitir formas de pago que se usan en ciertas regiones o paises. Se pueden crear modulos independientes de formas de pago usados en ciertas regiones y solamente descargarlos en cuestión de la configuración regional del dispositivo.

**Entrega instantánea**

**Google Play Instant** permite a los usuarios interactuar con tu app sin necesidad de instalar APK en sus dispositivos. En cambio, pueden experimentar la app a través del botón "Probar ahora" en Google Play Store o una URL que crees. 

Un juego que incluya los primeros niveles en un módulo de funciones liviano, esto sin instalar por completa la app.

### Cómo modularizar tu app

La modularización de una app es el proceso de separar componentes lógicos del proyecto de app en módulos independientes. Requiere una evaluación cuidadosa y tiempo. En cambio ofrece los siguientes beneficios:

* **Desarrollo en paralelo**: Se puede separar el desarrollo por diferentes personas sin interferir unos con otros. También puede servir para la reutilización y encapsulación de código.
* **Mejores tiempos de compilación**: Los sistemas de compilación como Gradle están optimizados para la ejecución de proyectos en paralelo. Si el sistema es multinucleo, el proyecto tendra mejores resultados y rendimiento.
* **Entrega de funciones personalizada**: Crear funciones a pedido requiere más esfuerzo y, posiblemente, la refactorización de la app. Se debe evaluar con cuidado cuales funciones de la app convendría modularizar en módulos de funciones a fin de aprovechar las opciones de entrega personalizada.



