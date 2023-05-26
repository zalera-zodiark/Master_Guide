Una biblioteca de Android tiene la misma estructura que un módulo de app de Android. Incluye todo lo que se necesita para compilar una app, como el código fuente, archivos de recursos y un manifiesto de Android.

Una biblioteca se compila en un archivo Android Archive (AAR) que puedes usar como dependencia para un módulo de app para Android. A diferencia de los archivos JAR, los archivos AAR ofrecen las siguiente funciones para las apps:

* Los archivos AAR pueden contener recursos de Android y un archivo de manifiesto, que te permite incluir recursos compartidos, como diseños y elementos de diseño, además de clases y métodos de Kotlin o Java.
* Los archivos AAR pueden contener bibliotecas C o C++ para que los use el código C o C++ del módulo de la app.

Un módulo de biblioteca es útil en las siguientes situaciones:

* Cuando compilas varias apps que comparten algunos componentes, como actividades, servicios o diseños de la IU.
* Cuando compilas una app que existe en diferentes variantes del APK, como una versión gratuita y una versión pagada, que comparten componentes principales.

## Cómo crear un módulo de biblioteca

1. Haz clic en **File > New > New Module**.
2. En el diálogo **Create New Module** que aparece, haz clic en **Android Library** y, luego en **Next**.
    
    También se puede crear una biblioteca de Kotlin o Java, que compila un archivo JAR tradicional. Si bien un archivo JAR es útil para muchos proyectos, en especial cuando deseas compartir el código con otras plataformas, no te permite incluir archivos de manifiesto ni recursos de Android, y esto es muy útil para reutilizar el código en proyectos de Android. Esta guía se enfoca en la creación de bibliotecas de Android.

3. Name de la biblioteca y selecciona un SDK mínimo para el código de la biblioteca y **Finish**.

Una vez que se haya completado la sincronización del proyecto de Gradle, se mostrará el módulo de la biblioteca en el panel **Project**. Si no ves la nueva carpeta del módulo, asegúrate de que el panel muestre la **vista de Android**.

### Cómo convertir un módulo de app en un módulo de biblioteca

Si tienes un módulo de app existente con el código que deseas reutilizar, puedes convertirlo en un módulo de biblioteca de la siguiente manera:

1. Abre el archivo `build.gradle` a nivel de módulo, si usas Groovy, o el archivo `build.gradle.kts`, si usas la secuencia de comandos de Kotlin.
2. Borra la línea para applicationId. Solo un módulo de la app para Android puede definir esto.
3. Busca el bloque "plugins" en la parte superior del archivo que se ve de la siguiente manera:

   ```kotlin
      plugins {
          id("com.android.application")
      }
   ```
   Cambialo por lo siguiente:
   
   ```kotlin
      plugins {
          id("com.android.library")
      }
   ```
4. Guarda el archivo y haz clic en **File > Sync Project with Gradle Files**.

La estructura del módulo sigue siendo la misma, pero ahora funciona como una biblioteca de Android. La compilación crea un archivo AAR en lugar de un APK.

Cuando desees compilar el archivo AAR, selecciona el módulo de biblioteca en la ventana **Project** y haz clic en **Build > Build APK**.

