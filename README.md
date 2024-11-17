<div style="text-align: center; color: #2c3e50;">
        <h1 style="font-size: 2.5em; margin: 0;">Práctica 1 - Examen Primer Trimestre</h1>
        <p style="font-size: 1.2em; font-style: italic;">Desarrollo Web en Entorno Servidor</p>
    </div>
    
<hr>

<h2 style="text-align: center; color: #3498db; font-size: 1.3em;">Duración: 2 horas | Entrega: ZIP</h2>

<!-- Índice de ejercicios -->
<h3 style="font-size: 1.5em; color: #4CAF50;">Índice de Ejercicios:</h3>
<ul style="font-size: 1.2em; color: #555; padding-left: 20px;">
<li><a href="#ejercicio1" style="color: #3498db; text-decoration: none;">Ejercicio 1: Clase UtilEstadistica</a></li>
<li><a href="#ejercicio2" style="color: #3498db; text-decoration: none;">Ejercicio 2: Implementación de BiMap</a></li>
<li><a href="#ejercicio3" style="color: #3498db; text-decoration: none;">Ejercicio 3: Clase Login con Anotaciones</a></li>
<li><a href="#ejercicio4" style="color: #3498db; text-decoration: none;">Ejercicio 4: Pruebas con la API de Streams de Java 8</a></li>
</ul>

<hr>

<!-- Ejercicio 1 -->
<h3 id="ejercicio1" style="color: #4CAF50; font-size: 1.5em;">Ejercicio 1: <a href="#ejercicio1" style="text-decoration: none; color: #3498db;">Clase UtilEstadistica</a></h3>
<div style="background-color: #ecf0f1; padding: 15px; border-radius: 8px; margin: 10px 0;">
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    Implementa la clase <code>UtilEstadistica</code> que contiene el método estático:
    <code>public static BigDecimal media(double[] x, int scale, RoundingMode roundingMode)</code>.
    Este método calculará la media aritmética de un conjunto de datos numéricos, permitiendo especificar la escala
    y el modo de redondeo. Además, deberás crear pruebas unitarias utilizando JUnit para verificar la correcta
    ejecución de este cálculo, considerando diferentes configuraciones de escala y redondeo.
</p>
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    <strong>Objetivo:</strong> Aprender a manejar BigDecimal para operaciones de precisión, y asegurar la exactitud
    de los cálculos a través de pruebas unitarias.
</p>
</div>

<!-- Ejercicio 2 -->
<h3 id="ejercicio2" style="color: #4CAF50; font-size: 1.5em;">Ejercicio 2: <a href="#ejercicio2" style="text-decoration: none; color: #3498db;">Implementación de BiMap</a></h3>
<div style="background-color: #ecf0f1; padding: 15px; border-radius: 8px; margin: 10px 0;">
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    Desarrolla la clase genérica <code>BiMap&lt;K, V&gt;</code> que permita almacenar pares clave-valor de manera bidireccional.
    Los métodos a implementar son:
    <ul style="padding-left: 20px; color: #555; font-size: 1em;">
        <li><code>put(K key, V value)</code>: Añade un par clave-valor al mapa, garantizando la unicidad en ambas direcciones.</li>
        <li><code>forcePut(K key, V value)</code>: Añade un par clave-valor incluso si ya existe, permitiendo la actualización.</li>
        <li><code>inv()</code>: Invierte el mapa, es decir, convierte las claves en valores y los valores en claves.</li>
    </ul>
</p>
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    <strong>Objetivo:</strong> Aprender a manejar mapas bidireccionales, y comprender la manipulación eficiente
    de claves y valores utilizando un diseño genérico.
</p>
</div>

<!-- Ejercicio 3 -->
<h3 id="ejercicio3" style="color: #4CAF50; font-size: 1.5em;">Ejercicio 3: <a href="#ejercicio3" style="text-decoration: none; color: #3498db;">Clase Login con Anotaciones</a></h3>
<div style="background-color: #ecf0f1; padding: 15px; border-radius: 8px; margin: 10px 0;">
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    Implementa la clase <code>Login</code> que utilizará anotaciones para gestionar los usuarios autorizados. 
    Las anotaciones deben estar asociadas a un nombre de usuario y su correspondiente contraseña cifrada. 
    El método <code>login()</code> solicitará las credenciales al usuario, y en función de si los datos son correctos,
    mostrará el mensaje "ACCESS GRANTED" o "ACCESS DENIED". Los usuarios serán definidos mediante anotaciones en
    la clase <code>Login</code>, y deberás asegurarte de que el proceso de autenticación funcione correctamente.
</p>
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    <strong>Objetivo:</strong> Trabajar con anotaciones personalizadas en Java, y manejar el proceso de autenticación
    y seguridad en un entorno de desarrollo web.
</p>
</div>

<!-- Ejercicio 4 -->
<h3 id="ejercicio4" style="color: #4CAF50; font-size: 1.5em;">Ejercicio 4: <a href="#ejercicio4" style="text-decoration: none; color: #3498db;">Pruebas con la API de Streams de Java 8</a></h3>
<div style="background-color: #ecf0f1; padding: 15px; border-radius: 8px; margin: 10px 0;">
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    Resuelve las pruebas proporcionadas para la API de Streams de Java 8. El objetivo es realizar un análisis y filtrado
    de datos utilizando los flujos de la API de Java. En este ejercicio se deben configurar una base de datos MySQL y
    aplicar los scripts <code>schema.sql</code> y <code>data.sql</code> para realizar las consultas adecuadas en la
    base de datos. Es fundamental manejar adecuadamente los valores nulos en las tablas.
</p>
<p style="font-size: 1em; color: #555; line-height: 1.6;">
    <strong>Objetivo:</strong> Familiarizarse con el uso de Streams para el procesamiento de datos y realizar consultas
    eficientes sobre bases de datos.
</p>
</div>

<hr>

<p style="text-align: center; font-size: 1em; font-style: italic; color: #555;">
📧 Para más información, puedes contactarme por correo electrónico: 
<a href="mailto:daniclavijonunez@gmail.com" style="color: #3498db; text-decoration: none;">daniclavijonunez@gmail.com</a>
</p>
