# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@Cuenta
@RegistroCuenta
Característica: Registrar cuenta
  Yo como cliente de la app Exito
  Necesito crear mi cuenta
  Para estar identificado ante cualquier funcionalidad que use

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @CP-002 # [FE][HP] - Completar solicitud de registro de cuenta, exitoso
  Escenario: Ir a comprobar identidad, al confirmar solicitud de registro de cuenta
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que "el usuario" se encuentra registrando su cuenta en su app Exito
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando confirma el registro de su cuenta
      | nombres_registro | apellidos_registro | tipo_documento_registro | documento_registro | fecha_nacimiento_registro | celular_registro | correo_registro                              | terminos_registro | politicas_registro |
      | Hector Fabio     | Cuenca Madrid      | C.C                     | 1144029966         | 07/08/1999                | 3104686490       | hcuenca8+{ddMMyyyy}_{HHmmss}_{###}@gmail.com | S                 | S                  |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería mostrarse en el app: "Código de confirmación"
