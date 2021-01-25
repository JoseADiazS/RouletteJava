# RouletteJava
Este repositorio tiene como fundamento la presentacion de una API siguiendo estandares de Clean Code para aplicar 
como BackEnd Developer Jr en la compañia Masivian.

## Endpotints

### 1. Endpoint de creación de nuevas ruletas

Este Endpoint retornara el id de la ruleta creada:

>[POST] localhost:8080/roulette
> 
> RESULTADO:
>
>>f5667cd6-eb1c-4f02-8d18-5cc4ea169ec6

### 2. Endpoint de apertura de ruleta dado el id
Este Endpoint permitira las posteriores peticiones de apuestas, retorna la confirmacion de estado de la ruleta

>[GET] localhost:8080/roulette/open/{id}
> 
> RESULTADO:
>
>> 
>>```json
>>{
>>  "id": "5d741683-64f7-4a7d-9728-740ba6605249",
>>  "status" : true,
>>  "bets" : []
>>}
>>```

### 3. Endpoint de apuesta
Este Endpoint recibe como numeros validos del 0 al 36 o colores Red o Black, la cnatidad de dinero maxima por 
apuesta es de 10.000 dolares.

Recibe como parametros de apuesta, un id de usuario señalado en el HEADER,

> [GET] localhost:8080/roulette/{idRoulette}
>> HEADER
>>
>> KEY : userId
>>
>> VALUE : 272c5f96-9704-4a9e-9171-3b44e8e08cca
> 
>> BODY: 
>>
>>```json
>>{ 
>>  "money": 20,
>>  "number" : 13
>>}
>>```
>
>>RESULTADO:
>> ```json
>> {
>>    "id": "5d741683-64f7-4a7d-9728-740ba6605249",
>>    "status": true,
>>    "bets": [
>>        {
>>            "bet": "13",
>>            "money": 20.0,
>>            "user": {
>>                "id": "272c5f96-9704-4a9e-9171-3b44e8e08cca",
>>                "userName": "Jose Diaz",
>>                "balance": 99985.0
>>            }
>>        }
>>    ]
>>}
>> ```

### 4. Endpoint de cierre de apuestas dado id

Este Endpoint dado el id de una ruleta devolvera el resultado de las apuestas echas desde su apertura hasta el cierro.
<br>
El numero ganador se selecciona automaticamente y se debita la cantidad ganada ( si gano ) a la cuenta del cliente.
> [GET] localhost:8080/roulette/bet/{idRoulette}
>>RESULTADO
>>```json
>>{
>>    "result": {
>>        "resultNumber": 30,
>>        "resultColor": "RED",
>>        "winners": 0,
>>        "losers": 1,
>>        "listOfWinners": [],
>>        "listOfLosers": [
>>            {
>>                "bet": "13",
>>                "money": 20.0,
>>                "user": {
>>                    "id": "272c5f96-9704-4a9e-9171-3b44e8e08cca",
>>                    "userName": "Jose Diaz",
>>                    "balance": 99965.0
>>                }
>>            }
>>        ]
>>    }
>>}
>>```

### 5. Endpoint de listado de ruletas creadas con sus estados
Este Enpoint retornara el listado de las ruletas creadas con su estado (True => Abierta), (False => Cerrada)

>[GET] localhost:8080/roulette
> 
>> Resultado
>> <br><br>
>> ```json
>> {
>>    "5d741683-64f7-4a7d-9728-740ba6605249": {
>>        "id": "5d741683-64f7-4a7d-9728-740ba6605249",
>>        "status": true,
>>        "bets": []
>>    },
>>    "f5667cd6-eb1c-4f02-8d18-5cc4ea169ec6": {
>>        "id": "f5667cd6-eb1c-4f02-8d18-5cc4ea169ec6",
>>        "status": false,
>>        "bets": []
>>    }
>>}
>> ```