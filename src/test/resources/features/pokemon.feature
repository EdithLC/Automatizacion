#language: es
@Prueba
Característica: Realizar una búsqueda de un pokemon

  Regla: Como usuario
  Quiero buscar pokemon
  Para ver su información de habilidades


    @HAPPYPATH
    Esquema del escenario: [HAPPY PATH] Busqueda exitosa pokemon existente por su nombre
      Dado que usuario accede al servicio
      Cuando realizo busqueda de <nombrePokemon>
      Entonces valido que la busqueda sea exitoso
      Y valido que tenga habilidades
      Ejemplos:
        | nombrePokemon |
        | ditto         |
        | pikachu       |
