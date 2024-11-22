# Estructura del proyecto

## Interfaces

| Entidad         | Descripción                                                                                                       |
|-----------------|-------------------------------------------------------------------------------------------------------------------|
| IBrowser        | Interfaz que define operaciones comunes para la gestión del navegador y la espera de elementos en una página web. |
| IVerify         | Interfaz que define métodos para verificar resultados esperados con obtenidos y agregar mensajes asociados.       |
| IPropertyReader | Interfaz para leer propiedades de diferentes archivos de configuración.                                           |

## Patrones aplicados

| Patrón     | Entidad                                                                                                             | Descripción                                                                                                        |
|------------|---------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| Factory    | DriverManagerFactory                                                                                                | Clase encargada de indicar que driver se debe retornar.                                                            |
| Singlenton | DriverManagerSinglenton                                                                                             | Clase encargada de mantener una sola instancia configurada con un driver.                                          |
| Facade     | FachadaCapacitacion                                                                                                 | Clase encargada de brindar métodos sencillos para utilizar en los test. Internamente manipula las **Page Object**. |
| POM        | ContraseniaPO <br/>GestionSistemaPO<br/> HomePO<br/>IngresoSitioPO<br/>IniciarSesionPO<br/>MenuPO<br/>RegistrarsePO | Clase encargada de manipular las acciones sobre la interfaz de usuario.                                            |

## Recursos

| Ruta                 | Nombre                           | Descripción                          |
|----------------------|----------------------------------|--------------------------------------|
| `src/test/resources` | mensajes.verificacion.properties | Mensajes para usar en verificaciones |
| `src/test/resources` | valores.pruebas.properties       | Valores para usar en las pruebas     |
