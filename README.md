# EasyRentingMotors


   [![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)


<h1 align="center">Bienvenido al Readme de ERM 👋</h1>



## 🛠 Equipo de Trabajo

<ol >
  <li>👤 Aitor Gutierrez <br /> </li>
  <li>👤 Javier Contreras <br /> </li>
  <li>👤 Gorka Zarate <br /> </li>
  <li>👤 Xabier Garai  </li>
</ol>


## 💻 Sobre el equipo

- 🎓 &nbsp; Grupo de cuatro estudiantes de Ingenieria Informática en la Universidad de Deusto.
- ⚙️ &nbsp; Asignatura: Programación III


## 👩‍💻 Lenguaje del proyecto 

Badge | URL
------------ | -------------
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" /> | `https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white`
<img src="https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white" /> | `https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white`


## 🚀 Funcionamiento del proyecto

<h2> Resumen/Contexto </h2>

    Aplicación que se basará en una tienda online de un concesionario de vehículos. Easy
    Renting Motors ofrecerá al consumidor una gran variedad de automóviles, incluyendo
    coches de diferentes clases, desde clase A hasta D. La aplicación estará dividida en
    varias partes. Antes de todo, tendremos el login, donde el usuario podrá entrar en la
    plataforma. En caso de que no estuviera registrado, procedería a realizar el registro
    del usuario. Una vez dentro, la aplicación contendrá una sección donde se mostrarán
    los vehículos, divididos en las categorías mencionadas anteriormente. El usuario
    podrá seleccionar cualquier tipo de vehículo en el que esté interesado. Podrá tener
    toda la información que necesite sobre el automovil que le interese. Tendrá tres
    diferentes formas de realizar el pago (A plazos, normal e incluso a alquiler donde el
    precio estará adecuado a su medida).
    Objetivos del proyecto
    El objetivo principal es programar una tienda/aplicación donde ofrezcamos comodidad
    a la hora de que el usuario entre en ella. Queremos crear una interfaz gráfica que
    satisfaga las necesidades del cliente y que a la vez sea atractiva. La comodidad del
    usuario a la hora de utilizar la aplicación es lo que más nos interesa y por ella
    intentaremos crear algo que sea lo más intuitivo para el cliente.

<h2> Ideas de Interfaz </h2>

    ● Ventana login: Habrá un login donde se introducirá el usuario y la contraseña que
      nos llevará a una ventana donde se encontrarán las secciones de coches que tendrá
      el concesionario. Por ejemplo, dividiremos la interfaz de secciones en 4 ‘partes’, 
      desde coche de clase A hasta D. Además, nos dará la opción de recuperar contraseña
      si no nos acordáramos de ella.
      
    ● Ventana Registro: En el caso de que no estuvieras registrado en “Easy Renting
      Motors”, esta ventana nos permitirá crear nuestro propio usuario. En esta interfaz
      tendremos la opción de insertar todos los datos necesarios para el registro. Una vez
      terminado este proceso, nos llevará a la “ventana login” para ahora sí, iniciar sesión
      en nuestro concesionario.
    
    ● Ventana Inicio: Esta ventana nos mostrará un pequeño resumen de todas las
      categorías. Aquí se podrá decidir en qué clase está interesado el usuario, para mas
      tarde ir a la ventana de esa categoría que desee el usuario. Se mostrarán imágenes
      de cada sección para una mejor interacción con el cliente.
    
    ● Ventana CategoríaCoche: Cuando seleccionemos la sección del automóvil en el que
      estamos interesados, pasaremos a una ventana donde encontraremos todos los
      automóviles disponibles que hay en esa categoría.
    
    ● Ventana InformaciónCoche: Una vez hayamos seleccionado el coche deseado en
      la ventana ClaseCoche, pasaremos a una nueva donde nos saldrá la propia
      información del coche: foto,precio,etc. Además, se podrá seleccionar algún extra si el
      usuario lo solicitara. Extras como gps integrado o techo panorámico.
    
    ● Ventana Pago: Una vez tenemos claro qué coche queremos pasaremos a tramitar el
      pago. Habrá tres diferentes opciones:
        ○ Comprar en un pago
        ○ Pagar a plazos
        ○ Alquiler
        
    ● Ventana VenderCoche: Otra opción que ofrecera la tienda a los usuarios será la de vender coches.
      Un usuario tendra la posibilidad de meter los datos de su coche en la web y podra venderselo a la tienda.
      
    ● Ventana AlquilarCoche: ERM también ofrecerá a sus usuarios de realizar el alquiler sus propios coches. El proceso
      de alquiler será sencillo, primero se elegirá el coche deseado y posteriormente se elegiran las fechas deseadas
      para la utilidad del coche.
      
    ● Ventanas Administrador: ERM tendra un modo usuario dentro de la web. Este administrador tendrá el uso exclusivo de 
      gestionar la stock de coches y los usuarios de la web. El admin podrá agregar y eliminar coches y usuarios de la BBDD.
     
    ● Ventana Opciones: La web tendra un apartado de opciones donde habra diferentes sub-ventanas donde habra información como
      la privacidad de la pagina web, protección de datos, redes sociales, etc.

    ● Ventana Final/Factura: Esta será la última ventana en la cual aparecerán el recibo final con
      los datos del coche y la factura. Habra diferentes métodos de pago tanto a la hora de compra,
      vender y alquilar un coche.
      
      
## 🧐 Dos maneras de iniciar sesión

Tipos de Usuario|Usuario normal | Administrador
-------------|------------- | -------------
Usuario|usuario*  | admin
Contraseña|usuario123*  | admin123

*Es una cuenta que te recomendamos para iniciar sesión. Si esta no te convence, puedes registrarte en nuestra aplicación con tus credenciales.

      
<h2> Instrucciones </h2>

    ● Para poner en marcha la aplicación de Easy Renting Motors debemos dirigirnos a la carpeta erm/src/erm.main/App.java,
      ahi encontraremos la ventana 'main' llamada App la cual deberemos correrla click-ando con el botón derecho del ratón y
      dirigiendonos a 'run as'. Una vez hayamos iniciado la aplicación nos encontraremos con la ventana inicial, tendremos
      diferentes secciones para elegir, entre ellas la de iniciar sesión o la de administrador. Para iniciar sesión, deberemos
      utilizar el nombre de usuario: gutiaitor, con la contraseña: 12345. Otra opción es la de registrarse mediante el botón de
      registro, el cual nos permitira registrarnos con un    nuevo nombre de usuario. Para iniciar sesión como administrador
      deberemos utilizar el nombre de usuario: admin, con la contraseña: admin123. 
     
    ● Una vez dentro de la aplicación, tendremos la posibilidad de comprar un coche dirigiendonos a la/s catergorias deseadas.
      Por otro lado, en la parte superior de la ventana tendremos un icono de ajustes el cual nos llevara a una ventana donde
      podremos seleccionar operaciones como la de vender o alquilar un coche, revisar los datos de la cuenta, etc.  
      
 [![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)

 
 <h3>💬 Contacto </h3>


<p align="center">

<a href="https://www.instagram.com/erMotors_/"><img alt="Instagram" src="https://img.shields.io/badge/Instagram-erMotors_-purple?style=flat-square&logo=instagram"> </a>

<a href="mailto:ermotors@gmail.com"><img alt="Email" src="https://img.shields.io/badge/Email-ermotos@gmail.com-red?style=flat-square&logo=gmail"></a>

<a href="https://twitter.com/erMotors"> <img alt="Twitter" src="https://img.shields.io/badge/Twitter-erMotors-blue?style=flat-square&logo=twitter"></a>
  
</p>







      
     
      
      
      
      

    
 
       
  
