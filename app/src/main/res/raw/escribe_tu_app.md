Las herramientas que te ayudarán a escribir rápidamente el código de tu app.

# Completar el código

Esto ya esta visto en la sección inicial [android_studio.md].

# Cómo crear plantillas personalizadas para completar el código

Las plantillas dinámicas te permite ingresar fragmentos de código a fin de insertar y completar rápidamente fragmentos de códigos pequeños. Para insertar una plantilla dinámica, escribe su abreviatura y presiona la tecla **Tab**. Android Studio inserta en tu código el fragmento asociado con la plantilla.

* `anonymous`. Anonymous class
* `closure`. Closure function without name
* `exfun`. Extension function
* `exval`. Extension read-only property
* `exvar`. Extension read-write property
* `fun0`. Function with no parameter
* `fun1`. Function with one parameter
* `fun2`. Function with two parameter
* `ifn`. Insert 'if null' expression
* `inn`. Inserts 'if not null' expression
* `interface`. Interface
* `iter`. Iterate over elements of iterable (for-in loop)
* `main`. main() function
* `maina`. main(args) function
* `object`. Anonymous class
* `psvm`. main() function
* `psvma`. main(args) function
* `serr`. prints a string to System.err
* `singleton`. Singleton
* `sout`. Prints a string to System.out
* `soutf`. Prints current class and function name to System.out
* `soutp`. Prints function parameters names and values to System.out
* `soutv`. Prints a value to System.out
* `void`. Function returning nothing

**Android Kotlin**
* `IntentView`. Creates on Intent with ACTION_VIEW
* `key`. Key for a bundle
* `newInstance`. create a new Fragment instance with arguments
* `rgS`. get a String from resources
* `rouiT`. runOnUIThread
* `sbc`. Block comment for structuring code
* `starter`. Creates a static start(...) helper method to start on Activity
* `toast`. Create a new Toast
* `viewGone`. set view visibility to GONE
* `viewVisible`. set view visibility to VISIBLE

**Android Log Kotlin**
* `logd`. Log.d(TAG, String)
* `loge`. Log.e(TAG, String, exception)
* `logi`. Log.i(TAG, String)
* `logm`. Log method name and its arguments
* `logr`. Log result of this method
* `logt`. A static logtag with your current filename
* `logw`. Log.w(TAG, String, Exception)
* `wtf`. Log.wtf(TAG, String, Exception)

**Android Compose Preview**
* `prev`. Create @Preview composable function
* `prevCol`. Creates a Collection PreviewParameterProvider

**Android Compose**
* `comp`. Create @Composable function
* `paddp`. Add padding Modifier in dp
* `W`. Surround with widget
* `WC`. Surround with Column
* `weight`. Add weight Modifier
* `WR`. Surround with Row

**Android Comments Kotlin**
* `cfalse`. Puts false in a comment section
* `ctrue`. Puts true in a comment section
* `fixme`. Adds //STOPSHIP
* `noop`. Indicate that method does not have any operations
* `stopship`. Adds //STOPSHIP
* `todo`. Adds //TODO

## Cómo hacer un live template

(Ejemplo con un Toast). 

```
android.widget.Toast.makeText($context$, "$text$", Toast.LENGTH_SHORT).show()
```

# Cómo consultar la documentación y los detalles de los recursos

Para ver la documentación, coloca el símbolo de intercalación en el nombre de método, miembro o clase, y presiona **F1**.

