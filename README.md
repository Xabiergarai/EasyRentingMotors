# EasyRentingMotors


   [![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)

<h1 align="center">
  <a href="https://git.io/typing-svg">
    <img src="https://readme-typing-svg.herokuapp.com/?lines=Bienvenido!+👋;Esto+es+ERM....;Empecemos!😊&center=true&size=30">
  </a>
</h1>


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


<h2> Resumen/Contexto </h2>

    Esta aplicacion es el prototipo de lo que llegaria a ser una concesinario online de coches.
    Easy Renting Motors ofrece a los usuarios diferentes clases y tipos de coches, mas concretamente
    desde la A hasta la D. La aplicación estará dividida en varias partes. Antes de todo, tendremos
    el login, donde el usuario podrá entrar en la plataforma. En caso de que no estuviera registrado,
    procedería a realizar el registro del usuario. Una vez dentro, la aplicación presenta várias
    funciones; por un lado, tenemos la posibilidad de comprar cualquier veiculo de las categorias
    anteriormente mencionadas, tambien es posible solicitar informacion sobre cualquier veiculo
    antes de proceder al pago. Ademas, si simplemente los usuarios necesitan el coche para un
    periodo concreto de tiempo, podran realizar un alquiler de cualquier coche que este
    disponible en nuesto concesionario. Todos estos pagos, tanto la compra simultanea de varios
    veiculos como los alquileres, podran realizarse con diferentes metodos de pago pensados 
    para la maxima comodidas de nuestos clientes. Tras realizar cualquier compra, los usuarios 
    pueden dejar su opinion acerca de la pagina web; si ha sido amigable, si el diseño es el mas
    adecuado, etc.
    Ademas, los usuarios tambien tienen la opcion de vender su coche de forma rapida y segura pudiendo
    agregar una foto del respectivo vehiculo.En relacion con la seguridad, con usuarios podran cambiar 
    de contraseña en cualquier momento, asi como eleminar su cuenta si asi lo desean.


## 🚀 Funcionamiento del proyecto

<h2> Descripcion de interfaz </h2>

      Para poner en marcha la aplicación de Easy Renting Motors debemos dirigirnos a la 
      carpeta erm/src/erm.main/App.java.
   
      Easy Renting Motors se inicia desde VentanaInicial. Si tenemos cuenta, iniciamos sesión. 
      Si es nuestra primera vez en la aplicación, elegimos la opcion de "Registrar Usuario".

      En el registro debemos poner un nombre de Usuario, contraseña y el email (@ y .).

      Una vez registrados, entramos en la aplicación. 
      
   <h2> Dos opciones: </h2>
                      
   <h4> Como administrador: </h4>
      
      Esta sección está únicamente pensada para el equipo administrativo. El objetivo es poder manejar 
      de una forma mucho mas accesible y cómoda los usuarios y coches de Easy Renting Motors.
      
      - VentanaGestionStocck: Gestiona el stock que hay actualmente en la tienda(mediante una lista con todos 
                              los coches que hay en la tienda). Donde se puede agregar o eliminar coches segun 
                              las necesidades del administrador, entre otras funciones.
                              
             - VentanaGestionUsuarios: Gestiona todos los usuarios registrados en la tienda. Asi como tambien 
                                       crea nuevos usuarios y/o  eliminar los usuarios que se desee. 
        
   <h4> Como usuario: </h4>
      
      La primera Ventana que obtendremos es VentanaPrincipal. En ella tenemos una serie de coches 
      divididos por categorias (A,B,C,D). En esa misma Ventana tenemos tres botones que nos llevan a "Mi Perfil", y "Ajustes".
      
      Aquí se podrá decidir en qué clase está interesado el usuario, para mas tarde ir a la ventana de esa categoría que desee
      el usuario. Se mostrarán imágenes de cada sección para una mejor interacción con el cliente.
      
 ## 🧐 Dos maneras de iniciar sesión

Tipos de Usuario|Usuario normal | Administrador
-------------|------------- | -------------
Usuario|usuario*  | admin
Contraseña|usuario123*  | admin123

*Es una cuenta que te recomendamos para iniciar sesión. Si esta no te convence, puedes registrarte en nuestra aplicación con tus 
credenciales.
      
      
   <h2> Opciones como usuario </h2>
      
   <h3> Compra</h3>
   
     ● Ventana CategoríaA/B/C/D: Cuando seleccionemos la sección del automóvil en el que estamos interesados, pasaremos a una 
      ventana donde encontraremos todos los automóviles disponibles que hay en esa categoría.
      
     ●  VentanaCarritoCompra: Una vez el usuario  ha decidido que compra desea hacer, podrá ver el resumen de su carrito en 
      esta venta, además del precio y algún detalle más. Una vez desea realizar el pedido, procederá a la ventana de pago.
      
     ● VentanaPago: Insertará todas sus credenciales. Tanto de la tarjeta como su dirección de domicilio. 
    
      En "Mi Perfil" accedes a Informacion de cuenta. Esta ventana te mostrará todos los datos del usuario con el que has 
      iniciado sesión.

      
  <h3> Venta </h3>
  
		   ● Ventas e información: En este apartado el usuario tiene la opción de poner su coche
				                    	a la venta, especificando la categoria del coche que pondrá a la venta.
                                 Además, cada usuario podrá publicar una opinión acerca de su experiencia en 
                                 la aplicación.
                                 
                                 
  <h3> Alquiler </h3>                             
               
                ● Alquiler: El usuario también tiene la opción de poder alquilar jun coche para un tiempo.
                            A través del calendario que falicitamos podrá seleccionar el ccoche que desea
                            y el tiempo que lo va a adquirir.
                            
                ● VentanaPago: Insertará todas sus credenciales. Tanto de la tarjeta como su dirección de domicilio. 
                     
  <h3> Mas de "Ajustes" </h3>      
               
    ● VentanaAjustes:    
   
		   - Privacidad: Dentro de esta tenemos las opciones de
			              "Politica de Privacidad", "Acerca de" y la
			                opcion de eliminar su cuenta.
               
		   - Seguridad: El usuario tendrá la posibilidad de cambiar
			             su contraseña.            
    ● Sesión:
       
		   Cerrar Sesion
		   Salir de la aplicacion

    ● Servicio:
		   Contacto: Podrás contactar a traves de gmail y nuestro instagram.
    
    ● Ventana Final/Factura: Esta será la última ventana en la cual aparecerán el recibo final con
      los datos del coche y la factura. Habra diferentes métodos de pago tanto a la hora de compra,
      vender y alquilar un coche.
      
  <h2> TEST </h2>
  
      En el paquete Test hemos probado todas las clases de las clases basicas, categorias
   
       
 [![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)

 
 <h3>💬 Contacto </h3>


<p align="center">

<a href="https://www.instagram.com/erMotors_/"><img alt="Instagram" src="https://img.shields.io/badge/Instagram-erMotors_-purple?style=flat-square&logo=instagram"> </a>

<a href="mailto:ermotors@gmail.com"><img alt="Email" src="https://img.shields.io/badge/Email-ermotos@gmail.com-red?style=flat-square&logo=gmail"></a>

<a href="https://twitter.com/erMotors"> <img alt="Twitter" src="https://img.shields.io/badge/Twitter-erMotors-blue?style=flat-square&logo=twitter"></a>
  
</p>
      
      
      
      

    
 
       
  
